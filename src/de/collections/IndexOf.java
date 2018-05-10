package de.collections;

public final class IndexOf<T> extends Number {
    private final Iterable<T> iterable;
    private final T elem;

    public IndexOf(Iterable<T> iterable, T elem) {
        this.iterable = iterable;
        this.elem = elem;
    }

    @Override
    public int intValue() {
        var iterator = iterable.iterator();
        for (int i = 0; iterator.hasNext(); i++) {
            final var current = iterator.next();
            if (current.equals(elem)) return i;
        }

        throw new IllegalStateException(
                "The given iterable doesn't contain the value. Use Contains before or be sure it does. Iterable: " +
                        iterable
        );
    }

    @Override
    public long longValue() {
        return intValue();
    }

    @Override
    public float floatValue() {
        return intValue();
    }

    @Override
    public double doubleValue() {
        return intValue();
    }
}
