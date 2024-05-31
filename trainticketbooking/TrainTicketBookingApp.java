package trainticketbooking;

import trainticketbooking.appsetup.AppSetupView;

public class TrainTicketBookingApp {

	public static String APP_NAME = "IRCTC";

	public static TrainTicketBookingApp trainTicketBookingApp;

	private static TrainTicketBookingApp getAppInstance() {
		if (trainTicketBookingApp == null) {
			trainTicketBookingApp = new TrainTicketBookingApp();
		}
		return trainTicketBookingApp;
	}

	private void start() {
		new AppSetupView().init();
	}

	public static void main(String[] args) {
		TrainTicketBookingApp.getAppInstance().start();
		;
	}
}
