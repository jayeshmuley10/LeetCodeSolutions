class Solution {
    public long minimumPossibleSum(int n, int target) {
        
        
        int k=target;
        HashSet<Long> h=new HashSet<>();
        
        long sumt=0;
        
        long firstr=1;
        
        while(n>0){
            
            long sec=(long)k-firstr;
            
            if(h.contains(firstr)==false){
                sumt+=firstr;
                n--;
            }
            h.add(sec);
            firstr++;
        }
        
        return sumt;
        
    }
}
