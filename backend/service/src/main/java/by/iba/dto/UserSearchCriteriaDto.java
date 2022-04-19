package by.iba.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSearchCriteriaDto {

    @Size(min = 3, max = 10, message = "Username should be between 3 and 15 characters")
    private String username;

    @Pattern(regexp = "^[a-z](\\.?\\w)*@[a-z]+(\\.[a-z]+)+", message = "The login must start with a letter," +
            " all letters are small," +
            " there may be a dot in it," +
            " but not 2 in a row." +
            " The @ must be present and the domain after it")
    private String email;

    @Size(min = 3, max = 10, message = "First name should be between 3 and 15 characters")
    private String firstName;

    @Size(min = 3, max = 10, message = "Last name should be between 3 and 15 characters")
    private String lastName;

    private Set<RoleDto> roles = new HashSet<>();
}
