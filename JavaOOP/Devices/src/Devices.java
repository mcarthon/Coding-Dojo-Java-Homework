public class Devices {
	
	private int batteryPercentage = 100;
	
	private boolean fullyCharged = true;
	
	int getBatteryLife () {
		
		return this.batteryPercentage;
		
	}
	
	Devices setBatteryLife ( int amount ) {
		
		this.batteryPercentage += amount;
		
		return this;
		
	}
	
	boolean getBatteryStatus () {
		
		return this.fullyCharged;
		
	}
	
	Devices displayBattery () {
		
		System.out.printf( "\nThe current battery percentage is: %d.\n\n", this.batteryPercentage );
		
		return this;
		
	}

}