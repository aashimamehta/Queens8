import java.io.*;
import java.util.*;


class RecursionBacktracking{
   public static void main(String[] args) {
//       List<Integer> list = new ArrayList<Integer>();
//       list.add(7);
//       list.add(30);
//       list.add(8);
//       list.add(22);
//       list.add(6);
//       list.add(1);
//       list.add(14);
//       int val = maxSum(list, 19);
//       System.out.println(list.toString());
//       System.out.println(val);
         
         testBreak();
         
         decToBin(10);
         System.out.println();
         System.out.println(decToBin2(11));
   }
   
   public static int maxSum(List<Integer> list, int limit) {
       if (list.size() == 0 || limit <= 0) {
           return 0;
       } else {
           int[] max = {0};
           maxSum(list, limit, 0, max);
           return max[0];
       }
   }

   public static void maxSum(List<Integer> list, int limit, int sum, int[] max) {
       if (sum > max[0] && sum <= limit) {
           max[0] = sum;
       }
       if (list.size() != 0) {
           int num = list.remove(0);
           maxSum(list, limit, sum + num, max);
           maxSum(list, limit, sum, max);
           list.add(num);
       }
   }
   
   public static void decToBin(int n){
      if(n > 0){
         decToBin(n/2);
         System.out.print(n%2);
      }
      else{
         System.out.print("0");
      }
   }
   
      
   public static String decToBin2(int n){
      if(n > 0){
         return decToBin2(n/2) + (n%2);
      }
       return "0"; 
   }
   
   public static void testBreak(){
      for(int i = 0; i < 8; i++){
         System.out.print("i = ");
         for(int j = 0; j < 5; j++){
            if(j == 3){
               break;
            }
            System.out.print("**");
         }
         System.out.println();
      }
   
   }
   
}