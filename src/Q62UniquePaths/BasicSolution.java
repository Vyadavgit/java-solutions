package Q62UniquePaths;

// recursive approach exceeds time for bigger inputs
// Time complexity: O(2^(m+n))
// Space complexity: O(2^(m+n))
public class BasicSolution {
    public static void main(String[] args) {
        System.out.println(uniquePaths(51,9));
    }

    public static int uniquePaths(int m, int n) {
        return count(m,n);
    }

    private static int count(int m, int n){
        if(m == 1 || n == 1) return 1;
        int down = count(m-1, n);
        int right = count(m, n-1);
        return down + right;
    }
}