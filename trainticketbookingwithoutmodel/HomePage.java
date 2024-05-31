package trainticketbookingwithoutmodel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HomePage {
	
	private Scanner scanner=new Scanner(System.in);
	private Ticket ticket;
	private static int passengerId=100;
	private static int ticketId=123456;
	private boolean isBookedPassanger;

	public void init() {
		System.out.println("1 -> Booking\n"+
						   "2 -> Get PNR Status\n"+
						   "3 -> Booked Ticketes\n"+
						   "4 -> Cancel Ticket\n"+
						   "5 -> Search Passenger\n"+
						   "6 -> Change Ticket Status of a Passengers\n"+
						   "7 -> List Of Trains\n"+
						   "8 -> Add Train Routes"+
						   "0 -> Exit"
				);
		System.out.print("Enter choice: ");
		int choice=scanner.nextInt();
		
		switch (choice) {
		
		case 1: onBooking(); break;
		
		case 2: getPnrStatus(); break;
		
		case 3: showBookedTicked(); break;
		
		case 4: onCancelTicket(); break;
		
		case 5: onSearchPaggenger(); break;
		
		case 7: showTrains(); break;
		
		case 0: 
				System.out.println("Thank You Vist Again!");
				System.exit(0);
			
		default:
			System.out.println("Invalid Choice: " +choice);
		}
		
		init();
		
	}

	private void onCancelTicket() {
		System.out.println("Enter Your PNR Number :");
		int number=scanner.nextInt();
		boolean result=DataLayer.getInstance().cancelTicket(number);
		if(result) {
			System.out.println("Ticket Canceled Successfully!");
		}
		else {
			System.out.println("No Tickts Fount");
		}
	}


	private void onSearchPaggenger() {
		System.out.println("Enter Passenger Id: ");
		int id=scanner.nextInt();
		Passenger passenger=DataLayer.getInstance().getPassenger(id);
		if(passenger!=null) {
			printPassenger(passenger);
		}
		else {
			System.out.println("No Passenger Fount!");
		}
	}


	private void showBookedTicked() {
		List<Ticket> ticketList=DataLayer.getInstance().getTicketList();
		if(ticketList.size()!=0) {
			System.out.println("Booked Tcikets");
			for(Ticket ticket: ticketList) {
				printTicket(ticket);
			}
		}
		else {
			System.out.println("No Booked Tickets Available!");
		}
	}

	private void showTrains() {
		List<Train> trainList=DataLayer.getInstance().getTrainList();
		System.out.println("\nTrain\n");
		printTrains(trainList);
	}

	private void printTrains(List<Train> trainList) {
		for(Train train: trainList) {
			printTrain(train);
		}
	}
	
	private void printTrain(Train train) {
		System.out.println("Number : "+train.getNumber()+"  |  Name : "+train.getName());
		System.out.println("Departure Time : "+train.getDepartureTime()+"  |  Arraival Time : "+train.getArrivalTmie());
		System.out.println("Seats : "+train.getTotalSeats()+"  |  Fare : "+train.getFare());
		System.out.println();
	}
	
	private void printPassengers(List<Passenger> passengerList) {
		for(Passenger passenger:passengerList) {
			printPassenger(passenger);
		}
		init();
	}
	
	private void printPassenger(Passenger passenger) {
		System.out.println("Name : "+passenger.getName()+"  |  Age : "+passenger.getAge());
		System.out.println("Gender : "+passenger.getGender()+"  |  Id : "+passenger.getId());
		System.out.println();
	}
	private void printTicket(Ticket ticket) {
		System.out.println("Ticket Details");
		System.out.println("--------------\n");
		
		Train train=DataLayer.getInstance().getTrain(ticket.getTrainId());
		System.out.println("Train Details\n");
		printTrain(train);
		
		List<Passenger> passengerList=DataLayer.getInstance().getBookedPassengersList(ticket.getPassengersId());
		System.out.println("Passengers Details\n");
		printPassengers(passengerList);
		
	}
	
	private void getPnrStatus() {
		System.out.println("Enter PNR Number:");
		int pnrNumber=scanner.nextInt();
		ticket=DataLayer.getInstance().getTicket(pnrNumber);
		if(ticket!=null) {
			printTicket(ticket);
		}
		else {
			System.out.println("No Tickets Avialable");
		}
	}

	private void onBooking() {
		Passenger passenger=null;
		String name="", gender="";
		int age=0;
		List<Integer> passengersId=new ArrayList<>();
		
		System.out.println("From station: ");
		String fromStation=scanner.next();
		System.out.println("To station: ");
		String toStation=scanner.next();
		
		List<Train> trainList=DataLayer.getInstance().isTrainAvaliable(fromStation, toStation);
		
		if(trainList.size()!=0) {
			System.out.println("\nAvilable Trains\n");
			printTrains(trainList);
			System.out.println("Enter Train Number: ");
			int number=scanner.nextInt();
			String status=getStatus(number);
			
			if(status.length()!=0) {
				
				System.out.print("\nEnter number of Passangers: ");
				int numberOfPassengers=scanner.nextInt();
				scanner.nextLine();
				int totalfare=getFare(number)*numberOfPassengers;
				
				for(int i=1;i<=numberOfPassengers;i++) {
					System.out.println("Enter Passengers "+i+" details: \n");
					System.out.println("Name: ");
					name=scanner.nextLine();
					System.out.println("Age: ");
					age=scanner.nextInt();
					scanner.nextLine();
					System.out.println("Gender: ");
					gender=scanner.nextLine();
					passenger=new Passenger(name, age, gender, passengerId);
					DataLayer.getInstance().setPassenger(passenger);
					passengersId.add(passengerId);
					passengerId++;
				}
				System.out.println("Total Fare: ₹"+totalfare);
				
				System.out.println("Pay:");
				System.out.println("1-Pay, 2-Cancel, 3-reschedule");
				int option=scanner.nextInt();
				
				if(option==1) {
					ticket=new Ticket(ticketId, passengersId, number, status, totalfare);
					DataLayer.getInstance().setTicketList(ticket);
					System.out.println("Ticket Booking Successfull");
					System.out.println("Your PNR Number is : "+ticketId);
					init();
				}
				else if(option==2){
					System.out.println("Booking Canceld!");
					init();
				}
				else if(option==3) {
					onBooking();
				}
				else {
					System.out.println("Invalid chice!");
					init();
				}
				
				
			}
			else {
				System.out.println("No Seats Available!");
			}
			
		}
		else {
			System.out.println("No Trains Available!");
		}
		
	}

	private int getFare(int number) {
		return DataLayer.getInstance().getFare(number);
	}

	private String getStatus(int number) {
		int seaatsCount=DataLayer.getInstance().getSeatCount(number);
		if(seaatsCount>0) {
			return "CNF";
		}
		else if(seaatsCount<=0 && seaatsCount>=-2) {
			return "WL";
		}
		return "";
	}
	

}
