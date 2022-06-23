package by.iba.dto.resp;

import by.iba.dto.AbstractDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RatingDto extends AbstractDto {

    private Integer rating;
}
