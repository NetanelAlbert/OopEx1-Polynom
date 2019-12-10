package Ex1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UnitTestComplexFunction{
	static ComplexFunction tmp = new ComplexFunction(new Monom(0,0));
	
	

	@Test
	void testCopyAndEquals() {
		String[] funcs = UnitTestFunctions_GUI.cfs;
		for (int i = 0; i < funcs.length; i++) {
			function cf = tmp.initFromString(funcs[i]);
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
		for (int i = 0; i < 10; i++) {
			Polynom p1 = UnitTestPolynom.randomPolynom();
			Polynom p2 = UnitTestPolynom.randomPolynom();
			ComplexFunction cf = new ComplexFunction(Operation.Times, p1, p2);
			p1.multiply(p2);
			assertEquals(p1, cf);
		}
	}
	
	@Test
	void testDiv() {
		String[] org = {"x^2-3x^5+8x^6", "8x^9-28x^6+9x^5", "5x^5+x^3-1.4x^8-2.8x^7"};
		String[] ans = {"1-3x^3+8x^4", "8x^7-28x^4+9x^3", "5x^3+x-1.4x^6-2.8x^5"};
		Polynom div = new Polynom("x^2");
		for (int i = 0; i < ans.length; i++) {
			ComplexFunction cf = new ComplexFunction(Operation.Divid, new Polynom(org[i]), div);
			Polynom pAns = new Polynom(ans[i]);
			assertEquals(pAns, cf);
		}
	}
	
	@Test
	void testMinMax() {
		String[] funcs = UnitTestFunctions_GUI.cfs;
		ComplexFunction cf = new ComplexFunction(new Monom(0,0));
		for (int i = 0; i < funcs.length; i++) {
			ComplexFunction small = (ComplexFunction)cf.initFromString(funcs[i]);
			ComplexFunction big = (ComplexFunction)small.copy();
			big.plus(new Monom(5, 0));
			
			ComplexFunction max = new ComplexFunction(Operation.Max, big, small);
			ComplexFunction min = new ComplexFunction(Operation.Min, big, small);
			assertEquals(big, max);
			assertEquals(small, min);
		}
		
	}
	
	@Test
	void testComp() {
		String[] org = {"x^2-3x^5+8x^6", "8x^9-28x^6+9x^25", "5x^5+x^3-1.4x^8-2.8x^7"};
		String[] ans = {"x^4-3x^10+8x^12", "8x^18-28x^12+9x^50", "5x^10+x^6-1.4x^16-2.8x^14"};
		Polynom div = new Polynom("x^2");
		for (int i = 0; i < ans.length; i++) {
			ComplexFunction cf = new ComplexFunction(Operation.Comp, new Polynom(org[i]), div);
			Polynom pAns = new Polynom(ans[i]);
			assertEquals(pAns, cf);
		}
	}
	
	@Test
	void testToStringAndInitToString() {
		String[] funcs = UnitTestFunctions_GUI.cfs;
		for (int i = 0; i < funcs.length; i++) {
			ComplexFunction cf1 = new ComplexFunction(new Monom(0,0));
			function cf = cf1.initFromString(funcs[i]);
			String str = cf.toString();
			
			assertEquals(cf,cf1.initFromString(str));	
			}
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
