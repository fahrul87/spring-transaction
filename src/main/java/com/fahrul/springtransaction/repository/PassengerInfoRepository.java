package com.fahrul.springtransaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fahrul.springtransaction.entity.PassengerInfo;

public interface PassengerInfoRepository extends JpaRepository<PassengerInfo, Long> {

}
