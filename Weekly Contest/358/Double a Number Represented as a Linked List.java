class Solution {
    public ListNode doubleIt(ListNode head) {
        
        List<Integer> li=new ArrayList<>();
        
        ListNode temp=head;
        
        while(temp!=null){
            
            li.add(temp.val);
            temp=temp.next;
        }
        
        List<Integer> li2=new ArrayList<>();
        
        int rem=0;
        
        for(int i=li.size()-1;i>=0;i--){
            
            int val=li.get(i);
            val=val*2;
            
            val+=rem;
            
            String p=val+"";
            
            if(p.length()==2){
                li2.add(p.charAt(1)-48);
                rem=p.charAt(0)-48;
            }else{
            li2.add(p.charAt(0)-48);
                rem=0;
            }
        }
        
        if(rem>0)
            li2.add(rem);
        
        System.out.println(li2);
        
        Collections.reverse(li2);
        
       
        ListNode prevt=new ListNode();
       
        
        ListNode tm=prevt;
        
        for(int i=0;i<li2.size();i++){
            
            int valt=li2.get(i);
             ListNode nw=new ListNode();
            nw.val=valt;
            prevt.next=nw;
            prevt=nw;
        }
        
        return tm.next;
        
    }
}
