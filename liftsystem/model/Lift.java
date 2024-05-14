package liftsystem.model;

public class Lift {

	private int number;
	private int currentPosition;
	private int capacity;
	
	public Lift(int number){
		this.number=number;
	}
	
	public int getNumber() {
		return number;
	}
	
	public int getCurrentPosition() {
		return currentPosition;
	}
	
	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
