package by.iba.dto.resp;

import by.iba.dto.AbstractDto;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SparePartDto extends AbstractDto {

    @NotBlank(message = "Car model should not be blank")
    private String carModel;

    @NotBlank(message = "Model should not be blank")
    private String model;

    @NotBlank(message = "Year of issue should not be blank")
    private String yearOfIssue;

    @NotBlank(message = "Spare part type should not be blank")
    private String sparePartType;

    @NotBlank(message = "Price should not be blank")
    private double price;

    @NotBlank(message = "Location should not be blank")
    private String location;

    private UserDto seller;

    @NotBlank(message = "Delivery type should not be blank")
    private String deliveryType;

    @NotBlank(message = "Image url should not be blank")
    private String imageUrl;
}
