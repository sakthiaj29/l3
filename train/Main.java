package train;

import java.util.Scanner;

public class Main {
	static void bookTicket(Passenger p) {
		TicketBooking booker=new TicketBooking();
		if(TicketBooking.availableWaitingList==0) {
			System.out.println("no ticket available");
			return;
		}
		if((p.berthPre.equals("L") && TicketBooking.availableLowerBer>0) ||
			(p.berthPre.equals("M") && TicketBooking.availableMiddleBer>0) || 
			(p.berthPre.equals("U") && TicketBooking.availableUpperBer>0)) {
			System.out.println("pref bearth available");
			if(p.berthPre.equals("L")) {
				System.out.println("Lower bearth given");
				booker.bookTicket(p,(TicketBooking.lowerBer.get(0)),"L");
				TicketBooking.lowerBer.remove(0);
				TicketBooking.availableLowerBer--;
			}
			else if(p.berthPre.equals("M")) {
				System.out.println("Midel bearth given");
				booker.bookTicket(p,(TicketBooking.middleBer.get(0)),"M");
				TicketBooking.middleBer.remove(0);
				TicketBooking.availableMiddleBer--;
			}
			else if(p.berthPre.equals("U")) {
				System.out.println("Upper bearth given");
				booker.bookTicket(p,(TicketBooking.upperBer.get(0)),"U");
				TicketBooking.upperBer.remove(0);
				TicketBooking.availableUpperBer--;
			}
		}
		else if(TicketBooking.availableLowerBer>0) {
			System.out.println("Lower bearth given");
			booker.bookTicket(p,TicketBooking.lowerBer.get(0),"L");
			TicketBooking.lowerBer.remove(0);
			TicketBooking.availableLowerBer--;
		}
		else if(TicketBooking.availableMiddleBer>0) {
			System.out.println("Middle bearth given");
			booker.bookTicket(p,TicketBooking.middleBer.get(0),"M");
			TicketBooking.middleBer.remove(0);
			TicketBooking.availableMiddleBer--;
		}
		else if(TicketBooking.availableUpperBer>0) {
			System.out.println("Upper bearth given");
			booker.bookTicket(p,TicketBooking.upperBer.get(0),"U");
			TicketBooking.upperBer.remove(0);
			TicketBooking.availableUpperBer--;
		}
		else if(TicketBooking.availableWaitingList>0) {
			System.out.println("added to waiting list");
			booker.addToWaitingList(p,(TicketBooking.waitingList.get(0)),"Wl");
		}
	}
	static void cancelTicket(int id) {
		TicketBooking booker=new TicketBooking();
		if(booker.passengers.containsKey(id)) {
			booker.cancelTicket(id);
		}
		else {
			System.out.println("Passenger Id not valid");
		}
	}
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		boolean loop=true;
		while(loop) {
			System.out.println(" 1)Book Tickt\n 2)Cancel Ticket\n 3)Available Tickets\n 5)Exit");
			int choice=sc.nextInt();
				if(choice==1) {
					System.out.println("enter passanger name, age and berth preference(L , M or U)");
					String name=sc.next();
					int age=sc.nextInt();
					String berthPer=sc.next();
					Passenger p=new Passenger(name,age,berthPer) ;
					bookTicket(p);
 				}
				else if(choice==2){
					System.out.println("Enter Passenger Id to cancel");
					int id=sc.nextInt();
					cancelTicket(id);
				}
				else if(choice==3){
					TicketBooking booker=new TicketBooking();
					booker.printAvailable();
					
				}
				else if(choice==5){
					loop=false;
				}
			
			}
		}
	}
