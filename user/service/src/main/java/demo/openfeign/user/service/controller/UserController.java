package demo.openfeign.user.service.controller;

import demo.openfeign.user.client.dto.User;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {

  private final Map<UUID, User> users = new ConcurrentHashMap<>();

  @PostMapping("user")
  public User addUser(@RequestBody User incomingUserRequest) {

    UUID userId = UUID.randomUUID();

    User user = new User();
    user.setId(userId);
    user.setName(incomingUserRequest.getName());
    user.setAddress(incomingUserRequest.getAddress());

    users.put(userId, user);

    return user;
  }

  @GetMapping("user/{id}")
  public User getUser(@PathVariable("id") String id) {

    return users.get(UUID.fromString(id));
  }
}
