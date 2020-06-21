class Solution {
    //regular BFS, time complexity O(N*M)
    //where N is size of the dictionary and M is the length of the word.
    //1.while (!queue.isEmpty()): O(N), only word in the dictionary will be added to the queue
    //2. for (int j = 0; j < current.length; j++): O(M), traverse current string
    //3.for (char c = 'a'; c <= 'z'; c++): worst case: O(26 - 1)
    //4.total: O(N * M * 25) = O(M * N)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet();
        // add word to a set
        for (String word: wordList) {
            set.add(word);
        }
        // endWord not in wordlist, return 0
        if (!set.contains(endWord))
            return 0;
        
        Queue<String> queue = new LinkedList();
        queue.offer(beginWord); //push word
        //count number of words transformed
        int level = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            // for all words in ths round
            for (int i=0; i<size; i++) {
                //poll word from the queue
                String current_word = queue.poll();
                char[] word_char = current_word.toCharArray();
                // traverse current word
                for (int j=0; j<word_char.length; j++) {
                    char original_char = word_char[j];
                    //loop through alphabet 
                    for (char c='a'; c<='z'; c++) {
                        if (word_char[j] == c) continue;
                        word_char[j] = c;
                        String new_word = String.valueOf(word_char);
                        if (new_word.equals(endWord)) 
                            return level + 1;
                        if (set.contains(new_word)) {
                            System.out.println(new_word);
                            queue.offer(new_word); //push it in the queue
                            set.remove(new_word); //remove from the set
                        }
                    }
                    // have to undo for next change of letter
                    word_char[j] = original_char;
                }
            }
            System.out.println(level);
            // this round ends with one letter changed
            level++;
        }
        
        return 0;
    }
}