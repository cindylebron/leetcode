class Solution {
    public boolean isHappy(int n) {
        Set<Integer> s = new HashSet<>();
        s.add(n);
        while (n != 1){
            int sum = 0;
            while (n>0){
                int digit = n%10;
                n = n/10;
                sum += (digit*digit);
            }
            n = sum;
            if (s.contains(n)){
                return false;
            }
            s.add(n);
        }
        return true;
    }
}