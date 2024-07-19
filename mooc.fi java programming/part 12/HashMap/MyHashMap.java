import java.util.List;

public class MyHashMap<K, V> {

    private MyList<Pair<K, V>>[] values;
    private int firstFreeIndex;

    public MyHashMap() {
        this.values = new MyList[32];
        this.firstFreeIndex = 0;
    }

    public void add(K key, V value) {
        MyList<Pair<K, V>> valuesAtIndex = getListBasedOnKey(key);
        int index = getIndexOfKey(valuesAtIndex, key);
    
        if (index < 0) {
            valuesAtIndex.add(new Pair<>(key, value));
            this.firstFreeIndex++;
        } else {
            valuesAtIndex.get(index).setValue(value);
        }
    
        if (1.0 * this.firstFreeIndex / this.values.length > 0.75) {
            grow();
        }
    }

    public V get(K key) {
        int hashValue = Math.abs(key.hashCode() % this.values.length);
        if (this.values[hashValue] == null) {
            return null;
        }
    
        MyList<Pair<K, V>> valuesAtIndex = this.values[hashValue];
    
        for (int i = 0; i < valuesAtIndex.size(); i++) {
            if (valuesAtIndex.get(i).getKey().equals(key)) {
                return valuesAtIndex.get(i).getValue();
            }
        }
    
        return null;
    }

    private MyList<Pair<K, V>> getListBasedOnKey(K key) {
        int hashValue = Math.abs(key.hashCode() % values.length);
        if (values[hashValue] == null) {
            values[hashValue] = new MyList<>();
        }
    
        return values[hashValue];
    }
    
    private int getIndexOfKey(MyList<Pair<K, V>> myList, K key) {
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).getKey().equals(key)) {
                return i;
            }
        }
    
        return -1;
    }

    private void copy(MyList<Pair<K, V>>[] newArray, int fromIdx) {
        if (this.values[fromIdx] == null) {
            return;  // Skip if the bucket is empty
        }
    
        for (int i = 0; i < this.values[fromIdx].size(); i++) {
            Pair<K, V> value = this.values[fromIdx].get(i);
    
            int hashValue = Math.abs(value.getKey().hashCode() % newArray.length);
            if(newArray[hashValue] == null) {
                newArray[hashValue] = new MyList<>();
            }
    
            newArray[hashValue].add(value);
        }
    }


    private void grow() {
        // create a new array
        MyList<Pair<K, V>>[] newArray = new MyList[this.values.length * 2];
    
        for (int i = 0; i < this.values.length; i++) {
            // copy the values of the old array into the new one
            if (this.values[i] != null) {  // Only copy if the bucket is not null
                copy(newArray, i);
            }
        }
    
        // replace the old array with the new
        this.values = newArray;
    }

    public V remove(K key) {
        MyList<Pair<K, V>> valuesAtIndex = getListBasedOnKey(key);
        if (valuesAtIndex.size() == 0) {
            return null;
        }
    
        int index = getIndexOfKey(valuesAtIndex, key);
        if (index < 0) {
            return null;
        }
    
        Pair<K, V> pair = valuesAtIndex.get(index);
        valuesAtIndex.remove(pair);
        return pair.getValue();
    }

    public boolean contains(K key) {
        MyList<Pair<K, V>> valuesAtIndex = getListBasedOnKey(key);
        return getIndexOfKey(valuesAtIndex, key) >= 0;
    }
    
}