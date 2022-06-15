package fsassignment.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flights")
public class Flight {

	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="created_at")
	private String createAt;
	
	@Column(name="updated_at")
	private String updateAt;
	
	@Column(name="flight_identifier")
	private String flightUID;
	
	@Column(name="flt_num")
	private Integer flightNum;
	
	@Column(name="scheduled_origin_gate")
	private String gateOrigin;
	
	@Column(name="scheduled_destination_gate")
	private String gateDestination;
	
	@Column(name="out_gmt")
	private String out;
	
	@Column(name="in_gmt")
	private String in;
	
	@Column(name="off_gmt")
	private String off;
	
	@Column(name="on_gmt")
	private String on;

	@Column(name="destination")
	private String destination;
	
	@Column(name="origin")
	private String origin;
	
	@Column(name="destination_full_name")
	private String fullDestination;
	
	@Column(name="origin_full_name")
	private String fullOrigin;
	
	public Flight() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreateAt() {
		return createAt;
	}

	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}

	public String getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(String updateAt) {
		this.updateAt = updateAt;
	}

	public String getFlightUID() {
		return flightUID;
	}

	public void setFlightUID(String flightUID) {
		this.flightUID = flightUID;
	}

	public Integer getFlightNum() {
		return flightNum;
	}

	public void setFlightNum(Integer flightNum) {
		this.flightNum = flightNum;
	}

	public String getGateOrigin() {
		return gateOrigin;
	}

	public void setGateOrigin(String gateOrigin) {
		this.gateOrigin = gateOrigin;
	}

	public String getGateDestination() {
		return gateDestination;
	}

	public void setGateDestination(String gateDestination) {
		this.gateDestination = gateDestination;
	}

	public String getOut() {
		return out;
	}

	public void setOut(String out) {
		this.out = out;
	}

	public String getIn() {
		return in;
	}

	public void setIn(String in) {
		this.in = in;
	}

	public String getOff() {
		return off;
	}

	public void setOff(String off) {
		this.off = off;
	}

	public String getOn() {
		return on;
	}

	public void setOn(String on) {
		this.on = on;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getFullDestination() {
		return fullDestination;
	}

	public void setFullDestination(String fullDestination) {
		this.fullDestination = fullDestination;
	}

	public String getFullOrigin() {
		return fullOrigin;
	}

	public void setFullOrigin(String fullOrigin) {
		this.fullOrigin = fullOrigin;
	}

	
	
}
