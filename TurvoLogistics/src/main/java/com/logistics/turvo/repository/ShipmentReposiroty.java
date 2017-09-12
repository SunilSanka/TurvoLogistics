package com.logistics.turvo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.logistics.turvo.model.Shipment;

@Repository
public interface ShipmentReposiroty extends JpaRepository<Shipment, Long> {

	Shipment findByShipmentCode(Long code);
}
