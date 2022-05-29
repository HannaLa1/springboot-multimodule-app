package by.iba.entity.price;

import by.iba.entity.AbstractBaseEntity;
import by.iba.entity.car.BodyType;
import by.iba.entity.location.Country;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "prices")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Price extends AbstractBaseEntity {

    @Column(name = "currency_types", nullable = false)
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<CurrencyType> currencyTypes = new HashSet<>();

    @Column(name = "price", nullable = false)
    private Double price;
}
