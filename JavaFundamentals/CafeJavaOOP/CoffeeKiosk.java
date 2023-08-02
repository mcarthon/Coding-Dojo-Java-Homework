import java.util.ArrayList;

public class CoffeeKiosk {

    private ArrayList<Items> menu = new ArrayList<Items>();

    private ArrayList<Orders> orders = new ArrayList<Orders>();

    CoffeeKiosk () {};

    CoffeeKiosk addMenuItem ( Items item ) {

        menu.add( item );

        return this;

    }

    CoffeeKiosk addNewOrder () {

        Orders newOrder = new Orders();

        int numItems = Integer.parseInt( System.console().readLine( "How many items do you want for this order? " ) );

        if ( numItems > 0 ) {

            String name = System.console().readLine( "Please enter the name of the order: " );
    
            newOrder.setName( name );

            for ( int itemNumber = 0; itemNumber < numItems; ++ itemNumber ) {

                String itemName = System.console().readLine( "What is the name of item #%d? ", itemNumber + 1 );

                double itemPrice = Double.parseDouble( System.console().readLine( "What is the price of item #%d? ", itemNumber + 1 ) );

                Items item = new Items ( itemName, itemPrice );

                newOrder.addItem( item );

            }
    
            String ready = System.console().readLine( "Please enter the order status of the item you want to order.\nIf the order is ready, enter true.\nOtherwse, enter the number false: " );
    
            newOrder.setReady ( Boolean.parseBoolean ( ready.toLowerCase() ) );

            newOrder.setTotal();
    
            orders.add ( newOrder );

            for ( int index = 0; index < orders.size(); ++ index ) {

                orders.get( index ).display();

            }

        }


        return this;

    }

    // CoffeeKiosk addMenu

    CoffeeKiosk displayMenu () {

        for ( Items item: this.menu ) {

            System.out.printf ( "\n%d %s -- $%.2f\n\n", Items.getIndex(), item.getName(), item.getPrice() );

        }

        return this;

    }

}