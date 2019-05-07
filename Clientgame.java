//package Client;

import java.util.Scanner;
/**
 *
 * @author Rahothan
 */
public class Clientgame {
    
	private static String[] words = {"yourname", "totoro", "pokemon", "doraemon", "avenger", "alita", "venom", "titanic", "avatar", "ted", "batman", 
	"aquaman", "it", "twilight", "shazam", "thor", "maleficent", "cinderella", "alien", "enchanted", "jumanji", "godzilla", "transformer", "rampage",
	"antman" , "deadpool", "bumblebee"};
	private static String word = words[(int) (Math.random() * words.length)];
	private static String asterisk = new String(new char[word.length()]).replace("\0", "*");
	private static int count = 0;
	private static int score = 0;
	private static int turn = 0;
	public static void hangman() 
	{
		System.out.print("Do you want to play Hangman?(y/n): ");
		Scanner sc = new Scanner(System.in);
		Scanner se = new Scanner(System.in);
		String p = se.nextLine();
		if(p.equals("n")){
			System.out.println("Bye Bye Hangman !!!");
			System.exit(0);
		}

		while (p.equals("y"))
		{	turn++;
			word = words[(int) (Math.random() * words.length)];
			asterisk = new String(new char[word.length()]).replace("\0", "*");
			count = 0;
			while (count < 7 ) 
			{
				System.out.println("Guess any letter in the word");
				System.out.println(asterisk);
				String guess = sc.next();
				hang(guess);
			}
			//sc.close();
			System.out.print("Do you want to play Hangman?(y/n): ");
			p = se.nextLine();
			if(p.equals("n")){
				System.out.println("Your score is "+score+"/"+turn);
				System.out.println("Bye Bye Hangman !!!");
				System.exit(0);
			}

		}
	}

	public static void hang(String guess) {
		String newasterisk = "";
		
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == guess.charAt(0)) {
				newasterisk += guess.charAt(0);
			} else if (asterisk.charAt(i) != '*') {
				newasterisk += word.charAt(i);
			} else {
				newasterisk += "*";
			}
		}

		if (asterisk.equals(newasterisk)) {
			count++;
			hangmanImage();
		} else {
			asterisk = newasterisk;
			
		}
		if (asterisk.equals(word)) {
			System.out.println("Correct! You win! The word was " + word);
			score++;
			count = 7;
		}
	}

	public static void hangmanImage() {
		if (count == 1) {
			System.out.println("Wrong guess, try again");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("___|___");
			System.out.println();
		}
		if (count == 2) {
			System.out.println("Wrong guess, try again");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 3) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   | ");
			System.out.println("___|___");
		}
		if (count == 4) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 5) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 6) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
		}
		if (count == 7) {
			System.out.println("GAME OVER!");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |          _|_");
			System.out.println("   |         / | \\");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
			System.out.println("GAME OVER! The word was " + word);
		}
	}
}

