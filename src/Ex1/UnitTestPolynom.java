package Ex1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UnitTestPolynom {

	@Test
	void testAdd() {
		fail("Not yet implemented");
	}
	@Test
	void testSubstract() {
		for (int i = 0; i < 100; i++) { 
			Polynom p = randomPolynom();
			p.substract(p);
			assertTrue(p.isZero(), "p-p should be zero but it is: " + p);
		}
	}
	
	@Test
	void testMultiply() {
		fail("Not yet implemented");
	}
	@Test
	void testEquals() {
		fail("Not yet implemented");
	}
	@Test
	void testIsZero() {
		fail("Not yet implemented");
	}
	@Test
	void testRoot() {
		fail("Not yet implemented");
	}
	@Test
	void testCopy() {
		for (int i = 0; i < 100; i++) { 
			Polynom p = randomPolynom();
			Polynom pCopy = (Polynom)p.copy();
			assertTrue(p.equals(pCopy), p+" isn't equals to his copy: " + pCopy);
		}
	}
	@Test
	void testDerivative() {
		fail("Not yet implemented");
	}
	@Test
	void testArea() {
		fail("Not yet implemented");
	}
	@Test
	void testToString() {
		for (int i = 0; i < 100; i++) { 
			Polynom p = randomPolynom();
			Polynom pCopy = new Polynom(p.toString());
			assertTrue(p.equals(pCopy), p+" isn't equals to his copy: " + pCopy);
		}
	}
	
	private static Polynom randomPolynom() {
		int monoms = (int)(Math.random()*10);
		Polynom p = new Polynom();
		for (int i = 0; i < monoms; i++) {
			p.add(UnitTestMonom.randomMonom());
		}
		return p;
	}

}
