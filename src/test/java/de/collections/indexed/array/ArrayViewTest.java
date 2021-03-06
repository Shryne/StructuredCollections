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
package de.collections.indexed.array;

import de.collections.indexed.array.base.ArrayView;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ArrayViewTest {
    @Test(expected = IllegalArgumentException.class)
    public void zeroGet() {
        new ArrayView<>().get(0);
    }

    @Test
    public void zeroSize() {
        assertEquals(
                0,
                new ArrayView<>().size()
        );
    }

    @Test
    public void oneGet() {
        assertEquals(
                10,
                (int) new ArrayView<>(10).get(0)
        );
    }

    @Test
    public void oneSize() {
        assertEquals(
                1,
                new ArrayView<>(524).size()
        );
    }

    @Test
    public void oneEquals() {
        assertEquals(
                new ArrayView<>(5),
                new ArrayView<>(5)
        );
    }

    @Test
    public void oneEqualsNot() {
        assertThat(
                new ArrayView<>(23),
                not(equalTo(new ArrayView<>(35)))
        );
    }

    @Test
    public void multipleEquals() {
        assertEquals(
                new ArrayView<>(5, 10, -10, 23, 54),
                new ArrayView<>(5, 10, -10, 23, 54)
        );
    }

    @Test
    public void multipleEqualsNot() {
        assertThat(
                new ArrayView<>(5, 0, 29, 12),
                not(equalTo(new ArrayView<>(5, 0, 29, -5)))
        );
    }
}
