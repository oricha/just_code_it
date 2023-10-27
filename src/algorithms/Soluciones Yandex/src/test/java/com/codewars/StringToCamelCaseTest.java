import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringToCamelCaseTest {
	
	 @Test
	    public void testSomeUnderscoreLowerStart() {
	      String input = "the_Stealth_Warrior";
	      System.out.println("input: "+input);      
	      assertEquals("theStealthWarrior", StringToCamelCase.toCamelCase(input));
	    }
	    @Test
	    public void testSomeDashLowerStart() {
	      String input = "the-Stealth-Warrior";
	      System.out.println("input: "+input);      
	      assertEquals("theStealthWarrior", StringToCamelCase.toCamelCase(input));
	    }

}
