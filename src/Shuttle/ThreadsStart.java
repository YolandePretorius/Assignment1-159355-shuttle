package Shuttle;

import java.util.ArrayList;

public class ThreadsStart {
	
	static int MaxnumberPassengers=50;

	public static void main(String[] args) throws InterruptedException {
		
		ArrayList<Thread> threads = new ArrayList<Thread>();
		
		System.out.println("******************  Welcome to our transport services  ******************");
		
		TravelDirection TDirection  = new TravelDirection();
		
		TravelSouth TSouth = new TravelSouth(TDirection);
		
		for (int i = 1; i <= MaxnumberPassengers; i++) {
			Thread customerTravelSouth = new Thread(TSouth,"Customer# "+i);
			//System.out.println("Threads size" + threads.size());
			threads.add(customerTravelSouth);
			customerTravelSouth.start();
			
		}
		for (Thread thread : threads) {
			thread.interrupt();
			thread.join();
		}
		
		
		System.out.println("Thank you for traveling with us");

	}

}
