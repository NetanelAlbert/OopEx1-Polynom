package Ex1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UnitTestComplexFunctio{
	
	

	@Test
	void testCopy() {
		for (int i = 0; i < 10; i++) {
			function cf = randomCF();
			function copy = cf.copy();
			assertEquals(cf, copy);
		}
	}
	
	@Test
	void testPlus() {
		for (int i = 0; i < 10; i++) {
			Polynom p1 = UnitTestPolynom.randomPolynom();
			Polynom p2 = UnitTestPolynom.randomPolynom();
			ComplexFunction cf = new ComplexFunction(Operation.Plus, p1, p2);
			p1.add(p2);
			assertEquals(p1, cf);
		}
	}
	
	@Test
	void testMul() {
		fail("Not yet implemented");
	}
	
	@Test
	void testDiv() {
		fail("Not yet implemented");
	}
	
	@Test
	void testMax() {
		fail("Not yet implemented");
	}
	
	@Test
	void testMin() {
		fail("Not yet implemented");
	}
	
	@Test
	void testComp() {
		fail("Not yet implemented");
	}
	
	@Test
	void testEqual() {
		fail("Not yet implemented");
	}
	
	@Test
	void testToString() {
		fail("Not yet implemented");
	}
	
	public static ComplexFunction randomCF() {
		Operation[] opArr = {Operation.Plus, Operation.Times, Operation.Divid, Operation.Max, Operation.Min, Operation.Comp};
		int opNum = (int)(Math.random()*2+1);
		ComplexFunction ans = new ComplexFunction(UnitTestPolynom.randomPolynom());
		for (int i = 0; i < opNum; i++) {
			Operation op = opArr[(int)(Math.random()*opArr.length)];
			ans = new ComplexFunction(op, ans, UnitTestPolynom.randomPolynom());
		}
		return ans;
	}
		

}
