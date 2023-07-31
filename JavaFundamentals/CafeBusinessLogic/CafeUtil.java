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

        System.out.println( String.format( "Hello, %s", username ) );

        System.out.println( String.format( "There are %d people in front of you", customers.size() ) );

        customers.add( username );

        System.out.println( customers );

    }

    public void printPriceChart( String product, double price, int maxQuantity ) {

        System.out.println( product );

        for ( int i = 0; i < maxQuantity; ++ i ) {

            System.out.println( String.format( "%d - $%.2f", i, (i + 1) * price - (0.5 * i) ) );

        }

    }

    public boolean displayMenu( ArrayList<String> menuItems, ArrayList<Double> prices ) {

        if ( menuItems.size() != prices.size() ) {

            return false;

        }

        for ( int index = 0; index < menuItems.size(); ++ index ) {

            System.out.println( String.format( "%d %s -- $%.2f", index, menuItems.get( index ), prices.get( index ) ) );

        }

        return true;

    }

}