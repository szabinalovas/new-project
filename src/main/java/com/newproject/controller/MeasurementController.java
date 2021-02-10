package com.newproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newproject.model.dto.MeasurementDTO;
import com.newproject.model.entity.Measurement;
import com.newproject.service.MeasurementService;

@RestController
public class MeasurementController {

	@Autowired
	private MeasurementService measurementService;
	
	@GetMapping(path = "/measurement")
	public List<MeasurementDTO> measurement(){
		return measurementService.getAllMeasurement();	
	}
	
	@GetMapping (path = "/measurement-by-device")
	public List<Measurement> searchMeasurementByDevice(@RequestParam String name){
		return measurementService.getMeasurementByDevice(name);		
	}
	
	@PostMapping (path = "/add-measurement")
	public String addMeasure (@RequestBody MeasurementDTO newMeasure, @RequestParam Long deviceId) {
		measurementService.addMeasure(newMeasure,deviceId);
		return "ok";
	}
	
	
	
}
