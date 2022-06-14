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
	
	@Column(name="create_at")
	private Date createAt;
	
	@Column(name="updated_at")
	private Date updateAt;
	
	@Column(name="flight_identifier")
	private String flightUID;
	
	@Column(name="fit_num")
	private Integer flightNum;
	
	@Column(name="scheduled_origin_gate")
	private String gateOrigin;
	
	@Column(name="scheduled_destination_gate")
	private String gateDestination;
	
	@Column(name="out_gmt")
	private Date out;
	
	@Column(name="in_gmt")
	private Date in;
	
	@Column(name="off_gmt")
	private Date off;
	
	@Column(name="on_gmt")
	private Date on;

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

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
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

	public Date getOut() {
		return out;
	}

	public void setOut(Date out) {
		this.out = out;
	}

	public Date getIn() {
		return in;
	}

	public void setIn(Date in) {
		this.in = in;
	}

	public Date getOff() {
		return off;
	}

	public void setOff(Date off) {
		this.off = off;
	}

	public Date getOn() {
		return on;
	}

	public void setOn(Date on) {
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
