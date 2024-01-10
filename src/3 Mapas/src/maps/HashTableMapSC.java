package maps;

import java.util.*;

/**
 * Separate chaining table implementation of hash tables. Note that all
 * "matching" is based on the equals method.
 *
 * @author A. Duarte, J. Vélez, J. Sánchez-Oro
 * @param <K> The key
 * @param <V> The stored value
 */
public class HashTableMapSC<K, V> implements Map<K, V> {

    private class HashEntry<T, U> implements Entry<T, U> {
        protected T key;

        protected U value;
        
        public HashEntry(T k, U v) {
            key = k;
            value = v;
        }

        public void setKey(T key) {
            this.key = key;
        }

        public void setValue(U value) {
            this.value = value;
        }

        @Override
        public T getKey() {
            return key;
        }

        @Override
        public U getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o.getClass() != this.getValue())) return false;
            HashEntry<?, ?> hashEntry = (HashEntry<?, ?>) o;
            return Objects.equals(key, hashEntry.key) && Objects.equals(value, hashEntry.value);
        }
        

        /**
         * Entry visualization.
         */
        @Override
        public String toString() {
            return "{" + key + ", " + value + "}";
            
        }
    }

    private class HashTableMapIterator<T, U> implements Iterator<Entry<T, U>> {

        private Deque<HashEntry<T, U>> queue;
        private List<HashEntry<T, U>>[] map;
        private int n;
        public HashTableMapIterator(List<HashEntry<T, U>>[] map, int numElems) {
            this.map = map;
            queue = new LinkedList<>();
            this.n = numElems;
            
            for (List<HashEntry<T, U>> auxList : map){
                if (auxList != null) {
                    for (HashEntry<T, U> auxEntry : auxList) {
                        if (auxEntry != null){
                            this.queue.addFirst(auxEntry);
                        }
                    }
                }
            }
        }

        @Override
        public boolean hasNext() {
            return this.queue.size() > 0;
        }

        @Override
        public Entry<T, U> next() {
            return this.queue.removeLast();
        }

        @Override
        public void remove() {
            // NO HAY QUE IMPLEMENTARLO
            throw new UnsupportedOperationException("Not implemented.");
        }
    }

    private class HashTableMapKeyIterator<T, U> implements Iterator<T> {

        public HashTableMapKeyIterator(HashTableMapIterator<T, U> it) {
            throw new UnsupportedOperationException("Not yet implemented");
        }

        @Override
        public T next() {
            throw new UnsupportedOperationException("Not yet implemented");
        }

        @Override
        public boolean hasNext() {
            throw new UnsupportedOperationException("Not yet implemented");
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not implemented.");
        }
    }

    private class HashTableMapValueIterator<T, U> implements Iterator<U> {

        public HashTableMapValueIterator(HashTableMapIterator<T, U> it) { throw new UnsupportedOperationException("Not yet implemented"); }

        @Override
        public U next() { throw new UnsupportedOperationException("Not yet implemented"); }

        @Override
        public boolean hasNext() { throw new UnsupportedOperationException("Not yet implemented"); }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not implemented.");
        }
    }


    private int n; // Number of entries
    private int cap; // capacity of the bucket
    private List<HashEntry<K, V>> [] bucket;
    private int a, b, prime;

    /**
     * Creates a hash table
     */
    public HashTableMapSC() {
        this(50);
    }

    /**
     * Creates a hash table.
     *
     * @param cap initial capacity
     */
    public HashTableMapSC(int cap) {
        this(101, cap);
    }

    /**
     * Creates a hash table with the given prime factor and capacity.
     *
     * @param p prime number
     * @param cap initial capacity
     */
    public HashTableMapSC(int p, int cap) {
        this.n = 0;
        this.cap = cap;
        this.bucket = new List[this.cap];
        this.prime = p;
        Random rand = new Random(this.cap);
        a = rand.nextInt(prime - 1) + 1;
        b = rand.nextInt(prime);
    }

    /**
     * Hash function applying MAD method to default hash code.
     *
     * @param key Key
     * @return
     */
    protected int hashCode(K key) {
        int x = key.hashCode();
        return (a*x + b) % prime;
    }

    /**
     * Calculate the dispersed key.
     * Calculate the hash code and apply the compression function.
     *
     * @param key Key
     * @return
     */
    protected int hashValue(K key) {
         int hash = hashCode(key);
         return Math.abs(hash) % this.cap;
    }

    /**
     * Returns the number of entries in the hash table.
     *
     * @return the size
     */
    @Override
    public int size() {
        return this.n;
    }

    /**
     * Returns whether or not the table is empty.
     *
     * @return true if the size is 0
     */
    @Override
    public boolean isEmpty() {
        return this.n == 0;
    }

    private V findValue(K key, List<HashEntry<K, V>> list){
        for(HashEntry<K, V> entry : list){
            if(entry.getKey().equals(key)){
                return entry.getValue();
            }
        }
        return null;
    }
    /**
     * Returns the value associated with a key.
     *
     * @param key
     * @return value
     */
    @Override
    public V get(K key) throws IllegalStateException {
        int index = hashValue(key);
        List<HashEntry<K, V>> B = this.bucket[index];

        if (B == null || B.isEmpty()){
            return null;
        }
        else {
            return this.findValue(key, B);
        }
    }

    /**
     * Put a key-value pair in the map, replacing previous one if it exists.
     *
     * @param key
     * @param value
     * @return value
     */
    @Override
    public V put(K key, V value) throws IllegalStateException {
        int index = hashValue(key);
        List<HashEntry<K, V>> B = this.bucket[index];
        V oldValue = null;
        HashEntry<K, V> newEntry = new HashEntry<>(key, value);

        if (B == null){
            B = new LinkedList<>();
        }
        else{
            oldValue = this.findValue(key, B);

            if (oldValue != null) {
                B.remove(new HashEntry<>(key, oldValue));
                this.n--;
            }
        }

        B.add(newEntry);
        this.bucket[index] = B;

        this.n++;
        return oldValue;
    }

    /**
     * Removes the key-value pair with a specified key.
     *
     * @param key
     * @return
     */
    @Override
    public V remove(K key) throws IllegalStateException {
        int index = hashValue(key);
        List<HashEntry<K, V>> B = this.bucket[index];
        V returnValue = null;

        if (B == null || B.isEmpty()){
            return returnValue;
        }
        else{
            returnValue = this.findValue(key, B);
            if (returnValue == null){
                return returnValue;
            }
            B.remove(new HashEntry<K, V>(key, returnValue));
            this.n--;
            this.bucket[index] = B;
        }
        return returnValue;
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {throw new UnsupportedOperationException("Not yet implemented");}

    /**
     * Returns an iterable object containing all of the keys.
     *
     * @return
     */
    @Override
    public Iterable<K> keys() {throw new UnsupportedOperationException("Not yet implemented");}

    /**
     * Returns an iterable object containing all of the values.
     *
     * @return
     */
    @Override
    public Iterable<V> values() {throw new UnsupportedOperationException("Not yet implemented");}

    /**
     * Returns an iterable object containing all of the entries.
     *
     * @return
     */
    @Override
    public Iterable<Entry<K, V>> entries() {throw new UnsupportedOperationException("Not yet implemented");}

    /**
     * Determines whether a key is valid.
     *
     * @param k Key
     */
    protected void checkKey(K k) {
        // We cannot check the second test (i.e., k instanceof K) since we do not know the class K
        if (k == null) {
            throw new IllegalStateException("Invalid key: null.");
        }
    }

    /**
     * Increase/reduce the size of the hash table and rehashes all the entries.
     * @param newCap
     */
    protected void rehash(int newCap) {throw new UnsupportedOperationException("Not yet implemented");}

}


