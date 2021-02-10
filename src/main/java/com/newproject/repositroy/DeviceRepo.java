package com.newproject.repositroy;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.newproject.model.entity.Device;

@Repository
public interface DeviceRepo extends CrudRepository <Device, Long> {
	
	List<Device> findAll();

}
