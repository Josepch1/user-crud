package josehomenhuck.user.service;

import josehomenhuck.user.entity.User;
import josehomenhuck.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    private UserService underTest;

    @BeforeEach
    void setUp() {
        underTest = new UserService(userRepository);
    }


    private User createUserFromDTO(String username, String email, String password) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        return user;
    }

    // Happy path
    @Test
    void createUser() {
        // Given
        String username = "test";
        String email = "test@email.com";
        String password = "pass";

        User user = createUserFromDTO(username, email, password);

        // When
        underTest.createUser(user);

        // Then
        verify(userRepository).save(user);
    }

    // Sad path
    @Test
    void createUserFailure() {
        // Given
        String username = "test";
        String email = "test@email.com";
        String password = "pass";

        User user = createUserFromDTO(username, email, password);

        // Mock the behavior of userRepository to simulate a failure when saving
        when(userRepository.save(user)).thenThrow(new RuntimeException("Database error"));

        // When & Then
        assertThrows(RuntimeException.class, () -> underTest.createUser(user));

        // Verify that save was attempted
        verify(userRepository).save(user);
    }


    // Happy path
    @Test
    void getAllUsers() {
        // Given
        String username1 = "test1";
        String email1 = "test1@email.com";
        String password1 = "pass1";

        String username2 = "test2";
        String email2 = "test2@email.com";
        String password2 = "pass2";

        List<User> mockUsers = List.of(
                createUserFromDTO(username1, email1, password1),
                createUserFromDTO(username2, email2, password2)
        );
        when(userRepository.findAll()).thenReturn(mockUsers);

        // When
        List<User> result = underTest.getAllUsers();

        // Then
        verify(userRepository).findAll();
        assertEquals(mockUsers.size(), result.size());
        assertEquals(mockUsers, result);
    }

    // Sad path
    @Test
    void getAllUsersEmpty() {
        // Given
        when(userRepository.findAll()).thenReturn(Collections.emptyList());

        // When
        List<User> result = underTest.getAllUsers();

        // Then
        verify(userRepository).findAll(); // Verify repository interaction
        assertTrue(result.isEmpty());
    }


    // Happy path
    @Test
    void findByUsername() {
        // Given
        String username = "test";
        String email = "test@email.com";
        String password = "pass";

        User user = createUserFromDTO(username, email, password);
        when(userRepository.findByUsername(username)).thenReturn(user);

        // When
        Optional<User> result = Optional.ofNullable(underTest.findByUsername(username));

        // Then
        verify(userRepository).findByUsername(username);
        assertTrue(result.isPresent());
        assertEquals(user, result.get());
    }

    // Sad path
    @Test
    void findByUsernameNotFound() {
        // Given
        String username = "test";

        when(userRepository.findByUsername(username)).thenReturn(null);

        // When
        Optional<User> result = Optional.ofNullable(underTest.findByUsername(username));

        // Then
        verify(userRepository).findByUsername(username);
        assertTrue(result.isEmpty());
    }

    // Happy path
    @Test
    void findById() {
        // Given
        Long id = 1L;
        User user = new User();
        when(userRepository.findById(id)).thenReturn(Optional.of(user));

        // When
        Optional<User> result = Optional.ofNullable(underTest.findById(id));

        // Then
        verify(userRepository).findById(id);
        assertTrue(result.isPresent());
        assertEquals(user, result.get());
    }

    // Sad Path
    @Test
    void findByIdNotFound() {
        // Given
        Long id = 1L;
        when(userRepository.findById(id)).thenReturn(Optional.empty());

        // When
        Optional<User> result = Optional.ofNullable(underTest.findById(id));

        // Then
        verify(userRepository).findById(id);
        assertTrue(result.isEmpty());
    }

    // Happy path
    @Test
    void deleteUser() {
        // Given
        Long id = 1L;
        User user = new User();
        when(userRepository.findById(id)).thenReturn(Optional.of(user));

        // When
        underTest.deleteUser(id);

        // Then
        verify(userRepository).deleteById(id);
    }


    // Sad path
    @Test
    void deleteUserNotFound() {
        // Given
        Long id = 1L;

        when(userRepository.findById(id)).thenReturn(Optional.empty());

        // When & Then
        assertThrows(IllegalArgumentException.class, () -> underTest.deleteUser(id));

        verify(userRepository, never()).deleteById(anyLong());
    }
}