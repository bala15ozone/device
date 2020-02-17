package com.main.device.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.device.model.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long>{

}


