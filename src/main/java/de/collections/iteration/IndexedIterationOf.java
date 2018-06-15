/*
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

package de.collections.iteration;

import de.collections.Collection;

import java.util.function.BiConsumer;

/**
 * An alternative to traditional loops, for each loops, iterators and iterables.
 * <p>This class is immutable and thread-safe.</p>
 * @param <T> The type of the elements of the iteration.
 */
public final class IndexedIterationOf<T> implements IndexedIteration<T> {
    private final Collection<T> collection;

    /**
     * @param collection to iterate through.
     */
    public IndexedIterationOf(Collection<T> collection) {
        this.collection = collection;
    }

    @Override
    public void apply(BiConsumer<T, Integer> consumer) {
        for (int i = 0; i < collection.size(); i++) {
            consumer.accept(collection.get(i), i);
        }
    }

    /**
     * @return Format: <Classname>: <collection to iterate through>
     */
    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + collection.toString();
    }
}
