package com.company;


public class IntList {

    private int[] data = new int[8];
    private int size = 0;

    public int size() {
        return size;
    }

    public void add(int value) {
        ensureCapacity();
        data[size] = value;
        size++;
    }

    /**
     * @return the value at the given index.
     */
    public int remove(int index) {
        // todo
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        if (index == size - 1) {
            // remove the last item
            return data[--size];
        }
        int r = data[index];
        System.arraycopy(data, index + 1, data, index, size - index);
        size--;
        return r;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size(); i++) {
            sb.append(get(i));
            if (i < size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public int get(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }

    private void ensureCapacity() {
        if (size == data.length) {
            int[] newArray = new int[data.length * 2];
            System.arraycopy(data, 0, newArray, 0, size);
            data = newArray;
        }
    }


}
