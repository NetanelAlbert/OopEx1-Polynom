package Ex1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UnitTestMonom {

	@Test
	void testDerivated() {
		for (int i = 0; i < 100; i++) { 
			Monom m = randomMonom();
			Monom mDer;
			if(m.get_power()==0) 
				mDer = new Monom(0,0);
			else
				mDer = new Monom(m.get_coefficient()*m.get_power(), m.get_power()-1);
			
			assertEquals(mDer, m.derivative());;
		}
	}

	@Test
	void testAddAndIsZero() {
		for (int i = 0; i < 100; i++) { 
			Monom m = randomMonom();
			Monom mMinus = (Monom)m.copy();
			mMinus.multipy(Monom.MINUS1);
			m.add(mMinus);
			assertTrue(m.isZero(), "m-m should be 0 but it is: " + m);
		}
	}
	@Test
	void testMultiply() {
		String[] monoms = {"3x^2","-6x^3","9x","-2"};
		String[] ans = {"6x^4","-12x^5","18x^3","-4x^2"};
		Monom mul = new Monom(2,2); 
		for (int i = 0; i < monoms.length; i++) { 
			Monom m = new Monom(monoms[i]);
			m.multipy(mul);
			assertEquals(new Monom(ans[i]), m);
			
		}	
	}
	@Test
	void testToString() {
		for (int i = 0; i < 100; i++) { 
			Monom m = randomMonom();
			Monom mCopy = new Monom(m.toString());
			assertTrue(m.equals(mCopy), m+" isn't equals to his copy: " + mCopy);
		}
	}
	@Test
	void testCopy() {
		for (int i = 0; i < 100; i++) { 
			Monom m = randomMonom();
			Monom mCopy = (Monom)m.copy();
			assertTrue(m.equals(mCopy), m+" isn't equals to his copy: " + mCopy);
		}
	}

	public static Monom randomMonom() {
		double c = Math.random()*20*(Math.random()-0.5); //some number in range -10 to 10
		int p = (int)(Math.random()*10);
		return new Monom(c,p);
	}

}
