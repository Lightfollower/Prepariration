package lesson_2;

import java.util.Arrays;

public class MyArrayList<Item> {
    private static final float LOAD_FACTOR = 0.75f;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] items;
    private int size = 0;

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        items = new Object[capacity];
    }

    public MyArrayList() {
        items = new Object[DEFAULT_CAPACITY];
    }

    public void add(Item item) {
        items[size] = item;
        size++;
        if(size >= items.length * LOAD_FACTOR){
            increaseVolume();
        }
    }

    public void add(int index, Item item) {
        if (index < 0) {
            index = 0;
        }
        if (index > size) {
            index = size;
        }
        for (int i = size; i > index; i--) {
            items[i] = items[i - 1];
        }
        items[index] = item;
        size++;
        if(size == items.length * LOAD_FACTOR) {
            increaseVolume();
        }
    }

    public boolean remove(Item item) {
        int i = 0;
        while (i < size && !items[i].equals(item)) {
            i++;
        }
        if (i == size) {
            return false;
        }
        for (int j = i; j < size - 1; j++) {
            items[j] = items[j + 1];
        }
        size--;
        items[size] = null;
        return true;
    }

    public Item get(int index) {
        return (Item)items[index];
    }

    public void set(int index, Item item) {
        items[index] = item;
    }

    public int size() {
        return size;
    }

    public boolean find(Item item) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s += items[i] + " ";
        }
        return s;
    }

    private void increaseVolume(){
        Item[] temp = (Item[]) new Comparable[(int) (items.length / LOAD_FACTOR)];
        items = Arrays.copyOf(items, (int) (items.length * 1.5));
    }
}