package com.in28minutes.unittesting.unittesting.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.in28minutes.unittesting.unittesting.data.AppointmentRepository;
import com.in28minutes.unittesting.unittesting.data.ItemRepository;
import com.in28minutes.unittesting.unittesting.model.Appointment;
import com.in28minutes.unittesting.unittesting.model.Item;

@Component
public class AppointmentService {
	
	@Autowired
	private AppointmentRepository  repository;
	
	public List<Appointment> retrieveAllAppointments() {
		List<Appointment> appointments = repository.findAll();
		
		for(Appointment appointment:appointments) {
			appointment.setAmount(500);
		}
		
		return appointments;	
	}
	
	public Appointment saveAppointment(Appointment app) {
		return repository.save(app);
	};
	
	
}