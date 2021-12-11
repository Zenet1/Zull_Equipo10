package Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Src.Parser;

public class ParserTest {
    public static Parser parseado;
    private String words[] = { "go", "help", "quit" };
    private String directions[] = { "north", "south", "east", "west" };

    @Before
    public void init() {
        parseado = new Parser("go", "north");
    }

    @Test
    public void testVerify() {
        assertTrue(parseado.verify("go", words));
    }

    @Test
    public void testVerifyA() {
        assertFalse(parseado.verify("jump", words));
    }

    @Test
    public void testVerifyDir() {
        assertTrue(parseado.verify("north", directions));
    }

    @After
    public void finish() {
        parseado = null;
    }
}
