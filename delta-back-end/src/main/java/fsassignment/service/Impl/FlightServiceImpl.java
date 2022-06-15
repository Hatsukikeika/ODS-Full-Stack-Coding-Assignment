package fsassignment.service.Impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import fsassignment.bean.Flight;
import fsassignment.service.FlightService;
import fsassignment.util.AutoComplete;

@Service
public class FlightServiceImpl implements FlightService {

	public FlightServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Page<Flight> allFlightByStation(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Flight> flightFromStation(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Flight> flightToStation(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> autoSuggest(String keyword, int limit) {
		return AutoComplete.lookup("station", keyword, limit);
	}

}
