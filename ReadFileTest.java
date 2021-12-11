import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class ReadFileTest {
    public static ReadFile read;

    @Before
    public void init() {
        read = new ReadFile();
    }

    @Test
    public void testDocExistWrong() {
        assertFalse(read.docExist("Error.txt"));
    }
}
