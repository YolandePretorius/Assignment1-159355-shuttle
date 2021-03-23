package Shuttle;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;



public class TravelDirection {
	
	private static int numberCheckInPassengers;
	static int maxPasengersPerTrip =3;
	//OnBoardPassengers_ID[maxPasengersPerTrip];
	static ArrayList<String> OnBoardPassengers_Name = new ArrayList<String>();
	
	
	static Semaphore numberPassengersSemaphore;
	static Semaphore mutex;
	static Semaphore queue;
	static Semaphore boarding;
	static Semaphore riding;
	static Semaphore unloading;
	
	public TravelDirection() {
		
		//boolean fair = true;
		//numberPassengersSemaphore = new Semaphore(10,fair);
		mutex = new Semaphore(1);
		//queue = new Semaphore(3,fair);
		boarding = new Semaphore(0);
		riding = new Semaphore(0);
		unloading = new Semaphore(0);
	}
	
	public void TravelSouthCustomer() throws InterruptedException
	{
		//queue.acquire();
		mutex.acquireUninterruptibly();
		OnBoardPassengers_Name.add(Thread.currentThread().getName());
		numberCheckInPassengers ++;
		Thread.sleep(200);
		if(numberCheckInPassengers == maxPasengersPerTrip) {
			boarding.release();
			System.out.println("All aboard");
		}
		mutex.release();
		
	}
	
	public static void loadShuttle() throws InterruptedException {
		//for(int i = 1; i < maxPasengersPerTrip; i++) {
		//	queue.release();	
		//}
		
		boarding.acquireUninterruptibly();
				
		System.out.println("We have: "+numberCheckInPassengers + " passengers on the shuttle");
		System.out.println("passenger on board" + OnBoardPassengers_Name);
		System.out.println("Passengers getting off");
		
		numberCheckInPassengers = 0;
		OnBoardPassengers_Name.clear();
		System.out.println("We have: "+numberCheckInPassengers + " passengers on the shuttle");
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public void removePassengers() {
//		System.out.println("Semaphore size2 "+ numberPassengersSemaphore.availablePermits());
//		numberPassengersSemaphore.release();
//		synchronized(this) {
//			numberCheckInPassengers--;
//		}
//		System.out.println("Customer getting off in Auckland "+Thread.currentThread().getName()+" sits "+ numberCheckInPassengers);
//		numberPassengersSemaphore.release();
//		
//		
//	}
//	
//	public void allAboard() {
//		try {
//			numberPassengersSemaphore.acquire();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			addPassengers();
//		}finally {
//			removePassengers();
//		}
//	}
//
//	private void addPassengers() {
//		synchronized(this) {
//			numberCheckInPassengers++;
//		}
//		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			//e.printStackTrace();
//		}
//		
//	}

//	public void addPassengers() { // remove a seat if customer gets on ferry
//		//try {
//			//System.out.println("Semaphore size "+ numberPassengersSemaphore.availablePermits());
//			//numberPassengersSemaphore.acquire();
////			System.out.println("number seats left before"+Thread.currentThread().getName()+" enters " +numberPassengers);
////			System.out.println("Semaphore size "+ numberPassengersSemaphore.availablePermits());
//			synchronized(this) {
//			numberPassengersCount++;
//			}
//			System.out.println("Customer traveling south "+Thread.currentThread().getName()+" sits "+ numberPassengersCount);
//			
//			Thread.sleep(1000);
//		//} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			//e.printStackTrace();
//		
//		//}
//	}
	

}
