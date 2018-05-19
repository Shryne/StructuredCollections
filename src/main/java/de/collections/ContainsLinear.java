package de.collections;

import de.Contains;
import de.collections.lambda.Action;

/**
 * Searches linear (from start to end) for the element.
 * @param <T> The type of the element and the type of the iterables contained type.
 */
public class ContainsLinear<T> implements Contains {
    private final Iterable<T> iterable;
    private final T element;

    /**
     * Primary constructor.
     * @param iterable The iterable where the element could be.
     * @param element The element to search for.
     */
    public ContainsLinear(Iterable<T> iterable, T element) {
        this.iterable = iterable;
        this.element = element;
    }

    @Override
    public void apply(Action action) {
        for (T t : iterable) {
            if (element.equals(t)) {
                action.apply();
            }
        }
    }
}
