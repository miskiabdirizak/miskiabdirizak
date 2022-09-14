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
  * Input: integer array A of length N where each element is distinct   and in the range [0, N]
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
    for(int i=0; i<arr.length; i++){ //iterate throw the array
      s += arr[i]; //add value of arr[i] to the sum 
    }
    //return the total sum of numbers b/w 1 and n=arr.length
    return n*(n+1)/2-s; 
  }

  /*
   * Input:Int
   * Output: num times the number 5 appears as a digit in the numver 
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
   * Add your key ideas to this comment.
   * How did you approach the problem?
   * Why does your code work?
   */
  public static int pickTrees(int[] arr) {
    throw new UnsupportedOperationException("pickTrees not yet written");
  }
}


//Q2 
/* 
 * Convert the following code into Pseudocode and put it in twosum.txt. Hint: for some loops, you
should describe what it does in English. There are no tests for this problem, so be sure to
double check and test your translation manually, similar to how we did in lecture. ***

  public static int[] twoSumFast(int[] arr, int target) {
    HashSet<Integer> seen = new HashSet<>();
    for (int j = 0; j < arr.length; j++) {
      int otherAddend = target - arr[j];
      if (seen.contains(otherAddend)) {
        for (int i = 0; i < arr.length; i++) {
          if (arr[i] == otherAddend) {
            return new int[] {i, j};  
          }
        }
      } else {
        seen.add(arr[j]);
      }
    }
    return new int[] {-1, -1};  
  }
*/

