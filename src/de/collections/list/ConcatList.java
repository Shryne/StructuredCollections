package de.collections.list;

import de.collections.list.base.List;
import de.collections.list.base.WithGet;
import de.collections.list.base.WithSet;
import de.collections.list.base.WithSize;

public final class ConcatList<T> implements List<T> {
    private final List<T> first;
    private final List<T> second;

    public ConcatList(List<T> first, List<T> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public T get(int index) {
        if (index < first.size()) return first.get(index);
        return second.get(index - first.size());
    }

    @Override
    public void set(int index, T t) {
        if (index < first.size()) first.set(index, t);
        second.set(index - first.size(), t);
    }

    @Override
    public int size() {
        return first.size() + second.size();
    }
}
