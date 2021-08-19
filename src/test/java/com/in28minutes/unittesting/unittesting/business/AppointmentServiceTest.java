package com.in28minutes.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.in28minutes.unittesting.unittesting.data.AppointmentRepository;
import com.in28minutes.unittesting.unittesting.model.Appointment;

@ExtendWith(MockitoExtension.class)
class AppointmentServiceTest {
	@InjectMocks
	private AppointmentService appointments;
	@Mock
	private AppointmentRepository repository;
	@Test
	void retrieveAllItems() {
		when(repository.findAll()).thenReturn(Arrays.asList(new Appointment(1,"Aneesh","apotnis@gmail.com",2348729347L,"thane",120f)));
		appointments.retrieveAllAppointments();
		
	}
	
	@Test
	void testsaveAppointment() {
		Appointment app = new Appointment(2,"Abc","abc@gmail.com",234872956546L,"pune",800f);
		when(repository.save(app)).thenReturn(app);
		Appointment saved = appointments.saveAppointment(app);
		assertEquals(app.getId(), saved.getId());
	}

}
