import java.util.ArrayList;

import java.util.Random;

public class PuzzleJava {    

    public ArrayList<Integer> getTenRolls( int maxValue ) {

        Random random = new Random();

        ArrayList<Integer> rolls = new ArrayList<>();

        for ( int numRoll = 0; numRoll < 10; ++ numRoll ) {

            rolls.add( random.nextInt( maxValue + 1 ) );

        }

        return rolls;

    }

    public String getRandomLetter() {

        ArrayList<String> letters = new ArrayList<>();

        Random random = new Random();

        for ( char letter = 'A'; letter <= 'Z'; ++ letter ) {

            letters.add( "" + letter );

        } 

        return letters.get( random.nextInt( letters.size() ) );

    }

    public String generatePassword() {

        String password = "";

        for ( int index = 0; index < 8; ++ index ) {

            password += getRandomLetter();

        }

        return password;

    }

    public ArrayList<String> getNewPasswordSet( int length ) {

        ArrayList<String> passwordSet = new ArrayList<>();

        for ( int index  = 0; index < length; ++ index ) {

            passwordSet.add( generatePassword() );

        }

        return passwordSet;

    }

    public ArrayList<String> shuffleArray( int numShuffles, ArrayList<String> passwordSet ) {

        // ArrayList<String> passwordSet = getNewPasswordSet( 8 );

        Random random = new Random();

        for ( int count = 0; count < numShuffles; ++ count ) {

            int rand1 = random.nextInt( passwordSet.size() );

            int rand2 = random.nextInt( passwordSet.size() );

            String temp = passwordSet.get( rand1 );

            passwordSet.set( rand1,  passwordSet.get( rand2 ) ) ;

            passwordSet.set( rand2, temp );

        }

        return passwordSet;

    }

}