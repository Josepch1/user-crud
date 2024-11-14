package josehomenhuck.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import josehomenhuck.user.entity.User;
import josehomenhuck.user.repository.UserRepository;

@Service
public class UserService {
  
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User createUser(User user) {
    return userRepository.save(user);
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User findByUsername(String username) {
    return userRepository.findByUsername(username);
  }

  public User findById(Long id) {
    return userRepository.findById(id).orElse(null);
  }
}
