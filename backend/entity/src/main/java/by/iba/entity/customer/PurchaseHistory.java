package by.iba.entity.customer;

import by.iba.entity.AbstractBaseEntity;
import by.iba.entity.price.Price;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "purchase_histories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseHistory extends AbstractBaseEntity {

    @Column(name = "customer_id", nullable = false)
    private String customerId;

    @Column(name = "spare_part_id", nullable = false)
    private String sparePartId;

    @Column(name = "date_of_purchase", nullable = false)
    private LocalDateTime dateOfPurchase;

    @Column(name = "date_of_purchase", nullable = false)
    @OneToOne(fetch = FetchType.LAZY)
    private Price price;

    @Column(name = "amount_of_products", nullable = false)
    private Integer amountOfProducts;
}
