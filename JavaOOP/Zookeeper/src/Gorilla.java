public class Gorilla extends Mammal {

	Gorilla () {
		
		super();
		
	};
	
	Gorilla throwSomething () {
		
		if ( this.getEnergyLevel() >= 5 ) {
			
			this.setEnergyLevel( -5 );
			
			System.out.println( "\nThe gorilla has thrown something.\n" );
			
			this.display();
			
			return this;
			
		}
		
		System.out.println( "\nThe gorilla can not throw an object unless its energy level is greater than 5.\nEating a banana will give the gorilla more energy.\n" );
		
		this.display();
		
		return this;
				
	}
	
	Gorilla eatBanana () {
		
		this.setEnergyLevel( 10 );
		
		System.out.println( "\nThe gorilla has just eaten a banana.\n" );
		
		this.display();
		
		return this;
		
	}
	
	Gorilla climb () {
		
		if ( this.getEnergyLevel() >= 10 ) {
			
			this.setEnergyLevel( -10 );
			
			System.out.println( "\nThe gorilla has just climbed a tree.\n" );
			
			this.display();
			
			return this;
			
		}
		
		System.out.printf( "\nThe gorilla needs at least 10 energy to climb.\n" );
		
		this.display();
		
		return this;
		
	}
	
	Gorilla display () {
		
		System.out.printf( "\nThe gorilla's current energy level is %d.\n\n", this.getEnergyLevel() );
		
		return this;
		
	}
	
}