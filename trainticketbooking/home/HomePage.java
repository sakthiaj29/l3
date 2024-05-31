package trainticketbooking.home;

import java.util.Scanner;

public class HomePage {

	private byte BOOKING = 1;
	private byte PNR_STATUS = 2;
	private byte BOOKED_TICKETS =3;
	private byte CANCEL_TICKETS =4;
	private byte SEARCH_PASSENGER =5;
	private byte CHANGE_STATUS = 6;
	private byte SHOW_TRAIN_ROUTES = 7;
	private byte ADD_TRAIN_ROUTES = 7;
	private Scanner scanner=new Scanner(System.in);
	
	public void init() {
		System.out.println(" "+BOOKING+" -> Booking\n "+
							   PNR_STATUS+" -> Get PNR Status\n "+
							   BOOKED_TICKETS+" -> Booked Tickts\n "+
							   CANCEL_TICKETS+" -> Cancel Tickets\n "+
							   SEARCH_PASSENGER+" -> Search Passangers\n "+
							   CHANGE_STATUS+" -> Change Tickets Status of a Passangers\n "+
							   SHOW_TRAIN_ROUTES+" -> List Train Routes\n "+
							   ADD_TRAIN_ROUTES+" -> Add Train Routes"
				);
		System.out.print("\nEnter your option: ");
		byte chioce = scanner.nextByte();
		if(chioce==BOOKING) {
			onBooking();
		}
		else if(chioce==PNR_STATUS) {
			showPnrStatus();
		}
		else if(chioce==BOOKED_TICKETS) {
			showBookedTickets();
		}
		else if(chioce==CANCEL_TICKETS) {
			onCancelTickets();
		}
		else if(chioce==SEARCH_PASSENGER) {
			onSearchPassenger();
		}
		else if(chioce==CHANGE_STATUS) {
			onChangePnrStatus();
		}
		else if(chioce==SHOW_TRAIN_ROUTES) {
			showTrainRoutes();
		}
		else if(chioce==ADD_TRAIN_ROUTES) {
			onAddTrainRoutes();
		}
	}

	private void onAddTrainRoutes() {
		System.out.println("Developing");
	}

	private void showTrainRoutes() {
		System.out.println("Developing");
	}

	private void onChangePnrStatus() {
		System.out.println("Developing");
	}

	private void onSearchPassenger() {
		System.out.println("Developing");
	}

	private void onCancelTickets() {
		System.out.println("Developing");
	}

	private void showBookedTickets() {
		System.out.println("Developing");
	}

	private void showPnrStatus() {
		// TODO Auto-generated method stub
		
	}

	private void onBooking() {
		
	}
}
