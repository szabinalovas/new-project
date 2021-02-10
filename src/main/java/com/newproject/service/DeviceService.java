package com.newproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newproject.model.dto.DeviceDTO;
import com.newproject.model.entity.Device;
import com.newproject.repositroy.DeviceRepo;

@Service
public class DeviceService implements DeviceServiceInterface{
	
	@Autowired
	private DeviceRepo deviceRepo;
	
	
	public List<DeviceDTO> getAllDevice() {
		List<Device> dbFindAllDevice = deviceRepo.findAll();
		List<DeviceDTO> dtoFindAllDevice = new ArrayList<>();
		for(Device device : dbFindAllDevice) {
			DeviceDTO deviceDTO = new DeviceDTO();
			deviceDTO.setId(device.getId());
			deviceDTO.setName(device.getName());
			dtoFindAllDevice.add(deviceDTO);
		}
		return dtoFindAllDevice;	
	}
	
	@Override
	public String addDevice (String newDeviceName) {
		deviceRepo.save(new Device(newDeviceName));
		
		return "ok";		
	}
	
	@Override
	public String updateDevice (DeviceDTO updateDevice) {
		deviceRepo.save(new Device(updateDevice.getId(), updateDevice.getName()));
		
		return "ok";
	} 
	
	@Override
	public void deleteDeviceByID (Long deleteDeviceById) {
		deviceRepo.deleteById(deleteDeviceById);
	}
}
