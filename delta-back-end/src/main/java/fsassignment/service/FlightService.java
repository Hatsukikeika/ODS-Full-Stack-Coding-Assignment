package fsassignment.service;

import org.springframework.data.domain.Page;

import fsassignment.bean.Flight;

public interface FlightService {
	
	Page<Flight> searchByKeyword(String keyword);
	
}
