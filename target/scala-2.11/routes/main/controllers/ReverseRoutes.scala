
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/user/workspace/letsplay-master-new-1/conf/routes
// @DATE:Thu Aug 06 12:26:05 CEST 2015

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:8
package controllers {

  // @LINE:8
  class ReverseCass(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def createSong(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "song")
    }
  
    // @LINE:8
    def index(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "song")
    }
  
    // @LINE:11
    def songById(id:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "song/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
    }
  
  }

  // @LINE:27
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:27
    def versioned(file:Asset): Call = {
      implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:14
  class ReverseApplication(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def staticFile(filename:String): Call = {
    
      (filename: @unchecked) match {
      
        // @LINE:17
        case (filename)  =>
          import ReverseRouteContext.empty
          Call("GET", _prefix + { _defaultPrefix } + "file/" + implicitly[PathBindable[String]].unbind("filename", filename))
      
      }
    
    }
  
    // @LINE:22
    def base(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "base")
    }
  
    // @LINE:24
    def search(q:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "search" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("q", q)))))
    }
  
    // @LINE:23
    def home(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "home")
    }
  
    // @LINE:15
    def staticUrl(filename:String): Call = {
    
      (filename: @unchecked) match {
      
        // @LINE:15
        case (filename)  =>
          import ReverseRouteContext.empty
          Call("GET", _prefix + { _defaultPrefix } + "v1/" + implicitly[PathBindable[String]].unbind("filename", filename))
      
      }
    
    }
  
    // @LINE:14
    def index(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix)
    }
  
  }


}