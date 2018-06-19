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

import de.indexed.IndexedCollection;

import java.util.function.BiConsumer;

/**
 * An iteration that starts and ends on the specified indices. This iteration is indexed, because only indexed
 * collections can have a index range.
 * <p>This class is immutable and thread-safe.</p>
 * @param <T> The type of the elements inside the iteration.
 */
public class RangedIteration<T> implements IndexedIteration<T> {
    private final IndexedCollection<T> collection;
    private final int from;
    private final int to;

    /**
     * @param collection to iterate through.
     * @param to The end of the iteration (exclusive, needs to be smaller than collection.size()).
     * @throws IllegalArgumentException if from or to are invalid.
     * @see IndexedIterationOf
     */
    public RangedIteration(IndexedCollection<T> collection, int to) {
        this(collection, 0, to);
    }

    /**
     * @param collection to iterate through.
     * @param from The start of the iteration (needs to be greater or equal to 0).
     * @param to The end of the iteration (exclusive, needs to be smaller than collection.size()).
     * @throws IllegalArgumentException if from or to are invalid.
     * @see IndexedIterationOf
     */
    public RangedIteration(IndexedCollection<T> collection, int from, int to) {
        if (from < 0 || collection.size() < to) {
            throw new IllegalArgumentException(
                    "From needs to be greater than 0 and to needs to be smaller than collection.size()." +
                            " From: " + from + ", to: " + to
            );
        }
        this.collection = collection;
        this.from = from;
        this.to = to;
    }

    @Override
    public void apply(BiConsumer<T, Integer> consumer) {
        for (int i = from; i < to; i++) {
            consumer.accept(collection.get(i), i);
        }
    }
}
