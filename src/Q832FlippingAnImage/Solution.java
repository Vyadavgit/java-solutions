package Q832FlippingAnImage;

class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int[] row : image){
            for(int i = 0; i < (row.length+1)/2; i++){
                // flip
                int temp = row[row.length-1-i] ^ 1; // XOR inverts the bits 1 to 0 and 0 to 1
                row[row.length-1-i] = row[i] ^ 1; // XOR inverts the bits 1 to 0 and 0 to 1
                row[i] = temp;
            }
        }
        return image;
    }
}