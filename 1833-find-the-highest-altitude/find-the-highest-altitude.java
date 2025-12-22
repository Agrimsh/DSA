class Solution {
    public int largestAltitude(int[] gain) {
        int maxgain=0;
        int curralt=0;
        for(int i=0;i<gain.length;i++){
            curralt=curralt+gain[i];
            maxgain=Math.max(maxgain,curralt);
        }
        return maxgain;  
    }
}