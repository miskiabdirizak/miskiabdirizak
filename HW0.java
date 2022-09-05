//Name: Miski Abdirizak 
//Due Date: September 5, 2022 
//CSC4520

import java.util.*;

public class HW0 {

  public static void main(String[] args) {

    // Q1
  
    int testResult1 = maxOfArray(new int[] {1, 3, 4, 5, 2});
    int testResult2 = maxOfArray(new int[] {-1, -3, -4, -5, -2});
    
    System.out.println("Question 1 Solution: ");
    System.out.println(testResult1); // should output 5
    System.out.println(testResult2); // should output -1
    System.out.println();



///create new branch than merge

    // Q2
    
      int[] testResult3 = twoSum(new int[] {0, 2, 3, 4, 5}, 6);
      int[] testResult4 = twoSum(new int[] {1, 2, 3, 4, 5}, 10);
  
      System.out.println("Question 2 Solution: ");
      System.out.println(Arrays.toString(testResult3)); // should output [1, 3]
      System.out.println(Arrays.toString(testResult4)); // should output [-1, -1]
      System.out.println();



    // Q3
    List<Integer> testResult5 = add(Arrays.asList(1, 2, 3), Arrays.asList(2, 4, 2));
    List<Integer> testResult6 = add(Arrays.asList(9, 9, 9), Arrays.asList(1));
    List<Integer> testResult7 = add(Arrays.asList(9, 2, 2, 3, 3, 7, 2, 0, 3, 6, 8, 5, 4, 7, 7, 5, 8, 0, 7), Arrays.asList(1, 2, 3, 4, 5));

    System.out.println("Question 3 Solution: ");
    System.out.println(testResult5); // should output [3, 6, 5]
    System.out.println(testResult6); // should output [1, 0, 0, 0]
    System.out.println(testResult7); // should output [9, 2, 2, 3, 3, 7, 2, 0, 3, 6, 8, 5, 4, 7, 8, 8, 1, 5, 2]
  }

  /**
   * Add your key ideas to this comment.
   * How did you approach the problem?
   * Why does your code work?
   */
  public static int maxOfArray(int[] arr) {
    if(arr == null){
      throw new IllegalArgumentException("Array must not be null");
    }else if(arr.length == 0){
      throw new IllegalArgumentException("Array is empty");
    }
    
     int maxInt =0;
      for(int i=0; i<arr.length; i++){
          if(arr[i]>arr[maxInt]){
            maxInt =i;
          }
        }
        return arr[maxInt];  
  }

  /**
   * Add your key ideas to this comment.
   * How did you approach the problem?
   * Why does your code work?
   */
  public static int[] twoSum(int[] arr, int targetSum) throws IllegalArgumentException{
    if(arr == null) {
      throw new IllegalArgumentException("Array must not be NULL");
    }else if(arr.length == 0){
      throw new IllegalArgumentException("Array is empty");
    }
    for(int i =0; i<arr.length; i++){
      for(int j=i+1; j<arr.length; j++){
        if(arr[j] == targetSum - arr[i]){
          return new int[] {i,j}; 
        }
      }
    }
    return new int[] {-1,-1}; 
  }

  /**
   * Add your key ideas to this comment.
   * How did you approach the problem?
   * Why does your code work?
   */
  public static List<Integer> add(List<Integer> lst1, List<Integer> lst2)  {
    if(lst1.size() >= lst2.size()){
      return addUtil(lst1, lst2); 
    }else {
      return addUtil(lst2, lst1);
    }
  }
    
  public static List<Integer>addUtil(List<Integer>lst1, List<Integer> lst2){
    int i = lst1.size()-1, carry =0, sum =0; 
    int j = lst2.size()-1, k=1;
    List<Integer> result = new ArrayList<Integer>(); 

    while(j>=0){
      sum = lst1.get(i) + lst2.get(j) + carry; 
      result.add(0,(sum%10)); 

      carry = sum/10; 
      i--;
      j--;
      k--;
    }

    while(i>=0){
      sum = lst1.get(i) + carry; 
      result.add(0,(sum%10)); 
      carry = sum /10; 
      i--;
      k--;
    }

    if(carry==1)
      result.add(0,1);
    return result; 
  }
  

}


