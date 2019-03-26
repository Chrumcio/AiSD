public interface Hash<K,V> {
    V get(K key);
    void put(K key, V value);
    boolean containsKey(K key);
    int size();
    boolean isEmpty();
    void resize();
    void dump(); //wyswietla tablice z pustymi
}
