package com.newproject.service;

import com.newproject.model.dto.MeasurementDTO;

public interface MeasurementServiceInterface {
	
	public String addMeasure (MeasurementDTO addMeasure, Long deviceId);

}
