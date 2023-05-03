package ua.com.public_utilities.bl;

import lombok.*;
import ua.com.public_utilities.entity.Rate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ItemCart {
    private Rate rate;
    private double index;

}
