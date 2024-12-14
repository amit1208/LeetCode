class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && 
                ((stack.peek() == 'A' && c == 'B') || 
                 (stack.peek() == 'C' && c == 'D'))) {
                stack.pop(); 
            } else {
                stack.push(c);
            }
        }
        return stack.size();
    }
}




// class Solution {
//     public int minLength(String s) {
//         StringBuilder str = new StringBuilder(s);
//         while (str.indexOf("AB") != -1 || str.indexOf("CD") != -1) {   
//             String temp = str.toString().replaceAll("AB|CD", "");
//             str = new StringBuilder(temp);
//         }
//         return str.length();
//     }
// }
