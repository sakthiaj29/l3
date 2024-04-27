package TaxiBooking;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner sc=new Scanner(System.in);
	static int bookingId=1;

	static void Booking() {
		TaxiBooker booker=new TaxiBooker();
		booker.addTaxi(); 
		System.out.println("Customer ID:");
		int customerId=sc.nextInt();
		System.out.println("Pickup Point:");
		char pickupPoint=sc.next().charAt(0);
		System.out.println("Drop Point:");
		char dropPoint=sc.next().charAt(0);
		System.out.println("Pickup Time:");
		int pickupTime=sc.nextInt();
		booker.bookTaxi(customerId,bookingId,pickupPoint, dropPoint, pickupTime);
		booker.printCustomerAll();
	}
	public static void main(String[] args) {
	
		boolean loop=true;
		while(loop) {
			System.out.println("1)Booking \n2)Display the Taxi details \n3)Exit");
			int choice=sc.nextInt();
			if(choice==1) {
				Booking();
			}
			else if(choice==2) {
				
			}
			else if(choice==3) {
				loop=false;
			}
			else {
				System.out.println("Invalid Option!..");
			}
		}
	}

}
