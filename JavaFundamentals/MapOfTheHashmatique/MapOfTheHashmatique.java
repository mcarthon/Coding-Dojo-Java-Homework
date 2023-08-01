import java.util.HashMap;

public class MapOfTheHashmatique {

    public static void main( String[] args ) {

    HashMap<String, String> songList = new HashMap<String, String>();

    for ( int count = 0; count < 4; ++ count ) {

        String trackNumber = String.format( "%d", ( count + 1 ) );

        songList.put( "track" + trackNumber, "lyrics to track" + trackNumber );   

        }
        
    System.out.println( songList );    
    
    System.out.println();

    System.out.println( songList.get( "track3" ) );

    }

}