package interview.recursion;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SubSetsTest {

	@Test
    public void compare()  {
		Comparator<Set<Integer>> setLengthComparator = new Comparator<Set<Integer>>() {
			@Override
			public int compare(Set<Integer> o1, Set<Integer> o2) {
				return o1.size() - o2.size();
			}
		};
		List<Set<Integer>> result = SubSets.recursive(new Integer[] {1, 2, 3, 4, 5, 6});
		Collections.sort(result, setLengthComparator);
		for (Set<Integer> set : result) {
			System.out.println(set);
		}
		assertEquals(64, result.size());
		
		result = SubSets.iterative(new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6)));
		Collections.sort(result, setLengthComparator);
		for (Set<Integer> set : result) {
			System.out.println(set);
		}
		assertEquals(64, result.size());
    }
}
