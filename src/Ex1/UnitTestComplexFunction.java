package Ex1;

import static org.junit.jupiter.api.Assertions.*;

import java.security.cert.PKIXRevocationChecker.Option;

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
	void test1() {
		fail("Not yet implemented");
	}
	
	@Test
	void test2() {
		fail("Not yet implemented");
	}
	
	@Test
	void test3() {
		fail("Not yet implemented");
	}
	
	@Test
	void test4() {
		fail("Not yet implemented");
	}
	
	@Test
	void test5() {
		fail("Not yet implemented");
	}
	
	@Test
	void test6() {
		fail("Not yet implemented");
	}
	
	@Test
	void test7() {
		fail("Not yet implemented");
	}
	
	@Test
	void test9() {
		fail("Not yet implemented");
	}
	
	@Test
	void test10() {
		fail("Not yet implemented");
	}
	
	public static ComplexFunction randomCF() {
		Operation[] opArr = {Operation.Plus, Operation.Times, Operation.Divid, Operation.Max, Operation.Min, Operation.Comp};
		int opNum = (int)(Math.random()*3+1);
		ComplexFunction ans = new ComplexFunction(UnitTestPolynom.randomPolynom());
		for (int i = 0; i < opNum; i++) {
			Operation op = opArr[(int)(Math.random()*opArr.length)];
			ans = new ComplexFunction(op, ans, UnitTestPolynom.randomPolynom());
		}
		return ans;
	}
		

}
