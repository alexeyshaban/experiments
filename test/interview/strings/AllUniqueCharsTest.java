package interview.strings;

import static interview.strings.AllUniqueChars.allUnique;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AllUniqueCharsTest {

	@Test
    public void testUniqueAscii() throws Exception {
	    assertTrue(allUnique("qwerty1234!zxcvb"));
    }
	
	@Test
    public void testNotUniqueAscii() throws Exception {
	    assertFalse(allUnique("qwerty1234!zxcvb!"));
    }

	@Test
    public void testUniqueCyrilic() throws Exception {
	    assertTrue(allUnique("йцукен1234!фыва"));
    }
	
	@Test
    public void testNotUniqueCyrilic() throws Exception {
		assertFalse(allUnique("йцукен1234!фывйа"));
    }
}
