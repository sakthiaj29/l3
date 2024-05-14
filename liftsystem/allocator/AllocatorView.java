package liftsystem.allocator;

import java.util.List;
import java.util.Scanner;

import liftsystem.model.Lift;

public class AllocatorView {
	
	private AllocatorModel allocatorModel;
	private final byte LIFT_ASSIGN = 1;
	private final byte MAINTENANCE=2;
	private final byte EXIT = 0;
	private Scanner scanner = new Scanner(System.in);
	
	public AllocatorView() {
		allocatorModel=new AllocatorModel(this);
	}
	
	public void init() {
		allocatorModel.add();
		System.out.println("\n "+LIFT_ASSIGN+" -> Lift Assign\n "+MAINTENANCE+" -> Maintenance\n "+EXIT+" -> Exit");
		System.out.print(" Enter choice: ");
		byte choice = scanner.nextByte();
		System.out.println();

		if (choice == LIFT_ASSIGN) {
			allocate();
		}else if(choice == MAINTENANCE) {
			maintenance();
		}else if (choice == EXIT) {
			System.exit(0);
		} else {
			System.out.println("Invalid choice, Enter valid option");
		}
		init();
	}
	
	private void maintenance() {
		allocatorModel.display();
		System.out.print("\nEnter a lift number: ");
		int number=scanner.nextInt();
		allocatorModel.onMaintenance(number);
	}

	private void allocate() {
		allocatorModel.display();
		System.out.print("\n\nEnter Current Floor: ");
		int currFloor=scanner.nextInt();
		System.out.print("Enter Destination Floor: ");
		int destFloor=scanner.nextInt();
		allocatorModel.onAllocator(currFloor, destFloor);
	}
	
	public void messege(String alertText) {
		System.out.println(alertText);
		init();
	}

	public void display(List<Lift> lifts) {
		System.out.print("Lift:");
		for (int i = 1; i <= lifts.size(); i++) {
			System.out.print(" L" + i);
		}
		System.out.print("\nFloor:");
		for (Lift lift : lifts) {
			if(lift.getCurrentPosition()==-1) {
				System.err.print(" " + lift.getCurrentPosition() + " ");
			}
			System.out.print(" " + lift.getCurrentPosition() + " ");
		}
	}
}

