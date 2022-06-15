package fsassignment.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

}
