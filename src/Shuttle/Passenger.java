package Shuttle;

public class Passenger implements Runnable{
	private TravelShuttle ShuttleTravel;
	private Boolean travelDirection;
	private Boolean TryEnter = true;
	
	public Passenger(Boolean Tdirection, TravelShuttle shuttle) {
		this.travelDirection = Tdirection;
		this.ShuttleTravel = shuttle;
	}

	@Override
	public void run() {
		
		while(true) {
		//System.out.println("Passenger " + Thread.currentThread().getName()+ " is traveling "+ travelDirection);		
		
			try {
				
				TryEnter = TravelShuttle.loadShuttle(travelDirection);
				
			} 
			catch (InterruptedException e1) 
			{
				//System.out.println(Thread.currentThread().getName()+" loadShuttle exception.");
				break;
			}
				
		
			if(TryEnter == false) {
				//System.out.println(Thread.currentThread().getName()+" has boarded the bus!");
				//Thread.currentThread().join();
				//valid = false;
				break;
			}
			else
			{
				System.out.println(Thread.currentThread().getName()+" waiting for another bus.");
			}
		
			try {
				Thread.sleep(2000);
			} 
			catch (InterruptedException e) {
				//System.out.println(Thread.currentThread().getName()+" sleep exception.");
			}		
	
		}
		
		System.out.println("...........Passenger " + Thread.currentThread().getName()+ " is done traveling");		
	}
}
		


