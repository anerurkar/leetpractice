package com.leetcode.exercises;

//Java program to print the maximum number
//from the set of digits of a given number
public class GFG
{
 // Function to print the maximum number
 static int printMaxNum(int num)
 {
     // hashed array to store count of digits
     int count[] = new int[10];
      
     // Converting given number to string
     String str = Integer.toString(num);
      
     // Updating the count array
     for(int i=0; i < str.length(); i++)
         count[str.charAt(i)-'0']++;
      
     // result is to store the final number
     int result = 0, multiplier = 1;
      
     // Traversing the count array
     // to calculate the maximum number
     for (int i = 0; i <= 9; i++)
     {
         while (count[i] > 0)
         {
             result = result + (i * multiplier);
             count[i]--;
             multiplier = multiplier * 10;
         }
     }
   
     // return the result
     return result;
 }
  
 // Driver program to test above function
 public static void main(String[] args)
 {
     int num = 50552;
     System.out.println(printMaxNum(num));
 }
}
