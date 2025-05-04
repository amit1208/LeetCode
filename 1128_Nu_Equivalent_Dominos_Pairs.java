class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] map = new int[100]; // since 1 <= a, b <= 9, a*10 + b is max 99
        int count = 0;

        for (int[] d : dominoes) {
            int a = d[0], b = d[1];
            int key = a < b ? a * 10 + b : b * 10 + a; // normalize the domino
            count += map[key]; // all previous same dominoes can form a pair with this one
            map[key]++;
        }

        return count;
    }
}

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;
        for (int i = 0; i < dominoes.length; i++) {
            for (int j = i + 1; j < dominoes.length; j++) {

                if (dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1] ||
        dominoes[i][0] == dominoes[j][1] && dominoes[i][1] == dominoes[j][0]) {
                    count++;
                }
            }
        }
        return count;
    }
}
