class Solution {
    public int countCompleteSubarrays(int[] nums) {
        
        int lent=nums.length;
        
        HashSet<Integer> hm=new HashSet<>();
        
        for(int i=0;i<lent;i++){
            
            int val=nums[i];
            hm.add(val);
        }
        
        int si=hm.size();
        
        int ans=0;
        for(int i=0;i<lent;i++){
            
            
            HashSet<Integer> ht=new HashSet<>();
            
            for(int j=i;j<lent;j++){
                
                ht.add(nums[j]);
                if(ht.size()==si){
                    ans++;
                }
            }
        }
        
        return ans;
        
    }
}
