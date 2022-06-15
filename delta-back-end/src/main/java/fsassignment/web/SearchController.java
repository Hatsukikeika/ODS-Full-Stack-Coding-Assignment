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

@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/")
public class SearchController {

	@Autowired
	private FlightService flightService;
	
	@RequestMapping(value="/station/lookup/{prefix}", method = RequestMethod.GET)
	public ResponseWrapper autoSuggest(@PathVariable String prefix, @RequestParam(defaultValue = "5") int limit) {
		return new ResponseWrapper().putData(flightService.autoSuggest(prefix, limit));
	}
	
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
