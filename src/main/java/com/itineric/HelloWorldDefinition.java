package com.itineric;

import org.springframework.security.access.prepost.PreAuthorize;

public interface HelloWorldDefinition
{
  @PreAuthorize("@myAuthenticator.isAuthenticated(authentication)")
  String helloWorld();
}
