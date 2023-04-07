// [17, 21, 25, 34, 37, 41, 61, 83, 92, 143, 148, 162, 206, 234, 268, 287, 442, 448, 645, 832, 852, 1672]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Pojo {
    public static void main(String[] args) {
        int[] arr = new int[]{
                832, 83, 21, 148, 206, 92, 234, 143, 25, 61, 37, 17, 34, 852, 162, 1672, 442, 448, 287, 268, 41, 645
        };

        // bubble sort
        for(int i = 0; i < arr.length-1; i++){
            for(int j = i+1; j < arr.length; j++){
                if(arr[i] > arr[j]){
                    swap(arr, i, j);
                }
            }
        }

        System.out.println(Arrays.toString(arr));

    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //---------------------------------------------------------------------------------------------------------------
    // calculate the max and max range form an array
    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 3, 10, 8, 15};
        System.out.println(max(arr));
        System.out.println(maxRange(arr, 1, 4));

    }

    public static int maxRange(int[] arr, int start, int end){
        // edge cases
        if(start > end){
            return -1;
        }

        if(arr ==  null){
            return -1;
        }

        int maxVal = arr[start];
        for(int i = start+1; i <= end; i++){
            if(arr[i] > maxVal){
                maxVal = arr[i];
            }
        }

        return maxVal;
    }

    public static int max(int[] arr){
        // edge case
        if(arr.length == 0){
            return -1;
        }

        int maxVal = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > maxVal){
                maxVal = arr[i];
            }
        }
        return maxVal;
    }

    //---------------------------------------------------------------------------------------------------------------
    // swap and reverse
    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 3, 10, 8, 15};
        swap(arr, 1,3);
        System.out.println(Arrays.toString(arr)); // [2, 10, 3, 7, 8, 15]

        reverse(arr);
        System.out.printf(Arrays.toString(arr)); // [15, 8, 7, 3, 10, 2]

        System.out.println();
        reverseimp(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void reverse(int[] arr){
        // 2, 7, 3, 10, 8, 15

        // edge case
        if(arr.length == 0){
            System.out.println("array is empty");
            return;
        }

        int start = 0;
        int end = arr.length;
        for(int i = 0; i < arr.length/2; i++){  // O(N/2)
            swap(arr, i, arr.length-i-1);
        }

    }

    // improved version
    public static void reverseimp(int[] arr) {
        // 2, 7, 3, 10, 8, 15

        // edge case
        if (arr.length == 0) {
            System.out.println("array is empty");
            return;
        }

        int start = 0;
        int end = arr.length-1;

        while (start < end){
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    //---------------------------------------------------------------------------------------------------------------
// Bitwise operations
    // find unique number in the array
    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 4, 2, 6, 4};
        System.out.println(unique(arr)); // 6
    }

    public static int unique(int[] arr){
        // num XOR num  = 0
        int unique = 0;

        for(int n : arr){
            unique ^= n;
        }
        return unique;
    }

    // find if the number is odd or even
    public static void main(String[] args) {
        int n = 16;
        System.out.println(isOdd(n));

        n = 67;
        System.out.println(isOdd(n));
    }

    public static boolean isOdd(int n){
        return (n & 1) == 1;
    }

    // left shift operator
    public static void main(String[] args) {
        int n = 10;
        System.out.println(n<<1); // left shift  by 1 doubles the number
        System.out.println(n<<4); // left shift by k increments the number by *2^k
        // here every time the number us shifted left every digit gets multiplied additional 2 to convert to decimal,
        // hences increases by the multiple of 2^k
    }

    // right shift operator
    public static void main(String[] args) {
        int n = 64;
        System.out.println(n>>1); // right shift by 1 halves the number
        System.out.println(n>>5); // right shift by k decreases the number by /2^k
    }

    // find ith bit of a number
    public static void main(String[] args) {
        int n = 20; // 10100
        // and with masked number
        System.out.println(find_ith_bit(3, n));
    }

    public static int find_ith_bit(int i, int n){
        if((n & (1<<(i-1))) == 0){
            return 0;
        }
        return 1;
    }

    // set the ith bit
    public static void main(String[] args) {
        int n = 41; // 101001
        int i = 3; // 3rd bit

        // set bit
        System.out.println(Integer.toBinaryString(n)); // 101001
        System.out.println(Integer.toBinaryString(setBit(4, n))); // 101101

    }
    public static int setBit(int i, int n){
        return n | (1<<(i-1));
    }

    // find the number of set bits in a number
    public static void main(String[] args) {
        int n = 180;
        System.out.println(Integer.toBinaryString(n)); // 10110100
        System.out.println(setBits_count(n)); // 4
    }

    public static int setBits_count(int n){
        int count = 0;
        while (n > 0){
            count++;
            n = n & (n-1);
        }
        return count;
    }

    // reset ith bit i.e 1->0, 0->1
    public static void main(String[] args) {
        int n = 86;
        int bit = 5;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(resetBit(findBit(bit, n), n, bit)));
    }

    public static int resetBit(boolean isZero, int n, int i){
        if (isZero){
            return n | (1<<(i-1));
        }
        return n & ~(1<<(i-1));
    }

    public static boolean findBit(int i, int n){
        return (n & (1<<(i-1))) == 0;
    }

     // find the position of the rightmost set bit
    public static void main(String[] args) {
        int n = 180;
        System.out.println(Integer.toBinaryString(n));
        System.out.println((int)(Math.log10(n & (-n))/Math.log10(2) + 1));
    }

    // find the non repeating number in an array if other nums repeat a constant times
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 2, 7, 7, 8, 8};
        System.out.println(findUnique(arr));
    }

    public static int findUnique(int[] arr){
        int unique = 0;
        for(int n : arr){
            unique ^= n;
        }
        return unique;
    }

     debug this soln later
    // find the none repeating number in an array if other nums repeat a constant times
    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 3, 2, 7, 7, 8, 7, 8, 8};

        // find the max length of the column required
        int collen = 0;
        for(int e: arr){
            int len = ((int)(Math.log10(e)/Math.log10(2)) + 1);
            if(collen < len){
                collen = len;
            }
        }
        int[][] multiDim = new int[arr.length][collen];
        int row = -1;

        // fill multiDim array with binary form of every number in array
        for (int e: arr) {
            row++;
//            multiDim[row] = new int[(int)(Math.log10(e)/Math.log10(2)) + 1];
            for (int n: binaryForm(e)) {
                multiDim[row][n] = 1;
            }
        }

//        // find the length of the longest row
//        int maxColumn = 0;
//        for (int[] ar: multiDim){
//            if(ar.length > maxColumn){
//                maxColumn = ar.length;
//            }
//        }

        int[] result = new int[collen];

        // add the column values of multiDim array into the result array
        for(int c = 0; c < collen; c++){
            for(int r = 0; r < multiDim.length; r++){
                result[c] += multiDim[r][c];
            }
        }

        // find the lowest num in the array
        int lowestnum = 0;
        for (int e: result){
            if (lowestnum > e){
                lowestnum = e;
            }
        }

        // find arr elements % lowestnum
        for(int i = 0; i < result.length; i++){
            result[i] = result[i] % lowestnum;
        }


        int ans = 0;
        int dec = 0;
        // find the decimal version of it
        for(int i = result.length-1; i >= 0; i--){
            ans = result[i] * (int)Math.pow(2, result.length-1-i);
            dec += ans;
        }

        System.out.println("the ans is " + dec);
    }

    // return an array with binary form of the num
    public static ArrayList<Integer> binaryForm(int n){
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (n != 0){
            arrayList.add(rightmostBitIndex(n)-1);
            n = n & ~n;
            System.out.println(Integer.toBinaryString(n));
        }
        return arrayList;
    }

    // method to find the position of the rightmost set bit
    public static int rightmostBitIndex(int n){
        return (int)(Math.log10(n & (-n))/Math.log10(2) + 1);
    }

//    public static void main(String[] args) {
//        int[][] arr = new int[3][];
//        arr[0] = new int[4];
//        arr[0][3] = 5;
////        arr[0][0] = 1;
//        System.out.println(arr[0][0]);
////        System.out.println(arr[0][1]);
//    }


    // find the nth magic number
    public static void main(String[] args){
        int n = 6;
        int ans = 0;
        int base = 1; // 5^0
        while(n>0){
            int k = n & 1;
            ans += k*5*base;
            base *= 5;
            n = n>>1;
        }
        System.out.println("ans: "+ans);
    }

    // find no. of digits in base b
    public static void main(String[] args) {
        int n = 31;
        System.out.println("number of digits: "+ Math.floor((Math.log(n)/Math.log(2))+1));
    }

    // you are given a number. find if it is a power of 2 or not
    public static void main(String[] args) {
        // for a number to be a power of 2 only 1 bit has to be a 1 and all other bits have to be 0's
        // ex: 32 = 100000 = 11111 + 1 = 100000 & 011111 = 0 , 18 = 10010 = 10010 & 01111 = 1
        int n = 32;
        if ((n & (n-1)) == 0){
            System.out.println(n + " is a power of 2");
         }else {
            System.out.println(n+" is not a power of 2");
        }
    }

    // calculate a^b using bitwise operation
    public static int getNumberOfbits(int num){
        //edge case
        if(num == 0 ){
            return 1;
        }
        int count = 0;
//        while(num > 0){
//            num = num/2;
//            count++;
//        }

        while (num != 0){
            count++;
            num = num >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int base = 3;
        int power = 5;
        int ans = 1;

        int count = getNumberOfbits(power);

        while (count > 0){
            if((power & 1)==1){ // check if the last bit is a 1
                ans = ans * base;
            }
            base = base * base;
            power = power >> 1;
            count--;
        }

        System.out.println("base^power: "+ ans); // 243
    }

    // given a number n, find the no. of set bits in it
    // example n = 9 = 1001 has 2 set bits
    public static void main(String[] args) {
        int a = 14;
        int count = 0;
        // n & (-n) gives the last set bit
        // n - (n & (-n)) gives the remaining, keep doing this until n = 0

        int n = a;
        while (n > 0){
            n = n - (n & (-n));
            count++;
        }
        System.out.printf("No. of set bits for %s is %d", Integer.toBinaryString(a), count); // No. of set bits for 1110 is 3
    }

    // second approach to above question
    // ex: n = 9; n & (n-1) => 1001 & 1000 = 1000 => 1000 & 0111 = 0 => count = 2
    public static void main(String[] args) {
        int n = 14;
        int count = 0;
        while (n > 0){
            n = n & (n-1);
            count++;
        }
        System.out.println("Number of set bits: " + count); // Number of set bits: 3
    }

    // Find XOR of nums from 0 to a
    // Note: after every 4 numbers there is a pattern
    // if a % 4 = 0 then XOR is a
    // if a % 4 = 1 then XOR is 1
    // if a % 4 = 2 then XOR is a+1
    // if a % 4 = 3 then XOR is 0
    public static void main(String[] args) {
        int a = 7;
        int xorResult = XORCalculator(a);
        System.out.println("XOR from o to "+a+ " is "+ xorResult);
    }

    public static int XORCalculator(int a){
        int xorResult = 0;
        int modResult = a % 4;
        if (modResult == 0){
            xorResult = 0;
        } else if (modResult == 1) {
            xorResult = 1;
        }else if (modResult == 2){
            xorResult = a + 1;
        } else {
            xorResult = 0;
        }
        return xorResult;
    }

    // find XOR of all numbers between a and b
    // a^b has repeated XORs 0 to a-1, hence, to find XORs between a and b => findXOR(a-1)^findXOR(b)
    public static void main(String[] args) {
        int a = 3;
        int b = 10;
        int xor = calculateXOR(a, b);
        System.out.println("XOR of numbers from "+ a + " to "+b+" inclusive: "+ xor);
    }

    public static int calculateXOR(int a, int b){
        // Calculate the XOR of numbers form o to a-1
        int xorA = getXOR(0, a-1);

        // Calculate the XOR of numbers form 0 to b
        int xorB = getXOR(0, b);

        // XOR result of step 1 with step 2
        return xorA ^ xorB;
    }

    // helper method to calculate XOR of numbers from start to end
    public static int getXOR(int start, int end){
        int result = 0;
        for(int i = start; i <= end; i++){
            result ^= i;
        }
        return result;
    }

    //---------------------------------------------------------------------------------------------------------------
    // Maths for DSA and Algo



}
