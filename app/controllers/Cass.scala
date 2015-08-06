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



//songsRepo: UsersRepository

class Cass extends Controller {

  def index22 = Action {
      //Ok(views.html.index("Your new application is ready."))
      Ok("Alpha")
  }

  def index = Action.async {
    var songsRepo: UsersRepository = new UsersRepository(new SimpleClient("127.0.0.1"))
    songsRepo.getAll.map(songs => Ok(Json.toJson(songs)))
  }

  def createSong = Action.async(parse.json) { implicit request =>
    // Json Format defined in models.JsonFormats.songDataReads
    request.body.validate[(String, String, String)].map {
      case (firstname, album, artist) => {
        var songsRepo: UsersRepository = new UsersRepository(new SimpleClient("127.0.0.1"))
        songsRepo.insert(firstname, album, artist).map( id =>
          Created.withHeaders("Location" -> routes.Cass.songById(id.toString).absoluteURL(false))
        )
      }
    }.recoverTotal {
      e => Future.successful(BadRequest("Detected error:" + JsError.toFlatJson(e)))
    }
  }

  def songById(id: String) = Action.async {
      var songsRepo: UsersRepository = new UsersRepository(new SimpleClient("127.0.0.1"))
       songsRepo.getById(UUID.fromString(id)).map(song => Ok(Json.toJson(song)))
  }

}
