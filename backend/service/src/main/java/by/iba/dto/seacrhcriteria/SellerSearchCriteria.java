package by.iba.dto.seacrhcriteria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Size;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SellerSearchCriteria extends BaseSearchCriteria{

    @Size(min = 3, max = 10, message = "First name should be between 3 and 15 characters")
    private String firstName;

    @Size(min = 3, max = 10, message = "Last name should be between 3 and 15 characters")
    private String lastName;

    @Range(min = 0, max = 5, message = "Rating should be between 0 and 5")
    private Double rating;
}
