class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
                sb.append(c);
            } else if (c == ')') {
                if (open > 0) {
                    open--;
                    sb.append(c);
                }
            } else {
                sb.append(c);
            }
        }

        StringBuilder result = new StringBuilder();
        int balance = 0;
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            if (c == '(' && balance > 0) {
                balance--;
            } else if (c == '(') {
                continue;
            } else if (c == ')') {
                balance++;
            }
            result.append(c);
        }

        return result.reverse().toString();
    }
}
