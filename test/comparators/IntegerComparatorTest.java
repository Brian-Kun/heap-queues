package comparators;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;

public class IntegerComparatorTest {

  IntegerComparator comparator;
	
  @Before
  public void setup() {
    comparator = new IntegerComparator();
  }

  @Test (timeout = 100)
  public void testOne() {
	  assertEquals(1,comparator.compare(100, 50));
  }

}
