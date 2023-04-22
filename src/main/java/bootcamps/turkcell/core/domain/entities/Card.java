package bootcamps.turkcell.core.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    private String number;
    private String holder;
    private int expirationYear;
    private int expirationDay;
    private String cvv;
}
