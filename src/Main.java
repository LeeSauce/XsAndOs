package caseStudy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);

        gameSequence(game, scanner);
    }

    public static void gameSequence(Game game, Scanner scanner){
        game.setAxis();
        while(true){
            game.drawBoard();
            System.out.println("Enter coordinates: ");
            if(game.didWin('O')){
                System.out.println("You Win!");
                break;
            }
            game.move(scanner);
            System.out.println("-".repeat(10));
        }
    }
}
