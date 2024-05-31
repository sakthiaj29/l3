package trainticketbookingwithoutmodel;

import java.util.ArrayList;
import java.util.List;

public class DataLayer {
	
	public static DataLayer dataLayer;
	private List<Train> trainList=new ArrayList<>();
	private List<Passenger> passengerList=new ArrayList<>();
	private List<Ticket> ticketList=new ArrayList<>();
	
	public static DataLayer getInstance() {
		if(dataLayer==null) {
			dataLayer=new DataLayer();
		}
		return dataLayer;
	}
	
	public List<Ticket> getTicketList() {
		return ticketList;
	}

	public void setTicketList(Ticket ticket) {
		ticketList.add(ticket);
	}

	
	
	public boolean setPassenger(Passenger passenger) {
		return passengerList.add(passenger);
	}

	public List<Passenger> getPassengerList() {
		return passengerList;
	}
	
	
	
	public List<Train> getTrainList() {
		return trainList;
	}

	public boolean setTrain(Train train) {
		if(trainList==null) {
			trainList=new ArrayList<>();
		}
		return trainList.add(train);
	}

	public List<Train> isTrainAvaliable(String fromStation, String toStation) {
		List<Train> avilableTrains=new ArrayList<>();
		for(Train train: trainList) {
			if(train.getRoutes().contains(fromStation) && train.getRoutes().contains(toStation)) {
				avilableTrains.add(train);
			}
		}
		return avilableTrains;
	}

	public int getSeatCount(int number) {
		for(Train train: trainList) {
			if(train.getNumber()==number) {
				return train.getTotalSeats();
			}
		}
		return 0;
	}

	public int getFare(int number) {
		for(Train train: trainList) {
			if(train.getNumber()==number) {
				return train.getFare();
			}
		}
		return 0;
	}

	public Ticket getTicket(int pnrNumber) {
		for(Ticket ticket: ticketList) {
			if(ticket.getPnrNumber()==pnrNumber) {
				return ticket;
			}
		}
		return null;
	}

	public Train getTrain(int trainId) {
		for(Train train: trainList) {
			if(train.getNumber()==trainId) {
				return train;
			}
		}
		return null;
	}

	public List<Passenger> getBookedPassengersList(List<Integer> passengersId) {
		List<Passenger> bookedPassengers=new ArrayList<>();
		for(Integer passengerId: passengersId) {
			for(Passenger passenger: passengerList) {
				if(passenger.getId()==passengerId) {
					bookedPassengers.add(passenger);
				}
			}
		}
		return bookedPassengers;
	}

	public Passenger getPassenger(int id) {
		for(Passenger passenger: passengerList) {
			if(passenger.getId()==id) {
				return passenger;
			}
		}
		return null;
	}

	public boolean cancelTicket(int number) {
		for(int i=0;i<ticketList.size();i++) {
			if(ticketList.get(i).getPnrNumber()==number) {
				ticketList.remove(i);
				return true;
			}
		}
		return false;
	}
	
}
