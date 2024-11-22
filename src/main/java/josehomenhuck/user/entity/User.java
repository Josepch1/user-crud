package josehomenhuck.user.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "USERS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username is required")
    @Column
    private String username;

    @NotBlank(message = "Email is required")
    @Column
    private String email;

    @NotBlank(message = "Password is required")
    @Column
    private String password;
}
