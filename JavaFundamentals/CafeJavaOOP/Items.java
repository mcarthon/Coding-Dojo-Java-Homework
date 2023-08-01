public class Items {
 
    private String name;
    
    private double price;

    Items () {

    }

    Items ( String name ) {

        this.name = name;

    }

    Items ( double price ) {

        this.name = "Guest";

        this.price = price;

    }

    Items ( String name, double price ) {

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

}