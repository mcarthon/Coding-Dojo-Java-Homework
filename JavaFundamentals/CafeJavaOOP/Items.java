public class Items {

    private static int index = -1;
 
    private String name;
    
    private double price;

    Items () {

        index ++;

    }

    Items ( String name ) {

        index ++;

        this.name = name;

    }

    Items ( double price ) {

        index ++;

        this.name = "Guest";

        this.price = price;

    }

    Items ( String name, double price ) {

        index ++;

        this.name = name;

        this.price = price;

    }

    public Items setName ( String itemName ) {

        this.name = itemName;

        return this;

    }

    public String getName () {

        return this.name;

    }

    public Items setPrice ( double itemPrice ) {

        this.price = itemPrice;

        return this;

    }

    public double getPrice () {

        return this.price;

    }

    static int getIndex () {

        return index;

    }

}