class Solution {
    
    public int getans(String s){
        
        int sum=0;
        for(int i=0;i<s.length();i++){
            
            sum+=s.charAt(i)-48;
        }
        return sum;
    }
    
    public int countSymmetricIntegers(int low, int high) {
        
        int ans=0;
        
        while(low<=high){
            
            String s=low+"";
            
            if(s.length()%2==0){
                int len=s.length();
                int half=len/2;
                String left=s.substring(0,half);
                String right=s.substring(half,len);
                
                int sum=getans(left);
                int sum2=getans(right);
                if(sum==sum2)
                    ans++;
            }
            low++;
        }
        
        return ans;
    }
}
