package de.collections.list;

import de.collections.Iterator;
import de.collections.list.base.WithGet;
import de.collections.list.base.WithSize;

public final class Iterable<T, L extends WithGet<T> & WithSize> implements java.lang.Iterable<T> {
    private final L list;

    public Iterable(L list) {
        this.list = list;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new Iterator<>(
                list
        );
    }
}
