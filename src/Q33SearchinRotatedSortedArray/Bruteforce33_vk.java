package Q33SearchinRotatedSortedArray;

public class Bruteforce33_vk {
    public static void main(String[] args) {

        System.out.println(binarySearchRec(new int[]{1, 2, 3, 4, 5, 6}, 0, 5, 2));
        System.out.println(binarySearchIt(new int[]{1, 2, 3, 4, 5, 6}, 2));

        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(findPivot(arr, 0, 0, arr.length - 1)); // 3
        System.out.println();
    }

    // recursion
    private static int binarySearchRec(int[] nums, int start, int end, int target){
        if(start > end){
            return -1;
        }

        int mid = start + (end - start)/2;

        if(nums[mid] == target){
            return mid;
        } else if (target < nums[mid]) {
            return binarySearchRec(nums, start, mid-1, target);
        }else {
            return binarySearchRec(nums, mid+1, end, target);
        }
    }

    // iteration
    private static int binarySearchIt(int[] nums, int target){
        if(nums == null){
            return -1;
        }

        int start = 0;
        int end = nums.length-1;

        while (start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                return mid;
            }else if(target < nums[mid]){
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return -1;
    }


    // soln
    private static int findPivot(int[] nums, int  target, int s, int e){
        if(s > e){
            return -1;
        }

        int m = s + (e - s)/2;

        if(target == nums[m]){
            return m;
        }
// sorted side
        // check sorted first
        if(nums[s] <= nums[m]){
            if(target >= nums[s] && target <= nums[m]){
                return findPivot(nums, target, s, m-1);
            }else {
                return findPivot(nums, target, m+1, e);
            }

        }

// unsorted side
        // check sorted side first
        if(target >= nums[m] && target <= nums[e]){
            return findPivot(nums, target, m+1, e);
        }
        // check unsorted first
        return findPivot(nums, target, s, m-1);

    }
}
