package by.iba.dto;

import by.iba.entity.customer.UserAccountStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends AbstractDto {

    private String username;

    private String email;

    private String firstName;

    private String lastName;

    private LocalDateTime created;

    private LocalDateTime updated;

    private String imageUrl;

    private Set<RoleDto> roles = new HashSet<>();

    private LocalDateTime lastVisitedDate;

    private UserAccountStatus userAccountStatus;
}
