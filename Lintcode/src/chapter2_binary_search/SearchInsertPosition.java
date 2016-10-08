package chapter2_binary_search;
/**Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume NO duplicates in the array.

Have you met this question in a real interview? Yes
Example
[1,3,5,6], 5 → 2

[1,3,5,6], 2 → 1

[1,3,5,6], 7 → 4

[1,3,5,6], 0 → 0

*/
public class SearchInsertPosition {

    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public static int searchInsert(int[] A, int target) {
        if(A == null || A.length == 0) return 0;
        // write your code here
        int left = 0, right = A.length-1;
        while(left+1 < right){
            int mid = left + (right-left)/2;
            if(A[mid] == target) return mid;
            else if(A[mid] > target) right = mid;
            else left = mid;
        }
        if(A[left] > target) return left == 0 ? 0 : left-1;
        if(A[right] < target) return right+1;
        else if(A[left] < target) return left+1;
        else if(A[left] == target) return left;
        else return right-1;
    }

    public static void main(String...strings){
//        int[] A = new int[]{};
//        int target = 9;//should be 0
        
        int[] A = new int[]{9,10,100,101,1002,10203};
        int target = 9;//should be 1
        System.out.println(searchInsert(A, target));
    }
}
