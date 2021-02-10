package com.newproject.model.dto;

import java.util.Date;

import lombok.Data;

@Data
public class MeasurementDTO {
	
	private Long id;
	private Date time;
	private int value;
	private String unit;


}
