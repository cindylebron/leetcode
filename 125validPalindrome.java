class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty() || s.length() == 0) return true;
        
        String ls = s.toLowerCase();
        int i = s.length() -1;
        int j = 0;
        while (j <= i) {
            if (!Character.isLetterOrDigit(ls.charAt(i))) {
                i--;
                continue;
            } 
            if (!Character.isLetterOrDigit(ls.charAt(j))) {
                j++;
                continue;
            }
            if (ls.charAt(i) == ls.charAt(j)) {
                i--;
                j++;
            } else {
                return false;
            }
            
        }
        return true;
    }
}