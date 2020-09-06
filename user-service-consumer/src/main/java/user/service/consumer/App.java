package user.service.consumer;

import demo.openfeign.user.client.dto.User;
import demo.openfeign.user.client.user.UserService;
import demo.openfeign.user.client.user.UserServiceFactory;

public class App {

    private static final String USER_SERVICE_HOST = "http://localhost:8080";

    public static void main(String[] args) {

        UserService userService = UserServiceFactory.create(USER_SERVICE_HOST);

        User newUser = new User();
        newUser.setName("John");
        newUser.setAddress("World");

        User addedUser = userService.addUser(newUser);

        System.out.println("Created new user = " + addedUser);

        User user = userService.getUser(addedUser.getId().toString());

        System.out.println("User = " + user);
    }
}
