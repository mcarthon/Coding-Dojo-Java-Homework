public class CafeJava {

    public static void main( String[] args ) {

        String generalGreeting = "Welcome to Cafe Java.";

        String pendingMessage = ", your order will be ready shortly";

        String readyMessage = ", your order is ready";

        String displayTotalMessage = "Your total is $";

        double mochaPrice = 3.5;

        String customer1 = "Cindhuri";

        boolean isReadyOrder1 = false;

        System.out.println( generalGreeting + customer1 );

        boolean drinkCoffee = false;

        boolean drinkLatte = false;

        boolean drinkCappuccino = false;

        String sam = "Sam";

        String jimmy = "Jimmy";

        String noah = "Noah";

        boolean cindhuriStatus = false;

        boolean samStatus = true;

        boolean jimmyStatus = true;

        boolean noahStatus = true;

        System.out.println( customer1 + pendingMessage );

        if ( noahStatus ) {

            System.out.println( noah + pendingMessage );

            System.out.println( displayTotalMessage + "4.99" );

            noahStatus = false;

        }

        if ( samStatus ) {

            System.out.println( sam + " - " + displayTotalMessage + "9.99" );

            samStatus = false;

        }        

        if ( jimmyStatus ) {

            System.out.println( jimmy + displayTotalMessage + "2.99" );

        }

    }

}