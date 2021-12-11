import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class LectorarchivoTest {
    public static Lectorarchivo read;

    @Before
    public void init() {
        read = new Lectorarchivo();
    }

    @Test
    public void testDocExistWrong() {
        assertFalse(read.DocExist("Error.txt"));
    }

}
