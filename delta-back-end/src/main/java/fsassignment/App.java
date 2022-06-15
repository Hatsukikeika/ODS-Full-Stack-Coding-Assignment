package fsassignment;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import fsassignment.DAO.FlightRepository;
import fsassignment.bean.convertor.StationPair;
import fsassignment.util.AutoComplete;
import fsassignment.util.StationLocker;

@SpringBootApplication
public class App {

	@Autowired
	private static FlightRepository flightRepository;
	
	static ApplicationContext context;
	static String catagory = "station";

	public static void main(String[] args) {
		
		//Init Spring Application
		context = SpringApplication.run(App.class, args);	
		flightRepository = (FlightRepository) context.getBean("flightRepository");
		
		//Init load auto-complete helper
		init();
		//Ready
		System.out.println("Program is running...");
	}
	
	private static void init() {
		AutoComplete.register(catagory, new StationLocker());
		
		HashSet<StationPair> stations = flightRepository.getDestinationPair();
		stations.addAll(flightRepository.getOriginPair());
		
		for(StationPair station : stations) {			
			AutoComplete.tryLoad(catagory, station.getCode(), station.getFullName());
			AutoComplete.tryLoad(catagory, station.getFullName(), station.getCode());
		}
	}

}
