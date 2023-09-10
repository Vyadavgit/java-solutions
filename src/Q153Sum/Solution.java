package Q153Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Time Complexity: O(n^2)
// Space Complexity: O(n)
class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums); // sort the array

        for(int i = 0; i < nums.length - 2; i++){
            // skip duplicate elements for i
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;

            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    // skip duplicates for j
                    while(j < k && nums[j] == nums[j+1]){
                        j++;
                    }

                    // skip duplicates for k
                    while( j < k && nums[k] == nums[k-1]){
                        k--;
                    }

                    // move pointers
                    j++;
                    k--;
                }else if(sum < 0){
                    // increment i to increase the sum
                    j++;
                }else {
                    // decrement k to decrease the sum
                    k--;
                }
            }

        }
        return ans;
    }
}