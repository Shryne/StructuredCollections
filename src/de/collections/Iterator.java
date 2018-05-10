package de.collections;

import de.collections.list.base.WithGet;
import de.collections.list.base.WithSize;

public class Iterator<T, E extends WithGet<T> & WithSize> implements java.util.Iterator<T> {
    private final E iterable;
    private int cursor = - 1;

    public Iterator(E iterable) {
        this.iterable = iterable;
    }

    @Override
    public boolean hasNext() {
        return cursor + 1< iterable.size();
    }

    @Override
    public T next() {
        cursor++;
        return iterable.get(cursor);
    }
}
