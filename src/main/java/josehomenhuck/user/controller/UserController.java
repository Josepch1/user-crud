package josehomenhuck.user.controller;

import josehomenhuck.user.dto.UserDTO;
import josehomenhuck.user.dto.UserMapper;
import org.springframework.web.bind.annotation.*;

import josehomenhuck.user.entity.User;
import josehomenhuck.user.service.UserService;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody UserDTO user) {
        try {
            User newUser = userMapper.mapToUser(user);
            return userService.createUser(newUser);
        } catch (Exception e) {
            throw new RuntimeException("Error creating user");
        }
    }

    @GetMapping("{id}")
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("username/{username}")
    public User findByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
