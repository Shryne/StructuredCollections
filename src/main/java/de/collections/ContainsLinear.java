/**
 * MIT Licence
 * Copyright (c) 2018 Eugen Deutsch
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package de.collections;

import de.collections.iterable.base.IterableOf;
import de.collections.lambda.Action;
import de.indexed.IndexedCollection;

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
     * @param element to search for.
     */
    public ContainsLinear(IndexedCollection<T> collection, T element) {
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
    }

    @Override
    public boolean apply(Action action) {
        for (T t : iterable) {
            if (element.equals(t)) {
                action.apply();
                return true;
            }
        }
        return false;
    }
}
