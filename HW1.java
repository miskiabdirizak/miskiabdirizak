public class HW1 {

  public static void main(String[] args) {
    // Q1
    System.out.println("Question 1: ");

    int testResult1 = findMissing(new int[] {0, 1, 2, 4, 5});
    System.out.println(testResult1); // should output 3

    int testResult2 = findMissing(new int[] {5, 0, 4, 3, 1});
    System.out.println(testResult2); // should output 2

    int testResult3 = findMissing(new int[] {});
    System.out.println(testResult3); // should output 0

    int testResult4 = findMissing(new int[] {9, 3, 5, 1, 4, 8, 2, 10, 0, 6});
    System.out.println(testResult4); // should output 7
    System.out.println();


    // Q3
    System.out.println("Question 3 ");

    System.out.println(countFives(123467890)); // should output 0
    System.out.println(countFives(555555));    // should output 6
    System.out.println(countFives(15354));     // should output 2
    System.out.println();


    // Q4
    System.out.println("Question 4: ");
    System.out.println();
    int testResult5 = pickTrees(new int[] {1, 2, 3, 4, 5});
    System.out.println(testResult5); // should output 9

    int testResult6 = pickTrees(new int[] {1, 3, 4, 3});
    System.out.println(testResult6); // should output 6

    int testResult7 = pickTrees(new int[] {5, 1, 4, 9});
    System.out.println(testResult7); // should output 14
    System.out.println();
 
  }
  
  /*algorithm findMissing
  * Input: integer array A of length N where each element is distinct and in the range [0, N]
  * Output: integer x where x is in the range [0, N], but not in A
  *  s = the sum of all numbers in A
  *  return (N(N+1))/2 - s
   */
  public static int findMissing(int[] arr) {
      //Test case //
    if(arr == null) {
      System.out.println("Array must not be NULL");
    }
    
    int n = arr.length;

    int s = 0; //initialize s = the sum of all numbers in A
    for(int i=0; i<arr.length; i++){ //iterate through the array
      s += arr[i]; //add value of arr[i] to the sum 
    }
    //return the total sum of numbers b/w 1 and n=arr.length
    return n*(n+1)/2-s; 
  }

  /*
   * Input:Int
   * Output: number of times the number 5 appears as a digit in the numver 
   */
  public static int countFives(int num) {
    //Base case
    if (num==0){
      return 0; 
    }
/*Removing least significant digit */
    int number = num % 10;
    //check if digit equals 5 or not  
    if (number == 5){
      //if yes, add 1 and recurse again to check the next digits  
      return 1 + countFives(num/10); 
    }
    //if not, recurse again to check next digit
    return countFives(num/10); 
  }

  /**
   *Using a helper method to solve the problem recursively
   */
  public static int pickTrees(int[] arr) {
    //pass zero as index and sum 
    return pickTreesHelper(arr, 0, 0); 
}

/* Helper Method *
* Helps find the max number of trees 
* Pass an index as the current location and sum as the sum of trees picked
*/ 
  public static int pickTreesHelper(int [] arr, int index, int sum) {
      /* Base Case*/
    //if index is >= the length of the array return current sum
    if (index >= arr.length) {
      return sum; 
    }

    //Sum1: Move to next location without picking the tree at the current location 
    int s1 = pickTreesHelper(arr, index +1, sum);
    //Sum2: Skip the next location. Move to next, next location after picking tree in current location 
    int s2 = pickTreesHelper(arr, index + 2, sum + arr[index]);

    //return the sum that is largest
    return Math.max(s1, s2);
 }
 
}

