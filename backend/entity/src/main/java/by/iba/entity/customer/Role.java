package by.iba.entity.customer;

import by.iba.entity.AbstractBaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role extends AbstractBaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "type_of_role", nullable = false, unique = true)
    private RoleType roleType;
}
