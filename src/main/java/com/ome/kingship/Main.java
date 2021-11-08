package com.ome.kingship;

import java.io.Console;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        gameBoardSize();
//        tableSize();
//        System.out.println("\n\n**** Welcome to Battle Ships game ****");
//        howToPlay();
//        playerTurn();

    }

    public static String[][] gameBoardSize(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of columns");
        int col = sc.nextInt();
        System.out.println("Enter number of rows");
        int row = sc.nextInt();
        String[][] gameBoard = new String[row][col];
        String[] alphabets = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J","K","L","M","N","O","P","Q","R","S"};
        for (int r = 1; r < row + 1; r++) {
            for (int c = 1; c < col + 1; c++) {
                gameBoard[r - 1][c - 1] = alphabets[r - 1]  + c + " ||";
            }
            // System.out.println();
        }
        displayLoop(gameBoard);

        ArrayList<String> validPositions = new ArrayList<String>();
        for(int i=0; i<row;i++){
            for(int j=0;j<col;j++) {
                validPositions.add(gameBoard[i][j]);
            }
        }
        //System.out.println(validPositions.contains("H8"+" ||"));
        return gameBoard;
    }
    public static void displayLoop(String[][] field){
        for (String[] row : field) {
            for (String column : row) {
                System.out.print(column);
            }
            System.out.println();
        }
    }

//    public static char[][] printBattleGround() {
//        String pos = "";
//        switch (pos) {
//
//        }
//    }
}
//    public static void playerTurn(){
//        String player1 = playerName();
//        Set<String> player1SecretNumbers = playerSecretNumbers(player1);
//        char[][] battleGround1 = battleGround();
//        ArrayList<String> player1RightAnswers = new ArrayList<String>();
//        ArrayList<String> player1Answers = new ArrayList<String>();
//
//        //Player 2 Name
//        String player2 = playerName();
//        Set<String> player2SecretNumbers = playerSecretNumbers(player2);
//        char[][] battleGround2 = battleGround();
//        ArrayList<String> player2RightAnswers = new ArrayList<String>();
//        ArrayList<String> player2Answers = new ArrayList<String>();
//        boolean gameOver=false;
//        for(int i=0; i<19; i++){
//            if(i % 2 == 0){
//                theGame(battleGround1,player1);
//                gameOver = guesses(player1Answers,player1RightAnswers,battleGround1,player1,player2SecretNumbers);
//                System.out.printf("Score: %s (%d) - %s (%d)%n",player1,player1RightAnswers.size(),player2,player2RightAnswers.size());
//                if(gameOver){
//                    System.out.println("\n\nHooray! You won the battle :)");
//                    break;
//                }
//            }
//            if(i % 2 != 0){
//                theGame(battleGround2,player2);
//                gameOver = guesses(player2Answers,player2RightAnswers,battleGround2,player2,player1SecretNumbers);
//                System.out.printf("Score: %s (%d) - %s (%d)",player1,player1RightAnswers.size(),player2,player2RightAnswers.size());
//                if(gameOver){
//                    System.out.println("\n\nHooray! You won the battle :)");
//                    break;
//                }
//            }
//        }
//
//    }
//
//    public static void theGame(char[][] battleField,String name){
//        System.out.println("\n\n"+ name + " It's your turn!!");
//        System.out.println("Here's the current state of your board before you make a guess");
//        displayLoop(battleField);
//    }
//
//    public static void howToPlay(){
//        System.out.println("\n\nHow To Play");
//        System.out.println("At the start of this game each player will be prompted to choose 2 secret positions to deploy their battleships.\n" +
//                "To win, you have to try to guess your opponents secret positions on the board.\n" +
//                "Do this by choosing a position between A1 to C3 as shown in the diagram below.\n" +
//                "An 'X' means you guessed wrongly and An 'O' means you guessed correctly. ");
//        String[][] sampleField =
//                {{"+","-","-","-","-","-","+","-","-","-","-","-","+","-","-","+"},
//                        {"|"," ","A1", " ", "|"," ","A2"," ", "|"," ","A3"," ","|"},
//                        {"+","-","-","-","-","-", "+","-","-","-","-","-","+","-","-","+"},
//                        {"|"," ","B1", " ", "|"," ","B2"," ", "|"," ","B3"," ","|"},
//                        {"+","-","-","-","-","-", "+","-","-","-","-","-","+","-","-","+"},
//                        {"|"," ","C1", " ", "|"," ","C2"," ", "|"," ","C3"," ","|"},
//                        {"+","-","-","-","-","-", "+","-","-","-","-","-","+","-","-","+"}};
//
//        for (String[] row : sampleField) {
//            for (String column : row) {
//                System.out.print(column);
//            }
//            System.out.println();
//        }
//        System.out.println("Let the battle begin!!!");
//    }
//
//    public static String playerName(){
//        Scanner playerName = new Scanner(System.in);
//        System.out.println("\n\nEnter your name: ");
//        String name = playerName.nextLine();
//        return name;
//    }
//    public static ArrayList<String> validList(){
//        ArrayList<String> validPositions = new ArrayList<>();
//        validPositions.addAll(Arrays.asList("A1","A2","A3","B1","B2","B3","C1","C2","C3"));
//        return validPositions;
//    }
//
//    public static Set<String> playerSecretNumbers(String name) {
//        ArrayList<String> validPositions = validList();
//        Console console = System.console();
//        Set<String> playerSecretPositions = new HashSet<>();
//        char[] playerSecret = console.readPassword(name + " deploy your first ship(A1-C3): ");
//        while(!(validPositions.contains(String.valueOf(playerSecret)))){
//            System.out.println("You can't place ships outside the battlefield");
//            char[] tryAgain =  console.readPassword(name + " deploy your first ship(A1-C3): ");
//            playerSecret = tryAgain;
//        }
//        playerSecretPositions.add(String.valueOf(playerSecret));
//        char[] playerSecondSecret = console.readPassword(name + " deploy your second ship(A1-C3): ");
//        while(!(validPositions.contains(String.valueOf(playerSecondSecret)))){
//            System.out.println("You can't place ships outside the battlefield");
//            char[] tryAgain =  console.readPassword(name + " deploy your second ship(A1-C3): ");
//            playerSecondSecret = tryAgain;
//        }
//        while(playerSecretPositions.contains(String.valueOf(playerSecondSecret))){
//            System.out.println("You can't place two or more ships on the same location");
//            char[] playerTry = console.readPassword(name + " deploy your second ship(A1-C3): ");
//            if(validPositions.contains(String.valueOf(playerTry))){
//                playerSecondSecret = playerTry;
//                break;
//            }
//            else{
//                while(!(validPositions.contains(String.valueOf(playerSecondSecret)))){
//                    System.out.println("You can't place ships outside the battlefield");
//                    char[] tryAgain =  console.readPassword(name + " deploy your second ship(A1-C3): ");
//                    playerSecondSecret = tryAgain;
//                }
//            }
//        }
//        playerSecretPositions.add(String.valueOf(playerSecondSecret));
//        return playerSecretPositions;
//    }
//
//    public static String guessPrompt(String name){
//        Scanner playerGuessPrompt = new Scanner(System.in);
//        System.out.print("Now Enter your position(A1-C3): ");
//        String playerGuess = playerGuessPrompt.nextLine();
//        return playerGuess;
//    }
//
//    public static boolean guesses(ArrayList<String> playerAnswers,ArrayList<String> playerRightAnswers,char[][] battleGround,String name, Set<String> playerSecretPositions ) {
//        String playerGuess = guessPrompt(name);
//        ArrayList<String> validPositions = validList();
//        while (!(validPositions.contains(playerGuess))) {
//            System.out.println("\nYou can't place ships outside the battlefield");
//            String tryAgain = guessPrompt(name);
//            playerGuess = tryAgain;
//        }
//        while (playerAnswers.contains(playerGuess)) {
//            System.out.println("\nYou can't place two or more ships on the same location");
//            String playerTry = guessPrompt(name);
//            playerGuess = playerTry;
//        }
//        if (!(playerAnswers.contains(playerGuess))) {
//            playerAnswers.add(playerGuess);
//            if (playerSecretPositions.contains(playerGuess)) {
//                playerRightAnswers.add(playerGuess);
//                printBattleGround(battleGround, 'O', playerGuess);
//                System.out.println("You guessed correctly!!");
//                if (playerRightAnswers.size() == 2) {
//                    return true;
//                }
//            } else {
//                printBattleGround(battleGround, 'X', playerGuess);
//                System.out.println("Wrong guess!!!");
//            }
//        }
//        return false;
//    }
//
//    public static void tableSize(){
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("Enter number of columns");
//        int col = sc.nextInt();
//        System.out.println("Enter number of rows");
//        int row = sc.nextInt();
//        for (int r = 0; r < row; r++) {
//            for (int c = 0; c < col; c++) {
//                System.out.print("|  "+c+"  |");
//            }
//            System.out.println();
//        }
//
//    }
//
//
//    public static char[][] battleGround(){
//        char[][] battleGround = {{'+','-','-','-', '+','-','-','-', '+','-','-','-','+'},
//                {'|',' ',' ',' ', '|',' ',' ',' ', '|',' ',' ',' ','|'},
//                {'+', '-', '-', '-', '+','-', '-', '-', '+', '-','-','-', '+'},
//                {'|',' ',' ',' ', '|',' ',' ',' ', '|',' ',' ',' ','|'},
//                {'+', '-', '-', '-', '+','-', '-', '-', '+', '-','-','-', '+'},
//                {'|',' ',' ',' ', '|',' ',' ',' ', '|',' ',' ',' ','|'},
//                {'+','-','-','-', '+','-','-','-', '+','-','-','-','+'}};
//        return battleGround;
//    }
//
//    public static void displayLoop(char[][] field){
//        for (char[] row : field) {
//            for (char column : row) {
//                System.out.print(column);
//            }
//            System.out.println();
//        }
//    }
//
//    public static char[][] printBattleGround(char[][] battleGround,char options, String pos){
//        switch (pos.toUpperCase()) {
//            case "A1":
//                battleGround[1][2] = options;
//                break;
//            case "A2":
//                battleGround[1][6] = options;
//                break;
//            case "A3":
//                battleGround[1][10] = options;
//                break;
//            case "B1":
//                battleGround[3][2] = options;
//                break;
//            case "B2":
//                battleGround[3][6] = options;
//                break;
//            case "B3":
//                battleGround[3][10] = options;
//                break;
//            case "C1":
//                battleGround[5][2] = options;
//                break;
//            case "C2":
//                battleGround[5][6] = options;
//                break;
//            case "C3":
//                battleGround[5][10] = options;
//                break;
//            case " ":
//                battleGround = null;
//            default:
//                break;
//        }
//        displayLoop(battleGround);
//        return battleGround;
//    }
//}


