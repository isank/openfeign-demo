package demo.openfeign.user.client.user;

import demo.openfeign.user.client.dto.User;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers("Content-Type: application/json")
public interface UserService {

  @RequestLine("POST /user")
  User addUser(User user);

  @RequestLine("GET /user/{id}")
  User getUser(@Param("id") String id);
}
