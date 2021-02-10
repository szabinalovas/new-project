package com.newproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newproject.model.dto.MeasurementDTO;
import com.newproject.model.entity.Device;
import com.newproject.model.entity.Measurement;
import com.newproject.repositroy.DeviceRepo;
import com.newproject.repositroy.MeasurementRepo;

@Service
public class MeasurementService implements MeasurementServiceInterface {
	
	@Autowired
	private MeasurementRepo measurementRepo;
	
	@Autowired 
	private DeviceRepo deviceRepo;
	
	public List<MeasurementDTO> getAllMeasurement() {
		List<Measurement> dbFindAllMeasure = measurementRepo.findAll();
		List<MeasurementDTO> dtoFindAllMeasure = new ArrayList<>();
		for(Measurement measurement : dbFindAllMeasure) {
			MeasurementDTO measurementDTO = new MeasurementDTO();
			measurementDTO.setId(measurement.getId());
			measurementDTO.setTime(measurement.getTime());
			measurementDTO.setUnit(measurement.getUnit());
			measurementDTO.setValue(measurement.getValue());
			dtoFindAllMeasure.add(measurementDTO);
		}
		return dtoFindAllMeasure;	
	} 
	
	
	public List<Measurement> getMeasurementByDevice(String name){
		List<Measurement> measurementList = measurementRepo.findAllByDeviceName(name);
		if(measurementList.isEmpty()){
			throw new RuntimeException("Nincs ilyen eszköznév");	
		}
		return measurementList;
	}
	
	@Override
	public String addMeasure (MeasurementDTO addMeasure, Long deviceId) {
		Optional<Device> deviceOptional = deviceRepo.findById(deviceId);
		Device device= deviceOptional.get();
		measurementRepo.save(new Measurement(addMeasure.getTime(), addMeasure.getValue(), addMeasure.getUnit(), device));
		return "ok";
	}

}
