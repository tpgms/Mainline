package test.java;
import org.junit.Test;

import junit.framework.*;
import main.java.RPNCalculator;
public class TestRPN extends TestCase {

	@Test
	public void test2operandAnd1Operator(){
		RPNCalculator rpn = new RPNCalculator();
	
		assertEquals("5", rpn.calculateSum("2,3,+"));
		assertEquals("1", rpn.calculateSum("-2,3,+"));
		assertEquals("10", rpn.calculateSum("2,3,5,+,+"));
		//assertEquals(5, rpn.calculateSum1RPN("A,3,+"));
		assertEquals("false", rpn.calculateSum("3,3,-"));
		//assertEquals(8, rpn.calculateSum1RPN("2,3,5,+,+"));
 
	}
}
