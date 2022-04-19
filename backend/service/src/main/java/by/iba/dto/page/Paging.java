package by.iba.dto.page;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paging {

    @NotNull(message = "Page can`t be null!")
    @Min(value = 1, message = "Min page value is 1!")
    @Positive(message = "Page must be positive")
    private int page;

    @NotNull(message = "Size can`t be null!")
    @Min(value = 1, message = "Min size value is 1!")
    @Positive(message = "Size must be positive")
    private int size;
}
