package com.logistics.turvo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shipment")
public class Shipment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long shipmentId;

	@Column(name = "shipment_code", nullable = false, unique = true)
	private Long shipmentCode;

	@Column(name = "title")
	private String title;

	@Column(name = "shipment_method")
	private String shipmentMethod;

	@Column(name = "from_address")
	private String fromAddress;

	@Column(name = "to_address")
	private String toAddress;

	@Column(name = "expected_delivery_date")
	private String expectedDate;

	@Column(name = "status")
	private String status;

	@Column(name = "message")
	private String message;

	public String getExpectedDate() {
		return expectedDate;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public String getMessage() {
		return message;
	}

	public Long getShipmentCode() {
		return shipmentCode;
	}

	public Long getShipmentId() {
		return shipmentId;
	}

	public String getShipmentMethod() {
		return shipmentMethod;
	}

	public String getStatus() {
		return status;
	}

	public String getTitle() {
		return title;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setExpectedDate(String expectedDate) {
		this.expectedDate = expectedDate;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setShipmentCode(Long shipmentCode) {
		this.shipmentCode = shipmentCode;
	}

	public void setShipmentId(Long shipmentId) {
		this.shipmentId = shipmentId;
	}

	public void setShipmentMethod(String shipmentMethod) {
		this.shipmentMethod = shipmentMethod;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

}
