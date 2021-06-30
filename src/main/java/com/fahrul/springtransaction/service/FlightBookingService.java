package com.fahrul.springtransaction.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fahrul.springtransaction.dto.FlightBookingAcknowledgement;
import com.fahrul.springtransaction.dto.FlightBookingRequest;
import com.fahrul.springtransaction.entity.PassengerInfo;
import com.fahrul.springtransaction.entity.PaymentInfo;
import com.fahrul.springtransaction.repository.PassengerInfoRepository;
import com.fahrul.springtransaction.repository.PaymentInfoRepository;
import com.fahrul.springtransaction.utils.PaymentUtils;

@Service
public class FlightBookingService {

	@Autowired
	private PassengerInfoRepository passengerInfoRepository;

	@Autowired
	private PaymentInfoRepository paymentInfoRepository;

	@Transactional // (readOnly = false,isolation = Isolation.READ_COMMITTED,propagation =
					// Propagation.REQUIRED)
	public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request) {
		PassengerInfo passengerInfo = request.getPassengerInfo();
		passengerInfo = passengerInfoRepository.save(passengerInfo);

		PaymentInfo paymentInfo = request.getPaymentInfo();

		PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());

		paymentInfo.setPassengerId(passengerInfo.getPId());
		paymentInfo.setAmount(passengerInfo.getFare());
		paymentInfoRepository.save(paymentInfo);
		return new FlightBookingAcknowledgement("SUCCESS", passengerInfo.getFare(),
				UUID.randomUUID().toString().split("-")[0], passengerInfo);
	}

}
