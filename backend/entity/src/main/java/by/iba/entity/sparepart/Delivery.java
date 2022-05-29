package by.iba.entity.sparepart;

import by.iba.entity.AbstractBaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "deliveries")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Delivery extends AbstractBaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "delivery_type", nullable = false, unique = true)
    private DeliveryType deliveryType;
}
