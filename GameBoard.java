// Anit Annadi & Taksh Pendap

public class GameBoard {
  private int pileSize;

  public GameBoard(int pileSize) {
    this.pileSize = pileSize;
  }

  public int getPileSize() {
    return pileSize;
  }

  public void removePieces(int numPieces) {
    pileSize -= numPieces;
  }

  public String toString() {
    return "There are " + pileSize + " pieces left in the pile.";
  }
}
