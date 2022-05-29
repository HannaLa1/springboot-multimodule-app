package by.iba.dto;

import by.iba.entity.customer.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingDto extends AbstractDto {

    private double rating;

    private User user;
}
