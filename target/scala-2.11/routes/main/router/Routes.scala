
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/user/workspace/letsplay-master-new-1/conf/routes
// @DATE:Fri Aug 07 16:21:58 CEST 2015

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:8
  Cass_2: controllers.Cass,
  // @LINE:14
  Application_1: controllers.Application,
  // @LINE:27
  Assets_0: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:8
    Cass_2: controllers.Cass,
    // @LINE:14
    Application_1: controllers.Application,
    // @LINE:27
    Assets_0: controllers.Assets
  ) = this(errorHandler, Cass_2, Application_1, Assets_0, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Cass_2, Application_1, Assets_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user""", """controllers.Cass.index"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user""", """controllers.Cass.createUser"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/$id<[^/]+>""", """controllers.Cass.userById(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """userlogin""", """controllers.Cass.userLoginByEmailAndPassword"""),
    ("""GET""", this.prefix, """controllers.Application.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """v1/$filename<.+>""", """controllers.Application.staticUrl(filename:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """url/$filename<.+>""", """controllers.Application.staticUrl(filename:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """file/$filename<.+>""", """controllers.Application.staticFile(filename:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """file/$filename<.+>""", """controllers.Application.staticFile(filename:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """file/$filename<.+>""", """controllers.Application.staticFile(filename:String)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """file/$filename<.+>""", """controllers.Application.staticFile(filename:String)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """file/$filename<.+>""", """controllers.Application.staticFile(filename:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """base""", """controllers.Application.base"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """home""", """controllers.Application.home"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """search""", """controllers.Application.search(q:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:8
  private[this] lazy val controllers_Cass_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user")))
  )
  private[this] lazy val controllers_Cass_index0_invoker = createInvoker(
    Cass_2.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Cass",
      "index",
      Nil,
      "GET",
      """""",
      this.prefix + """user"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_Cass_createUser1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user")))
  )
  private[this] lazy val controllers_Cass_createUser1_invoker = createInvoker(
    Cass_2.createUser,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Cass",
      "createUser",
      Nil,
      "POST",
      """""",
      this.prefix + """user"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_Cass_userById2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Cass_userById2_invoker = createInvoker(
    Cass_2.userById(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Cass",
      "userById",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """user/$id<[^/]+>"""
    )
  )

  // @LINE:11
  private[this] lazy val controllers_Cass_userLoginByEmailAndPassword3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("userlogin")))
  )
  private[this] lazy val controllers_Cass_userLoginByEmailAndPassword3_invoker = createInvoker(
    Cass_2.userLoginByEmailAndPassword,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Cass",
      "userLoginByEmailAndPassword",
      Nil,
      "POST",
      """""",
      this.prefix + """userlogin"""
    )
  )

  // @LINE:14
  private[this] lazy val controllers_Application_index4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Application_index4_invoker = createInvoker(
    Application_1.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "index",
      Nil,
      "GET",
      """""",
      this.prefix + """"""
    )
  )

  // @LINE:15
  private[this] lazy val controllers_Application_staticUrl5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("v1/"), DynamicPart("filename", """.+""",false)))
  )
  private[this] lazy val controllers_Application_staticUrl5_invoker = createInvoker(
    Application_1.staticUrl(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "staticUrl",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """v1/$filename<.+>"""
    )
  )

  // @LINE:16
  private[this] lazy val controllers_Application_staticUrl6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("url/"), DynamicPart("filename", """.+""",false)))
  )
  private[this] lazy val controllers_Application_staticUrl6_invoker = createInvoker(
    Application_1.staticUrl(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "staticUrl",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """url/$filename<.+>"""
    )
  )

  // @LINE:17
  private[this] lazy val controllers_Application_staticFile7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("file/"), DynamicPart("filename", """.+""",false)))
  )
  private[this] lazy val controllers_Application_staticFile7_invoker = createInvoker(
    Application_1.staticFile(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "staticFile",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """file/$filename<.+>"""
    )
  )

  // @LINE:18
  private[this] lazy val controllers_Application_staticFile8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("file/"), DynamicPart("filename", """.+""",false)))
  )
  private[this] lazy val controllers_Application_staticFile8_invoker = createInvoker(
    Application_1.staticFile(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "staticFile",
      Seq(classOf[String]),
      "POST",
      """""",
      this.prefix + """file/$filename<.+>"""
    )
  )

  // @LINE:19
  private[this] lazy val controllers_Application_staticFile9_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("file/"), DynamicPart("filename", """.+""",false)))
  )
  private[this] lazy val controllers_Application_staticFile9_invoker = createInvoker(
    Application_1.staticFile(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "staticFile",
      Seq(classOf[String]),
      "DELETE",
      """""",
      this.prefix + """file/$filename<.+>"""
    )
  )

  // @LINE:20
  private[this] lazy val controllers_Application_staticFile10_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("file/"), DynamicPart("filename", """.+""",false)))
  )
  private[this] lazy val controllers_Application_staticFile10_invoker = createInvoker(
    Application_1.staticFile(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "staticFile",
      Seq(classOf[String]),
      "PATCH",
      """""",
      this.prefix + """file/$filename<.+>"""
    )
  )

  // @LINE:21
  private[this] lazy val controllers_Application_staticFile11_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("file/"), DynamicPart("filename", """.+""",false)))
  )
  private[this] lazy val controllers_Application_staticFile11_invoker = createInvoker(
    Application_1.staticFile(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "staticFile",
      Seq(classOf[String]),
      "PUT",
      """""",
      this.prefix + """file/$filename<.+>"""
    )
  )

  // @LINE:22
  private[this] lazy val controllers_Application_base12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("base")))
  )
  private[this] lazy val controllers_Application_base12_invoker = createInvoker(
    Application_1.base,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "base",
      Nil,
      "GET",
      """""",
      this.prefix + """base"""
    )
  )

  // @LINE:23
  private[this] lazy val controllers_Application_home13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("home")))
  )
  private[this] lazy val controllers_Application_home13_invoker = createInvoker(
    Application_1.home,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "home",
      Nil,
      "GET",
      """""",
      this.prefix + """home"""
    )
  )

  // @LINE:24
  private[this] lazy val controllers_Application_search14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("search")))
  )
  private[this] lazy val controllers_Application_search14_invoker = createInvoker(
    Application_1.search(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "search",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """search"""
    )
  )

  // @LINE:27
  private[this] lazy val controllers_Assets_versioned15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned15_invoker = createInvoker(
    Assets_0.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/$file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:8
    case controllers_Cass_index0_route(params) =>
      call { 
        controllers_Cass_index0_invoker.call(Cass_2.index)
      }
  
    // @LINE:9
    case controllers_Cass_createUser1_route(params) =>
      call { 
        controllers_Cass_createUser1_invoker.call(Cass_2.createUser)
      }
  
    // @LINE:10
    case controllers_Cass_userById2_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_Cass_userById2_invoker.call(Cass_2.userById(id))
      }
  
    // @LINE:11
    case controllers_Cass_userLoginByEmailAndPassword3_route(params) =>
      call { 
        controllers_Cass_userLoginByEmailAndPassword3_invoker.call(Cass_2.userLoginByEmailAndPassword)
      }
  
    // @LINE:14
    case controllers_Application_index4_route(params) =>
      call { 
        controllers_Application_index4_invoker.call(Application_1.index)
      }
  
    // @LINE:15
    case controllers_Application_staticUrl5_route(params) =>
      call(params.fromPath[String]("filename", None)) { (filename) =>
        controllers_Application_staticUrl5_invoker.call(Application_1.staticUrl(filename))
      }
  
    // @LINE:16
    case controllers_Application_staticUrl6_route(params) =>
      call(params.fromPath[String]("filename", None)) { (filename) =>
        controllers_Application_staticUrl6_invoker.call(Application_1.staticUrl(filename))
      }
  
    // @LINE:17
    case controllers_Application_staticFile7_route(params) =>
      call(params.fromPath[String]("filename", None)) { (filename) =>
        controllers_Application_staticFile7_invoker.call(Application_1.staticFile(filename))
      }
  
    // @LINE:18
    case controllers_Application_staticFile8_route(params) =>
      call(params.fromPath[String]("filename", None)) { (filename) =>
        controllers_Application_staticFile8_invoker.call(Application_1.staticFile(filename))
      }
  
    // @LINE:19
    case controllers_Application_staticFile9_route(params) =>
      call(params.fromPath[String]("filename", None)) { (filename) =>
        controllers_Application_staticFile9_invoker.call(Application_1.staticFile(filename))
      }
  
    // @LINE:20
    case controllers_Application_staticFile10_route(params) =>
      call(params.fromPath[String]("filename", None)) { (filename) =>
        controllers_Application_staticFile10_invoker.call(Application_1.staticFile(filename))
      }
  
    // @LINE:21
    case controllers_Application_staticFile11_route(params) =>
      call(params.fromPath[String]("filename", None)) { (filename) =>
        controllers_Application_staticFile11_invoker.call(Application_1.staticFile(filename))
      }
  
    // @LINE:22
    case controllers_Application_base12_route(params) =>
      call { 
        controllers_Application_base12_invoker.call(Application_1.base)
      }
  
    // @LINE:23
    case controllers_Application_home13_route(params) =>
      call { 
        controllers_Application_home13_invoker.call(Application_1.home)
      }
  
    // @LINE:24
    case controllers_Application_search14_route(params) =>
      call(params.fromQuery[String]("q", None)) { (q) =>
        controllers_Application_search14_invoker.call(Application_1.search(q))
      }
  
    // @LINE:27
    case controllers_Assets_versioned15_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned15_invoker.call(Assets_0.versioned(path, file))
      }
  }
}