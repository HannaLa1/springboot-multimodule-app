package by.iba.dto;

import by.iba.entity.TypeOfRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto extends AbstractDto {

    private TypeOfRole typeOfRole;
}
