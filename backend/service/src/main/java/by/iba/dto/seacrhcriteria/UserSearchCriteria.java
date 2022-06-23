package by.iba.dto.seacrhcriteria;

import by.iba.dto.resp.RoleDto;
import lombok.*;

import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSearchCriteria extends BaseSearchCriteria{

    @Size(min = 3, max = 10, message = "Username should be between 3 and 15 characters")
    private String username;

    @Size(min = 3, max = 10, message = "First name should be between 3 and 15 characters")
    private String firstName;

    @Size(min = 3, max = 10, message = "Last name should be between 3 and 15 characters")
    private String lastName;

    private Set<RoleDto> roles = new HashSet<>();
}
