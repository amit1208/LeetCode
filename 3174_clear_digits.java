class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb=new StringBuilder(s);

        while(sb.indexOf(part)!=-1){
            sb.delete(sb.indexOf(part),sb.indexOf(part)+part.length());
        }

        return sb.toString();            

    }
}



// class Solution {

//     public String removeOccurrences(String s, String part) {
//         if(s.equals(part)) return '' ;
//         if(s.length()<part.length()) return s;

//         Stack<Character> st=new Stack<>();
//         int plen=part.length()-1;

//          for(char c:s.toCharArray()){

//             if(c == part.charAt(plen))
//                 {

//                     while(plen>0){
//                         if(st.peek()==part.charAt(--plen)){
//                             st.pop();
//                     }
//                     else {break;}

//                     }
//                     st.pop();
//                 }
//             else{
//                 st.push(c);
//             }

//          }



//         StringBuilder result = new StringBuilder();

//         for(char ch:st) {
//             result.append(ch);
//         }
        
//         return result.toString();

//     }
// }