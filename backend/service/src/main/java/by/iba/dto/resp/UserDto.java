package by.iba.dto.resp;

import by.iba.dto.AbstractDto;
import by.iba.entity.customer.AccountStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends AbstractDto {

    private String username;

    private String email;

    private String firstName;

    private String lastName;

    private LocalDateTime created;

    private LocalDateTime updated;

    private Set<RoleDto> roles = new HashSet<>();

    private LocalDateTime lastVisitedDate;

    private AccountStatus userAccountStatus;
}
