//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.elbicon.coderscampus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CustomArrayList<T> implements CustomList<T> {
    Object[] items = new Object[10];
    Elements indices = new Elements();
    Integer arrayTotalSize;
    Integer size = 0;
    Long currentUserCount;
    Integer newUserCount;
    Long lastElement;

    public CustomArrayList() {
    }

    public boolean add(T item) {
        if (this.size == this.items.length) {
            this.items = Arrays.copyOf(this.items, this.items.length * 2);
        }

        this.items[this.size] = item;
        Integer var2 = this.size;
        this.size = this.size + 1;
        return true;
    }

    public boolean add(int index, T item) throws IndexOutOfBoundsException {
        this.size = 0;
        Object[] newObject = null;
        if (this.size == this.items.length) {
            this.items = Arrays.copyOf(this.items, this.items.length * 2);
        }

        Integer totalElements;
        if (this.items[index] == null) {
            this.items[index] = item;
            totalElements = this.size;
            this.size = this.size + 1;
        } else {
            newObject = new Object[this.items.length + 1];
            totalElements = this.getIndexElementsSize();

            for(int i = 0; i < totalElements + 1; ++i) {
                Integer var6;
                if (i < index - 1 && this.items[i] != null) {
                    newObject[i] = this.items[i];
                    var6 = this.size;
                    this.size = this.size + 1;
                } else if (i == index - 1 && this.items[i] != null) {
                    newObject[i] = item;
                    var6 = this.size;
                    this.size = this.size + 1;
                } else {
                    newObject[i] = this.items[i - 1];
                    var6 = this.size;
                    this.size = this.size + 1;
                }
            }
        }

        this.items = Arrays.copyOf(newObject, newObject.length);
        return true;
    }

    public int getSize() {
        return this.size;
    }

    public T get(int index) {
        try {
            if (index >= this.size) {
                throw new ArrayIndexOutOfBoundsException();
            } else {
                return (T) this.items[index];
            }
        } catch (Exception e) {
            System.out.println("Exception Caught " + e.getMessage());
            return null;
        }
    }

    public T remove(int index) throws IndexOutOfBoundsException {
        this.size = 0;
        Integer totalElements = this.getIndexElementsSize();
        Object[] newObject = new Object[this.items.length - 1];

        for(int i = 0; i < totalElements - 1; ++i) {
            if (i < index - 1) {
                newObject[i] = this.items[i];
                size++;
            } else if (i == index - 1) {
                newObject[i] = this.items[i + 1];
                size++;
            } else {
                newObject[i] = this.items[i + 1];
                size++;
            }
        }

        return null;
    }

    private void updateCountStats() {
        this.indices.setCurrentUserCount(this.items);
        this.currentUserCount = this.indices.getCurrentUserCount();
        this.indices.setLastElement(this.items);
        this.lastElement = this.indices.getLastElement();
    }

    private void updateNewUserCount(T item) {
        this.indices.setNewUserCount((ArrayList)item);
        this.newUserCount = this.indices.getNewUserCount();
    }

    private void updateArraySize(int elementCount) {
        this.indices.setTotalLength(elementCount);
        this.arrayTotalSize = this.indices.getTotalLength();
    }

    private boolean indexFree() {
        return (long)this.arrayTotalSize > this.lastElement;
    }

    private Integer getIndexElementsSize() {
        ArrayList itemsCount = new ArrayList(Arrays.asList(this.items));
        itemsCount.removeAll(Collections.singleton((Object)null));
        return itemsCount.size();
    }
}
