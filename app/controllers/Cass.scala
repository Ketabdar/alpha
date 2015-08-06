package controllers

import play.api._
import play.api.mvc._
import models.SimpleClient
import models.UsersRepository
import play.api.libs.json.Json
import com.datastax.driver.core.utils.UUIDs
import models.User
import play.api.libs.json.JsError
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
    request.body.validate[(String, String, String, String, String, String, String, String, String)].map {
      case (firstname, lastname, email, email_confirmed, dateOfBirth, gender, mobilePhone, createdAt, password) => {
        var usersRepo: UsersRepository = new UsersRepository(new SimpleClient("127.0.0.1"))
        usersRepo.insert(firstname, lastname, email, email_confirmed, dateOfBirth, gender, mobilePhone, createdAt, password).map( id =>
          Created.withHeaders("Location" -> routes.Cass.userById(id.toString).absoluteURL(false))
        )
      }
    }.recoverTotal {
      e => Future.successful(BadRequest("Detected error:" + JsError.toFlatJson(e)))
    }
  }

  def userById(id: String) = Action.async {
      var usersRepo: UsersRepository = new UsersRepository(new SimpleClient("127.0.0.1"))
       usersRepo.getById(UUID.fromString(id)).map(user => Ok(Json.toJson(user)))
  }

}
