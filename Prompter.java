import java.util.Scanner;

public class Prompter {
  
  private Jar jar;
  
  public Prompter (Jar jar) {
    this.jar = jar;
  }
  
  public void howToPlay() {
    System.out.printf("The objective of the game is to guess how many %s are in the jar.%n", jar.showItemName());
    System.out.printf("Start by guessing a number between 1 and %d.\n\n", jar.showMaxItem());
  }
  
 public boolean promptForGuess() {
   boolean isHit = false;
   boolean isAcceptable = false;
   int isAccurate = 0;
   Scanner scanner = new Scanner(System.in);
   
   do {
   System.out.printf("Enter your guess:  ");
   int guessInput = scanner.nextInt();
     
     try {
        isAccurate = jar.applyGuess(guessInput);
        isAcceptable = true;
     } catch(IllegalArgumentException iae) {
       System.out.printf("%s..   Please try again. \n", iae.getMessage());
     }
   } while (! isAcceptable);
    
   if (isAccurate == -1) {
     System.out.println("That guess was too low.");
   } else if (isAccurate == 0) {
     System.out.println("That's the right answer!");
   } else if (isAccurate == 1) {
     System.out.println("That guess was too high");
   }
   return isHit;
 }
  
 public void displayAttemptNumber() {
    System.out.printf("You got it in only %d guesses\n\n", jar.showNumberOfGuesses());
  }
}