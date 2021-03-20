package Shuttle;

public class TravelDirection {
	
	int maxPasengersPerTrip;

	public TravelDirection(int maxnumberPassengers) {
		this.maxPasengersPerTrip = maxnumberPassengers; 
	}

	public void addPassengers() { // remove a seat if customer gets on ferry
		
		System.out.println("number seats left before"+Thread.currentThread().getName()+" enters " +maxPasengersPerTrip);
		maxPasengersPerTrip--;
		System.out.println("number seats left after "+Thread.currentThread().getName()+" sits "+ maxPasengersPerTrip);
		
	}
	
	

}
