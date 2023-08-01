import java.util.ArrayList;

import java.util.Random;

public class BankAccount {

    private double checkingAccountBalance = 0.0;

    private double savingsAccountBalance = 0.0;

    private static double totalAmount = 0;

    private static int numAccounts = 0;

    private String acccountNumber = "";

    private ArrayList<String> characters = new ArrayList<String>();

    private Random random = new Random();

    BankAccount ( double checkingAccountBalance, double savingsAccountBalance ) {

        this.checkingAccountBalance = checkingAccountBalance;

        this.savingsAccountBalance = savingsAccountBalance;

        totalAmount = this.checkingAccountBalance + this.savingsAccountBalance;

        ++ numAccounts;

        this.setCharacters();

        this.generateAccountNumber();

        this.display();

    }

    BankAccount depositChecking ( double amount ) {

        this.checkingAccountBalance += amount;

        totalAmount += amount;

        System.out.printf( "You deposited: $%.2f to checking", amount );

        this.display();

        return this;

    }

    BankAccount withdrawChecking ( double amount ) {

        if ( this.checkingAccountBalance >= amount ) {

            this.checkingAccountBalance -= amount;

            totalAmount -= amount;

            System.out.printf( "You withdrew: $%.2f from checking", amount );

        }

        else {

            System.out.printf( "You are trying to withdraw $%.2f from checking, but you only have $%.2f in your checking account.", 
            
                amount,
                
                this.checkingAccountBalance);

        }

        this.display();

        return this;

    }

    double getCheckingBalance (){

        this.display();

        return this.checkingAccountBalance;

    }

    BankAccount depositSavingsAccount ( double amount ) {

        this.savingsAccountBalance += amount;

        totalAmount += amount;

        System.out.printf( "You deposited $%.2f to savings", amount );

        this.display();

        return this;

    }

    BankAccount withdrawSavingsAccount ( double amount ) {

        if ( this.savingsAccountBalance >= amount ) {

            this.savingsAccountBalance -= amount;

            totalAmount -= amount;

            System.out.printf( "You withdrew $%.2f from savings", amount );

        }

        else {

            System.out.printf( "You are trying to withdraw $%.2f, but you only have $%.2f in your checking account.", 
            
                    amount,
                    
                    this.savingsAccountBalance );

        }

        this.display();

        return this;

    }
    
    double getSavingsBalance () {

        this.display();

        return this.savingsAccountBalance;

    }

    static double getTotalAmount () {        

        return totalAmount;

    }

    static int getNumAccounts () {

        return numAccounts;

    }

    void display () {

        System.out.printf( "\nAccount Number: %s\n", this.acccountNumber );

        System.out.printf( "\nChecking account balance: $%.2f\n", this.checkingAccountBalance );

        System.out.printf( "\nSavings account balance: $%.2f\n", this.savingsAccountBalance );        

        System.out.printf( "\nTotal Amount: $%.2f\n", totalAmount );

        System.out.printf( "\nNumber of Accounts: %d\n\n", numAccounts );

    }

    BankAccount setCharacters () {

        for ( char letter = 'A'; letter <= 'Z'; ++ letter ) {

            this.characters.add( String.valueOf( letter ) );

        }

        for ( int number = 0; number < 10; ++ number ) {

            this.characters.add( String.valueOf( number ) );

        }

        return this;

    }

    BankAccount generateAccountNumber () {

        for ( int characterCount = 0; characterCount < 10; ++ characterCount ) {

            String randomCharacter = this.characters.get( this.random.nextInt( this.characters.size() ) );                

            this.acccountNumber += randomCharacter;

        }

        return this;

    }

}