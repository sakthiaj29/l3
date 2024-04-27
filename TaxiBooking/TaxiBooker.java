package TaxiBooking;

import java.util.ArrayList;

public class TaxiBooker {
	 ArrayList<Customer> Customers=new ArrayList<>();
	ArrayList<Taxi> Taxis=new ArrayList<>();
	public void addTaxi() {
		int j=0;
		for(int i=0;i<=4;i++) {
			Taxi taxi=new Taxi(i,0,'A',j);
			Taxis.add(taxi);
		}
		System.out.println(Taxis);
	}
	public void bookTaxi(int customerId,int bookingId,char pickupPoint,char dropPoint,int currentTime) {
		System.out.println(Taxis);
		for(Taxi taxis:Taxis) {
			System.out.println("hi");
			System.out.println(taxis);
			if(taxis.CurrentLocation<=pickupPoint && taxis.CurrentTime<=currentTime) {
				int dropTime=(dropPoint-pickupPoint);
				int amount=((dropPoint-pickupPoint)*15-5)*10+100;
				
				Customer customer=new Customer(customerId,bookingId,pickupPoint,dropPoint,currentTime,dropTime,amount,taxis.TaxiNumber);
				Customers.add(customer);
			}
		}
		return ;
	}
	public void setCustomer(Customer customer) {
		Customers.add(customer);
	}
	public void printCustomerAll() {
		for(Customer c:Customers) {
			System.out.println(c.BookingId+" "+c.Amount);
		}
		return;
	}
	
}
