/*
   This class generates a Board for working through the EightQueens 
   problem. https://en.wikipedia.org/wiki/Eight_queens_puzzle
   @author Crystal Hess 10/29/2019
   Edited by: Aashima Mehta (02/02/2020)
*/

public class QueensBoard {
   public static final char EMPTY = ' ';
   protected char[][] board;
   private int placed = 0;

   public QueensBoard(int size) {
      if(size == 2 || size == 3) {
         System.out.println("Queens cannot be played with a board of size 2 or 3.");
         throw new IllegalArgumentException("Queens cannot be played with a board of size 2 or 3.");
      }
      board = new char[size][size];
      for(int r = 0; r < board.length; r++) {
         for(int c = 0; c < board[r].length; c++) {
            board[r][c] = EMPTY;
         }
      }
      placed = 0;
   }
   
   // Places a Queen and adds one to placed count
   public void place(int row, int column) {
      board[row][column] = 'Q';
      placed++;
   }
   
   // Removes the Queen and subtracts one from placed count
   public void remove(int row, int column) {
      board[row][column] = EMPTY;
      placed--;
   }
   
   // This recursive method solves the Queens problem
   public boolean solve() {
      //System.out.println(toString()); //------can see the backtracking working in the solution
      if(allPlaced()) {
         return true;
      }
      for(int c = 0; c < board[0].length; c++) {
         for(int r = 0; r < board.length; r++) {
            if(isSafe(r,c)) {
               place(r,c);//here u out the queen
               if(solve()) { // then u check if if the puzzle is solved or not since 
               //the board just changes after putting that one new queen in the new position.
                  return true; //if this doesnt lead to a solution
               }
               remove(r,c); // then remove it and then try a new palce
            }
         }
      }
      return false;
   }
   
   // checks if all Queens have been placed
   private boolean allPlaced() {
      return placed == board.length;
   }
   
   // checks if board[row][column] is a valid placement for a Queen
   public boolean isSafe(int row, int column) {
      // if this spot isn't empty --> not safe
      if(board[row][column] != EMPTY) {
         return false;
      }
      
      // if there's another queen on the row --> not safe
      for(int r = 0; r < board.length; r++) {
         if(r != row && board[r][column] == 'Q') {
            return false;
         }
      }
      
      // if there's another queen on the column --> not safe
      for(int c = 0; c < board[row].length; c++) {
         if(c != column && board[row][c] == 'Q') {
            return false;
         }
      }
      
      // if there's another queen diagonally --> not safe
      if(!checkDiagonals(row, column)) {
         return false;
      }
      
      // nothing was unsafe --> so it's safe
      return true;
   }
   
   // This helper method contents was stolen from my colleague, Kelsie :-)
   private boolean checkDiagonals(int row, int col) {
      // Check lower-left diagonal
      for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
         if (board[i][j] == 'Q') {
            return false;
         }
      }

      // Check lower-right diagonal
      for (int i = row, j = col; j >= 0 && i < board.length; i++, j--) {
         if (board[i][j] == 'Q') {
             return false;
         }
      }

      // Check upper-left diagonal
      for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
         if (board[i][j] == 'Q') {
             return false;
         }
      }

      // Check upper-right diagonal
      for (int i = row, j = col; j < board.length && i < board.length; i++, j++) {
         if (board[i][j] == 'Q') {
             return false;
         }
      }
     
      return true;
   }
   
   // Turns the board into printable format
   public String toString() {
      String sBoard = "";
      for(char[] row : board) {
         for(char cell : row) {
            sBoard += cell == EMPTY ? "-" : cell;
            sBoard += " ";
         }
         sBoard += "\n";
      }
      return sBoard;
   }
}
