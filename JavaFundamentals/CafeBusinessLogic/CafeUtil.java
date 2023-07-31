import java.util.ArrayList;

public class CafeUtil {

    public int getStreakGoal( int numWeeks ) {

        int sum = 0;

        for ( int number = 1; number <= numWeeks; ++ number ) {

            sum += number;

        }

        return sum;

    }

    public double getOrderTotal( double[] prices ) {

        double total = 0.0;

        for ( int index = 0; index < prices.length; ++ index ) {

            total += prices[ index ];

        }

        return total;

    }

    public void displayMenu( ArrayList<String> menuList ) {

        System.out.println( menuList );

    }

    public void addCustomer( ArrayList<String> customers ) {

        String username = System.console().readLine( "Please enter your username:" );

        String.format( "Hello, %s", username );

        String.format( "There are %d people in front of you", customers.size() );

        customers.add( username );

        System.out.println( customers );

    }

}