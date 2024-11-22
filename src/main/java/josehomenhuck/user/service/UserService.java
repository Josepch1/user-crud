package josehomenhuck.user.service;

import java.util.List;
import java.util.Optional;

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

    public void deleteUser(Long id) {
    Optional<User> user = userRepository.findById(id);
    if (user.isEmpty()) {
        throw new IllegalArgumentException("User not found");
    }

    userRepository.deleteById(id);
}
}
