package by.iba.dto.resp;

import by.iba.dto.AbstractDto;
import by.iba.entity.customer.RoleType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto extends AbstractDto {

    private RoleType typeOfRole;
}
