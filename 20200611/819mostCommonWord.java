class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> banset = new HashSet();
        for(String s: banned) {
            banset.add(s);
        }
        String ans = "";
        int freq = 0;
        
        Map<String, Integer> words = new HashMap();
        String ls = paragraph.toLowerCase();
        String[] text =ls.split("\\W");
        for (String word: text){
            if (word.matches("[a-z]+")){
                if (!banset.contains(word)) {
                    words.put(word, words.getOrDefault(word, 0) + 1);
                    if (words.get(word) > freq) {
                        ans = word;
                        freq = words.get(word);
                    }
                }
           } 
        }
        return ans;
    }
}