package by.iba.dto.req;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResetDto {

    private String recovery_token;

    @Size(min = 6, max = 15, message = "Password should be between 6 and 15 characters")
    @NotBlank(message = "Password should not be blank")
    private String password;
}
