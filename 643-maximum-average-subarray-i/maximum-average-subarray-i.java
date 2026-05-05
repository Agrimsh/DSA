class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int window=0;
        for(int i=0;i<k;i++){
            window+=nums[i];
        }
        int result=window;
        for(int i=k;i<nums.length;i++){
            window+=nums[i];
            window-=nums[i-k];

            result=Math.max(result,window);
        }
        return (double) result/k;
        
    }
}