package labb2ps;

import java.util.Scanner;

/**
 *
 * @author supermannen1
 */
public class UI {
    
    Scanner scan = new Scanner(System.in);
    PSLogic game = new PSLogic();
    
    public static void main(String[] args){
        UI ui = new UI();
        ui.runGame();
    }
    
    public void runGame(){
        String playAgain;
        
        boolean GameIsRunning = true;
        while(GameIsRunning){
        
            System.out.println("PokerPatient.");
            System.out.println("Choose a pile (1-5) in which you want to place the card.");
            System.out.println("Each pile can maximum hold (5) cards.");
            System.out.println("After (25) placed cards your score will be calculated.");

            while(!game.isGameOver()){
                System.out.println("Current status:" + game.getPiles());
                System.out.println("Nr Of Placed Cards:" + game.getCardCount());
                System.out.println("Your next card:" + game.pickNextCard().toShortString());
                System.out.println("In which pile?");
                game.addCardToPile(scan.nextInt()-1);
                System.out.println("\n\n\n\n\n\n");

            }

            System.out.println("End game.\n" + game.getPiles());
            System.out.println("Your score:" + game.getPoints());
            System.out.println("\n");
            System.out.println("Do you want to play again?:");
            
            playAgain = scan.next();
            if(playAgain.toUpperCase().equals("YES")){
                GameIsRunning = true;
                game.initNewGame();
                System.out.println("\n\n\n\n\n\n");
            }else{
                GameIsRunning = false;
            }
        }
    }
    
}
