import java.util.Random;
public class Jar {
  
  private String item;
  private int maxItem;
  private int answer;
  public boolean isHit = false;
  public int misses;
  public int hits;
  public int numberOfGuesses;
  public int isAccurate;
  
  public Jar(String item, int maxItem) {
    this.item = item;
    this.maxItem = maxItem;
  }
  
  public int generateAnswer() {
    Random random = new Random();
    answer = random.nextInt(maxItem - 1) + 1;
    this.answer = answer;
    return answer;
  }
  
  public int applyGuess(int number) {
    number = normalizeGuess(number);
    int isAccurate = 0;
    numberOfGuesses ++;
    if (number < answer) {
      return isAccurate = -1;
    } else if (number == answer) {
      hits = 1;
      return isAccurate = 0;
    } else if (number > answer) {
      return isAccurate = 1;
    }
    return isAccurate;
  }

  private int normalizeGuess(int number) {

    if (number > maxItem) {
      throw new IllegalArgumentException("Your guess was greater than the jar allowed.");
    }
    return number;
  }
  
  
  public boolean isWon() {
    boolean isHit = false;
    if (hits == 1) {
      isHit = true;
    }
    return isHit;
  }

  public int showNumberOfGuesses() {
    return numberOfGuesses;
  }
  public String showItemName() {
    return item;
  }
  public int showMaxItem() {
    return maxItem;
  }
}
