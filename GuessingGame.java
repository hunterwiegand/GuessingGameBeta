import java.util.Scanner;

public class GuessingGame {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("ADMINISTRATIVE SETTINGS\n-----------------------");
    System.out.printf("Type of items in jar:  ");
    String item = scanner.nextLine();
    System.out.printf("Maximum number of %s in the jar: ",
                      item);
    int maxItem = scanner.nextInt();
    
    System.out.println("\nPLAYER\n-------");
    
    Jar jar = new Jar(item, maxItem);
    Prompter prompter = new Prompter(jar);
    
    prompter.howToPlay();
    jar.generateAnswer();

    while (!jar.isWon()) {
    prompter.promptForGuess(); 
    }
    prompter.displayAttemptNumber();
    }
}
