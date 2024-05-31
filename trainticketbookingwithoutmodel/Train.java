package trainticketbookingwithoutmodel;

import java.util.List;

public class Train {

	private int number;
	private String name;
	private String departureTime;
	private String arrivalTmie;
	private List<String> routes;
	private int totalSeats;
	private int fare;
	
	public Train(int number, String name, String departureTime, String arraivalTime, List<String> routes, int totalSeats, int fare) {
		this.number=number;
		this.name=name;
		this.departureTime=departureTime;
		this.arrivalTmie=arraivalTime;
		this.routes=routes;
		this.totalSeats=totalSeats;
		this.fare=fare;
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
	public String getArrivalTmie() {
		return arrivalTmie;
	}
	public void setArrivalTmie(String arrivalTmie) {
		this.arrivalTmie = arrivalTmie;
	}
	public List<String> getRoutes() {
		return routes;
	}
	public void setRoutes(List<String> routes) {
		this.routes = routes;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
}
