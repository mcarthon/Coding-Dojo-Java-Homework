import java.util.ArrayList;

class ListsOfExceptions {

    public static void main( String[] args ) {

        ArrayList<Object> myList = new ArrayList<Object>();

        myList.add( "Hello World" );

        myList.add( 1234.345 );

        myList.add( true );

        for ( int index = 0; index < myList.size(); ++ index ) {

            try {

                Integer castedValue = ( Integer ) myList.get( index );

            }

            catch ( ClassCastException error ) {

                System.out.println( String.format( "\nindex: %d", index ) );

                System.out.println( error );

                System.out.println( String.format( "Invalid value: %s\n", myList.get( index ) ) );

            }

        }

    }

}