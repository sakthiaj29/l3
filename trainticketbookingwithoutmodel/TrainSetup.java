package trainticketbookingwithoutmodel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrainSetup {
	
	private Scanner scanner=new Scanner(System.in);
	private Train train;
	private List<String> routeList;
	private boolean isTrainAdded;
	
	public void init() {
		addTrains();
		if(isTrainAdded) {
			System.out.println("------------All trains added successfully.");
			new HomePage().init();
		}
		else {
			addTrains();
		}
	}

	public void addTrains() {
		
		int number=0, totalSeats=0, fare=0;
		String name="", departureTime="", arrivalTime="", routes="";
		
		System.out.println("\t\t\t --- "+"IRTC"+" ---");
		System.out.println("\t\t\t --- "+"0.0.1"+" ---");
		System.out.println("\nEnter Number Of Schedule : ");
		int numberOfSchedule=scanner.nextInt();
		for(int i=1;i<=numberOfSchedule;i++) {
			System.out.println("Schedule"+i+" :");
			System.out.println("Enter Train Number: ");
			number=scanner.nextInt();
			System.out.println("Enter Train Name: ");
			scanner.nextLine();
			name=scanner.nextLine();
			System.out.println("Enter Departure Time: ");
			departureTime=scanner.nextLine();
			System.out.println("Enter Arrival Time: ");
			arrivalTime=scanner.nextLine();
			System.out.println("Enter Routes (Enter each station type ',' sperated)");
			routes=scanner.nextLine();
			System.out.println("Enter Number Seates: ");
			totalSeats=scanner.nextInt();
			System.out.println("Enter Fare (RS)");
			fare=scanner.nextInt();
			System.out.println(number+" , "+name+" , "+departureTime+" , "+arrivalTime+" , "+routes+" , "+totalSeats+" , "+fare);
			isTrainAdded=addTrain(number, name, departureTime, arrivalTime, routes, totalSeats, fare);
			if(!isTrainAdded) {
				i--;
			}
		}
		
	}
	
	public boolean addTrain(int number, String name, String departureTime, String arrivalTime, String routes, int totalSeats, int fare) {
		String[] routesArray=routes.split(",");
		routeList=new ArrayList<>();
		for(int i=0;i<routesArray.length;i++) {
			routeList.add(routesArray[i]);
		}
		train=new Train(number, name, departureTime, arrivalTime, routeList, totalSeats, fare);
		return DataLayer.getInstance().setTrain(train);
	}
	
}
