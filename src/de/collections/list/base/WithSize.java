package de.collections.list.base;

public interface WithSize {
    int size();
    default boolean isEmpty() {
        return size() == 0;
    }
}
