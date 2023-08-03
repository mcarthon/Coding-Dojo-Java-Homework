import java.util.ArrayList;

import java.util.Random;

public class TestArt {

	public static void main ( String args[] ) {
		
		Painting painting1 = new Painting ( "Watercolor" );
		
		painting1.setTitle( "painting1" );
		
		painting1.setAuthor( "painting1 author" );
		
		painting1.setDescription( "painting1 description" );
		
		Painting painting2 = new Painting ( "Oil" );
		
		painting2.setTitle( "painting2" );
		
		painting2.setAuthor( "painting2 author" );
		
		painting2.setDescription( "painting2 description" );
		
		Painting painting3 = new Painting ( "Acryllic" );
		
		painting3.setTitle( "painting3" );
		
		painting3.setAuthor( "painting3 author" );
		
		painting3.setDescription( "painting3 description" );
		
		Sculpture sculpture1 = new Sculpture ( "Marble" );
		
		sculpture1.setTitle( "sculpture1" );
		
		sculpture1.setAuthor( "sculpture1 author" );
		
		sculpture1.setDescription( "sculpture1 description" );
		
		Sculpture sculpture2 = new Sculpture ( "Bronze" );
		
		sculpture2.setTitle( "sculpture2" );
		
		sculpture2.setAuthor( "sculpture2 author" );
		
		sculpture2.setDescription( "sculpture2 description" );
		
		ArrayList<Art> museum = new ArrayList<Art>();
		
		museum.add( painting1 );
		
		museum.add( painting2 );
		
		museum.add( painting3 );
		
		museum.add( sculpture1 );
		
		museum.add( sculpture2 );
		
		Random random = new Random();
		
		ArrayList<Art> museumCopy = new ArrayList<Art>( museum );
		
		for ( int index = 0; index < museumCopy.size(); ++ index ) {
			
			int randomIndex = random.nextInt( museumCopy.size() );
			
			Art temp = museumCopy.get( index );
			
			museumCopy.set( index, museumCopy.get( randomIndex ) );
			
			museumCopy.set( randomIndex , temp );
			
			museumCopy.get( index ).viewArt();
					
			museumCopy.remove( index );
			
			index --;
			
		}
		
	}
	
}