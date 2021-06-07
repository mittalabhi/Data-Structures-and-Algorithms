class RandomizedSet {
    HashMap<Integer,Integer> hm;
    ArrayList <Integer> ar;
        Random rand = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        hm= new HashMap<>();
        ar = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(hm.containsKey(val))
        {
            return false;
        }
        else
        {
            hm.put(val,ar.size());
            ar.add(val);
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(hm.containsKey(val))
        {
            int idx=hm.get(val);
            int cidx=ar.size()-1;
            hm.put(ar.get(cidx),idx);
            hm.remove(val);
            
            ar.set(idx,ar.get(cidx));
            ar.remove(cidx);
            return true;
        }
        else
            return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int idx = rand.nextInt(ar.size());
         return ar.get(idx);
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */