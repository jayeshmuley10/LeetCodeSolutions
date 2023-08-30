class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        
        int len=moves.length();
        
        int lcountt=0;
        int rcountt=0;
        int space=0;
        
        for(int i=0;i<len;i++){
            
            char c=moves.charAt(i);
            if(c=='L'){
                lcountt++;
            }else if(c=='R'){
                rcountt++;
            }else{
                space++;
            }
        }
        
        if(space==len){
            return len;
        }else{
            
            String str="";
            char put=0;
            if(lcountt==rcountt){
                put='R';
            }else if(lcountt>rcountt){
                put='L';
            }else{
                put='R';
            }
            
            for(int i=0;i<len;i++){
                
                char c=moves.charAt(i);
                if(c=='_'){
                    str=str+""+put+"";
                }else
                    str=str+c+"";
            }
          //  System.out.println(str);
            int start=0;
            
            for(int i=0;i<len;i++){
                
                char c=str.charAt(i);
                if(c=='L'){
                    start--;
                }else{
                    start++;
                }
            }
            
            if(start<0)
                return start*-1;
            else
                return start;
        }
        
        
        
    }
}
