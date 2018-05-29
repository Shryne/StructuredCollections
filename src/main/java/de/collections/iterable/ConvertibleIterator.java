package de.collections.iterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * - mutable
 *
 * @param
 * @return
 */
public interface ConvertibleIterator<T> extends Iterator<T> {
    /**
     * Creates a new array and puts the elements of the iterable inside of it.
     * @return The array with the elements.
     */
    default T[] toArray() {
        final List<T> list = new ArrayList<>();
        forEachRemaining(list::add);
        //noinspection unchecked
        return (T[]) list.toArray();
    }
}
