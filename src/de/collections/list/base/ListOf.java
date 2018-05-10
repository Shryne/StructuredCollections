package de.collections.list.base;

import java.util.Arrays;

// TODO: Checks
public final class ListOf<T> implements List<T> {
    private final T[] container;

    public ListOf(T... elements) {
        container = Arrays.copyOf(elements, elements.length);
    }

    @Override
    public T get(int index) {
        return container[index];
    }

    /*
    @Override
    public void set(int index, T t) {
        container[index] = t;
    }
    */

    @Override
    public int size() {
        return container.length;
    }
}
