package josehomenhuck.user.controller;

import org.springframework.web.bind.annotation.*;

import josehomenhuck.user.entity.User;
import josehomenhuck.user.service.UserService;

import java.util.List;


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
  public User createUser(@RequestBody User user) {
      return userService.createUser(user);
  }

  @GetMapping("{id}")
  public User findById(@PathVariable Long id) {
      return userService.findById(id);
  }

  @GetMapping("username/{username}")
  public User findByUsername(@PathVariable String username) {
      return userService.findByUsername(username);
  }
}
