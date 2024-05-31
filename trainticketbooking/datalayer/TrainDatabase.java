package trainticketbooking.datalayer;

import java.util.ArrayList;
import java.util.List;

import trainticketbooking.model.Passanger;
import trainticketbooking.model.Ticket;
import trainticketbooking.model.Train;

public class TrainDatabase {

	public static TrainDatabase trainDatabase;
	private List<Train> trainList = new ArrayList<>();
	private List<Passanger> passangerList = new ArrayList<>();
	private List<Ticket> ticketList = new ArrayList<>();

	public static TrainDatabase getInstance() {
		if (trainDatabase == null) {
			trainDatabase = new TrainDatabase();
		}
		return trainDatabase;
	}

	public List<Train> getTrainList() {
		return trainList;
	}

	public boolean setTrainList(Train train) {
		if(trainList==null) {
			trainList=new ArrayList<>();
		}
		return trainList.add(train);
	}

	public List<Passanger> getPassangerList() {
		return passangerList;
	}

	public void setPassangerList(List<Passanger> passangerList) {
		this.passangerList = passangerList;
	}

	public List<Ticket> getTicketList() {
		return ticketList;
	}

	public void setTicketList(List<Ticket> ticketList) {
		this.ticketList = ticketList;
	}

}
