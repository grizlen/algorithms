package ru.geekbrains;

public class LinkHashMap<K, V> {

    static class Item<K, V> {

        private final K key;
        private V value;
        private Item<K, V> next;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            if (next == null) {
                return "key: " + key + "; value: " + value + ";";
            } else {
                StringBuilder sb = new StringBuilder("[");
                for (Item<K, V> i = this; i != null; i = i.next) {
                    sb.append("{key: " + i.key);
                    sb.append("; value: " + i.value + "; ");
                }
                sb.append("]");
                return sb.toString();
            }
        }

        public void append(Item<K, V> item) {
            Item<K, V> i = this;
            while (i.next != null) {
                i = i.next;
            }
            i.next = item;
        }

        public Item<K, V> find(K key) {
            for (Item<K, V> item = this; item != null; item = item.next) {
                if (item.key.equals(key)) {
                    return item;
                }
            }
            return null;
        }

        public void remove(K key) {
            for (Item<K, V> item = this; item.next != null; item = item.next) {
                if (item.next.key.equals(key)) {
                    item.next = item.next.next;
                    return;
                }
            }
        }

    }

    private final Item<K, V>[] items;
    private int size;

    public LinkHashMap(int capacity) {
        items = new Item[capacity];
    }

    public void put(K key, V value) {
        int index = hashFunc(key);
        if (items[index] == null) {
            items[index] = new Item<>(key, value);
        } else if (items[index].key.equals(key)){
            items[index].setValue(value);
        } else {
            items[index].append(new Item<>(key, value));
        }
        size++;
    }

    public V get(K key) {
        if (key == null) {
            return null;
        }
        int index = hashFunc(key);
        if (items[index] == null) {
            return null;
        } else if (items[index].key.equals(key)){
            return items[index].getValue();
        } else {
            Item<K, V> item = items[index].find(key);
            return item != null ? item.getValue() : null;
        }
    }

    public void remove(K key) {
        if (key == null) {
            return;
        }
        int index = hashFunc(key);
        if (items[index] == null) {
            return;
        }
        if (items[index].next == null) {
            items[index] = null;
        } else if (items[index].key.equals(key)){
            items[index] = items[index].next;
        } else {
            items[index].remove(key);
        }
        size--;
    }

    public int size() {
        return size;
    }
    
    public void display() {
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                System.out.println(i + ": " + items[i]);
            } else {
                System.out.println(i + ": null");
            }
        }
    }

    private int hashFunc(K key) {
        return Math.abs(key.hashCode() % items.length);
    }
}
