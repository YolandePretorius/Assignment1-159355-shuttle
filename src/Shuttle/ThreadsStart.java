//Class starts and stops passenger threads 
package Shuttle;

import java.util.ArrayList;

public class ThreadsStart {
	
	
	static int MaxnumberPassengers=50;
	static Boolean South = true;
	static Boolean North = false;

	public static void main(String[] args) throws InterruptedException {
		
				
		System.out.println("******************  Welcome to our transport services  ******************");
		
		ArrayList<Thread> threadsSouth = new ArrayList<Thread>();
		ArrayList<Thread> threadsNorth = new ArrayList<Thread>();
					
					
		TravelShuttle shuttle  = new TravelShuttle();
		
	    Passenger TravelSouthCustomer = new Passenger(South,shuttle);
		Passenger TravelNorthCustomer = new Passenger(North,shuttle);
		
				
		int added = 0;				
		for (int i = 1; i <= MaxnumberPassengers; i++) { // Create Threads that travels to Auckland and store in an Array
			added++;
			Thread customerTravelSouth = new Thread(TravelSouthCustomer,"Customer traveling to Auckland #"+i);
			threadsSouth.add(customerTravelSouth);
			customerTravelSouth.start();
			
		}
		
		
		added = 0;	
		for (int i = 1; i <= MaxnumberPassengers; i++) { // Create threads that travels to North Shore and store in an Array
			added++;
			Thread customerTravelNorth = new Thread(TravelNorthCustomer,"Customer traveling to North Shore"+i);
			threadsNorth.add(customerTravelNorth);
			customerTravelNorth.start();
			
		}
	
		// stop threads going to North Shore
		for (Thread thread : threadsSouth) {
			thread.interrupt();
			thread.join();
			
		}
		// stop threads going to Auckland
		for (Thread thread : threadsNorth) {
			thread.interrupt();
			thread.join();
			}
		
		System.out.println("Thank you for traveling with us");

	}

}
