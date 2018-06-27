/**
 * MIT Licence
 * Copyright (c) 2018 Eugen Deutsch
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package de.collections.indexed.vector.base;

import de.collections.indexed.IndexedSet;

/**
 * A mutable vector. It's like an array but grows automatically in size if the user tries to set an element above
 * its size. Example:
 * <pre><code>final var vector = new MutableVector<>(1, 2, 3, 4); // size == 4
 * vector.set(20, 10); // size == 21</code></pre>
 * @param <T> The type of the elements this vector can contain.
 */
public interface MutableVector<T> extends Vector<T>, IndexedSet<T> {
    /**
     * Shrinks the vector down to the new size.
     * @param newSize of the vector. It has to be smaller than the current size and positive.
     */
    void shrink(int newSize);
}
