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
		assertNotEquals(2, 4, "2!=4");
		for (int i = 0; i < 100; i++) { 
			Polynom p = randomPolynom();
			p.substract(p);
			assertNotEquals(2, 4, "2!=4");
			if(!p.isZero()) {
				System.out.println("wrong: " + p + " != 0");
				//fails++;
			}
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
		fail("Not yet implemented");
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
		fail("Not yet implemented");
	}
	
	private static Polynom randomPolynom() {
		int monoms = (int)(Math.random()*10);
		Polynom p = new Polynom();
		for (int i = 0; i < monoms; i++) {
			p.add(MonomTest.randomMonom());
		}
		return p;
	}

}
