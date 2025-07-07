package ca.pranavpatel.algo.kombin;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit tests for the Table class, verifying the bijective mapping
 * between indices and ordered pairs for various set sizes and indexing modes.
 */
public class TableTest {

    /**
     * Tests the Table class for all combinations of set sizes from 1 to 100
     * using one-based indexing (zeroBasedIndex = false).
     * For each possible index, retrieves the pair, then maps it back to the index,
     * and asserts that the mapping is consistent.
     */
    @Test
    public void testAll100false() {
        for (int X = 1; X <= 100; X++) {
            for (int Y = 1; Y <= 100; Y++) {
                Table myXY = new Table(X, Y, false);
                for (long i = 1; i <= X * Y; i++) {
                    Pair ai_bi = myXY.GetElementsAtIndex(i);
                    long index = myXY.GetIndexOfElements(ai_bi.ai, ai_bi.bi);
                    assertEquals("Mismatch at X=" + X + ", Y=" + Y + ", i=" + i, i, index);
                }
            }
        }
    }

    /**
     * Tests the Table class for all combinations of set sizes from 1 to 100
     * using zero-based indexing (zeroBasedIndex = true).
     * For each possible index, retrieves the pair, then maps it back to the index,
     * and asserts that the mapping is consistent.
     */
    @Test
    public void testAll100True() {
        boolean result = true;
        for (int X = 1; X <= 100; X++) {
            for (int Y = 1; Y <= 100; Y++) {
                Table myXY = new Table(X, Y, true);
                for (long i = 0; i <= (X * Y) - 1; i++) {
                    Pair ai_bi = myXY.GetElementsAtIndex(i);
                    long index = myXY.GetIndexOfElements(ai_bi.ai, ai_bi.bi);
                    assertEquals("Mismatch at X=" + X + ", Y=" + Y + ", i=" + i, i, index);
                }
            }
        }
        assertEquals(true, result);
    }
}
