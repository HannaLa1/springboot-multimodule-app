package by.iba.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpReq {

    @Size(min = 3, max = 10, message = "Username should be between 3 and 15 characters")
    @NotBlank(message = "Username should not be blank")
    private String username;

    @Size(min = 6, max = 15, message = "Password should be between 6 and 15 characters")
    @NotBlank(message = "Password should not be blank")
    private String password;

    @Size(min = 6, max = 15, message = "Confirmed password should be between 6 and 15 characters")
    @NotBlank(message = "Confirmed password should not be blank")
    private String confirmPassword;

    @Pattern(regexp = "^[a-z](\\.?\\w)*@[a-z]+(\\.[a-z]+)+", message = "The login must start with a letter," +
            " all letters are small," +
            " there may be a dot in it," +
            " but not 2 in a row." +
            " The @ must be present and the domain after it")
    @NotBlank(message = "Email should not be blank")
    private String email;

    @NotBlank(message = "First name should not be blank")
    private String firstName;

    @NotBlank(message = "Last name should not be blank")
    private String lastName;

    @NotBlank(message = "Image url should not be blank")
    private String imageUrl;
}
