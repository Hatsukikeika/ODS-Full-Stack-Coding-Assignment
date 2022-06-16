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

/**
 * @author Yi
 *
 * This class is the implementation of FlightService
 */
@Service
public class FlightServiceImpl implements FlightService {
	
	@Autowired
	private FlightRepository flightRepository;

	/**
	 * This method returns a Page object that contains the flight info that has keyword presented in:
	 * origin, destination, origin_full_name, destination_full_name
	 */
	@Override
	public Page<Flight> allFlightByStation(String keyword, int page, int size) {
		List<Flight> resultList = flightRepository.findByDestinationOrOriginOrFullDestinationOrFullOrigin(keyword, keyword, keyword, keyword);
		return PagiHelper.listToPageCovert(resultList, page, size);
	}
	
	/**
	 * This method returns a Page object that contains the flight info that has keyword presented in:
	 * origin, origin_full_name
	 */
	@Override
	public Page<Flight> flightFromStation(String keyword, int page, int size) {
		List<Flight> resultList = flightRepository.findByOriginOrFullOrigin(keyword, keyword);
		System.out.println(resultList.size());
		return PagiHelper.listToPageCovert(resultList, page, size);
	}

	/**
	 * This method returns a Page object that contains the flight info that has keyword presented in:
	 * destination, destination_full_name
	 */
	@Override
	public Page<Flight> flightToStation(String keyword, int page, int size) {
		List<Flight> resultList = flightRepository.findByDestinationOrFullDestination(keyword, keyword);
		return PagiHelper.listToPageCovert(resultList, page, size);
	}

	/**
	 * This method returns a list of all the most possible keywords based on current input.
	 */
	@Override
	public List<String> autoSuggest(String keyword, int limit) {
		return AutoComplete.lookup("station", keyword, limit);
	}

}
