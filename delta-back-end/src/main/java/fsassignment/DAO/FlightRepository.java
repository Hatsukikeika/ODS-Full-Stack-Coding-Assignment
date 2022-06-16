package fsassignment.DAO;

import java.util.HashSet;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fsassignment.bean.Flight;
import fsassignment.bean.convertor.StationPair;

/**
 * @author Yi
 *
 */
public interface FlightRepository extends JpaRepository<Flight, Long> {
	
	public List<Flight> findByDestinationOrOriginOrFullDestinationOrFullOrigin(String destination, String origin, String fullDestination, String fullOrigin);
	
	public List<Flight> findByDestinationOrFullDestination(String destination, String fullDestination);
	
	public List<Flight> findByOriginOrFullOrigin(String origin, String fullOrigin);
	
	@Query(value="SELECT destination as code, destination_full_name as fullname FROM flights ", nativeQuery = true)
	public HashSet<StationPair> getDestinationPair();
	
	
	@Query(value="SELECT origin as code, origin_full_name as fullname FROM flights", nativeQuery = true)
	public HashSet<StationPair> getOriginPair();
}
