package by.iba.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Role extends AbstractBaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "type_of_role", nullable = false, unique = true)
    private TypeOfRole typeOfRole;
}
