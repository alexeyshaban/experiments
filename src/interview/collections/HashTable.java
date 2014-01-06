package interview.collections;

public class HashTable<K, V> {

    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;
        
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        
    }
    
    private Entry<K, V>[] table;
    
    @SuppressWarnings("unchecked")
    public HashTable(int size) {
        table = new Entry[size];
    }
    
    public V put(K key, V value) {
        int pos = getPosition(key);
        if (table[pos] == null) {
            table[pos] = new Entry<>(key, value);
            return null;
        } else {
            Entry<K, V> entry = table[pos];
            Entry<K, V> prev = null;
            while (entry != null) {
                if (key.equals(entry.key)) {
                    V result = entry.value;
                    entry.value = value;
                    return result;
                }
                prev = entry;
                entry = entry.next;
            }
            prev.next = new Entry<>(key, value);
            return null;
        }
    }

    private int getPosition(K key) {
        return Math.abs(key.hashCode() % table.length);
    }
    
    public V get(K key) {
        Entry<K, V> entry = table[getPosition(key)];
        while (entry != null) {
            if (key.equals(entry.key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }
}
