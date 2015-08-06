package controllers

import play.api._
import play.api.mvc._

import java.io._
import java.io
import org.apache.http.HttpEntity
import org.apache.http.HttpResponse
import org.apache.http.client.ClientProtocolException
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.DefaultHttpClient
import scala.collection.mutable.StringBuilder
import play.api.libs.json._
import play.api.Play.current

class Application extends Controller {

  def index = Action {
      //Ok(views.html.index("Your new application is ready."))
      Ok("Alpha")
  }

  def base = Action { request =>
      Ok("Got METHOD: " + request.method )
  }

  def home = Action {
      downloadJsonOk("https://api-mobile.home24.com/api/v1/search?query=Bettb%C3%A4nke")
  }

  def search(q: String) = Action {
      downloadJsonOk("https://api-mobile.home24.com/api/v1/search?query="+q)
  }

  def staticUrl(path: String) = Action {
      var base: String = current.configuration.getString("json.url.base").get
      val url: String = base+""+path
      println("url "+url)
      downloadJsonOk(url)
  }

  def downloadJsonOk(url: String) =  {
      val content = getRestContent(url)
      println(content)
      val jsonObject: JsValue = Json.parse(content)
      Ok(jsonObject).as("application/json")
  }

  def staticFile(filename: String) = Action { request =>
      var root: String = current.configuration.getString("json.files.path").get
      val filepath: String = root+"/"+ request.method.toLowerCase()+"/"+filename
      println("filepath "+filepath)
      val source = scala.io.Source.fromFile(filepath)
      val jsonText = try source.mkString finally source.close()
      val jsonObject: JsValue = Json.parse(jsonText)
      Ok(jsonObject).as("application/json")
  }

  /**
   * Returns the text content from a REST URL. Returns a blank String if there
   * is a problem.
   */
  def getRestContent(url:String): String = {
      val httpClient = new DefaultHttpClient()
      val httpGet = new HttpGet(url)
      // set the desired header values
      httpGet.setHeader("Content-Type", "application/json")
      httpGet.setHeader("X-App-Domain", "1")
      httpGet.setHeader("Accept-Language", "de_DE")
      val httpResponse = httpClient.execute(httpGet)
      val entity = httpResponse.getEntity()
      var content = ""
      if (entity != null) {
          val inputStream = entity.getContent()
          content = scala.io.Source.fromInputStream(inputStream).getLines.mkString
          inputStream.close
      }
      httpClient.getConnectionManager().shutdown()
      return content
  }

}
