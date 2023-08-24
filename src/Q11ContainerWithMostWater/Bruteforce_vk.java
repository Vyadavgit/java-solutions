package Q11ContainerWithMostWater;

// Time complexity: O(n^2) - not good
// Space complexity: O(1)
public class Bruteforce_vk {
    public static int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int temp_height, temp_area;

        for(int i = 0; i < height.length; i++){ // O(n)
            for(int j = i+1; j < height.length; j++){ // O(n)
                temp_height = Math.min(height[i], height[j]);
                temp_area = temp_height * (j - i);
                maxArea = Math.max(maxArea, temp_area);
            }
        }

        return maxArea;
    }

}
