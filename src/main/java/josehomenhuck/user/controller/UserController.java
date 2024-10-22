package josehomenhuck.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import josehomenhuck.user.entity.User;
import josehomenhuck.user.service.UserService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/users")
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public List<User> getAllUsers() {
      return userService.getAllUsers();
  }
  
  @PostMapping
  public User createUser(User user) {
      return userService.createUser(user);
  }

  @GetMapping("{id}")
  public User findById(@PathVariable(value = "id") Long id) {
      return userService.findById(id);
  }

  @GetMapping("username/{username}")
  public User findByUsername(@PathVariable(value = "username") String username) {
      return userService.findByUsername(username);
  }
}
