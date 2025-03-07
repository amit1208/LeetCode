class Solution {
public boolean isPrime(int inputNumber) {
    if (inputNumber <= 1) return false;  
    if (inputNumber == 2) return true;  
    if (inputNumber % 2 == 0) return false;

    int sqrt = (int) Math.sqrt(inputNumber);
    for (int i = 3; i <= sqrt; i += 2) {
        if (inputNumber % i == 0) return false;
    }
    
    return true;
}

       public int[] closestPrimes(int left, int right) {
        int[] arr = {-1, -1};
        int prevPrime = -1, minDiff = Integer.MAX_VALUE;

        // Iterate in increasing order
        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                if (prevPrime != -1) {
                    int diff = i - prevPrime;
                    if (diff < minDiff) {
                        minDiff = diff;
                        arr[0] = prevPrime;
                        arr[1] = i;
                    }
                }
                prevPrime = i;
            }
        }

        return arr;
    }
}