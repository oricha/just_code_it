package com.codewars;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class SumOfNumbersTest {
	
	  
	SumOfNumbers s = new SumOfNumbers();

    @Test
    public void Test1()
    {
      assertEquals(-1, s.GetSum(0, -1));
      assertEquals(1, s.GetSum(0, 1));
    }


}
