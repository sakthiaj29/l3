package student;

import java.util.ArrayList;


import java.util.Scanner;



public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ArrayList<student> list=new ArrayList<>();
		student s1=new student("sakthi",1,12,1190);
		student s2=new student("arun",2,10,456);
		student s5=new student("aruna",1,11,1110);
		student s3=new student("suku",8,11,1200);
		student s4=new student("partha",6,10,487);
		student s7=new student("Rajii",4,11,1110);

		student s6=new student("Saro",26,10,463);

	
		list.add(s4);list.add(s1);list.add(s2);list.add(s3);
		list.add(s5);
		System.out.println("enter your option \n1)name \n2)id \n3)class \n4)Mark");
		int c=sc.nextInt();
		if(c==1) {
			ArrayList<student> temp=list;
			for(int i=0;i<temp.size();i++) {
				for(int j=i+1;j<temp.size();j++) {
					student s;
					if(temp.get(i).Name.compareTo(temp.get(j).Name)>0) {
						s=temp.get(i);
						temp.set(i, temp.get(j));
						temp.set(j,s);
					}
				}
			}
			for(student s:temp) {
				System.out.println(s.Name+" "+s.Id+" "+s.Class+" "+s.Total);
			}
		}
		else if(c==2) {
			ArrayList<student> temp=list;
			for(int i=0;i<temp.size();i++) {
				for(int j=i+1;j<temp.size();j++) {
					student s;
					if(temp.get(i).Id.compareTo(temp.get(j).Id)>0) {
						s=temp.get(i);
						temp.set(i, temp.get(j));
						temp.set(j,s);
					}
				}
			}
			for(student s:temp) {
				System.out.println(s.Name+" "+s.Id+" "+s.Class+" "+s.Total);
			}
			
		}
		else if(c==3) {
			ArrayList<student> temp=list;
			for(int i=0;i<temp.size();i++) {
				for(int j=i+1;j<temp.size();j++) {
					student s;
					if(temp.get(i).Class.compareTo(temp.get(j).Class)>0) {
						s=temp.get(i);
						temp.set(i, temp.get(j));
						temp.set(j,s);
					}
				}
			}
			for(student s:temp) {
				System.out.println(s.Name+" "+s.Id+" "+s.Class+" "+s.Total);
			}
		}
		else if(c==4) {
			ArrayList<student> temp=list;
			for(int i=0;i<temp.size();i++) {
				for(int j=i+1;j<temp.size();j++) {
					student s;
					if(temp.get(i).Total.compareTo(temp.get(j).Total)>0) {
						s=temp.get(i);
						temp.set(i, temp.get(j));
						temp.set(j,s);
					}
				}
			}
			for(student s:temp) {
				System.out.println(s.Name+" "+s.Id+" "+s.Class+" "+s.Total);
			}
		}
	}
}
