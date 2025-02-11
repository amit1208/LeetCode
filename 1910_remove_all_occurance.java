class Solution {
    public Stack<Character> stackfun(String s,String part,Stack<Character> st,int plen,char temp){

        for(Char c:toCharArray()){
            if(c==part.charAt[plen]){
                {
                    while(plen>=0){
                        if(st.peek()==part.charAt[plen]){
                            st.pop();
                    }
                    else{
                        break;
                    }
                    plen--;

                    }
                }
            else{
                st.push(c);
            }
               
               
               char temp=st.pop();
               stackfun(s,part,st,plen-1,temp);
                
            }
            else{
                st.push(c);
            }
        }
    }

    public String removeOccurrences(String s, String part) {
        if(s.equals(part)) retrun null ;
        if(s.length()<part.length()) return s;

        Stack<Character> st=new Stack<>();
        char temp='';
        int plen=part.length()-1;



         for(Char c:toCharArray()){
            if(c==part.charAt[plen]){
                {
                    while(plen>=0){
                        if(st.peek()==part.charAt[plen]){
                            st.pop();
                    }
                    plen--;

                    }
                }
            else{
                st.push(c);
            }

        // stackfun(s,part,st,plen,temp);


        StringBuilder result = new StringBuilder();
        for (char ch : st) {
            result.append(ch);
        }
        
        return result.toString();

    }
}