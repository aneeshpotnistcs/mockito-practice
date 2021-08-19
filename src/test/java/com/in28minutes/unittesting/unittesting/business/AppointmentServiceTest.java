package com.in28minutes.unittesting.unittesting.business;

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

}
