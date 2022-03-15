package com.company;

public class IntArrayList implements IntList {
    private int[] arr = new int[10];
    private int size = 0;

    public void add(int element) {
        if (size >= arr.length) {
            int newSize = arr.length * 3 / 2 + 1;
            int[] newArr = new int[newSize];
            for (int i = 0; i < size; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
        arr[size] = element;
        size++;

    }
    @Override
    public boolean add(int index, int element) {
        if (size >= index) {
            int newSize = size + 1;
            int[] newArr = new int[newSize];
            int changed = arr[index];

            for (int i = index + 2; i < newSize; i++) {
                newArr[i] = arr[i - 1];
            }

            for (int i = 0; i < index; i++) {
                newArr[i] = arr[i];
            }
            newArr[index] = element;
            newArr[index + 1] = changed;
            arr = newArr;
            size++;
            return true;
        }
        if (size < index) {
            throw new ArrayIndexOutOfBoundsException("Exception: The Array is out of boundaries");
        }
        return false;
    }
    @Override
    public void clear() {
        size = 0;
    }
    @Override
    public int get(int index) {
        return arr[index];
    }

    @Override
    public boolean isEmpty() {
        return size ==0;
    }

    @Override
    public boolean remove(int index) {
        if(size >= index){
            int newSize = size -1;
            int[] newArr = new int[newSize];

            for(int i=0; i<index; i++){
                newArr[i]=arr[i];
            }
            for(int i=index+1;i<=newSize; i++){
                newArr[i-1]=arr[i];
            }
            arr=newArr;
            size--;
            return true;
        }
        if(size<index){
            throw new ArrayIndexOutOfBoundsException("Exception: The Array is out of boundaries");
        }
        return false;
    }

    @Override
    public boolean removeByValue(int value) {
        boolean return_value = false;
        for(int i = 0; i < size; i++){
            if (arr[i] == value) {
                return_value = remove(i);
                break;
            }
        }
        return return_value;
    }

    @Override
    public boolean set(int index, int element) {
        return add(index, element);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public IntList subList(int fromIndex, int toIndex) {
        if(fromIndex > toIndex) {
            throw new RuntimeException("FromIndex has to be less than ToIndex");
        } else {
            IntArrayList return_list = new IntArrayList();
            for (int i = fromIndex;i < toIndex; i++) {
                return_list.add(arr[i]);
            }
            return return_list;
        }
    }

    @Override
    public int[] toArray() {
        return arr;
    }
}
