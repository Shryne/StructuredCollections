package de.collections.list;

import de.collections.list.base.List;

/**
 * Defines a view on a given area that can be equal to the origin data structure. This class is immutable.
 * @param <T> The type of the contained elements.
 */
public class Sublist<T> implements List<T> {
    private final List<T> list;
    private final int start;
    private final int end;

    /**
     * Primary constructor.
     * @param list to create the sublist from.
     * @param start index (inclusive).
     * @param end index (exclusive).
     * @throws IllegalArgumentException if:
     * <li>start >= end</li>
     * <li>start < 0</li>
     * <li>end < 0</li>
     * <li>start >= list.size()</li>
     * <li>end >= list.size()</li>
     */
    public Sublist(List<T> list, int start, int end) {
        if (between(start, 0, list.size()) && between(end, 0, list.size())) {
            throw new IllegalArgumentException(
                    String.format(
                            "The start and the end need to be between 0 and list.size(). " +
                                    "List.size(): %d, start: %d, end: %d",
                            list.size(), start, end
                    )
            );
        }
        if (start >= end) {
            throw new IllegalArgumentException(
                    "The start needs to be smaller than the end. Start: " + start + ", end: " + end
            );
        }
        this.list = list;
        this.start = start;
        this.end = end;
    }

    @Override
    public T get(int index) {
        return list.get(start + index);
    }

    @Override
    public int size() {
        return end - start;
    }

    private static boolean between(int elem, int min, int max) {
        return min <= elem && elem < max;
    }

    /**
     * @return format: Sublist: [...|...|...]
     */
    @Override
    public String toString() {
        return "Sublist: ["; // TODO: Complete it and implement some classes to make it easy
    }
}
