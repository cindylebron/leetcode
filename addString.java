class Solution {
    public String addStrings(String num1, String num2) {
        int padding = 0;
        if (num1.length() > num2.length()){
            padding = num1.length() - num2.length();
            num2 = paddingZeros(padding, num2);
            
        } else {
            padding = num2.length() - num1.length();
            num1 = paddingZeros(padding, num1);
        }
        
        StringBuffer output = new StringBuffer("");
        int reminder = 0;
        
        for(int i=num1.length()-1; i>=0; --i){
            char c1 = num1.charAt(i);
            char c2 = num2.charAt(i);
            
            int result = (c1 - '0') + (c2 - '0') + reminder;
            
            reminder = result / 10;
            result = result % 10;
            
            output.insert(0, result);
        }
        if (reminder > 0){
            output.insert(0,reminder);
        }
        
        return output.toString();
    }
    
    private String paddingZeros(int num, String s){
            StringBuffer sb = new StringBuffer(s);
            for (int i=0; i<num; ++i){
                sb.insert(0,'0');
            }
            return sb.toString();
        }
}