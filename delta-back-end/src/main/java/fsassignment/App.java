package fsassignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import fsassignment.DAO.FlightRepository;
import fsassignment.util.AutoComplete;

@SpringBootApplication
public class App {

	@Autowired
	private static FlightRepository flightRepository;
	
	static ApplicationContext context;

	public static void main(String[] args) {
		String catagory = "station";
		
		//Init Spring Application
		context = SpringApplication.run(App.class, args);	
		flightRepository = (FlightRepository) context.getBean("flightRepository");
		
		
		//Init load auto-complete helper
		AutoComplete.register(catagory);
		for(String station : flightRepository.getStationInfo()) {
			AutoComplete.tryLoad(catagory, station);
		}
		
		//Ready
		System.out.println("Program is running...");
	}

}
