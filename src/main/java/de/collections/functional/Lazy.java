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


import java.util.function.Supplier;

/**
 * A class for lazy initialization. The initialization will be applied only once. Example:
 * <pre><code>val list = new Lazy<>(
 *      () -> {
 *          val list = new ArrayList<>();
 *          list.add(15);
 *          return list;
 *      } // will be applied later, when the list content is actually needed.
 * );</code></pre>
 * @param <T> The type of the resulting value that will be created.
 */
public final class Lazy<T> {
    private final Supplier<T> supplier;
    private T value = null;

    /**
     * Primary constructor.
     * @param supplier Contains the information on how the element has to be created.
     */
    public Lazy(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    /**
     * Constructs the value the first time this method is called and saves it then.
     * @return The constructed value.
     */
    public T value() {
        if (value == null) {
            value = supplier.get();
        }
        return value;
    }
}
