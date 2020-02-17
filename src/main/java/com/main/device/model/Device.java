package com.main.device.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "devices")
public class Device {

	private long id;
	private String device_attribute;
	private String registration_type;
	private String ownership_type;
	private String attribute_type;
	
	
	
	
	@Column(name = "ownership_type", nullable = false)
	public String getOwnership_type() {
		return ownership_type;
	}

	public void setOwnership_type(String ownership_type) {
		this.ownership_type = ownership_type;
	}
	@Column(name = "attribute_type", nullable = false)
	public String getAttribute_type() {
		return attribute_type;
	}

	public void setAttribute_type(String attribute_type) {
		this.attribute_type = attribute_type;
	}

	public Device() {
		
	}
	
	public Device(String device_attribute, String registration_type) {
		this.device_attribute = device_attribute;
		this.registration_type = registration_type;
		}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "device_attribute", nullable = false)
	public String getdeviceAttribute() {
		return device_attribute;
	}
	public void setdeviceAttribute(String device_attribute) {
		this.device_attribute = device_attribute;
	}
	
	
	
	@Column(name = "registration_type", nullable = false)
	public String getregistrationType() {
		return registration_type;
	}
	public void setregistrationType(String registration_type) {
		this.registration_type = registration_type;
	}
	
	@Override
	public String toString() {
		return "Device [id=" + id + ", deviceAttribute=" + device_attribute + ", registrationAttribute=" + registration_type + "]";
	}
	
}
