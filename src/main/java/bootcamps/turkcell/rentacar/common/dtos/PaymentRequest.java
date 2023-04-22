package bootcamps.turkcell.rentacar.common.dtos;

import bootcamps.turkcell.core.domain.entities.Card;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {
    private String invoiceNo;
    private double totalAmount;

    private Card card;
}
