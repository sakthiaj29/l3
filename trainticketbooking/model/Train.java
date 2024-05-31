package trainticketbooking.model;

import java.util.List;

public class Train {

	private int number;
	private String name;
	private String departureTime;
	private String arrivalTime;
	private List<String> routes;
	private int totalSeats;
	private short fare;

	public Train(int number, String name, String departureTime, String arrivalTime, List<String> routes, int totalSeats,
			short fare) {
		this.number = number;
		this.name = name;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.routes = routes;
		this.totalSeats = totalSeats;
		this.fare = fare;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public List<String> getRoutes() {
		return routes;
	}

	public void setRoutes(List<String> routes) {
		this.routes = routes;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public short getFare() {
		return fare;
	}

	public void setFare(short fare) {
		this.fare = fare;
	}

}
