package Q41FirstMissingPositive;
/* Amazon asked
* Q41. First Missing Positive
* Given an unsorted integer array nums, return the smallest missing positive integer.
You must implement an algorithm that runs in O(n) time and uses constant extra space.
* Example 1:
* Input: nums = [1,2,0]
  Output: 3
  Explanation: The numbers in the range [1,2] are all in the array.
* */
public class MissingPosition {
    public static void main(String[] args) {
        int[] arr = new int[]{3,4,-1,1};
        System.out.println(findMissingPositive(arr));

    }

    public static int findMissingPositive(int[] arr){
        int i = 0;
        while(i < arr.length){
            int correctPos = arr[i] - 1;
            if(arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[correctPos]){
                swap(arr, i, correctPos);
            }else{
                i++;
            }
        }

        for(int j = 0; j < arr.length; j++){
            if(arr[j] != j+1){
                return j+1;
            }
        }

        return arr.length + 1;
    }

    public static void swap(int[] arr, int i, int correctPos){
        int temp = arr[correctPos];
        arr[correctPos] = arr[i];
        arr[i] = temp;
    }
}
