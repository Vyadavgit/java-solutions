import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Rough {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 4};
//        System.out.println(Arrays.toString(swap(arr)));
        System.out.println(Arrays.toString(swapWithoutVar(arr)));
        swapWithoutVar1(3, 4);
    }

    public static int[] swap(int[] arr){
        int temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;
        return arr;
    }

    public static int[] swapWithoutVar(int[] arr){
        arr[0] = arr[0] + arr[1];
        arr[1] = arr[0] - arr[1];
        arr[0] = arr[0] - arr[1];
        return arr;
    }

    public static void swapWithoutVar1(int x, int y){
        x = x+y;
        y = x - y;
        x = x - y;
        System.out.println("x: "+ x + " y: "+ y);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1,3};
//        System.out.println(Arrays.toString(swap(arr[0], arr[1])));
        System.out.println(Arrays.toString(swapWtemp(arr[0], arr[1])));
    }

    public static int[] swap(int x, int y){
        int temp = x;
        x = y;
        y = temp;
        return new int[]{x, y};
    }

    public static int[] swapWtemp(int x, int y){
        x = x + y;
        y = x - y;
        x = x - y;
        return new int[]{x, y};
    }


    //-----------------
    // bubble sort
    public static void main(String[] args) {
        int[] arr = new int[]{
                832, 83, 21, 148, 206, 92, 234, 143, 25, 61, 37, 17, 34, 852, 162, 1672, 442, 448, 287, 268, 41, 645
        };

        for(int i = 0; i < arr.length-1; i++){
            for(int j = i+1; j<arr.length; j++){
                if(arr[i] > arr[j]){
                    swap(arr, i, j);
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

//----------------
// calculate the max
    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 3, 10, 8, 15};
        System.out.println(max(arr));
    //    System.out.println(maxRange(arr, 1, 4));
    }

    public static int max(int[] arr){
        //edge case
        if(arr.length == 0){
            return -1;
        }

        int max = arr[0];
        for(int i=1; i<arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }

    //----------------
    // swap and reverse
    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 10, 8, 15};
//        swap(arr, 1, 3);
//        System.out.println(Arrays.toString(arr));
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void reverse(int[] arr){
        // edge case
        if(arr.length ==0){
            System.out.println("array is empty");
        }

        for(int i=0; i<(arr.length)/2; i++){
            swap(arr, i, arr.length-i-1);
        }
    }

    public static void reverseImp(int[] arr){
        if(arr.length == 0){
            System.out.println("array is empty");
        }

        int start = 0;
        int end = arr.length-1;

        while (start < end){
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    //----------
    // find if it is prime number
    public static void main(String[] args) {
        System.out.println(isPrime(10));
    }

    public static boolean isPrime(int x){
        if(x <= 1){
            return false;
        }

        for(int i=2; i< Math.sqrt(x); i++){
            if(x%i == 0){
                return false;
            }
        }
        return true;
    }

    //--------------
    // find the prime numbers till N
    public static void main(String[] args) {
        int n = 20;
        System.out.println(listPrimes(n));
    }

    public static int[] listPrimes(int n){
        if(n<=1){
            return new int[]{};
        }

        for(int i = 2; )
    }


    //------------
    // find the factors of a number
    public static void main(String[] args) {
        int num = 20;
        System.out.println(factors(num));
    }

    public static ArrayList<Integer> factors(int num){
        ArrayList<Integer> list = new ArrayList<>();
        if(num == 1){
            list.add(1);
            return list;
        }

        for(int i=1; i<=Math.sqrt(num); i++){
            if(num % i == 0){
                list.add(i);
                if(i != Math.sqrt(num)){
                    list.add(num/i);
                }
            }
        }
        Collections.sort(list);
        return list;
    }




}
