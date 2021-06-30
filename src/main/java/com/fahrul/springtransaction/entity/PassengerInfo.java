package com.fahrul.springtransaction.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "PASSENGER_INFOS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PassengerInfo {

	@Id
	@GeneratedValue
	private Long pId;
	private String name;
	private String email;
	private String source;
	private String Destination;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyy")
	private Date travelDate;
	private String pickupTime;
	private String arrivalTime;
	private double fare;

}
