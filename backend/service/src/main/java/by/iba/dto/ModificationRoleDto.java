package by.iba.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModificationRoleDto {

    @NotNull(message = "Role id should not be blank")
    private Long roleId;
}
