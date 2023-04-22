package numberrangesummarizer;
import static org.junit.Assert.*;
import java.util.*;
import java.util.stream.Collectors;
import org.junit.Test;

public class UnitTests {
	

	@Test
   public void testCollect() {
    Numbers numbers = new Numbers();
    Collection<Integer> result = numbers.numbers.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
    List<Integer> expected = Arrays.asList(1,3,6,7,8,12,13,14,15,21,22,23,24,31);
    assertEquals(expected, result);
    
  }
	@Test
	   public void testCollect1() {
	    Numbers numbers = new Numbers();
	    Collection<Integer> result = numbers.numbers.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,25,26,27,28,29,30,31");
	    List<Integer> expected = Arrays.asList(1,3,6,7,8,12,13,14,15,21,22,23,24,25,26,27,28,29,30,31);
	    assertEquals(expected, result);
	    
	  }
	
  @Test
  public void testSummarizeCollection() {
    Numbers numbers = new Numbers();
    Collection<Integer> input = numbers.numbers.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
    String result = numbers.numbers.summarizeCollection(input);
    String expected = "1,3,6-8,12-15,21-24,31";
    assertEquals(expected, result);
  }
  
  @Test
  public void testSummarizeCollection1() {
    Numbers numbers = new Numbers();
    Collection<Integer> input = numbers.numbers.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,25,26,27,28,29,30,31");
    String result = numbers.numbers.summarizeCollection(input);
    String expected = "1,3,6-8,12-15,21-31";
    assertEquals(expected, result);
  }
  
  }
