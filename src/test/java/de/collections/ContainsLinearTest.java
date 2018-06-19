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

import de.indexed.list.base.ListOf;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class ContainsLinearTest {
    @Test
    public void oneApply() {
        new ContainsLinear<>(
                new ListOf<>(0),
                0
        ).apply(
                () -> assertTrue(true)
        );
        assertFalse(false);
    }

    @Test
    public void oneValue() {
        assertTrue(
                new ContainsLinear<>(
                        new ListOf<>(0),
                        0
                ).value()
        );
    }

    @Test
    public void oneApplyNot() {
        new ContainsLinear<>(
                new ListOf<>(0),
                1
        ).apply(
                () -> assertFalse(false)
        );
        assertTrue(true);
    }

    @Test
    public void oneValueNot() {
        assertFalse(
                new ContainsLinear<>(
                        new ListOf<>(0),
                        1
                ).value()
        );
    }

    @Test
    public void zeroApplyNot() {
        new ContainsLinear<>(
                new ListOf<>(),
                5
        ).apply(
                () -> assertFalse(false)
        );
        assertTrue(true);
    }
}
