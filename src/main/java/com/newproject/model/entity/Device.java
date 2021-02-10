package com.newproject.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
public class Device  {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Long id;
	private String name;
	@JsonBackReference
	@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "device")
	private List<Measurement>  measurement;
		
	public Device(String name) {
		this.name = name;
	}	
	public Device(Long id, String name) {
		this.id = id;
		this.name = name;
	}	
}
