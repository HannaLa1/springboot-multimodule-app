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
@Table(name = "cities")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class City extends AbstractBaseEntity {

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "city_index", nullable = false)
    private String cityIndex;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Country> countries = new HashSet<>();
}
