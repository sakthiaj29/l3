package TaxiBooking;

public class Taxi {
	int TaxiNumber;
	int TotalEarnings;
	char CurrentLocation;
	int CurrentTime;
	Taxi(int taxiNumber,int amount,char currentLocation,int currentTime){
		TaxiNumber=taxiNumber;
		TotalEarnings+=amount;
		CurrentLocation=currentLocation;
		CurrentTime=currentTime;
	}
}
