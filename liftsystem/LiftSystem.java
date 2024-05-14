package liftsystem;

import liftsystem.allocator.AllocatorView;

public class LiftSystem {

	public static LiftSystem main;
	
	public static LiftSystem getInstance() {
		if(main==null) {
			main=new LiftSystem();
		}
		return main;
	}
	
	void start() {
		
		new AllocatorView().init();
	}
	
	public static void main(String[] args) {
		
		LiftSystem.getInstance().start();
		
	}
}
