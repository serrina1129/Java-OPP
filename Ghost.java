package Ghost;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ghost {

	public static void main(String[] args) throws IOException {
		//read file words into array called dict
		String[] dict = new String [279496];	
		File words = new File("/Users/serrinabrown/Desktop/words.txt");
		Scanner in = new Scanner(words);
		for(int i = 0; i < dict.length; i++)
			dict[i] = in.nextLine();
		//All user input will be held in variable answer
 		Scanner answer = new Scanner(System.in);
 		//Gets player count
 		System.out.println("Enter the number of players: ");
		int players = answer.nextInt();
		//the total string of letters 
		String phrase = "";
		// the letter input by a player during their turn
		String letter = "";
		//condition to allow players to take turns till game is over
		boolean gameOver = false;
		while(!gameOver) {
			//allows players to take turns until someone loses
			for(int i = 1; i <= players; i++) {
				System.out.println("Player " + i + ", it's your turn. The letters are " + phrase + ". Enter a letter or enter * to challenge.");
				letter = answer.next();
				//challenges
				if(letter.equals("*")) {
					for(int s = 0; s < dict.length; s++) {
						int wordLen = dict[s].length();
						// checks the dictionary for words 4 or more letters that are 1 letter longer than the phrase and starts with the same letters as the phrase
						if((wordLen > 3 && wordLen == phrase.length()+1) && (dict[s].substring(0, wordLen-1).equals(phrase))) {
							System.out.println( dict[s] + " begins with those letters. Player " + i + " loses!");
							System.exit(0);
						}	
					}
					//makes it so if the first player wins the challenge it would print that the last player loses.
					if(i==1) i = players+1;
					System.out.println("No word begins with those letters. Player " + (i-1) + " loses!");
					System.exit(0);
				}
				phrase += letter;
				//if the current player creates a word they lose
				for(int s = 0; s < dict.length; s++) {
					//checks words 4 letters or longer
					if(dict[s].length() > 3 && (phrase).equals(dict[s])) {
						System.out.println(phrase + " is a word. Player " + i + " loses!");
						System.exit(0);
					}
				}
			}
		}
	}

}
