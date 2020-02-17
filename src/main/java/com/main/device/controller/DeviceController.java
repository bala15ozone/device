package com.main.device.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.device.exception.ResourceNotFoundException;
import com.main.device.model.Device;
import com.main.device.repository.DeviceRepository;



@RestController
@RequestMapping("/api/v1")
public class DeviceController {
	@Autowired
	private DeviceRepository deviceRepository;

	@GetMapping("/devices")
	public List<Device> getAllDevices() {
		return deviceRepository.findAll();
	}

	@GetMapping("/devices/{id}")
	public ResponseEntity<Device> getDeviceById(@PathVariable(value = "id") Long deviceId)
			throws ResourceNotFoundException {
		Device device = deviceRepository.findById(deviceId)
				.orElseThrow(() -> new ResourceNotFoundException("Device not found for this id :: " + deviceId));
		return ResponseEntity.ok().body(device);
	}

	@PostMapping("/devices")
	public Device createDevice(@Valid @RequestBody Device device) {
		return deviceRepository.save(device);
	}

	@PutMapping("/devices/{id}")
	public ResponseEntity<Device> updateDevice(@PathVariable(value = "id") Long deviceId,
			@Valid @RequestBody Device deviceDetails) throws ResourceNotFoundException {
		Device device = deviceRepository.findById(deviceId)
				.orElseThrow(() -> new ResourceNotFoundException("Device not found for this id :: " + deviceId));

		device.setAttribute_type(deviceDetails.getAttribute_type());
		device.setdeviceAttribute(deviceDetails.getdeviceAttribute());
		device.setId(deviceDetails.getId());
		device.setOwnership_type(deviceDetails.getOwnership_type());
		
		final Device updatedDevice = deviceRepository.save(device);
		return ResponseEntity.ok(updatedDevice);
	}

	/*
	 * @DeleteMapping("/devices/{id}") public Map<String, Boolean>
	 * deleteDevice(@PathVariable(value = "id") Long deviceId) throws
	 * ResourceNotFoundException { Device device =
	 * deviceRepository.findById(deviceId) .orElseThrow(() -> new
	 * ResourceNotFoundException("Device not found for this id :: " + deviceId));
	 * 
	 * deviceRepository.delete(device); Map<String, Boolean> response = new
	 * HashMap<>(); response.put("deleted", Boolean.TRUE); return response; }
	 */
	}
