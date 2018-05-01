package de.collections.list;

import de.collections.list.base.List;
import de.collections.list.base.WithGet;
import de.collections.list.base.WithSize;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public final class IterableList<T, L extends WithGet<T> & WithSize> implements java.lang.Iterable<T> {
    private final L list;

    public IterableList(L list) {
        this.list = list;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new ListIterator<>(
                list
        );
    }
}
