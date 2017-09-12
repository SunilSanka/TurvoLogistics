package com.logistics.turvo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;

	@Column(name = "name")
	private String name;

	@Column(name = "password")
	@Length(min = 5, message = "*Your password must have at least 5 characters")
	@NotEmpty(message = "*Please provide your password")
	private String password;

	@Column(name = "aadhar", unique = true, nullable = false)
	private String aadhar;

	@Column(name = "email", nullable = true)
	private String email;

	@Column(name = "number")
	private String number;
	
	@Column(name="active")
	private int active;
	
	
	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}


	// Events
	@Column(name = "Shipment_Created")
	private boolean Shipment_Created;

	@Column(name = "Shipment_Packed")
	private boolean Shipment_Packed;

	@Column(name = "Shipment_Shipped")
	private boolean Shipment_Shipped;

	@Column(name = "Shipment_Delivered")
	private boolean Shipment_Delivered;

	@Column(name = "Shipment_Running_Late")
	private boolean Shipment_Running_Late;

	// Channels
	@Column(name = "by_Web")
	private boolean by_Web;

	@Column(name = "by_Email")
	private boolean by_Email;

	@Column(name = "by_SMS")
	private boolean by_SMS;

	public String getAadhar() {
		return aadhar;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getNumber() {
		return number;
	}

	public String getPassword() {
		return password;
	}

	public Long getUserId() {
		return userId;
	}

	public boolean isBy_Email() {
		return by_Email;
	}

	public boolean isBy_SMS() {
		return by_SMS;
	}

	public boolean isBy_Web() {
		return by_Web;
	}

	public boolean isShipment_Created() {
		return Shipment_Created;
	}

	public boolean isShipment_Delivered() {
		return Shipment_Delivered;
	}

	public boolean isShipment_Packed() {
		return Shipment_Packed;
	}

	public boolean isShipment_Running_Late() {
		return Shipment_Running_Late;
	}

	public boolean isShipment_Shipped() {
		return Shipment_Shipped;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public void setBy_Email(boolean by_Email) {
		this.by_Email = by_Email;
	}

	public void setBy_SMS(boolean by_SMS) {
		this.by_SMS = by_SMS;
	}

	public void setBy_Web(boolean by_Web) {
		this.by_Web = by_Web;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setShipment_Created(boolean shipment_Created) {
		Shipment_Created = shipment_Created;
	}

	public void setShipment_Delivered(boolean shipment_Delivered) {
		Shipment_Delivered = shipment_Delivered;
	}

	public void setShipment_Packed(boolean shipment_Packed) {
		Shipment_Packed = shipment_Packed;
	}

	public void setShipment_Running_Late(boolean shipment_Running_Late) {
		Shipment_Running_Late = shipment_Running_Late;
	}

	public void setShipment_Shipped(boolean shipment_Shipped) {
		Shipment_Shipped = shipment_Shipped;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
