package resultsbackend;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;
import resultsbackend.Students;
import resultsbackend.resultsDAO;
public class services {
	private static final int RollNumber = 0;
	private static final int PinNumber = 0;
	resultsDAO dao = new resultsDAO();
	Scanner scan = new Scanner(System.in);
	public void addStudentresults() {
	     
	     System.out.println("enter student name");
	     String name=scan.next();
	     System.out.println("enter PIN Number");
	     int pinnumber=scan.nextInt();
	     System.out.println("enter gender");
	     String gender=scan.next();
    	 System.out.println("enter the telugu marks");
    	 int a=scan.nextInt();
    	 System.out.println("enter the english marks");
    	 int b=scan.nextInt();
    	 System.out.println("enter the maths marks");
    	 int c=scan.nextInt();
    	 System.out.println("enter the physics marks");
    	 int d=scan.nextInt();
    	 System.out.println("enter the chemistry marks");
    	 int e=scan.nextInt();
    	 Students resu = new Students();
    	 resu.setPinnumber(pinnumber);
    	 resu.setName(name);
    	 resu.setGender(gender);
    	 resu.setTelugu(a);
    	 resu.setEnglish(b);
    	 resu.setMaths(c);
    	 resu.setPhysics(d);
    	 resu.setChemistry(e);     
          dao.addresults(resu);
	}
	public void displayresults(Students resu ) {
		System.out.println("pinnumber"+resu.getPinnumber());
		System.out.println(resu.getName());
		System.out.println(resu.getGender());
		System.out.println(resu.getTelugu());
		System.out.println(resu.getEnglish());
		System.out.println(resu.getMaths());
		System.out.println(resu.getPhysics());
		System.out.println(resu.getChemistry());
		System.out.println();
		 
	}
	public void displayresultss() {
		List<Students> empList = dao.displayresults();
		for(Students resu : empList) {
			displayresults(resu);
		}
	}
	public void resultsbyid() {
		
		 System.out.println("enter PIN Number");
	     int pinNumber=scan.nextInt();
	     Students resu = dao.displayresults(pinNumber);
         
	     if(resu.getPinnumber()==0) {
	    		System.out.println("Sorry!!! we unable to find an employee ");
			}
			else {
			    displayresults(resu);
			}
	}

	
	public void  menu() {
		while(true) {
		 System.out.println("menu");
		 System.out.println("\n1.add student results");
		 System.out.println("\n2.display all results");
		 System.out.println("\n3.display required results");
		
		 System.out.println("enter your choice");
		int option=scan.nextInt();
		switch(option){
		case 1:addStudentresults();break;
		case 2:displayresultss();break;

		case 3:resultsbyid();break;
		
		default: System.out.println("pleasse enter correct option");
		}
		}}
}
     
