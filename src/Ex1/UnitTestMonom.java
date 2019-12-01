package Ex1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UnitTestMonom {

	@Test
	void testDerivated() {
		fail("Not yet implemented");
	}

	@Test
	void testIsZero() {
		fail("Not yet implemented");
	}
	@Test
	void testAdd() {
		fail("Not yet implemented");
	}
	@Test
	void testMultiply() {
		fail("Not yet implemented");
	}
	@Test
	void testToString() {
		fail("Not yet implemented");
	}
	@Test
	void testEquals() {
		fail("Not yet implemented");
	}
	@Test
	void testCopy() {
		fail("Not yet implemented");
	}
	
	public static Monom randomMonom() {
		double c = Math.random()*100*(Math.random()-0.5); //some number in range -50 to 50
		int p = (int)(Math.random()*10);
		return new Monom(c,p);
	}

}
