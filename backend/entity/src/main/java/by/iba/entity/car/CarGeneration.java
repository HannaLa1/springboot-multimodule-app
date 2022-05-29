package by.iba.entity.car;

import by.iba.entity.AbstractBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "car_generations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarGeneration extends AbstractBaseEntity {

    @Column(name = "generation", nullable = false)
    private String generation;

    @Column(name = "start_year", nullable = false)
    private LocalDate startYear;

    @Column(name = "finish_year", nullable = false)
    private LocalDate finishYear;

    @Column(name = "body_types", nullable = false)
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<BodyType> bodyTypes = new HashSet<>();

    @Column(name = "transmission_types", nullable = false)
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<TransmissionType> transmissionTypes = new HashSet<>();

    @Column(name = "engine_types", nullable = false)
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<EngineType> engineTypes = new HashSet<>();

    @Column(name = "drive_types", nullable = false)
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<DriveType> driveTypes = new HashSet<>();
}
