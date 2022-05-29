package by.iba.entity.car;

import by.iba.entity.AbstractBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "car_models")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarModel extends AbstractBaseEntity {

    @Column(name = "model", nullable = false)
    private String model;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<CarGeneration> carGenerations = new HashSet<>();
}
