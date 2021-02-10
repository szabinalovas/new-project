package com.newproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newproject.model.dto.DeviceDTO;
import com.newproject.service.DeviceService;


@RestController
public class DeviceConroller {
	
	@Autowired
	private DeviceService deviceService;
	
//	@GetMapping
//	public String hello() {
//		return "hello";
//	}
	 
	
	@GetMapping(path = "/device")
	public ResponseEntity<List<DeviceDTO>> device(){
		return new ResponseEntity<>(deviceService.getAllDevice(), HttpStatus.OK) ;	
	}
	
	@PostMapping (path = "/add-device")
	public String addNewDevice(@RequestParam String deviceName) {
		deviceService.addDevice(deviceName);
		return "ok";
	}
	
	@PutMapping (path = "/update-device")
	public String updateDevice(@RequestBody DeviceDTO updateDevice) {
		deviceService.updateDevice(updateDevice);
		return "ok";
	}
	
	@DeleteMapping(path = "/delete-device")
	public ResponseEntity<Void> deleteDeviceById(@RequestParam Long deleteDeviceById) {
		deviceService.deleteDeviceByID(deleteDeviceById);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
