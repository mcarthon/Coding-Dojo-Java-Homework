import java.util.Random;

public class NumbersGame {

    public static void main(String[] args){

        System.out.println("Hello, human. I am thinking of a number between 0 and 10.");

        System.out.println("*********************************************************");

        System.out.println("Can you guess the number?");

        System.out.println("If you are not up to the task, you can always type 'q' to quit.");

        int tries = 0;

        while( tries < 3 ){

            tries += 1;

            int answer = new Random().nextInt( 10 );

            String guess = System.console().readLine( "Enter a guess: " );

            if( guess.equals( "q" ) ) {

                System.out.println("I knew you didn't have it in you.");

                System.out.println("Shutting down...");

                break;

            }

            if( guess.equals( String.valueOf( answer ) ) ) {

                String choice = System.console().readLine("Lucky guess! But can you do it again?");                

                if ( choice.toLowerCase().equals( "y" ) || choice.toLowerCase().equals( "yes" ) ) {

                    tries = 0;    

                }
                
                else if ( choice.toLowerCase().equals( "n" ) || choice.toLowerCase().equals( "no" ) ) {

                    break;

                }

                else {

                    System.out.println( "Invalid answer" );

                    break;

                }

            }

            else {

                System.out.println("Swing and a miss! Keep trying...");                    

            }

            try {

                if ( Integer.parseInt( guess ) < 0 || Integer.parseInt( guess ) > 10 ) {

                    System.out.println( "You must guess a number between 0 and 10" );

                }

            }

            catch ( Exception e ) {

                System.out.println( "You must guess a number between 0 and 10" );  

            }

            if ( tries == 3 ) {

                String playAgain = System.console().readLine( "Do you want to play again? " );

                if ( playAgain.equals( "y" ) || playAgain.equals( "yes" ) ) {

                    tries = 0;

                }

                else {

                    break;

                }

            }

        }

        System.out.println("Game over. Shutting down...");

    }

}

