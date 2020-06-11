class Solution {
    //mapping two parenthesis
    private HashMap<Character, Character> mappings;
    
    public Solution() {
        mappings = new HashMap<>();
        // Use closing bracket as keys, and opening bracket as values
        mappings.put(')','(');
        mappings.put(']','[');
        mappings.put('}','{');
    }
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if (mappings.containsKey(c)) {
                // declare outside if-else block
                char topElement;
                if (stack.empty()){
                    topElement = '?';
                } else {
                    topElement = stack.pop();
                }
                if (topElement != mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack 
                stack.push(c);
            }
        }
        
        // If the stack contains elements, return false
        return stack.isEmpty();
    }
}

