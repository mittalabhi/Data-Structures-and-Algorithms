class Trie {

    /** Initialize your data structure here. */
    class Node{
        boolean isLast;
        Node children[] = new Node[26];
        Node(boolean isLast){
            this.isLast = isLast;
        }
    }
    Node root;
    public Trie() {
        root = new Node(false);
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node temp = root;
        for(int i = 0;i < word.length();i++){
            char ch = word.charAt(i);
            if(temp.children[ch - 'a'] == null){
                temp.children[ch - 'a'] = new Node(false);
            }
            temp = temp.children[ch - 'a'];
        }
        temp.isLast = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node temp = root;
        for(int i = 0;i < word.length();i++)
        {
            char ch = word.charAt(i);
            if(temp.children[ch - 'a'] == null) return false;
            temp = temp.children[ch  - 'a'];
        }
        return temp.isLast;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String word) {
        Node temp = root;
        for(int i = 0;i < word.length();i++)
        {
            char ch = word.charAt(i);
            if(temp.children[ch - 'a'] == null) return false;
            temp = temp.children[ch  - 'a'];
        }
        return true;
    }
    }


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */