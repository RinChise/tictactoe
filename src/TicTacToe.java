import java.util.Scanner;
import java.util.InputMismatchException;

public class TicTacToe {
    static String player1;
    static String player2;
    static Scanner scan = new Scanner(System.in);
    static char board[][] = new char[3][3];
    static char currentPlayer = 'X';
    public static final String RESET = "\033[0m";
    public static final String RED = "\033[0;31m";

    public static void main(String[] args) {
        initBoard();
        playerName();
        boardPrint();

        boolean gameFinished = false;
        while (!gameFinished) {
            int[] move = userInput();
            if (isFieldFree(move)) {
                placeMove(move);
                boardPrint();
                if (checkWin()) {
                    whoWonPrint();
                    gameFinished = true;
                } else if (isBoardFull()) {
                    whoWonPrint();
                    gameFinished = true;
                } else {
                    currentPlayer = (currentPlayer == 'X')? 'O' : 'X';
                }
            }
        }
    }

    //weißt Spielern Namen zu
    public static void playerName() {
        System.out.println("Spieler 1 bitte Namen eingeben: ");
        player1 = scan.nextLine();
        System.out.println("\nSpieler 2 bitte Namen eingeben: ");
        player2 = scan.nextLine();
        System.out.printf("\n%s spielt mit X \n%s spielt mit O\n", player1, player2);
    }

    //füllt Array mit -
    public static void initBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public static void flush() {
        System.out.println("\n");
    }

    //printet das Spielfeld + Nummerierung
    public static void boardPrint() {
        flush();
        System.out.println(RED + "\t1" + "\t2" + "\t3" + RESET);
        for (int i = 0; i < 3; i++) {
            System.out.print(RED + (i + 1) + "\t" + RESET);
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
        flush();
    }

    //prüft welcher Spieler dran ist, frägt ab wo man platzieren will und returned den wert in einem array
    public static int[] userInput() {
        String whoMoves = "";
        if (currentPlayer == 'X') {
            whoMoves = player1;
        } else {
            whoMoves = player2;
        }

        boolean validInputRow = false;
        boolean validInputCol = false;
        int row = 0;
        int column = 0;
        while (!validInputRow) {
            System.out.printf("%s welche Reihe(links)  1, 2 oder 3: ", whoMoves);
            try {
                row = scan.nextInt() - 1;
                if (row >= 0 && row < 3) {
                    validInputRow = true;
                } else {
                    System.out.println("\nInput falsch. 1, 2 oder 3. Bitte nochmal.\n");
                }
            } catch (InputMismatchException e){
                System.out.println("\nUngültiger Input. Nur Zahlen. Bitte Zahl eingeben.\n");
                scan.next();
            }
        }
        while (!validInputCol) {
            System.out.printf("%s welche Spalte(oben) 1, 2 oder 3: ", whoMoves);
            try {
                column = scan.nextInt() - 1;

                if (column >= 0 && column < 3) {
                    validInputCol = true;
                } else {
                    System.out.println("\nInput falsch. Bitte nochmal.\n");
                }
            } catch (InputMismatchException e){
                System.out.println("\nUngültiger Input. Nur Zahlen. Bitte Zahl eingeben.\n");
                scan.next();
            }
        }
        return new int[]{row, column};
    }

    //prüft ob Platz im Array an der gewünschten Stelle bereits "bespielt" wurde oder noch frei ist
    public static boolean isFieldFree(int[] move) {
        if (board[move[0]][move[1]] == '-') {
            return true;
        } else {
            System.out.println("\nFeld nicht leer. Bitte neues wählen.\n");
            return false;
        }
    }

    //platziert Symbol vom aktuellen Spieler ins Spielfeld an der Position userInput
    public static void placeMove(int[] move) {
        board[move[0]][move[1]] = currentPlayer;
    }

    //prüft Gewinnkriterien falls nicht gewonnen dann unentschieden
    public static boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            //prüft waagerecht
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer)
                return true;
            //prüft senkrecht
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)
                return true;
        }
        //prüft diagonal
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer)
            return true;
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)
            return true;
        return false;
    }

    //prüft ob das Spielfeld bereits voll ist = Unentschieden
    public static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    //prüft ob CheckWin true ist (es gibt einen gewinner) oder false (unentschieden)
    public static void whoWonPrint() {
        if (checkWin()) {
            if (currentPlayer == 'X') {
                System.out.printf("%s hat gewonnen.\n", player1);
            } else {
                System.out.printf("%s hat gewonnen.\n", player2);
            }
        } else {
            System.out.println("Unentschieden.\n");
        }
    }
}

