import de.collections.list.base.ListOf;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListOfTest {
    @Test
    public void oneElementGet() {
        assertEquals(
                5,
                (int) new ListOf<>(5).get(0)
        );
    }
}
