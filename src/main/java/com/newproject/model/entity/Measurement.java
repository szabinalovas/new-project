package com.newproject.model.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
public class Measurement {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Long id;
	private Date time;
	private int value;
	private String unit;
	@ManyToOne (cascade = CascadeType.ALL)
	private Device device;
	
	public Measurement(Date time, int value, String unit, Long device_id) {
		this.time = time;
		this.value = value;
		this.unit = unit;
		this.device = new Device(device_id, "homero");
	}
	
	public Measurement(Date time, int value, String unit, Device device) {
		this.time = time;
		this.value = value;
		this.unit = unit;
		this.device = device;
	}
	
	public Measurement(Date time, int value, String unit) {
		this.time = time;
		this.value = value;
		this.unit = unit;
	}
}
