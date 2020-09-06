package demo.openfeign.user.client.user;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

public class UserServiceFactory {

  public static UserService create(String targetUrl) {

    return Feign.builder().encoder(new JacksonEncoder()).decoder(new JacksonDecoder())
        .target(UserService.class, targetUrl);
  }
}
