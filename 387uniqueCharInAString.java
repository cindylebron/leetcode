class Solution {
    public int firstUniqChar(String s) {
        HashMap <Character, Integer> freq = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i=0; i<chars.length; i++) {
            freq.put(chars[i], freq.getOrDefault(chars[i],0) + 1); 
        }
        for (char c: chars) {
            if (freq.get(c) == 1) 
                return s.indexOf(c);
        }
        return -1;
    }
}