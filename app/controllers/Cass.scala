package controllers

import jdk.nashorn.internal.runtime.JSErrorType
import play.api._
import play.api.mvc._
import models.SimpleClient
import models.UsersRepository
import play.api.libs.json.Json
import com.datastax.driver.core.utils.UUIDs
import models.User
import play.api.libs.json.JsError
import sun.security.util.Password
import scala.concurrent.Future
import java.util.UUID
import scala.util.Try

//def getRepo{
  //var cassandra: SimpleClient = cassandra = new SimpleClient("127.0.0.1")
  //cassandra = new SimpleClient(app.configuration.getString("cassandra.node")
//  controller = new controllers.Application(new UsersRepository(cassandra))
//}
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import models.JsonFormats._



//usersRepo: UsersRepository

class Cass extends Controller {

  def index22 = Action {
      //Ok(views.html.index("Your new application is ready."))
      Ok("Alpha")
  }

  def index = Action.async {
    var usersRepo: UsersRepository = new UsersRepository(new SimpleClient("127.0.0.1"))
    usersRepo.getAll.map(users => Ok(Json.toJson(users)))
  }

  def createUser = Action.async(parse.json) { implicit request =>
    // Json Format defined in models.JsonFormats.userDataReads
    request.body.validate[(UUID, String, String, String, String, String, String, String, String, String, String, String, String, UUID, UUID, String, String)].map {
      case (collection_id, firstname, lastname, login, email, email_confirmed, dateOfBirth, gender, mobilePhone, createdAt, password, picUrl, tacConfirmed, device_id,
            client_id, loggedIn, updated_at) => {
        var usersRepo: UsersRepository = new UsersRepository(new SimpleClient("127.0.0.1"))
        usersRepo.insert(collection_id, firstname, lastname, login, email, email_confirmed, dateOfBirth, gender, mobilePhone, createdAt, password, picUrl,
                        tacConfirmed, device_id, client_id, loggedIn, updated_at).map( id =>
          Created.withHeaders("Location" -> routes.Cass.userById(id.toString).absoluteURL(false))
        )
      }
    }.recoverTotal {
      e => Future.successful(BadRequest("Detected error:" + JsError.toFlatJson(e)))
    }
  }

  def userLoginByEmailAndPassword = Action.async(parse.json) { implicit request =>
    request.body.validate[(String, String)].map {
      case (email, password) => {
        var userRepo: UsersRepository = new UsersRepository(new SimpleClient("127.0.0.1"))
          userRepo.userLogin(email, password).map( id =>
          Created.withHeaders("Location" -> routes.Cass.userById(id.toString).absoluteURL(false))
        )
      }
    }.recoverTotal {
      e => Future.successful(BadRequest("Detected error:" + JsError.toFlatJson(e)))
    }

  }

  /*def userLoginByEmailAndPassword(email: String, password: String) = Action.async {
      var userRepo: UsersRepository = new UsersRepository(new SimpleClient("127.0.0.1"))
      userRepo.getByEmailAndPassword(email, password).map(user => Ok(Json.toJson(user)))
  }*/

  def userById(id: String) = Action.async {
      var usersRepo: UsersRepository = new UsersRepository(new SimpleClient("127.0.0.1"))
       usersRepo.getById(UUID.fromString(id)).map(user => Ok(Json.toJson(user)))
  }

}
