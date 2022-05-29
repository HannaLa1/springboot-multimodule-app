package by.iba.entity.shoppingcard;

import by.iba.entity.AbstractBaseEntity;
import by.iba.entity.sparepart.SparePart;
import by.iba.entity.customer.User;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shoppingCard")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCard extends AbstractBaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "shopping_cards_spare_parts",
            joinColumns = {
                    @JoinColumn(
                            name = "shopping_card_id",
                            referencedColumnName = "id"),
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "spare_part_id",
                            referencedColumnName = "id")
            })
    private List<SparePart> spareParts = new ArrayList<>();
}
