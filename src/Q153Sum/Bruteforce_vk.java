package Q153Sum;

import java.util.ArrayList;
import java.util.List;

// 269 / 312 testcases passed
public class Bruteforce_vk {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                for(int k = j+1; k < nums.length; k++){
                    if(nums[i]+nums[j]+nums[k] == 0 && i!=j && j!=k && k!=i){
                        List<Integer> list_temp = new ArrayList<>();
                        list_temp.add(nums[i]);
                        list_temp.add(nums[j]);
                        list_temp.add(nums[k]);
                        if(!exists(list_temp, list)){
                            list.add(list_temp);
                        }
                    }
                }
            }
        }
        return list;
    }

    public static boolean exists(List<Integer> list_temp, List<List<Integer>> list){
        for(List<Integer> l: list){
            int i = 1;
            for(Integer e: l){
                if(list_temp.contains(e)){
                    i = i & 1;
                }else {
                    i = i & 0;
                }
            }
            if(i==1){return true;}
        }
        return false;
    }
}
