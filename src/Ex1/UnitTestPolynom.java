package Ex1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UnitTestPolynom {

	@Test
	void testAdd() {
		String[] org = {"1+2x+5.3x^4", 		  "3x^6-4x^9", "3.5+4.23x-5x^7+2x^10"};
		String[] add = {"4+2x^3-x^4+10.6x^7", "6x^6", 	   "-4.23x+7x^3+8x^4-10x^10"};
		String[] ans = {"5+2x+2x^3+4.3x^4+10.6x^7", "9x^6-4x^9", "3.5+7x^3+8x^4-5x^7-8x^10"};
		for (int i = 0; i < ans.length; i++) {
			Polynom p = new Polynom(org[i]);
			Polynom ad = new Polynom(add[i]);
			Polynom an = new Polynom(ans[i]);
			assertEquals(p, an);
		}
	}
	
	@Test
	void testSubstractAndIsZero() {
		for (int i = 0; i < 100; i++) { 
			Polynom p = randomPolynom();
			p.substract(p);
			assertTrue(p.isZero(), "p-p should be zero but it is: " + p);
		}
	}
	
	@Test
	void testMultiply() {
		String[] org = {"1+2x+5.3x^4", "3x^3", "3.5+4x-5x^7"};
		String[] ans = {"2x^3+10.6x^7", "6x^6", "7x^3+8x^4-10x^10"};
		Polynom mul = new Polynom("2x^3");
		for (int i = 0; i < ans.length; i++) {
			Polynom p = new Polynom(org[i]);
			p.multiply(mul);
			Polynom a = new Polynom(ans[i]);
			assertEquals(p, a);
		}
	}
	@Test
	void testEquals() {
		for (int i = 0; i < 100; i++) {
			Polynom p = randomPolynom();
			Polynom copy = (Polynom)p.copy();
			assertEquals(p, copy);
		}
	}
	
	@Test
	void testRoot() {
		String[] polinoms = {"x^4-16", "x^2-9", "x-8"};
		double[] root = {2, 3, 8};
		for (int i = 0; i < polinoms.length; i++) {
			Polynom p = new Polynom(polinoms[i]);
			double pRoot = p.root(1, 10, Monom.EPSILON);
			double diff = Math.abs(pRoot - root[i]);
			assertTrue(diff < Monom.EPSILON, "'" + p 
				+ "' root should be " + root[i] + " and not " + pRoot);
		}
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
		String[] polinoms = {"3x^5-x^3+9.2x-3", "9x^9+8x^3", "2345"};
		String[] derivatives = {"15x^4-3x^2+9.2", "81x^8+24x^2", "0"};
		for (int i = 0; i < polinoms.length; i++) {
			Polynom p = new Polynom(polinoms[i]);
			Polynom d = new Polynom(derivatives[i]);
			assertEquals(d, p.derivative(), "derivativeTest fail: '" + p.derivative() 
			+ "' isn't the derivative of '" + p + "', the derivative is '"+d+"'");
		}
	}
	
	@Test
	void testToString() {
		for (int i = 0; i < 100; i++) { 
			Polynom p = randomPolynom();
			Polynom pCopy = new Polynom(p.toString());
			assertEquals(p, pCopy);
		}
	}
	
	@Test
	void testArea() {
		String[] polinoms = {"x^2+3x-5", "x^3-x^2+0.5", "x"};
		double[] area = {23.25,38.859375, 4.875};
		for (int i = 0; i < polinoms.length; i++) {
			Polynom p = new Polynom(polinoms[i]);
			double pArea = p.area(2.5, 4, Monom.EPSILON);
			double diff = Math.abs(pArea - area[i]);
			assertTrue(diff < Monom.EPSILON, "areaTest fail: '" + p + 
					"' area from 2.5 to 4 should be " + area[i] + " and not " + pArea);
		}
	}
	
	public static Polynom randomPolynom() {
		int monoms = (int)(Math.random()*6);
		Polynom p = new Polynom();
		for (int i = 0; i < monoms; i++) {
			p.add(UnitTestMonom.randomMonom());
		}
		return p;
	}

}
