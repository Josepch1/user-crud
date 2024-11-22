package josehomenhuck.user.repository;

import josehomenhuck.user.dto.UserDTO;
import josehomenhuck.user.dto.UserMapper;
import josehomenhuck.user.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository underTest;

    private final UserMapper userMapper = new UserMapper();

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    // happy path
    @Test
    void findByUsernameFound() {
        // Given
        String username = "test";
        String email = "test@email.com";
        String password = "pass";
        UserDTO userDTO = new UserDTO(username, email, password);

        User user = userMapper.mapToUser(userDTO);

        underTest.save(user);

        // When
        User result = underTest.findByUsername(username);


        // Then
        assertEquals(username, result.getUsername());
        assertEquals(email, result.getEmail());
        assertEquals(password, result.getPassword());
        assertTrue(result.getId() > 0);
    }

    // unhappy path
    @Test
    void findByUsernameNotFound() {
        // Given
        String username = "wrongUsername";

        // When
        User result = underTest.findByUsername(username);

        // Then
        assertNull(result);
    }
}