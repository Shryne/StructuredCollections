package de;

import de.collections.lambda.Action;

/**
 * Defines an interface for classes that check if something is inside of something else (depends on the implementing
 * class).
 */
public interface Contains {
    /**
     * Applies the given action only if the containment is fulfilled. Example (pseudo code):
     * <pre><code>new Contains([1, 2, 3, 4], 3).apply(() -> System.out.println("Hey")); // => Hey</code></pre>
     * This is an alternative to the traditional way:
     * <pre><code>if (list.contains(5)) action();</code></pre>
     * @param action The action to apply.
     */
    void apply(Action action);
}
