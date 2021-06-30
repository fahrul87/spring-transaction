package com.fahrul.springtransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fahrul.springtransaction.dto.FlightBookingAcknowledgement;
import com.fahrul.springtransaction.dto.FlightBookingRequest;
import com.fahrul.springtransaction.service.FlightBookingService;

@SpringBootApplication
@RestController
@EnableTransactionManagement
public class SpringTransactionApplication {

	@Autowired
	private FlightBookingService flightBookingService;

	@PostMapping("/bookFlightTicket")
	public FlightBookingAcknowledgement bookFlightTicket(@RequestBody FlightBookingRequest request) {
		return flightBookingService.bookFlightTicket(request);

	}

	public static void main(String[] args) {
		SpringApplication.run(SpringTransactionApplication.class, args);
	}

}
