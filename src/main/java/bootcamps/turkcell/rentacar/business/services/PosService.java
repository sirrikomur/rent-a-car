package bootcamps.turkcell.rentacar.business.services;

import bootcamps.turkcell.rentacar.common.dtos.PaymentRequest;

public interface PosService {
    boolean pay(PaymentRequest paymentRequest);
}
