import java.util.Date;

public class AlfredQuotes {
    
    public String basicGreeting() {

        return "Hello, lovely to see you. How are you?";

    }
    
    public String guestGreeting(String name) {

        return "Hello " + name ;

    }
    
    public String dateAnnouncement() {

        java.util.Date date = new java.util.Date();

        return "Today's date is " + date;

    }
    
    public String respondBeforeAlexis(String conversation) {
        
        return conversation;

    }

    public String guestGreeting( String name, String greeting ) {

        return String.format( "%s %s, how ya goin?", greeting, name );

    }

    public String concatStrings( String string1, String string2 ) {

        String newString = string1.concat( string2 );

        return String.format( "The first string is %s, second string is %s, and the combined string is %s with a length of %d",
        
                                string1,
                                string2,
                                string1.concat( string2 ),
                                string1.concat( string2 ).length()                                

         );

    }
    
	// NINJA BONUS
	// See the specs to overload the guestGreeting method
        // SENSEI BONUS
        // Write your own AlfredQuote method using any of the String methods you have learned!

}

