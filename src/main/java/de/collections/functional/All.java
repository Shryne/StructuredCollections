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
package de.collections.functional;

import de.collections.lambda.Action;

import java.util.function.Predicate;

/**
 * Checks if a collection of elements fulfill a predicate. It's equivalent to array.all { ... } in functional languages.
 * @param <T> The type of the elements in the collection.
 */
public final class All<T> {
    private final Iterable<T> iterable;
    private final Predicate<T> predicate;

    /**
     * Primary constructor.
     * @param iterable with the elements.
     * @param predicate to fulfill.
     */
    public All(Iterable<T> iterable, Predicate<T> predicate) {
        this.iterable = iterable;
        this.predicate = predicate;
    }

    /**
     * Equivalent to the call "apply(() -> {});".
     * @return True if the collection fulfills the predicate, false otherwise.
     */
    public boolean value() {
        return apply(() -> {});
    }

    /**
     * Applies the given action if the collection fulfills the given predicate.
     * @param action to be applied.
     * @return True if the action has been applied, false otherwise.
     */
    public boolean apply(Action action) {
        for (T element : iterable) {
            if (!predicate.test(element)) {
                return false;
            }
        }
        action.apply();
        return true;
    }
}
