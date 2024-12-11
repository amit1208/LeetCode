import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } 
            else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } 
            else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else {
                return false; 
            }
        }
        
       return stack.isEmpty();
    }
}



// class Solution {
//     public boolean isValid(String s) {

//     HashMap<Character,Float> map=new HashMap<>();
//     map.put('(',1.203f);
//     map.put('[',2.605f);
//     map.put('{',1.101f);
//     map.put(')',-1.203f);
//     map.put('}',-1.101f);
//     map.put(']',-2.605f);

//     float count=0.0f;
//         for(int i=0;i<s.length();i++){   
//         count +=map.get(s.charAt(i));
//         }
//      return count== 0.0f ? true:false;
//     }
// }