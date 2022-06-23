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
@Table(name = "locations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Location extends AbstractBaseEntity {

    @OneToMany(fetch = FetchType.LAZY)
    private Set<City> cities = new HashSet<>();
}
