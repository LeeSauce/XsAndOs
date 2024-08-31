package caseStudy;
import java.util.Scanner;

public class Game {
    private final char[] player = new char[]{'X', 'O'};

    private final char emptySpace = '□';
    private final char[][] gameBoard = new char[3][3];

    public void setAxis(){
        for(int y = 0; y < 3; y++){
            setAxis(y);
        }
    }
    private void setAxis(int yAxis){
        for(int x = 0; x < 3; x++){
            this.gameBoard[yAxis][x] = this.emptySpace;
        }
    }

    public void move(Scanner input){
        while(true){
            String[] spaces = coordinates(input);
            int y = convertToNum(spaces[0]);
            int x = convertToNum(spaces[1]);
            if(y == -1 || x == -1){
                continue;
            }
            y = setBound(y);
            x = setBound(x);
            if(y == -1 || x == -1){
                continue;
            }
            if(this.gameBoard[y][x] == this.emptySpace){
                this.gameBoard[y][x] = this.player[1];
                break;
            }else{
                System.out.println("Oops! Space is already taken!");
            }

        }
    }
    public boolean didWin(char checkPlayer){
        return checkHorizontal(checkPlayer) || checkHorizontal(checkPlayer) || checkCross(checkPlayer);
    }
    private String[] coordinates(Scanner input){
        while(true){
            String[] coordinates = input.nextLine().split(",");
            if(coordinates.length > 2){
                System.out.println("Entered too many values!");
                continue;
            }
            return coordinates;
        }
    }

    private int convertToNum(String input) throws NumberFormatException{
        try{
            return Integer.parseInt(input);
        }catch (NumberFormatException N){
            System.out.println("Entered a non-Int value!");
            return -1;
        }
    }
    private int setBound(int input){
        switch(input){
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            default:
                System.out.println("Coordinates out of bounds!");
                return -1;
        }
    }

    public void drawBoard(){

        for(int y = 0; y < 3; y++){
            for(int x = 0; x < 3; x++){
                System.out.printf("%c ",this.gameBoard[y][x]);
                if(x == 2){
                    System.out.printf("%n");
                }
            }
        }
    }

    private boolean checkHorizontal(char checkPlayer){
        for(int y = 0; y < 3; y++){
            int boxChecked = 0;
            for(int x = 0; x < 3; x++){
                if(this.gameBoard[y][x] == checkPlayer){
                    boxChecked++;
                }
            }
            if(boxChecked == 3){
                return true;
            }
        }
        return false;
    }
    private boolean checkVertical(char checkPlayer){
        for(int x = 0; x < 3; x++){
            int boxChecked = 0;
            for(int y = 0; y < 3; y++){
                if(this.gameBoard[y][x] == checkPlayer){
                    boxChecked++;
                }
            }
            if(boxChecked == 3){
                return true;
            }
        }
        return false;
    }
    private boolean checkCross(char checkPlayer){
        return this.gameBoard[1][1] == checkPlayer &&
                ((this.gameBoard[0][0] == checkPlayer && this.gameBoard[2][2] == checkPlayer)
                        || (this.gameBoard[0][2] == checkPlayer && this.gameBoard[2][0] == checkPlayer));
    }

}
