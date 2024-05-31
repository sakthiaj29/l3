package trainticketbooking.model;

import java.util.ArrayList;
import java.util.List;

public class Ticket {

	private long pnrNumber;
	private List<Integer> passengersId;
	private int trainId;
	private String status;

	public Ticket(long pnrNumber, String status) {
		this.pnrNumber = pnrNumber;
		this.status = status;
	}

	public long getPnrNumber() {
		return pnrNumber;
	}

	public void setPnrNumber(long pnrNumber) {
		this.pnrNumber = pnrNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Integer> getPassengersId() {
		return passengersId;
	}

	public void setPassengerId(int passengerId) {
		if (passengersId == null) {
			passengersId = new ArrayList<>();
		}
		passengersId.add(passengerId);
	}

	public int getTrainId() {
		return trainId;
	}

	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}

}
