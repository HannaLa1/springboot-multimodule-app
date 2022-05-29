package by.iba.entity.seller;

import by.iba.entity.AbstractBaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "seller_ratings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SellerRating extends AbstractBaseEntity {

    @Column(name = "rating", nullable = false)
    private Double rating;
}
