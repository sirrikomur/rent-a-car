package bootcamps.turkcell.rentacar.common.adapters.services;

import bootcamps.turkcell.external.banks.isbank.IsBankPosService;
import bootcamps.turkcell.rentacar.business.services.PosService;
import bootcamps.turkcell.rentacar.common.dtos.PaymentRequest;
import org.springframework.stereotype.Service;

@Service
public class IsBankPosServiceAdapter implements PosService {
    @Override
    public boolean pay(PaymentRequest paymentRequest) {
        IsBankPosService isBankPosService = new IsBankPosService();
        isBankPosService.pay(paymentRequest.getCard(), paymentRequest.getAmount());
        return true;
    }
}
