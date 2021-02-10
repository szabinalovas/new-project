package com.newproject.repositroy;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.newproject.model.entity.Measurement;

@Repository
public interface MeasurementRepo extends CrudRepository <Measurement, Long> {
	
	List<Measurement> findAll();
	
	List<Measurement> findAllByDeviceName(String name);

}
