package com.fahrul.springtransaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fahrul.springtransaction.entity.PaymentInfo;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, Long> {

}
