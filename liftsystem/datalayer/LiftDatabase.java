package liftsystem.datalayer;

import java.util.ArrayList;
import java.util.List;

import liftsystem.model.Lift;

public class LiftDatabase {
	
	private List<Lift> lifts = new ArrayList<>();
	private static LiftDatabase liftDatabase;
	
	public static LiftDatabase getInstance() {
		if(liftDatabase==null) {
			liftDatabase=new LiftDatabase();
		}
		return liftDatabase;
	}
	
	public List<Lift> getAllLift() {
		return  lifts;
	}
	
	public void setAllLift(List<Lift> lifts) {
		this.lifts=lifts;
	}
	
	
}
