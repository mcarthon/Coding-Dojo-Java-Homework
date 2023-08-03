public class Painting extends Art {

	private String paintType;
	
	Painting ( String paintType ) {
		
		super();
		
		this.paintType = paintType;
		
	}
	
	void viewArt () {
		
		System.out.printf( "\n%s\n%s\n%s\n%s\n\n", this.getTitle(), this.getAuthor(), this.getDescription(), this.getPaintType() );
		
	}

	String getPaintType () {
		
		return this.paintType;
		
	}
	
	Painting setPaintType ( String paintType ) {
		
		this.paintType = paintType;
		
		return this;
		
	}
	
}