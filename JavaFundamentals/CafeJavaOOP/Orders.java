import java.util.ArrayList;

public class Orders {

    private String name;
    
    private double total;

    private boolean ready;

    private ArrayList<Items> items;

    Orders ( String name ) {

        this.name = name;

    }

    public Orders setName ( String orderName ) {

        this.name = orderName;

        return this;

    }

    public String getName () {

        return this.name;

    }

    public Orders setTotal () {

        for ( Items item: this.items ) {

            this.total += item.getPrice();

        }

        return this;

    }

    public double getTotal () {

        return this.total;

    }

    public Orders setReady ( boolean orderReady ) {

        this.ready = orderReady;

        return this;

    } 

    public boolean getReady () {

        return this.ready;

    }

    public Orders addItem ( Items item ) {

        items.add( item );

        return this;

    } 

    public Orders setItems ( ArrayList<Items> orderItems ) {

        this.items = orderItems;

        return this;

    }

    public ArrayList<Items> getItems () {

        return this.items;

    }

    public Orders display () {

        System.out.println( String.format( "Order Name: %s", this.name ) );

        for ( Items item: this.items ) {

            System.out.println( String.format( "Item Name: %s", item.getName() ) );

            System.out.println( String.format( "Item Price: $%.2f", item.getPrice() ) );

        }

        System.out.println( String.format( "Order Total: $%.2f", this.total ) );

        if ( this.ready ) {

            System.out.println( "Order Status: Ready" );

        }

        else {

            System.out.println( "Order Status: Not Ready" );

        }

        return this;

    }

}