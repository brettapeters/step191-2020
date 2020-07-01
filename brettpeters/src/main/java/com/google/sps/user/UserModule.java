package com.google.sps.user;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.google.inject.servlet.RequestParameters;
import com.google.inject.servlet.RequestScoped;
import java.util.Map;

/**
 * Guice module for injecting user information
 */
public class UserModule extends AbstractModule {

  @Provides
  @Named("username")
  @RequestScoped
  public String provideUserName(@RequestParameters Map<String, String[]> params) {
    if (params.containsKey("name")) {
      return params.get("name")[0];
    }
    return "World";
  }
}
