class Solution {
    public boolean isAnagram(String s, String t) {
        // string to int array
        if (s.length() != t.length()) 
            return false;
        int[] ss = new int[s.length()];
        int[] tt = new int[t.length()];
        for (int i=0; i<s.length(); i++) {
            ss[i] = s.charAt(i) - 'a';
        }
        for (int i=0; i<t.length(); i++) {
            tt[i] = t.charAt(i) - 'a';
        }
        
        // Hashmap
        HashMap<Integer, Integer> freq_s = new HashMap<>();
        for (int i=0; i<ss.length; i++) {
            freq_s.put(ss[i], freq_s.getOrDefault(ss[i], 0) + 1);
        }
        HashMap<Integer, Integer> freq_t = new HashMap<>();
        for (int i=0; i<tt.length; i++) {
            freq_t.put(tt[i], freq_t.getOrDefault(tt[i], 0) + 1);
        }
        
        for (int i: freq_s.keySet()) {
            if (!freq_t.containsKey(i) || (freq_t.get(i) - freq_s.get(i)) != 0) {
                //if use a != b will cause overflow issue
                return false;
            }
        }
        
        return true;
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) 
            return false;
        // string to hash table
        int[] counter = new int[26];
        //increment counter for letter in s, decrement counter for letter in t
        for (int i=0; i<s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        
        
        for (int i: counter) {
            if (i != 0) 
                return false;
        }
        return true;
    }
}