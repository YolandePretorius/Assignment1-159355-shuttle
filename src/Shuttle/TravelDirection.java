package Shuttle;

import java.util.concurrent.Semaphore;

public class TravelDirection {
	
	int maxPasengersPerTrip =3;
	static Semaphore numberPassengersSemaphore;
	static Semaphore mutex;
	private int numberPassengersCount;
	
	public TravelDirection() {
		
		boolean fair = true;
		numberPassengersSemaphore = new Semaphore(10,fair);
		
	}
	
	public void removePassengers() {
		System.out.println("Semaphore size2 "+ numberPassengersSemaphore.availablePermits());
		numberPassengersSemaphore.release();
		synchronized(this) {
		numberPassengersCount--;
		}
		System.out.println("Customer getting off in Auckland "+Thread.currentThread().getName()+" sits "+ numberPassengersCount);
		numberPassengersSemaphore.release();
		
		
	}
	
	public void allAboard() {
		try {
			numberPassengersSemaphore.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
		addPassengers();
		}finally {
			removePassengers();
		}
	}

	private void addPassengers() {
		synchronized(this) {
			numberPassengersCount++;
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
	}

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
