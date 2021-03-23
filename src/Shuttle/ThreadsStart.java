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
					
					//TravelDirection TDirection  = new TravelDirection();
		TravelShuttle shuttle  = new TravelShuttle();
		
	    Passenger TravelSouthCustomer = new Passenger(South,shuttle);
		Passenger TravelNorthCustomer = new Passenger(North,shuttle);
		
				//ShuttleAuckland SAuckland = new ShuttleAuckland(TDirection);
		
				//Thread shuttleThread = new Thread(SAuckland,"Shuttle");
				//shuttleThread.start();
		int added = 0;				
		for (int i = 1; i <= MaxnumberPassengers; i++) {
			added++;
			Thread customerTravelSouth = new Thread(TravelSouthCustomer,"Customer AAA#"+i);
			//System.out.println("Threads size" + threads.size());
			threadsSouth.add(customerTravelSouth);
			customerTravelSouth.start();
			
		}
		System.out.println("Added threads: " + added);
		
		added = 0;	
		for (int i = 1; i <= MaxnumberPassengers; i++) {
			added++;
			Thread customerTravelNorth = new Thread(TravelNorthCustomer,"Customer BBB#"+i);
			//System.out.println("Threads size" + threads.size());
			threadsNorth.add(customerTravelNorth);
			customerTravelNorth.start();
			
		}
		System.out.println("Added threads: " + added);
		
		
		
		
		// Pasengers traveling North
		
		/*
		 * for (int j = 1; j <= MaxnumberPassengers; j++) { Thread customerTravelNorth =
		 * new Thread(TravelNorthCustomer,"Customer# "+j);
		 * //System.out.println("Threads size" + threads.size());
		 * threadsNorth.add(customerTravelNorth); customerTravelNorth.start();
		 * 
		 * }
		 */
		
		System.out.println("Closing threads");

		for (Thread thread : threadsSouth) {
			thread.interrupt();
			thread.join();
			System.out.println("Thread closed:" + thread.getName());
		}
		
		for (Thread thread : threadsNorth) {
			thread.interrupt();
			thread.join();
			System.out.println("Thread closed:" + thread.getName());
		}
		
		/*
		 * for (Thread thread : threadsNorth) { thread.interrupt(); thread.join(); }
		 */
				//shuttleThread.interrupt();
				//shuttleThread.join();
		
		System.out.println("Thank you for traveling with us");

	}

}
