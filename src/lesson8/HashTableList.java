package lesson8;

public class HashTableList{
    private Chain[] chain;
    private int capacity;

    public HashTableList(int initialCapacity) {
        capacity = initialCapacity;
        chain = new Chain[capacity];
    }

    private int hashFunc(int key) {
        return key % capacity;
    }

    public void add(int key, int value) {
        final int index = hashFunc(key);
        if (chain[index] == null) {
            chain[index] = new Chain(key, value);
        } else {
            Chain entry = chain[index];
            while (entry.getNext() != null && entry.getKey() != key) {
                entry = entry.getNext();
            }
            if (entry.getKey() == key) {
                entry.setValue(value);
            } else {
                entry.setNext(new Chain(key, value));
            }
        }
    }

    public void remove(int key) {
        final int index = hashFunc(key);
        if (chain[index] != null) {
            Chain prevEntry = null;
            Chain entry = chain[index];
            while (entry.getNext() != null && entry.getKey() != key) {
                prevEntry = entry;
                entry = entry.getNext();
            }
            if (entry.getKey() == key) {
                if (prevEntry == null) {
                    chain[index] = entry.getNext();
                } else {
                    prevEntry.setNext(entry.getNext());
                }
            }
        }
    }

    public Integer indexOf(int key) {
        final int index = hashFunc(key);
        if (chain[index] == null)
            return null;
        else {
            Chain entry = chain[index];
            while (entry != null && entry.getKey() != key) {
                entry = entry.getNext();
            }
            if (entry == null) {
                return null;
            } else {
                return entry.getValue();
            }
        }
    }


    public String display() {
        final StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i < capacity; i++) {
            sb.append("{  ");
            if (chain[i] != null) {
                Chain entry = chain[i];
                do {
                    sb.append(String.format("%d  ", entry.getValue()));
                    entry = entry.getNext();
                } while (entry != null);
            }
            sb.append("} ");
        }
        sb.append(']');
        return sb.toString();
    }

}
