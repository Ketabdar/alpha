package models

import java.util.UUID
import sun.security.util.Password

import scala.collection.convert.WrapAsScala
import scala.concurrent.ExecutionContext
import scala.concurrent.Future
import play.api.libs.json._
import play.api.libs.functional.syntax._
import play.api.data.validation.ValidationError
import com.datastax.driver.core.utils.UUIDs
import com.datastax.driver.core.BoundStatement
import com.datastax.driver.core.ResultSet
import com.datastax.driver.core.querybuilder.QueryBuilder
import com.datastax.driver.core.Row

case class User(id: UUID, collection_id: UUID, firstname: String, lastname: String, login: String, email: String, email_confirmed: String, dateOfBirth: String,
                gender: String, mobilePhone: String, createdAt: String, password: String, picUrl: String,
                tacConfirmed: String, device_id: UUID, client_id: UUID, loggedIn: String, updated_at: String)

case class UserPrefs(id: UUID, pref: String, tag: String)

class UsersRepository(client: SimpleClient) {

  import Utils._

  def getAll(implicit ctxt: ExecutionContext): Future[List[User]] = {

    import WrapAsScala.iterableAsScalaIterable

    client.getRows.toScalaFuture.map { rows =>
      rows.map(row => user(row)).toList
    }
  }

  private def user(row: Row): User =
    User(
      row.getUUID("id"), row.getUUID("collection_id"), row.getString("firstname"),
      row.getString("lastname"), row.getString("login"), row.getString("email"),
         row.getString("email_confirmed"), row.getString("dateOfBirth"), row.getString("gender"), row.getString("mobilePhone"), row.getString("createdAt"), row.getString("password"),
         row.getString("picUrl"), row.getString("tacConfirmed"), row.getUUID("device_id"), row.getUUID("client_id"), row.getString("loggedIn"), row.getString("updated_at"))

  def getById(id: UUID)(implicit ctxt: ExecutionContext): Future[User] = {
    val stmt = new BoundStatement(client.session.prepare("SELECT * FROM gee.users WHERE id = ?;"))
    client.session.executeAsync(stmt.bind(id)).toScalaFuture.map(rs => user(rs.one))
  }

  def insert(collection_id: UUID, firstname: String, lastname: String, login: String, email: String, email_confirmed: String, dateOfBirth: String, gender: String, mobilePhone: String,
             createdAt: String, password: String, picUrl: String, tacConfirmed: String, device_id: UUID, client_id: UUID,
             loggedIn: String, updated_at: String)(implicit ctxt: ExecutionContext): Future[UUID] = {
    val stmt = new BoundStatement(client.session.prepare("INSERT INTO gee.users (id, collection_id, firstname, lastname, login, email, email_confirmed, dateOfBirth, gender, mobilePhone," +
                                  "createdAt, password, picUrl, tacConfirmed, device_id, client_id, loggedIn, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?," +
                                  "?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"))
    val id = UUIDs.timeBased
    client.session.executeAsync(stmt.bind(id, collection_id, firstname, lastname, login, email, email_confirmed, dateOfBirth, gender, mobilePhone, createdAt, password,
                                picUrl, tacConfirmed, device_id, client_id, loggedIn, updated_at)).toScalaFuture.map(rs => id)
  }

  def userLogin(email: String, password: String)(implicit ctxt: ExecutionContext): Future[UUID] = {
    val stmt = new BoundStatement(client.session.prepare("SELECT * FROM gee.users WHERE email = ? AND password = ? allow filtering;"))
    val id = UUIDs.timeBased
    client.session.executeAsync(stmt.bind(email, password)).toScalaFuture.map(rs => id)
  }
}

object JsonFormats {

  /**
   * Deserializer for java.util.UUID, from latest play Reads (was added on 2014-03-01 to master,
   * see https://github.com/playframework/playframework/pull/2428)
   */
  private def uuidReader(checkUuuidValidity: Boolean = false): Reads[java.util.UUID] = new Reads[java.util.UUID] {
    import java.util.UUID
    import scala.util.Try
    def check(s: String)(u: UUID): Boolean = (u != null && s == u.toString())
    def parseUuid(s: String): Option[UUID] = {
      val uncheckedUuid = Try(UUID.fromString(s)).toOption

      if (checkUuuidValidity) {
        uncheckedUuid filter check(s)
      } else {
        uncheckedUuid
      }
    }

    def reads(json: JsValue) = json match {
      case JsString(s) => {
        parseUuid(s).map(JsSuccess(_)).getOrElse(JsError(Seq(JsPath() -> Seq(ValidationError("error.expected.uuid")))))
      }
      case _ => JsError(Seq(JsPath() -> Seq(ValidationError("error.expected.uuid"))))
    }
  }

  private implicit val uuidReads: Reads[java.util.UUID] = uuidReader()
  private implicit val uuidWrites: Writes[UUID] = Writes { uuid => JsString(uuid.toString) }

  implicit val userFormat: Format[User] = Json.format[User]
  implicit val userDataReads = (
    (__ \ 'collection_id).read[UUID] and
    (__ \ 'firstname).read[String] and
    (__ \ 'lastname).read[String] and
    (__ \ 'login).read[String] and
    (__ \ 'email).read[String] and
    (__ \ 'email_confirmed).read[String] and
    (__ \ 'dateOfBirth).read[String] and
    (__ \ 'gender).read[String] and
    (__ \ 'mobilePhone).read[String] and
    (__ \ 'createdAt).read[String] and
    (__ \ 'password).read[String] and
    (__ \ 'picUrl).read[String] and
    (__ \ 'tacConfirmed).read[String] and
    (__ \ 'device_id).read[UUID] and
    (__ \ 'client_id).read[UUID] and
    (__ \ 'loggedIn).read[String] and
    (__ \ 'updated_at).read[String]
    ) tupled

  implicit val userDataReadsLogin = (
    (__ \ 'email).read[String] and
    (__ \ 'password).read[String]
    ) tupled
}
