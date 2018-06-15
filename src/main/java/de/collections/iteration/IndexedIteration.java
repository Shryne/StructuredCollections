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

import java.util.function.BiConsumer;

/**
 * The interface of the iteration classes that are a alternative to the normal java iteration loops. Classes that
 * implement this interface must only be applied on collections that are actually indexed (e.g. list, array. Not
 * indexed: Set).
 * @param <T> The type of the elements of the iteration.
 */
public interface IndexedIteration<T> {
    /**
     * @param action to be applied. The iteration will give the current element of the iteration and the index of it.
     */
    void apply(BiConsumer<T, Integer> action);
}
