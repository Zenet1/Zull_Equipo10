
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ParserTest {
    public static Parser parseado;

    @Before
    public void init() {
        parseado = new Parser("go", "north");
    }

    @Test
    public void testVerify() {
        assertTrue(parseado.verify("go"));
    }

    @Test
    public void testVerifyA() {
        assertFalse(parseado.verify("jump"));
    }

    @Test
    public void testVerifyDir() {
        assertTrue(parseado.verifyDir("north"));
    }

    @After
    public void finish() {
        parseado = null;
    }
}
