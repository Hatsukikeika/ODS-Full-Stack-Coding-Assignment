package fsassignment.DAO;

import java.util.HashSet;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fsassignment.bean.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {
	
	public List<Flight> findByAorBorCorD(String... strings);
	
	@Query(value=
			"SELECT destination FROM Flight flight" +
			"union" +
			"SELECT orgin FROM Flight flight" +
			"union" + 
			"SELECT fullDestination FROM Flight flight" +
			"union" +
			"SELECT fullOrigin FROM Flight flight"
			, nativeQuery = true)
	public HashSet<String> getStationInfo();
}
