package by.iba.entity.sparepart;

import by.iba.entity.AbstractBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "phone_numbers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhoneNumber extends AbstractBaseEntity {

    @Column(name = "phone", nullable = false)
    private String phone;
}
