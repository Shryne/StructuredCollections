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
package de.collections.indexed.list.base;

import de.collections.functional.Lazy;

/**
 * This class prevents code duplication from using decorators.
 * @param <T> The type of the elements inside the list.
 */
public abstract class MutableListEnvelope<T> implements MutableList<T> {
    private final Lazy<MutableList<T>> lazyList;

    /**
     * Primary constructor.
     * @param lazyList The list to be used for the methods inside of lazy.
     */
    public MutableListEnvelope(Lazy<MutableList<T>> lazyList) {
        this.lazyList = lazyList;
    }

    @Override
    public final void add(int index, T element) {
        lazyList.value().add(index, element);
    }

    @Override
    public final T get(int index) {
        return lazyList.value().get(index);
    }

    @Override
    public final void remove(int index) {
        lazyList.value().remove(index);
    }

    @Override
    public final int size() {
        return lazyList.value().size();
    }

    @Override
    public boolean equals(Object obj) {
        return lazyList.value().equals(obj);
    }

    @Override
    public int hashCode() {
        return lazyList.value().hashCode();
    }

    /**
     * @return Format: List: [...]
     */
    @Override
    public String toString() {
        return lazyList.value().toString();
    }
}
