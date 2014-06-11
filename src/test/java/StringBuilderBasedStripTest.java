import org.junit.Test;

import static org.junit.Assert.*;

public class StringBuilderBasedStripTest {
    @Test
    public void testToString() throws Exception {
        String str = "asd";
        Strip<Character> strip = new StringBuilderBasedStrip(str);
        assertEquals(str, strip.toString());
    }

    @Test
    public void testGetCurrent() throws Exception {
        Strip<Character> strip = new StringBuilderBasedStrip("a");
        assertEquals('a', (char) strip.getCurrent());
    }

    @Test
    public void testReplace() throws Exception {
        Strip<Character> strip = new StringBuilderBasedStrip("a");
        strip.setCurrent('b');
        assertEquals('b', (char) strip.getCurrent());
    }

    @Test
    public void testMove() throws Exception {
        Strip<Character> strip = new StringBuilderBasedStrip("ab");
        strip.moveRight();
        assertEquals('b', (char) strip.getCurrent());
    }

    @Test
    public void testReplaceOffset() throws Exception {
        Strip<Character> strip = new StringBuilderBasedStrip("aa");
        strip.moveRight();
        strip.setCurrent('b');
        assertEquals("ab", strip.toString());
    }

    @Test
    public void testExtendBoundRight() throws Exception {
        Strip<Character> strip = new StringBuilderBasedStrip("a");
        strip.moveRight();
        strip.moveRight();
        strip.setCurrent('b');
        assertEquals("a b", strip.toString());
    }

    @Test
    public void testExtendBoundLeft() throws Exception {
        Strip<Character> strip = new StringBuilderBasedStrip("a");
        strip.moveLeft();
        strip.moveLeft();
        strip.setCurrent('b');
        assertEquals("b a", strip.toString());
    }
}