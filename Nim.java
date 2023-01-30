// Anit Annadi & Taksh Pendap

import java.util.Scanner;
import java.util.Random;

public class Nim {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Random random = new Random();

    boolean playAgain = true;
    while (playAgain) {
      System.out.println("Do you want to play against AI or with other players (AI/Multiplayer)?");
      String gameMode = input.nextLine();
  
      int numPlayers;
      
      // AI option or multiplayer option
      
      if (gameMode.equalsIgnoreCase("AI")) {
        numPlayers = 2;
      } else if (gameMode.equalsIgnoreCase("Multiplayer")) {
        System.out.println("How many players will be playing?");
        numPlayers = input.nextInt();
        input.nextLine();
      } else {
        System.out.println("Invalid input, please enter either 'AI' or 'Multiplayer'");
        return;
      }
  
      Player[] players = new Player[numPlayers];
      for (int i = 0; i < numPlayers; i++) {
        System.out.println("Enter player " + (i + 1) + "'s name:");
        String name = input.nextLine();
        if (i == 0 && gameMode.equalsIgnoreCase("AI")) {
          players[i] = new AIPlayer(name);
        } else {
          players[i] = new Player(name);
        }
      }
      
      // random pile size
  
      int pileSize = random.nextInt(100) + 1;
      GameBoard gameBoard = new GameBoard(pileSize);
      int currentPlayer = 0;
  
      while (gameBoard.getPileSize() > 0) {
        System.out.println("Pile size: " + gameBoard.getPileSize());
        int numPieces = players[currentPlayer].move(gameBoard.getPileSize());
        while ((gameBoard.getPileSize() > 3 && numPieces > gameBoard.getPileSize() / 2) || numPieces < 1) {
          System.out.println("Invalid move. Please remove anywhere from 1 piece to at most half of the pile.");
          numPieces = players[currentPlayer].move(gameBoard.getPileSize());
        }
        gameBoard.removePieces(numPieces);
        currentPlayer = (currentPlayer + 1) % numPlayers;
      }
  
      System.out.println(gameBoard.toString());
      System.out.println(players[(currentPlayer + numPlayers - 1) % numPlayers].getName() + " wins!");
  
      System.out.println("Do you want to play again? (yes/no)");
      String playAgainResponse = input.nextLine();
      
      // play again option
      
      playAgain = playAgainResponse.equalsIgnoreCase("yes");
    }
  }
}






