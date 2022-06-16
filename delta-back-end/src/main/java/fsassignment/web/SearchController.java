package fsassignment.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fsassignment.model.ResponseWrapper;
import fsassignment.service.FlightService;


/**
 * @author Yi
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/")
public class SearchController {

	@Autowired
	private FlightService flightService;
	
	
	/**
	 * Handle a GET API call for auto-suggestion feature.
	 * 
	 * @param prefix a prefix string for fuzzy search.
	 * @param limit how many possible keyword can be suggested.
	 * @return list of most possible keyword based on current input.
	 */
	@RequestMapping(value="/station/lookup/{prefix}", method = RequestMethod.GET)
	public ResponseWrapper autoSuggest(@PathVariable String prefix, @RequestParam(defaultValue = "5") int limit) {
		return new ResponseWrapper().putData(flightService.autoSuggest(prefix, limit));
	}
	
	/**
	 * Handle a GET API call for flight search, the default search method is both From & To station.
	 * The parameters here are not required, except search keyword.
	 * 
	 * @param keyword search keyword, this keyword needs to be exactly same as a station code or a station name.
	 * @param type search type, the type can be from/to/all station.
	 * @param page page number of the search result.
	 * @param pageSize number of data per page.
	 * @return up to [pageSize] number of results.
	 */
	@RequestMapping(value="/flights/{keyword}", method = RequestMethod.GET)
	public ResponseWrapper searchFlights(@PathVariable String keyword, @RequestParam(defaultValue = "all") String type, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "15") int pageSize) {
		
		switch(type) {
		case "all":
			return new ResponseWrapper().putData(flightService.allFlightByStation(keyword, page, pageSize));
		case "to":
			return new ResponseWrapper().putData(flightService.flightToStation(keyword, page, pageSize));
		case "from":
			return new ResponseWrapper().putData(flightService.flightFromStation(keyword, page, pageSize));
		}
		
		return new ResponseWrapper().setStatus(HttpStatus.BAD_REQUEST.value()).setMessage(HttpStatus.BAD_REQUEST.toString());
	}

}
