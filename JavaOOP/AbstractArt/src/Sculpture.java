public class Sculpture extends Art {

	private String material;
	
	Sculpture ( String material ) {
		
		super();
		
		this.material = material;
		
	}
	
	void viewArt () {
		
		System.out.printf( "\n%s\n%s\n%s\n%s\n\n", this.getTitle(), this.getAuthor(), this.getDescription(), this.getMaterial() );
		
	}
	
	String getMaterial () {
		
		return this.material;
		
	}
	
	Sculpture setMaterial ( String material ) {
		
		this.material = material;
		
		return this;
		
	}
	
}