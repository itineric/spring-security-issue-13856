See https://github.com/spring-projects/spring-security/issues/13856

Run the example using standard VM:
```
> mvn spring-boot:run
```
And then
```
> curl localhost:8080
```
Expected output is an error 500 since the reproduction is minimal and not everything for spring-security implementation is provided.


With native compilation
```
> mvn -Pnative package
> target/native-hello-world-with-security
```
And then
```
> curl localhost:8080
```
Output is "Hello World!"


When moving the @PreAuthorize from the HelloWorldDefinition interface to the implementation makes it work.
```
  @Override
  @RequestMapping("/")
  @PreAuthorize("@myAuthenticator.isAuthenticated(authentication)") // we need this here and not on interface, otherwise native compiled exec wont use spring security
  public String helloWorld()
  {
    return "Hello World!";
  }
```
