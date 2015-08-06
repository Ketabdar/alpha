
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/user/workspace/letsplay-master-new-1/conf/routes
// @DATE:Thu Aug 06 12:26:05 CEST 2015

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:8
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:8
  class ReverseCass(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def createSong: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Cass.createSong",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "song"})
        }
      """
    )
  
    // @LINE:8
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Cass.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "song"})
        }
      """
    )
  
    // @LINE:11
    def songById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Cass.songById",
      """
        function(id) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "song/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
        }
      """
    )
  
  }

  // @LINE:27
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:27
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[Asset]].javascriptUnbind + """)("file", file)})
        }
      """
    )
  
  }

  // @LINE:14
  class ReverseApplication(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def staticFile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.staticFile",
      """
        function(filename) {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "file/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("filename", filename)})
          }
        
        }
      """
    )
  
    // @LINE:22
    def base: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.base",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "base"})
        }
      """
    )
  
    // @LINE:24
    def search: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.search",
      """
        function(q) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "search" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("q", q)])})
        }
      """
    )
  
    // @LINE:23
    def home: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.home",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "home"})
        }
      """
    )
  
    // @LINE:15
    def staticUrl: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.staticUrl",
      """
        function(filename) {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "v1/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("filename", filename)})
          }
        
        }
      """
    )
  
    // @LINE:14
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }


}