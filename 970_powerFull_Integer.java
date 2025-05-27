class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> result = new HashSet<>();

        for (int i = 0; i == 0 || Math.pow(x, i) <= bound; i++) {
            int powX = (int) Math.pow(x, i);
            if (powX > bound) break;

            for (int j = 0; j == 0 || Math.pow(y, j) <= bound; j++) {
                int powY = (int) Math.pow(y, j);
                int sum = powX + powY;

                if (sum <= bound) {
                    result.add(sum);
                } else {
                    break; // since y^j is increasing
                }

                if (y == 1) break; // avoid infinite loop
            }

            if (x == 1) break; // avoid infinite loop
        }

        return new ArrayList<>(result);
    }
}
