
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/user/workspace/letsplay-master-new-1/conf/routes
// @DATE:Thu Aug 06 12:26:05 CEST 2015

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseCass Cass = new controllers.ReverseCass(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseApplication Application = new controllers.ReverseApplication(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseCass Cass = new controllers.javascript.ReverseCass(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseApplication Application = new controllers.javascript.ReverseApplication(RoutesPrefix.byNamePrefix());
  }

}
