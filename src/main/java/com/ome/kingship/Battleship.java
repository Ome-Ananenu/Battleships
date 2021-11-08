package com.ome.kingship;

import java.io.Console;
import java.util.*;

public class Battleship {
    public static void main(String[] args) {
        System.out.println("\n\n**** Welcome to Battle Ships game ****");
        playerTurn();
    }

    public static void playerTurn(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows");
        int row = sc.nextInt();
        System.out.println("Enter number of columns");
        int col = sc.nextInt();
        String[][] gameBoard = new String[row][col];
        String[] alphabets = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        for (int r = 1; r < row + 1; r++) {
            for (int c = 1; c < col + 1; c++) {
                gameBoard[r-1][c-1] = " "+alphabets[r-1]  + c + "  | ";
            }
            // System.out.println();
        }
        displayLoop(gameBoard);

        String player1 = playerName();
        Set<String> player1SecretNumbers = playerSecretNumbers(player1,row,col);
        ArrayList<String> battleGround1 = battleGround(row,col);
        ArrayList<String> player1RightAnswers = new ArrayList<String>();
        ArrayList<String> player1Answers = new ArrayList<String>();

        //Player 2 Name
        String player2 = playerName();
        Set<String> player2SecretNumbers = playerSecretNumbers(player2,row,col);
        ArrayList<String> battleGround2 = battleGround(row,col);
        ArrayList<String> player2RightAnswers = new ArrayList<String>();
        ArrayList<String> player2Answers = new ArrayList<String>();
        boolean gameOver=false;
        for(int i=0; i<row*col; i++){
            if(i % 2 == 0){
                theGame(battleGround1,player1,col);
                gameOver = guesses(row,col,player1Answers,player1RightAnswers,battleGround1,player1,player2SecretNumbers);
                System.out.printf("Score: %s (%d) - %s (%d)%n",player1,player1RightAnswers.size(),player2,player2RightAnswers.size());
                if(gameOver){
                    System.out.println("\n\nHooray! You won the battle :)");
                    break;
                }
            }
            if(i % 2 != 0){
                theGame(battleGround2,player2,col);
                gameOver = guesses(row,col,player2Answers,player2RightAnswers,battleGround2,player2,player1SecretNumbers);
                System.out.printf("Score: %s (%d) - %s (%d)",player1,player1RightAnswers.size(),player2,player2RightAnswers.size());
                if(gameOver){
                    System.out.println("\n\nHooray! You won the battle :)");
                    break;
                }
            }
        }
    }
    public static ArrayList<String> battleGround(int row, int col){
        String[][] gameBoard = new String[row][col];
        String[] alphabets = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J","K","L","M","N","O","P","Q","R","S"};
        for (int r = 1; r < row + 1; r++) {
            for (int c = 1; c < col + 1; c++) {
                gameBoard[r - 1][c - 1] = " "+alphabets[r - 1]  + c + "  | ";
            }
            // System.out.println();
        }
       // displayLoop(gameBoard);
        ArrayList<String> validPositions = new ArrayList<String>();
        for(int i=0; i< gameBoard.length;i++){
            for(int j=0;j<gameBoard[i].length;j++) {
                validPositions.add(gameBoard[i][j]);
            }
        }
        return validPositions;
    }

    public static String playerName(){
        Scanner playerName = new Scanner(System.in);
        System.out.println("\n\nEnter your name: ");
        String name = playerName.nextLine();
        return name;
    }

public static ArrayList<String> displayLoop(String[][] field){
    for (String[] row : field) {
        for (String column : row) {
            System.out.print(column);
        }
        System.out.println();
    }
    return null;
}
    public static Set<String> playerSecretNumbers(String name,int row,int col) {
        ArrayList<String> validPositions = battleGround(row,col);
        Console console = System.console();
        Set<String> playerSecretPositions = new HashSet<>();
        char[] playerSecret = console.readPassword(name + " deploy your first ship(A1-C3): ");
        while(!(validPositions.contains(" "+String.valueOf(playerSecret)+"  | "))){
            System.out.println("You can't place ships outside the battlefield");
            char[] tryAgain =  console.readPassword(name + " deploy your first ship(A1-C3): ");
            playerSecret = tryAgain;
        }
        playerSecretPositions.add(String.valueOf(playerSecret));
        char[] playerSecondSecret = console.readPassword(name + " deploy your second ship(A1-C3): ");
        while(!(validPositions.contains(" "+String.valueOf(playerSecondSecret)+"  | "))){
            System.out.println("You can't place ships outside the battlefield");
            char[] tryAgain =  console.readPassword(name + " deploy your second ship(A1-C3): ");
            playerSecondSecret = tryAgain;
        }

        while(playerSecretPositions.contains(String.valueOf(playerSecondSecret))){
            System.out.println("You can't place two or more ships on the same location");
            char[] playerTry = console.readPassword(name + " deploy your second ship(A1-C3): ");
            if(validPositions.contains(" "+String.valueOf(playerTry)+"  | ")){
                playerSecondSecret = playerTry;
                break;
            }
            else{
                while(!(validPositions.contains(" "+String.valueOf(playerSecondSecret)+"  | "))){
                    System.out.println("You can't place ships outside the battlefield");
                    char[] tryAgain =  console.readPassword(name + " deploy your second ship(A1-C3): ");
                    playerSecondSecret = tryAgain;
                }
            }
        }
        playerSecretPositions.add(String.valueOf(playerSecondSecret));
        return playerSecretPositions;
    }

    public static String guessPrompt(String name){
        Scanner playerGuessPrompt = new Scanner(System.in);
        System.out.print("Now Enter your position(A1-C3): ");
        String playerGuess = playerGuessPrompt.nextLine();
        return playerGuess;
    }

    public static boolean guesses(int row,int col,ArrayList<String> playerAnswers,ArrayList<String> playerRightAnswers,ArrayList<String>  battleGround,String name, Set<String> playerSecretPositions ) {
        String playerGuess = guessPrompt(name);
        ArrayList<String> validPositions = battleGround(row,col);
        while (!(validPositions.contains(" "+playerGuess +"  | "))) {
            System.out.println("\nYou can't place ships outside the battlefield");
            String tryAgain = guessPrompt(name);
            playerGuess = tryAgain;
        }
        while (playerAnswers.contains(" "+playerGuess+"  | ")) {
            System.out.println("\nYou can't place two or more ships on the same location");
            String playerTry = guessPrompt(name);
            playerGuess = playerTry;
        }
        if (!(playerAnswers.contains(" "+playerGuess+"  | "))) {
            playerAnswers.add(" "+playerGuess+"  | ");
            if (playerSecretPositions.contains(playerGuess)) {
                playerRightAnswers.add(playerGuess);
                battleGround.set(battleGround.indexOf(" "+playerGuess+"  | ")," O   | ");
                System.out.println(displayLoop(toArray(battleGround, col)));
                System.out.println("You guessed correctly!!");
                if (playerRightAnswers.size() == 2) {
                    return true;
                }
            } else {
                battleGround.set(battleGround.indexOf(" "+playerGuess+"  | ")," X   | ");
               System.out.println(displayLoop(toArray(battleGround, col)));
                System.out.println("Wrong guess!!!");
            }
        }
        return false;
    }

    public static void theGame(ArrayList<String> battleGround,String name,int col){
        System.out.println("\n\n"+ name + " It's your turn!!");
        System.out.println("Here's the current state of your board before you make a guess");
        System.out.println(displayLoop(toArray(battleGround, col)));
    }


    public static String[][] toArray(ArrayList<String> list, int rows) {
        int resultRows = list.size()/rows;
        if(list.size()%rows!=0){
            resultRows++;
        }
        String[][] result = new String[resultRows][rows];
        int i = 0;
        int j = 0;
        for (String value : list) {
            result[i][j] = value;
            j++;
            if(j > rows - 1){
                i++;
                j = 0;
            }
        }
        System.out.println("about to");
        return result;
    }

}
