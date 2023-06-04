package Q287FindTheDuplicateNumber;

class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;
        while(i < nums.length){
            if(nums[i] != i+1){
                if(nums[nums[i]-1] == nums[i]){ // if swap positions have same value
                    return nums[i];
                }
                swap(nums, nums[i]-1, i);
            }else{
                i++;
            }
        }
        return -1;
    }

    public void swap(int[] nums, int x, int y){
        int temp = nums[y];
        nums[y] = nums[x];
        nums[x] = temp;
    }
}