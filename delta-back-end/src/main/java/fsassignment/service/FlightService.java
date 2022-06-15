package fsassignment.service;

import java.util.List;

import org.springframework.data.domain.Page;

import fsassignment.bean.Flight;

public interface FlightService {
	
	Page<Flight> allFlightByStation(String keyword);
	
	Page<Flight> flightFromStation(String keyword);
	
	Page<Flight> flightToStation(String keyword);
	
	List<String> autoSuggest(String keyword, int limit);
	
}
