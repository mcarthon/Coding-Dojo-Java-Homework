public class Phone extends Devices {

	private String name = "";
	
	Phone ( String name ) {
		
		super();
		
		this.name = name;
		
	}
	
	String getName () {
		
		return this.name;
		
	}
	
	Phone setName ( String newName ) {
		
		this.name = newName;
		
		return this;
		
	}
	
	Phone makePhoneCall () {
		
		this.deadBattery();
				
		this.setBatteryLife( -5 );
		
		this.batteryCritical();
		
		System.out.printf( "\nYou have made a phone call. The %s's current battery level is %d%%.\n\n", this.name, this.getBatteryLife() );
		
		return this;
		
	}
	
	Phone playGame ( String gameName ) {
		
		this.deadBattery();
		
		if ( this.getBatteryLife() < 25 ) {
			
			System.out.printf( "You can not play a game when your battery level is below 25%!" );
			
			return this;
			
		}
		
		this.setBatteryLife( -20 );
		
		this.batteryCritical();
		
		System.out.printf( "\nYou just played %s. The %s's current battery level is %d%%.\n\n", gameName, this.name, this.getBatteryLife() );
		
		return this;
		
	}	
	
	Phone chargePhone () {
		
		if ( this.getBatteryLife() + 50 > 100 ) {
			
			this.setBatteryLife( 100 - this.getBatteryLife() );
			
		}
		
		else {
			
			this.setBatteryLife( 50 );
			
		}
		
		System.out.printf( "\nYou have just charged your %s. Your current battery life is %d%%.\n\n", this.name, this.getBatteryLife() );
		
		return this;
		
	}
	
	Phone batteryCritical () {
		
		if ( this.getBatteryLife() < 10 ) {
			
			System.out.printf( "Your battery has fallen below 10% and needs to be charged immediately!" );
			
		}
		
		return this;
		
	}
	
	Phone deadBattery () {
		
		if (this.getBatteryLife() < 1 ) {
			
			System.out.printf( "You can not do anything with this phone because your phone has no more battery life." );
			
		}
		
		return this;
		
	}
	
}