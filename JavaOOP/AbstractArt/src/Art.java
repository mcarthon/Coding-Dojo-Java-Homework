public abstract class Art {
	
	private String title;
	
	private String author;
	
	private String description;
	
	abstract void viewArt();
	
	String getTitle () {
		
		return this.title;
		
	}
	
	String getAuthor () {
		
		return this.author;
		
	}
	
	String getDescription () {
		
		return this.description;
		
	}
	
	Art setTitle ( String title ) {
		
		this.title = title;
		
		return this;
		
	}
	
	Art setAuthor ( String author ) {
		
		this.author = author;
		
		return this;
		
	}
	
	Art setDescription ( String description ) {
		
		this.description = description;
		
		return this;
		
	}

}