package fsassignment.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import fsassignment.DAO.FlightRepository;
import fsassignment.bean.Flight;
import fsassignment.service.FlightService;
import fsassignment.util.AutoComplete;
import fsassignment.util.PagiHelper;

@Service
public class FlightServiceImpl implements FlightService {
	
	@Autowired
	private FlightRepository flightRepository;

	@Override
	public Page<Flight> allFlightByStation(String keyword, int page, int size) {
		List<Flight> resultList = flightRepository.findByDestinationOrOriginOrFullDestinationOrFullOrigin(keyword, keyword, keyword, keyword);
		return PagiHelper.listToPageCovert(resultList, page, size);
	}

	@Override
	public Page<Flight> flightFromStation(String keyword, int page, int size) {
		List<Flight> resultList = flightRepository.findByOriginOrFullOrigin(keyword, keyword);
		System.out.println(resultList.size());
		return PagiHelper.listToPageCovert(resultList, page, size);
	}

	@Override
	public Page<Flight> flightToStation(String keyword, int page, int size) {
		List<Flight> resultList = flightRepository.findByDestinationOrFullDestination(keyword, keyword);
		return PagiHelper.listToPageCovert(resultList, page, size);
	}

	@Override
	public List<String> autoSuggest(String keyword, int limit) {
		return AutoComplete.lookup("station", keyword, limit);
	}

}
