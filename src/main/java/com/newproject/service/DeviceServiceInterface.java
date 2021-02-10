package com.newproject.service;

import com.newproject.model.dto.DeviceDTO;

public interface DeviceServiceInterface {
	
	public String addDevice (String name);
	
	public String updateDevice (DeviceDTO updateDevice);
	
	public void deleteDeviceByID (Long deleteDeviceById);

}
