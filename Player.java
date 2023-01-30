// Anit Annadi & Taksh Pendap

import java.util.Scanner;

public class Player {
  private String name;

  public Player(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int move(int pileSize) {
    Scanner input = new Scanner(System.in);
    System.out.println(name + ", how many pieces would you like to remove from the pile?");
    int numPieces = input.nextInt();
    if (numPieces < 1) {
      System.out.println("Invalid move. Please enter a number greater than 0.");
      return move(pileSize);
    }
    return numPieces;
  }
}

