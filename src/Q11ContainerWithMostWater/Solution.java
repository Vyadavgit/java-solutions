package Q11ContainerWithMostWater;

// Time Complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;
        int max = 0;

        while(start < end){
            int min_height = Math.min(height[start], height[end]);
            max = Math.max(max, min_height * (end - start));
            if(height[start] < height[end]){
                start++;
            }else{
                end--;
            }
        }
        return max;
    }
}