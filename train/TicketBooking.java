package train;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TicketBooking {
	static int availableLowerBer=1;
	static int availableMiddleBer=1;
	static int availableUpperBer=1;
	static int availableWaitingList=1;
	
	static Queue<Integer> QWaitingList=new LinkedList<>();
	static List<Integer> bookedTicket=new ArrayList<>();
	
	static List<Integer> lowerBer=new ArrayList<>(Arrays.asList(1));
	static List<Integer> middleBer=new ArrayList<>(Arrays.asList(1));
	static List<Integer> upperBer=new ArrayList<>(Arrays.asList(1));
	static List<Integer> waitingList=new ArrayList<>(Arrays.asList(1));
	
	static Map<Integer,Passenger> passengers=new HashMap<>();
	
	public void bookTicket(Passenger p,int bearthInfo,String allotedBearth) {
		p.number=bearthInfo;
		p.alloted=allotedBearth;
		passengers.put(p.passengerId,p);
		bookedTicket.add(p.passengerId);
		System.out.println("............................ Booked Successfully");
	}
	public void addToWaitingList(Passenger p,int waitingListInfo,String allotedWl){
		p.number=waitingListInfo;
		p.alloted=allotedWl;
		passengers.put(p.passengerId,p);
		waitingList.add(p.passengerId);
		availableWaitingList--;
		waitingList.remove(0);
		System.out.println("............................ added to Waiting List Successfully");
	}
	public void cancelTicket(int id) {
		Passenger p=passengers.get(id);
		passengers.remove(p);
		bookedTicket.remove(p);
		int position=p.number;
		System.out.println("..............................cancel Successfully");
		
		if(p.alloted.equals("L")) {
			availableLowerBer++;
			lowerBer.add(position);
		}
		else if(p.alloted.equals("M")) {
			availableMiddleBer++;
			middleBer.add(position);
		}
		else if(p.alloted.equals("U")) {
			availableUpperBer++;
			upperBer.add(position);
		}
		if(QWaitingList.size()>0) {
			Passenger passFromWaitingList=passengers.get(QWaitingList.poll());
			//int posiWl=passFromWaitingList.number;
			//waitingList.add(posiWl);
			QWaitingList.remove(passFromWaitingList.passengerId);
			availableWaitingList++;
			//Main.bookTicket(passFromWaitingList);
		}	
	}
	public void printAvailable() {
		System.out.println("Available Lower Bearth = "+availableLowerBer);
		System.out.println("Available Middle Bearth = "+availableMiddleBer);
		System.out.println("Available Upper Bearth = "+availableUpperBer);
		System.out.println("Available Waiting Bearth = "+availableWaitingList);
	}
}
