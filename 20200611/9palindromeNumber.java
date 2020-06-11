class Solution {
    public boolean isPalindrome(int x) {
        if (x<0) 
            return false;
        int xx = x;
        int y = 0;
        while (xx > 0) {
            int reminder = xx % 10;
            y = 10*y + reminder;
            xx = xx/10;
        }
        return x == y;
        
    }
}

