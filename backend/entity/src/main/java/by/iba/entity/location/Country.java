package by.iba.entity.location;

import by.iba.entity.AbstractBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "countries")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Country extends AbstractBaseEntity {

    @Column(name = "country", nullable = false)
    private String country;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Street> streets = new HashSet<>();
}
