// Anit Annadi & Taksh Pendap

import java.util.Scanner;

public class AIPlayer extends Player {
  public AIPlayer(String name) {
    super(name);
  }

  @Override
  public int move(int pileSize) {
    int numPieces = (int) (Math.random() * (pileSize / 2)) + 1;
    System.out.println(this.getName() + " removed " + numPieces + " pieces from the pile.");
    return numPieces;
  }
}
