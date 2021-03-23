package Shuttle;

import java.util.concurrent.Semaphore;

public class TravelShuttle {
	
	static Semaphore passengersSem;
	static Semaphore mutex;
	static int MaxnumberPassengers;
	static int numberPassengers;
	static int passengersTransported;
	static int transportTrips;
	static Boolean travelingDirectionVariable;
	static Boolean travelingDirectionOld;
	static String Direction;


	public TravelShuttle() {
		passengersSem =  new Semaphore(3,true);
		mutex = new Semaphore(1,true);
		MaxnumberPassengers = 10;
		travelingDirectionVariable = true;
		passengersTransported = 0;
	}

	public static boolean loadShuttle(Boolean travelDirection) throws InterruptedException {
		//passengersSem.acquireUninterruptibly();
		travelDirectionName(travelingDirectionVariable);
		mutex.acquireUninterruptibly();
		if(travelDirection == travelingDirectionVariable) {
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
			//else
			//{
				//System.out.println(numberPassengers+" seats occupied, traveling to " + Direction + ", total transported: " + passengersTransported);
			//}
		}
		else 
		{
			mutex.release();
			return true;
		}
		mutex.release();
		return true;
	}
	
	
	public static void ofloadPassengers() {
		numberPassengers = 0;
		transportTrips++;
		//travelingDirectionVariableNew = !(travelingDirectionVariable);
		travelingDirectionOld = travelingDirectionVariable;
		travelingDirectionVariable = !travelingDirectionVariable;
		
		System.out.println("Passengers exiting shuttle, trips complted: " + transportTrips);
		System.out.println("Shuttle returning from " + getTravelDirectionName(travelingDirectionOld) + " now travelling to " + getTravelDirectionName(travelingDirectionVariable) + " -> seats occupied: " + numberPassengers);
		System.out.println("............................");		
		
		//mutex.release();
	}
	
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
