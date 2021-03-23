// Class create passenger threads that travels either to Auckland or to North Shore
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
			
		
			try {
				
				TryEnter = TravelShuttle.loadShuttle(travelDirection);
				
			} 
			catch (InterruptedException e1) 
			{
				break;
			}
				
		
			if(TryEnter == false) { // if the thread is completed it will be interupted and terminate
				
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
				
			}		
		}
		
				
	}
}
		


