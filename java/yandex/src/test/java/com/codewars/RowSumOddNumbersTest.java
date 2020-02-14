package com.codewars;

import org.junit.Test;
import static org.junit.Assert.*;

public class RowSumOddNumbersTest {
	
	 @Test
	    public void test1() {
	        assertEquals(1, RowSumOddNumbers.rowSumOddNumbers(1));
	        assertEquals(8, RowSumOddNumbers.rowSumOddNumbers(2));
	        assertEquals(27, RowSumOddNumbers.rowSumOddNumbers(3));
	        assertEquals(74088, RowSumOddNumbers.rowSumOddNumbers(42));
	    }

}
