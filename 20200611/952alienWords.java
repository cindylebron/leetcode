class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        boolean output = true;
        for (int i = 0; i < words.length-1; i++){
            if (compare(words[i], words[i+1], order) == false)
                output = false;
        }
        return output;
    }
    
    
    private boolean compare(String word1, String word2, String order){
        for (int i = 0; i < Math.min(word1.length(), word2.length()); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                char c1 = word1.charAt(i);
                char c2 = word2.charAt(i);
                if (order.indexOf(c1) > order.indexOf(c2)){
                    return false;
                } else 
                    return true;
            } 
        }
        if (word1.length() > word2.length())
            return false;
        return true; 
    }
}

/**
*   for (int i = 0; i < order.length(); ++i)
*       index[order.charAt(i) - 'a'] = i;
**/
