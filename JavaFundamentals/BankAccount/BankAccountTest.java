public class BankAccountTest {
    
    public static void main ( String[] args ) {

        BankAccount Tom = new BankAccount( 2456.78, 5.89);

        Tom.depositChecking( 400.00 );

        Tom.depositSavingsAccount( 300.00 );

        Tom.withdrawChecking( Tom.getCheckingBalance() + 100 );

        Tom.withdrawSavingsAccount( Tom.getSavingsBalance() + 100 );

        Tom.withdrawChecking( 78.5654 );

        Tom.withdrawSavingsAccount( 43.12978 );

        BankAccount notTom = new BankAccount(444.444, 44.222);

    }

}
