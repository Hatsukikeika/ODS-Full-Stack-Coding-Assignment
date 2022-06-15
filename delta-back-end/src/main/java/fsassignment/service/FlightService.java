package fsassignment.service;

import java.util.List;

import org.springframework.data.domain.Page;

import fsassignment.bean.Flight;

public interface FlightService {
	
	Page<Flight> allFlightByStation(String keyword, int page, int size);
	
	Page<Flight> flightFromStation(String keyword, int page, int size);
	
	Page<Flight> flightToStation(String keyword, int page, int size);
	
	List<String> autoSuggest(String keyword, int limit);
	
}
