import java.util.ArrayList;

public class TestOrders {

    public static void main(String[] args) {
    
        // Menu items

        Items item1 = new Items();

        item1.setName( "item1" );

        item1.setPrice( 1.00 );

        Items item2 = new Items();

        item2.setName( "item2" );

        item2.setPrice( 2.00 );
    
        // Order variables -- order1, order2 etc.

        Orders order = new Orders( "Jeff Hardy" );        
    
        // Application Simulations

        ArrayList<Items> items = new ArrayList<>();

        items.add( item1 );

        items.add( item2 );

        order.setItems( items );        

        order.setReady( false );

        order.setTotal();

        // Use this example code to test various orders' updates

        order.display();

    }

}