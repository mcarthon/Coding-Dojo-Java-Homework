public class Bat extends Mammal {

	Bat () {
		
		super();
		
		this.setEnergyLevel( 300 );
		
	}
	
	Bat fly() {
		
		if ( this.getEnergyLevel() >= 50 ) {
			
			this.setEnergyLevel( -50 );
			
			System.out.println( "\nThe bat is flying\n" );
			
			this.display();
			
			return this;
			
		}
		
		System.out.println( "\nThe bat needs at least 50 energy level to fly.\n" );
		
		this.display();
		
		return this;
		
	}
	
	Bat eatHuman () {
		
		this.setEnergyLevel( 25 );
		
		System.out.println( "\nThe bat just ate some humans.\n" );
		
		this.display();
		
		return this;
		
	}
	
	Bat attackTown () {
		
		if ( this.getEnergyLevel() >= 100 ) {
			
			this.setEnergyLevel( -100 );
			
			System.out.println( "\nThe bat has just attacked the town!\n" );
			
			this.display();
			
			return this;
			
		}
		
		System.out.println( "\nThe bat does not have energy to attack a town.\n" );
		
		this.display();
		
		return this;
		
	}
	
	Bat display () {
		
		System.out.printf( "\nThe bat's energy level is %d.\n\n", this.getEnergyLevel() );
		
		return this;
		
	}
	
}