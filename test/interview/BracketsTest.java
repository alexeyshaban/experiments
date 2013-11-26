package interview;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BracketsTest {

	@Test
    public void testNull() throws Exception {
	    assertFalse(Brackets.isBalanced(null));
    }
	
	@Test
    public void testEmpty() throws Exception {
	    assertTrue(Brackets.isBalanced(""));
    }
	
	@Test
    public void testBalanced() throws Exception {
	    assertTrue(Brackets.isBalanced("([{}()])"));
	    assertTrue(Brackets.isBalanced("([()])"));
	    assertTrue(Brackets.isBalanced("{   (  dsfsd ) } dsfsd"));
    }
	
	@Test
    public void testNotBalanced() throws Exception {
	    assertFalse(Brackets.isBalanced("([{}())"));
	    assertFalse(Brackets.isBalanced("([()]){"));
	    assertFalse(Brackets.isBalanced("{{   (  dsfsd ) } dsfsd"));
    }
}
