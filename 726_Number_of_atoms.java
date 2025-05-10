
import java.util.*;

class Solution {
    public String countOfAtoms(String formula) {
        Deque<Map<String, Integer>> stack = new ArrayDeque<>();
        stack.push(new HashMap<>());
        int i = 0, n = formula.length();

        while (i < n) {
            char ch = formula.charAt(i);

            if (ch == '(') {
                stack.push(new HashMap<>());
                i++;
            } else if (ch == ')') {
                i++;
                int start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int val = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;

                Map<String, Integer> top = stack.pop();
                for (String key : top.keySet()) {
                    int count = top.get(key);
                    stack.peek().put(key, stack.peek().getOrDefault(key, 0) + count * val);
                }
            } else {
                int start = i;
                i++;  // Move past first uppercase letter
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String atom = formula.substring(start, i);

                start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int val = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;

                stack.peek().put(atom, stack.peek().getOrDefault(atom, 0) + val);
            }
        }

        Map<String, Integer> result = stack.pop();
        List<String> keys = new ArrayList<>(result.keySet());
        Collections.sort(keys);

        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            sb.append(key);
            int count = result.get(key);
            if (count > 1) {
                sb.append(count);
            }
        }

        return sb.toString();
    }
}
