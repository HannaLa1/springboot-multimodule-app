package by.iba.dto.req;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModificationRoleDto {

    @NotNull(message = "Role id should not be blank")
    private Long roleId;
}
