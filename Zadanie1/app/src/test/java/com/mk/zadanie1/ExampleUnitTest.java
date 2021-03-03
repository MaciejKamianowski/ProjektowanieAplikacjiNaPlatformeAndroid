package com.mk.zadanie1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, MainActivity.dodawanieLiczb(2, 2), 0.00000001);
        assertEquals(0, MainActivity.dodawanieLiczb(-2, 2), 0.00000001);
    }
    @Test
    public void subtraction_isCorrect(){
        assertEquals(-2, MainActivity.odejmowanieLiczb(4, 6), 0.0000001);
        assertEquals(10, MainActivity.odejmowanieLiczb(14, 4), 0.0000001);
    }
    @Test
    public void multiplication_isCorrect(){
        assertEquals(0, MainActivity.mnozenieLiczb(2.5, 0), 0.000000001);
        assertEquals(0, MainActivity.mnozenieLiczb(2.5, 0), 0.000000001);
    }
    @Test
    public void division_isCorrect(){
        assertEquals(4, MainActivity.dzielenieLiczb(8, 2), 0.0000000001);
        assertEquals(-2, MainActivity.dzielenieLiczb(8, -4), 0.0000000001);
    }


}