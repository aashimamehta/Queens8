public class QueensGame {
   public static void main(String[] args) {
      QueensBoard board = new QueensBoard(8);
      //QueensGUI board = new QueensGUI(8);
      board.solve();
      System.out.println("One possible solution...\n");
      System.out.println(board);
   }
}