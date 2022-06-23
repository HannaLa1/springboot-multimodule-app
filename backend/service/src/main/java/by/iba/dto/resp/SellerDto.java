package by.iba.dto.resp;

import by.iba.dto.AbstractDto;
import by.iba.entity.customer.AccountStatus;
import by.iba.entity.customer.PurchaseFeedback;
import by.iba.entity.seller.SellerRating;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SellerDto extends AbstractDto {

    private String email;

    private String firstName;

    private String lastName;

    private LocalDateTime created;

    private LocalDateTime updated;

    private LocalDateTime lastVisitedDate;

    private AccountStatus userAccountStatus;

    private RatingDto sellerRating;

    private Set<PurchaseFeedback> purchaseFeedbacks = new HashSet<>();
}
