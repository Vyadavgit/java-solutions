package Q645SetMismatch;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findErrorNums(new int[]{1, 2, 2, 4})));
    }

    public static int[] findErrorNums(int[] nums) {
        int i = 0;
        while(i < nums.length){
            if(nums[i] != nums[nums[i]-1]){
                swap(nums, i, nums[i]-1);
            }else{
                i++;
            }
        }

        for(int j = 0; j < nums.length; j++){
            if(nums[j] != j+1){
                return new int[]{nums[j], j+1};
            }
        }
        return new int[]{-1, -1};
    }

    public static void swap(int[] nums, int x, int y){
        int temp = nums[y];
        nums[y] = nums[x];
        nums[x] = temp;
    }
}