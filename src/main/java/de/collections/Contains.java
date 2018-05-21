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

import de.collections.lambda.Action;

/**
 * Defines an interface for classes that check if something is inside of something else (depends on the implementing
 * class).
 */
public interface Contains {
    default boolean value() {
        return apply(() -> {});
    }

    /**
     * Applies the given action only if the containment is fulfilled. Example (pseudo code):
     * <pre><code>new Contains([1, 2, 3, 4], 3).apply(() -> System.out.println("Hey")); // => Hey</code></pre>
     * This is an alternative to the traditional way:
     * <pre><code>if (list.contains(5)) action();</code></pre>
     * @param action The action to apply.
     * @return true if the action has been applied, otherwise false.
     */
    boolean apply(Action action);
}
