package josehomenhuck.user.dto;

import lombok.*;

@Data
public class UserDTO {
    @NonNull
    private String username;

    @NonNull
    private String email;

    @NonNull
    private String password;
}
