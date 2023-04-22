package bootcamps.turkcell.rentacar.common.adapters.services;

import bootcamps.turkcell.core.domain.entities.Card;
import bootcamps.turkcell.external.banks.isbank.IsBankPosService;
import bootcamps.turkcell.rentacar.business.services.PosService;
import bootcamps.turkcell.rentacar.common.dtos.PaymentRequest;

public class IsBankPosServiceAdapter implements PosService {
    @Override
    public boolean pay(PaymentRequest paymentRequest) {
        IsBankPosService isBankPosService = new IsBankPosService();
        isBankPosService.pay(paymentRequest.getTotalAmount());
        return true;
    }
}
