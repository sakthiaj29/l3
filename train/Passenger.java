package train;

public class Passenger {
	static int id=1;
	String name;
	int age;
	String berthPre;
	int passengerId;
	String alloted;
	int number; 
	Passenger(String name,int age,String berthPre){
		this.name=name;
		this.age=age;
		this.berthPre=berthPre;
		alloted="";
		this.passengerId=id++;
		number=-1;
	}
}
