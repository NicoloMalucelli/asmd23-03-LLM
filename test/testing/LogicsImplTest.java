package testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LogicsImplTest {

    private LogicsImpl logics;

    @Before
    public void setUp() {
        logics = new LogicsImpl(3); // Create a 3x3 grid for testing
    }

    @Test
    public void testHitFirst() {
        assertEquals(Logics.HitType.FIRST, logics.hit(0, 0));
    }

    @Test
    public void testHitSecond() {
        logics.hit(0, 0);
        assertEquals(Logics.HitType.SECOND, logics.hit(2, 2));
    }

    @Test
    public void testHitSelection() {
        logics.hit(0, 0);
        logics.hit(2, 2);
        assertTrue(logics.isSelected(1, 1));
    }

    @Test
    public void testHitSelectionDiagonal() {
        logics.hit(0, 0);
        logics.hit(2, 2);
        assertTrue(logics.isSelected(0, 1));
        assertTrue(logics.isSelected(1, 0));
        assertTrue(logics.isSelected(1, 1));
        assertTrue(logics.isSelected(2, 0));
        assertTrue(logics.isSelected(0, 2));
    }

    @Test
    public void testGameNotOver() {
        assertFalse(logics.isOver());
    }

    @Test
    public void testGameOver() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                logics.hit(i, j);
                logics.hit(i, j);
            }
        }
        assertTrue(logics.isOver());
    }
}
