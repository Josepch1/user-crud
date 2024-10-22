package josehomenhuck.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import josehomenhuck.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
  User findByUsername(String username);
}
