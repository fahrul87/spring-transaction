package com.fahrul.springtransaction.dto;

import com.fahrul.springtransaction.entity.PassengerInfo;
import com.fahrul.springtransaction.entity.PaymentInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingRequest {
	private PassengerInfo passengerInfo;

	private PaymentInfo paymentInfo;
}
