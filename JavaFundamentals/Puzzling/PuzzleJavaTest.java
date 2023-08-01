import java.util.ArrayList;

public class PuzzleJavaTest {
    
	public static void main(String[] args) {

		PuzzleJava generator = new PuzzleJava();

		ArrayList<Integer> randomRolls = generator.getTenRolls( 20 );

		System.out.println(randomRolls);

        ArrayList<String> passwordSet = generator.getNewPasswordSet( 5 );
		
        System.out.println( passwordSet );

        ArrayList<String> randomPasswordSet = generator.shuffleArray( 4, passwordSet );

        System.out.println( randomPasswordSet );

	}
}
