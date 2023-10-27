import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class TwoFightersOneWinnerTest {
	
    @Test
    public void basicTests() {
    assertEquals("Lew", TwoFightersOneWinner.declareWinner(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Lew"));
    }
    @Test
    public void basicTests2() {
    assertEquals("Harry", TwoFightersOneWinner.declareWinner(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Harry"));
    }
    @Test
    public void basicTests3() {
    assertEquals("Harald", TwoFightersOneWinner.declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harry"));    
    }
    @Test
    public void basicTests4() {
    assertEquals("Harald", TwoFightersOneWinner.declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harald"));   
    }
    @Test
    public void basicTests5() {
    assertEquals("Harald", TwoFightersOneWinner.declareWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Jerry"));     
    }
    @Test
    public void basicTests6() {
    assertEquals("Harald", TwoFightersOneWinner.declareWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Harald"));
    }

}
