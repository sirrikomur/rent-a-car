package bootcamps.turkcell.rentacar.business.managers;

import bootcamps.turkcell.core.domain.entities.Card;
import bootcamps.turkcell.core.fakes.FakeCards;
import bootcamps.turkcell.rentacar.business.services.PaymentService;
import bootcamps.turkcell.rentacar.business.services.PosService;
import bootcamps.turkcell.rentacar.common.dtos.PaymentRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentManager implements PaymentService {
    private final PosService posService;

    @Override
    public void pay(Card card, double amount) {
        FakeCards fakeCards = new FakeCards();
        card = fakeCards.getCards().get(0);
        posService.pay(new PaymentRequest(card, amount));
    }
}
