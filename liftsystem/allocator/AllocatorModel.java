package liftsystem.allocator;

import java.util.List;

import liftsystem.datalayer.LiftDatabase;
import liftsystem.model.Lift;

public class AllocatorModel {
	
	private AllocatorView allocatorView;
	
	public AllocatorModel(AllocatorView allocatorView) {
		this.allocatorView=allocatorView;
	}
	
	public void onAllocator(int currFloor, int destFloor) {
		List<Lift> lifts=LiftDatabase.getInstance().getAllLift();
		int minDistance=Integer.MAX_VALUE;
		int index=-1;
		int currPostion=-1;
		
		for(int i=0;i<lifts.size();i++) {
			currPostion=lifts.get(i).getCurrentPosition();
			
			if(currPostion!=-1 && canAllocate(i, currFloor, destFloor)) {
				if(minDistance==Math.abs(currPostion-currFloor)) {
					if( (currFloor>destFloor) && (currPostion>currFloor)) {
						index=i;
					}
				}
				
				else if(minDistance>Math.abs(currPostion-currFloor)) {
					minDistance=Math.abs(currPostion-currFloor);
					index=i;
				}
			}
			
		}
		
		if(index>=0) {
			lifts.get(index).setCurrentPosition(destFloor);
			allocatorView.messege("\nL"+(index+1)+" is assigned :)");
			
		}
		else {
			allocatorView.messege("\nNo lift assigned :(");
		}
		
		allocatorView.init();
	}
	
	private boolean canAllocate(int number, int currFloor, int destFloor) {
		if((number==0 || number==1) && (currFloor>=0 && currFloor<=5) && (destFloor>=0 && destFloor<=5)) {
			return true;
		}
		else if((number==2 || number==3) && ((currFloor==0 || currFloor>5) && currFloor<=10) && ((destFloor==0 || destFloor>5) && destFloor<=10)) {
			return true;
		}
		else if(number==4) {
			return true;
		}
		return false;
	}

	public void onMaintenance(int number) {
		List<Lift> lifts=LiftDatabase.getInstance().getAllLift();
		if(number>0 && number<=lifts.size()) {
			lifts.get(number-1).setCurrentPosition(-1);
			allocatorView.messege("\n lift"+number+"is under maintenance");
		}
		else {
			allocatorView.messege("\n Lift maintenance not set");
		}
		allocatorView.init();
	}
	
	public void display() {
		List<Lift> lifts=LiftDatabase.getInstance().getAllLift();
		allocatorView.display(lifts);
	}

	public void add() {
		List<Lift> lifts=LiftDatabase.getInstance().getAllLift();
		if (lifts.size() == 0) {
			for (int i = 1; i <= 5; i++) {
				lifts.add(new Lift(i));
			}
		}
		LiftDatabase.getInstance().setAllLift(lifts);
	}
	
}
