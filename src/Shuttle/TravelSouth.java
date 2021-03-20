package Shuttle;

public class TravelSouth implements Runnable{
	
	

	private TravelDirection TravelDirection;

	public TravelSouth(TravelDirection T) {
		this.TravelDirection = T;
	}

	@Override
	public void run() {
		System.out.println("Customer are traveling south "+ Thread.currentThread().getName());
		TravelDirection.addPassengers();
		
	}

}
