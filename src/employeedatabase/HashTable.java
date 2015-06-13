/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package employeedatabase;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author slin
 * @param <Key>
 * @param <Value>
 */
public class HashTable<Key, Value> {
    private static final int BUCKET_SIZE = 6;
    private ArrayList<LinkedList<Pair>> table = new ArrayList<LinkedList<Pair>> ();
    
    private class Pair {
        private Key k;
        private Value v;
        
        public Pair(Key k, Value v) {
            this.k = k;
            this.v = v;
        }
        
        @SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object o) {
            return o!=null&&(o==this||(o.getClass()==getClass()&&((Pair)o).k.equals(k)));
	}
    }
    HashTable() {
        for (int i=0; i<BUCKET_SIZE; ++i)
            table.add(new LinkedList<Pair>());
    }
    
    public boolean contains(Key k) {
        return table.get(getIndex(k)).contains(new Pair(k,null));
    }
    private int getIndex(Key k) {
        return Math.abs(k.hashCode())%BUCKET_SIZE;
    }
    
    public void add(Key k, Value element) {
        if(!contains(k)) {
            table.get(getIndex(k)).add(new Pair(k, element));
        }
    }
    
    public Value get (Key k) {
        if(contains(k)) {
            for(Pair element : table.get(getIndex(k))) {
                if(element.k.equals(k))
                    return element.v;
            }
        }
        return null;
    }
    
    public void remove(Key k) {
        table.get(getIndex(k)).remove(new Pair(k,null));
    }
    
    void replace(Key k, Value element) {
        for(Pair e : table.get(getIndex(k))) {
            if(e.k.equals(k)){
                e.v = element;
            }
        }
    }
    
}