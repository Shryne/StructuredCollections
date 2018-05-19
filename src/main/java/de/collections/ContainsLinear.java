package de.collections;

import de.collections.lambda.Action;
import de.collections.list.base.WithGet;
import de.collections.list.base.WithSize;

import javax.swing.*;

/**
 * Searches linear (from start to end) for the element.
 * @param <T> The type of the element and the type of the iterables contained type.
 */
public class ContainsLinear<T> implements Contains {
    private final Iterable<T> iterable;
    private final T element;

    /**
     * Secondary constructor.
     * @param collection Where the element could be.
     * @param element To search for.
     * @param <C> A collection that implements WithGet and WithSize to construct an Iterable.
     */
    public <C extends WithGet<T> & WithSize> ContainsLinear(C collection, T element) {
        this(new IterableOf<>(collection), element);
    }

    /**
     * Primary constructor.
     * @param iterable Where the element could be.
     * @param element To search for.
     */
    public ContainsLinear(Iterable<T> iterable, T element) {
        this.iterable = iterable;
        this.element = element;
        var button = new JButton("Hallo");
        button.setBorder(BorderFactory.createCompoundBorder());
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
