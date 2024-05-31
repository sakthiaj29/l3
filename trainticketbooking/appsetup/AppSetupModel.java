package trainticketbooking.appsetup;

import java.util.ArrayList;
import java.util.List;

import trainticketbooking.datalayer.TrainDatabase;
import trainticketbooking.model.Train;

public class AppSetupModel {
	
	private Train train;
	
	public boolean addTrain(int number, String name, String departureTime, String arrivalTime, String routes, int totalSeats, short fare) {
		
		List<String> routeList=new ArrayList<>();
		addRoutes(routeList, routes);
		train=new Train(number, name, departureTime, arrivalTime, routeList, totalSeats, fare);
		return TrainDatabase.getInstance().setTrainList(train);
	}

	private void addRoutes(List<String> routeList, String routes) {
		String[] routesArray=routes.split(",");
		for(int i=0;i<routesArray.length;i++) {
			if(routesArray[i]!=null) {
				routeList.add(routesArray[i]);
			}
		}
	}

	
}
