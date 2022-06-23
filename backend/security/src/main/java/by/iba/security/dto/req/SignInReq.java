package by.iba.security.dto.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInReq {

    @Pattern(regexp = "^[a-z](\\.?\\w)*@[a-z]+(\\.[a-z]+)+", message = "The login must start with a letter," +
            " all letters are small," +
            " there may be a dot in it," +
            " but not 2 in a row." +
            " The @ must be present and the domain after it")
    @NotBlank(message = "Email should not be blank")
    private String email;

    @Size(min = 6, max = 15, message = "Password should be between 6 and 15 characters")
    @NotBlank(message = "Password should not be blank")
    private String password;
}
