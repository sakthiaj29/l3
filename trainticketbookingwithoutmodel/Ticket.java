package trainticketbookingwithoutmodel;

import java.util.List;

public class Ticket {

	private int pnrNumber;
	private List<Integer> passengersId;
	private int trainId;
	private String status;
	private int totalFare;
	
	public Ticket(int pnrNumber, List<Integer> passengersId, int trainId, String status, int totalFare) {
		this.pnrNumber=pnrNumber;
		this.passengersId=passengersId;
		this.trainId=trainId;
		this.status=status;
		this.totalFare=totalFare;
	}
	
	public int getPnrNumber() {
		return pnrNumber;
	}
	
	public void setPnrNumber(int pnrNumber) {
		this.pnrNumber = pnrNumber;
	}
	
	public List<Integer> getPassengersId() {
		return passengersId;
	}
	
	public void setPassengersId(List<Integer> passengersId) {
		this.passengersId = passengersId;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public int getTrainId() {
		return trainId;
	}

	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}

	public int getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(int totalFare) {
		this.totalFare = totalFare;
	}
}
