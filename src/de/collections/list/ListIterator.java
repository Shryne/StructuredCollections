package de.collections.list;

import de.collections.list.base.WithGet;
import de.collections.list.base.WithSize;

import java.util.Iterator;

public class ListIterator<T, E extends WithGet<T> & WithSize> implements Iterator<T> {
    private final E iterable;
    private int cursor = - 1;

    public ListIterator(E iterable) {
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
