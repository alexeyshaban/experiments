package interview.strings;

import static org.junit.Assert.*;
import interview.strings.RLE;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RLETest {

	@Test
    public void encode() throws Exception {
	    assertEquals("a2b4c3def2", RLE.encode("aabbbbcccdeff"));
    }
}
