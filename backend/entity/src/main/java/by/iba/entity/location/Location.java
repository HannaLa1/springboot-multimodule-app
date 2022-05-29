package by.iba.entity.location;

import by.iba.entity.AbstractBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "locations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Location extends AbstractBaseEntity {

    @Column(name = "country", nullable = false)
    @OneToOne(fetch = FetchType.LAZY)
    private Country country;

    @Column(name = "city", nullable = false)
    @OneToOne(fetch = FetchType.LAZY)
    private City city;

    @Column(name = "street", nullable = false)
    @OneToOne(fetch = FetchType.LAZY)
    private Street street;
}
