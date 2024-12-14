package sliding.window.maximum;

import java.util.ArrayDeque;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        // Create an integer array of size n - k  + 1
        int[] maxs = new int[nums.length - k + 1];
        ArrayDeque<Integer> queue =  new ArrayDeque<>();

        for(int i = 0 ; i < nums.length; i++){
            int num = nums[i];
            while(!queue.isEmpty() && nums[queue.getLast()] < num){
                queue.removeLast();
            }
            queue.add(num);
            System.out.println("---- Current queue - at index - " + i + " > " + queue) ;

        }

        return maxs ;
    }



//         System.out.println("----") ;


    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7} ;
        int k = 3 ;

        Solution sol = new Solution();
        sol.maxSlidingWindow(nums, k) ;
    }
}

