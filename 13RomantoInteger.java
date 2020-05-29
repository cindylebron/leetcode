class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        for (int i=0; i < s.length(); i++) {
            switch(s.charAt(i)){
                case 'I':
                    ans += 1;
                    break;
                case 'V':
                    if (i>0 && s.charAt(i-1) == 'I') {
                        ans += -1 + 4;
                    } else {
                        ans += 5;
                    }
                    break;
                case 'X':
                    if (i>0 && s.charAt(i-1) == 'I') {
                        ans += -1 + 9;
                    } else 
                        ans += 10;
                    break;
                case 'L':
                    if (i>0 && s.charAt(i-1) == 'X') {
                        ans += -10 + 40;
                    } else 
                        ans += 50;
                    break;
                case 'C':
                    if (i>0 && s.charAt(i-1) == 'X') {
                        ans += -10 + 90;
                    } else 
                        ans += 100;
                    break;
                case 'D':
                    if (i>0 && s.charAt(i-1) == 'C') {
                        ans += -100 + 400;
                    } else 
                        ans += 500;
                    break;
                case 'M':
                    if (i>0 && s.charAt(i-1) == 'C') {
                        ans += -100 + 900;
                    } else 
                        ans += 1000;
                    break;
                default:
                    ans += 0;
            }
        }
        return ans;
    }
}