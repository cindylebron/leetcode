class Solution {
    public String addBinary(String a, String b) {
        if (a.equals("0"))
            return b;
        if (b.equals("0"))
            return a;
        
        int l1 = a.length() - 1;
        int l2 = b.length() - 1;
        int carry = 0;
        String result = "";
        
        
        while (l1 >=0 || l2 >= 0 || carry == 1) {
            if (l1 >=0) {
                //charAt return a char, + "" converts it to a string
                carry += Integer.parseInt(a.charAt(l1)+"");
                l1--;
            }
            if (l2 >=0) {
                //charAt return a char, + "" converts it to a string
                carry += Integer.parseInt(b.charAt(l2)+"");
                l2--;
            }
            //add string in front of the result
            result = String.valueOf(carry % 2) + result; 
            carry = carry / 2;
            
        }
        
        return result;
    }
}