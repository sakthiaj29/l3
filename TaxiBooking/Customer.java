package TaxiBooking;

public class Customer {
	int CustomerId;
	int BookingId;
	char PickupPoint;
	char DropPoint;
	int PickupTime;
	int DropTime;
	int Amount;
	int TaxiNumber;
	Customer(int customerId,int bookingId,char pickupPoint,char dropPoint,int pickupTime,int dropTime,int amount,int taxiNumber){
		CustomerId=customerId;
		BookingId=bookingId;
		PickupPoint=pickupPoint;
		DropPoint=dropPoint;
		PickupTime=pickupTime;
		DropTime=dropTime;
		Amount=amount;
		TaxiNumber=taxiNumber;
	}
}
