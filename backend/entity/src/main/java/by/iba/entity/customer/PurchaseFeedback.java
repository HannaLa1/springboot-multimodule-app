package by.iba.entity.customer;

import by.iba.entity.AbstractBaseEntity;
import by.iba.entity.seller.Seller;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "purchase_feedbacks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseFeedback extends AbstractBaseEntity {

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
