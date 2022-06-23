package by.iba.entity.seller;

import by.iba.entity.FullAbstractEntity;
import by.iba.entity.customer.PurchaseFeedback;
import by.iba.entity.customer.AccountStatus;
import by.iba.entity.sparepart.Image;
import by.iba.entity.sparepart.SparePart;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sellers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Seller extends FullAbstractEntity {

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "recovery_token", unique = true)
    private String recoveryToken;

    @Column(name = "token_creation_date")
    private LocalDateTime tokenCreationDate;

    @Column(name = "last_Visited_Date")
    private LocalDateTime lastVisitedDate;

    @Column(name = "account_status", nullable = false)
    @Enumerated
    private AccountStatus accountStatus = AccountStatus.PENDING;

    @OneToOne(fetch = FetchType.LAZY)
    private SellerRating sellerRating;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<PurchaseFeedback> purchaseFeedbacks = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY)
    private Set<SparePart> spareParts = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY)
    private Image image;
}
