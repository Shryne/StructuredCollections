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
package de.indexed.array;

import de.indexed.array.base.ArrayOf;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ArrayOfTest {
    @Test(expected = IllegalArgumentException.class)
    public void zeroGet() {
        new ArrayOf<>().get(0);
    }

    @Test
    public void zeroSize() {
        assertEquals(
                0,
                new ArrayOf<>().size()
        );
    }

    @Test
    public void oneGet() {
        assertEquals(
                10,
                (int) new ArrayOf<>(10).get(0)
        );
    }

    @Test
    public void oneSize() {
        assertEquals(
                1,
                new ArrayOf<>(524).size()
        );
    }

    @Test
    public void oneEquals() {
        assertEquals(
                new ArrayOf<>(5),
                new ArrayOf<>(5)
        );
    }

    @Test
    public void oneEqualsNot() {
        assertThat(
                new ArrayOf<>(23),
                not(equalTo(new ArrayOf<>(35)))
        );
    }

    @Test
    public void multipleEquals() {
        assertEquals(
                new ArrayOf<>(5, 10, -10, 23, 54),
                new ArrayOf<>(5, 10, -10, 23, 54)
        );
    }

    @Test
    public void multipleEqualsNot() {
        assertThat(
                new ArrayOf<>(5, 0, 29, 12),
                not(equalTo(new ArrayOf<>(5, 0, 29, -5)))
        );
    }
}
