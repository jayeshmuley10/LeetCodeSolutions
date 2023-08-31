class Solution {
    
    public int getMax(String s){
        
        int max=s.charAt(0)-48;
        
        for(int i=1;i<s.length();i++){
            
            int val=s.charAt(i)-48;
            if(val>max)
                max=val;
        }
        return max;
    }
    
    public int maxSum(int[] nums) {
        
        int lent=nums.length;
        
        int maxt=-1;
        
        for(int i=0;i<lent-1;i++){
            
            for(int j=i+1;j<lent;j++){
                
                String a=nums[i]+"";
                String b=nums[j]+"";
                
                int val1=getMax(a);
                int val2=getMax(b);
                
                if(val1==val2){
                    
                    int sum=nums[i]+nums[j];
                    if(sum>maxt)
                        maxt=sum;
                }
                
            }
        }
        
        return maxt;
    }
}
