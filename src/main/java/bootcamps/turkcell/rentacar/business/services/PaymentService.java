package bootcamps.turkcell.rentacar.business.services;

import bootcamps.turkcell.core.domain.entities.Card;

public interface PaymentService {
    void pay(Card card, double amount);
}
