/** Author: Joab Berhane **/

package coe318.lab5;

import java.util.Scanner;

public class SimpleUI implements UserInterface {
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);

  @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
    }

  @Override
    public void display() {
        System.out.println("House Holds: " + (game.getHouseCards().getCards()));
        System.out.println("You Holds: " + (game.getYourCards().getCards()));
    }

  @Override
    public boolean hitMe() {
       int totalScore = game.score(game.getYourCards());
       
       if (totalScore >= 21)
       {
        return false;
       }
       
       System.out.println("Would you like another card?(y or n)");
        String input = user.nextLine();
        if (input.equalsIgnoreCase("n")){
            return false;
        }else if (input.equalsIgnoreCase("y")){
            return true;
        }else{
            System.out.println("Invalid response please try again!");
            gameOver();
            return false;
            
        }
    }

  @Override
    public void gameOver() {
          
        int yourCards = game.score(game.getYourCards());
        int dealerCards = game.score(game.getHouseCards());
        display();
        System.out.println("Your Score: ");
        System.out.println (yourCards);
        System.out.println("House Score: ");
        System.out.println (dealerCards);
        if (21 < yourCards || yourCards == dealerCards){
            System.out.println("You Lose!");
        }else if (21 >= yourCards && ((yourCards > dealerCards) || (dealerCards > 21))){
            System.out.println("You Win");
        }else{
            System.out.println("House Wins");
        }
    }

}