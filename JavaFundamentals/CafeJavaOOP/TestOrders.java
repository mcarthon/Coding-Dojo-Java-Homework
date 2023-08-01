import java.util.ArrayList;

public class TestOrders {

    public static void main(String[] args) {
    
        // Menu items

        Items item1 = new Items();

        item1.name = "item1";

        item1.price = 1.00;

        Items item2 = new Items();

        item2.name = "item2";

        item2.price = 2.00;
    
        // Order variables -- order1, order2 etc.

        Orders order = new Orders();        
    
        // Application Simulations

        ArrayList<Items> items = new ArrayList<>();

        items.add( item1 );

        items.add( item2 );

        order.items = items;

        order.name = "Jeff Hardy";

        order.ready = false;

        order.total = item1.price + item2.price;

        // Use this example code to test various orders' updates

        System.out.printf("Name: %s\n", order.name);

        System.out.printf("Total: $%.2f\n", order.total);

        System.out.printf("Ready: %s\n", order.ready);

    }

}