public class Mammal {

	private int energyLevel = 100;
	
	int getEnergyLevel () {
		
		return this.energyLevel;
		
	}
	
	Mammal setEnergyLevel ( int amount ) {
		
		this.energyLevel += amount;
		
		return this;
		
	}
	
	int displayEnergy () {
		
		System.out.printf( "Current energy level: %d", this.energyLevel );
		
		return this.energyLevel;
		
	}
	
}