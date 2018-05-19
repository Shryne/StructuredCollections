/**
 * The test naming has the following format: <elementAmount><operation name><Nothing or Not, if it must not apply>
 * <if expected: exception type> Example:
 * <pre><code>@Test
 * public void oneNot() {
 *     // one element involved, must not apply
 * }</code></pre>
 * It can be different with concatenation, because there are multiple collections involved. Example:
 * <pre><code>public void oneOne() { // To collections with one element</code></pre>
 * One test can contain multiple method calls. This is the case for example if it's more about the construction and
 * the object itself. Some classes can introduce additional namings that are not covered here.
 */
package de.collections;