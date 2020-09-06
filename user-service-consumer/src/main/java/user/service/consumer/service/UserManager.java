package user.service.consumer.service;

import demo.openfeign.user.client.dto.User;
import demo.openfeign.user.client.user.UserService;

public class UserManager {

  private final UserService userService;

  public UserManager(UserService userService) {

    super();
    this.userService = userService;
  }

  public User addUser(User user) {

    return userService.addUser(user);
  }

  public User getUser(String id) {

    return userService.getUser(id);
  }
}
