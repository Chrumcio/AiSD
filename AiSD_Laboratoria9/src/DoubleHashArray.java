import java.util.Arrays;

public class DoubleHashArray<K, V> implements Hash<K, V> {
    Entry[] entries;
    int m;
    int n;

    public DoubleHashArray(){
        entries = (DoubleHashArray<K,V>.Entry[]) (new DoubleHashArray.Entry[13]);
        m = 13;
        n = 0;
    }

    @Override
    public V get(K key) {
        Entry v = null;
        if(containsKey(key)){
            for (int i=key.hashCode()%m; i<=m; i++) {
                if(i==m){
                    i=0;
                }
                if(entries[i] != null)
                    if (entries[i].key == key){
                        v = entries[i];
                        break;
                    }
            }
        }
        return v.value;
    }

    @Override
    public void put(K key, V value) {
        if(((double)n/m)>0.5) {
            resize();
        }
        //System.out.println((double)n/m);
        //System.out.println(key.hashCode()%m);
        put(key, value, entries);
        n++;
    }
    private void put(K key, V value, Entry[] tab){
        if(containsKey(key, tab)){
            boolean wstawiaj = true;
            for (int i=0; wstawiaj; i++){
                int ind = (key.hashCode() + i*hashCode2(key))%m;
                if(tab[ind] == null) {
                    tab[ind] = new Entry(key, value);
                    wstawiaj = false;
                }
            }
        }else {
            int k = key.hashCode() % m;
            tab[k] = new Entry(key, value);
        }
    }
    @Override
    public boolean containsKey(K key) {
        return containsKey(key, entries);
    }
    private boolean containsKey(K key, Entry[] tab) {
        return tab[key.hashCode()%m]== null ? false : true;
    }
    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n==0 ? true : false;
    }

    @Override
    public void resize() {
        m = m*2;
        Entry[] tmp = (DoubleHashArray<K,V>.Entry[]) (new DoubleHashArray.Entry[m]);

        for (int i =0 ; i<entries.length ; i++){
            if(entries[i] != null){
                put(entries[i].key, entries[i].value, tmp);
            }
        }
        entries = tmp;
    }

    @Override
    public void dump() {
        System.out.println(Arrays.toString(entries));
    }

    private int hashCode2(K key) {
        int hash = 1;
        hash = Integer.parseInt((String) key) * 3;
        return hash;
    }
    private class Entry{
        K key;
        V value;

        private Entry(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}
