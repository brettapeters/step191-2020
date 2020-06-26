package com.google.sps.user;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Names;

/**
 * Guice module for injecting user information
 */
public class UserModule extends AbstractModule {

  @Override
  protected void configure() {
    bindConstant().annotatedWith(Names.named("username")).to("Brett");
  }
}