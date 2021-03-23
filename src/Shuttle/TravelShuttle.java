// Class loads passengers and off loads passengers
package Shuttle;

import java.util.concurrent.Semaphore;

public class TravelShuttle {
	
	
	static Semaphore mutex; // provides mutual exclusion of critical area where  numerous variables are increased and decreased by threads
	static int MaxnumberPassengers;
	static int numberPassengers;
	static int passengersTransported;
	static int transportTrips;
	static Boolean travelingDirectionVariable;
	static Boolean travelingDirectionOld;
	static String Direction;


	public TravelShuttle() {
		
		mutex = new Semaphore(1,true);
		MaxnumberPassengers = 10;
		travelingDirectionVariable = true;
		passengersTransported = 0;
	}
	
	// Passenger threads enters and request the mutex to get permission into critical area
	public static boolean loadShuttle(Boolean travelDirection) throws InterruptedException {
		travelDirectionName(travelingDirectionVariable);
		mutex.acquireUninterruptibly();
		if(travelDirection == travelingDirectionVariable) { // thread going in same direction as shutlle will get get on else they wait for their turn 
			if(numberPassengers < MaxnumberPassengers) {
				passengersTransported++;
				numberPassengers++;
				System.out.println(Thread.currentThread().getName()+" Boarding shuttle to travel "+Direction+" with " + Integer.toString(numberPassengers) +" seats filled.");
			
				if(numberPassengers==MaxnumberPassengers) {
					System.out.println(numberPassengers+" Passengers are traveling to " + Direction + ", total transported: " + passengersTransported);
					ofloadPassengers();
				}
				
				mutex.release();
				return false;
			}
			
		}
		else 
		{
			mutex.release();
			return true;
		}
		mutex.release();
		return true;
	}
	
	
	public static void ofloadPassengers() {   // function off loads customers and changes direction of shuttle
		numberPassengers = 0;
		transportTrips++;

		travelingDirectionOld = travelingDirectionVariable;
		travelingDirectionVariable = !travelingDirectionVariable;
		
		System.out.println("Passengers exiting shuttle, trips completed: " + transportTrips);
		System.out.println(" ");
		System.out.println("Shuttle returning from " + getTravelDirectionName(travelingDirectionOld) + " now travelling to " + getTravelDirectionName(travelingDirectionVariable) + " -> seats occupied: " + numberPassengers);
		System.out.println("............................");		
		
		
	}
	// function gives a boolean direction a name
	public static void travelDirectionName(Boolean travelingDirectionVariable2travelingDirectionVariable) {
		if (travelingDirectionVariable == false) {
			 Direction = "North Shore";
		}else {
			Direction = "Auckland city";
		}
	}
	
	public static String getTravelDirectionName(Boolean dir) {
		if (dir == false) {
			 return "North Shore";
		}
		else {
			return  "Auckland city";
		}
	}	
}
