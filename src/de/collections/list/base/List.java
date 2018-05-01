package de.collections.list.base;

// TODO: Checks
public final class List<T> implements WithGet<T>, WithSet<T>, WithSize {
    private final T[] container;

    public List(T... elements) {
        container = elements;
    }

    @Override
    public T get(int index) {
        return container[index];
    }

    @Override
    public void set(int index, T t) {
        container[index] = t;
    }

    @Override
    public int size() {
        return container.length;
    }
}
