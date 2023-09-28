package com.itineric;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class MyApplication implements HelloWorldDefinition
{
  @Override
  @RequestMapping("/")
  public String helloWorld()
  {
    return "Hello World!";
  }

  public static void main(final String[] args)
  {
    SpringApplication.run(MyApplication.class, args);
  }
}
