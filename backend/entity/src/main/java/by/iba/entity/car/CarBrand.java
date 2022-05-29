package by.iba.entity.car;

import by.iba.entity.AbstractBaseEntity;
import by.iba.entity.sparepart.SparePart;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "car_brands")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarBrand extends AbstractBaseEntity {

    @Column(name = "brand", nullable = false)
    private String brand;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<CarModel> carModels = new HashSet<>();
}
