class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer>map=new HashMap<>();
        int result=0;
        int cumsum=0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            cumsum+=nums[i];
            if(map.containsKey(cumsum-k)){
                result+=map.get(cumsum-k);
            }
            map.put(cumsum,map.getOrDefault(cumsum,0)+1);
        }
        return result; 
    }
}