package trainticketbooking.appsetup;

import java.awt.Robot;
import java.util.Scanner;

import trainticketbooking.home.HomePage;

public class AppSetupView {

	private AppSetupModel appSetupModel;
	private boolean isSetupCompleted = false;
	private Scanner scanner = new Scanner(System.in);

	public AppSetupView() {
		appSetupModel = new AppSetupModel();
	}

	public void init() {
		setup();
		if (isSetupCompleted) {
			System.out.println("Train Schedules Successfully :)");
		} else {
			System.out.println("Train Schedules Faild :(");
			setup();
		}
		new HomePage().init();
	}

	public void setup() {
		int number = 0, totalSeats = 0;
		short fare = 0;
		String name = "", departureTime = "", arraivalTime = "", routes = "";

		System.out.println("\t\t\tWelcome to Indian Railway System");
		System.out.println("App Setup\n" + "---------");
		System.out.println("Enter number of Schedules you want added ?");
		int numberOfSchedules = scanner.nextInt();
		for (int i = 1; i <= numberOfSchedules; i++) {
			System.out.println("Schedule" + i + " :");
			System.out.print("\nEnter Train Number : ");
			number = scanner.nextInt();
			System.out.print("\nEnter Train Name : ");
			name = scanner.nextLine();
			System.out.print("\nEnter Departure Time: ");
			departureTime = scanner.nextLine();
			System.out.print("\nEnter Arrival Time: ");
			arraivalTime = scanner.nextLine();
			System.out.print("\nEnter Train Routes '(,separated)'");
			routes = scanner.nextLine();
			System.out.print("\nEnter fare : ");
			fare = scanner.nextShort();
			isSetupCompleted = appSetupModel.addTrain(numberOfSchedules, name, departureTime, arraivalTime, routes,
					totalSeats, fare);
			if (!isSetupCompleted) {
				i--;
			}
		}

	}
}
