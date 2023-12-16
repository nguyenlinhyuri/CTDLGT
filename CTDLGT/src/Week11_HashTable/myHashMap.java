package Week11_HashTable;

import java.util.ArrayList;
import java.util.List;

class myHashMap {
    private final int size = 1000;
    private List<Data>[] buckets;

    private class Data {
        int key, value;

        public Data(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public myHashMap() {
        buckets = new ArrayList[size];
        for (int i = 0; i < size; i++) {
            buckets[i] = new ArrayList<>();
        }
    }

    public int hashFunction(int key) {
        return key % size;
    }

    public void put(int key, int value) {
        int hashValueIndex = hashFunction(key);
        List<Data> bucket = buckets[hashValueIndex];

        for (Data data : bucket) {
            if (data.key == key) {
                data.value = value;
                return;
            }
        }

        bucket.add(new Data(key, value));
    }

    public int get(int key) {
        int hashValueIndex = hashFunction(key);
        List<Data> bucket = buckets[hashValueIndex];

        for (Data data : bucket) {
            if (data.key == key) {
                return data.value;
            }
        }

        return -1;
    }

    public void remove(int key) {
        int hashValueIndex = hashFunction(key);
        List<Data> bucket = buckets[hashValueIndex];

        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).key == key) {
                bucket.remove(i);
                return;
            }
        }
    }
}