package Ex1;
/**
 * This class represents a simple (naive) tester for the Monom class, 
 */
public class PolynomTest {

	public static void main(String[] args) {
		System.out.println("PolynomTest:\n");
		substractTest();
		equalsToString();
		copyTest();
		WrongPolynom();
		//derivativeTest();
		//areaTest();
		rootTest();
		System.out.println("\nEnd of PolynomTest");
	}
	
	
	private static void substractTest() {
		System.out.println("substractTest - start ");
		int fails = 0;
		for (int i = 0; i < 100; i++) { 
			Polynom p = randomPolynom();
			p.substract(p);
			if(!p.isZero()) {
				System.out.println("wrong: " + p + " != 0");
				fails++;
			}
		}
		if(fails == 0)
			System.out.println("substractTest: good");
		else
			System.out.println("substractTest: " + fails + " fails");
	}
	
	private static void copyTest() {
		System.out.println("copyTest - start");
		int fails = 0;
		for (int i = 0; i < 100; i++) { 
			Polynom p = randomPolynom();
			Polynom pCopy = (Polynom)p.copy();
			if(!p.equals(pCopy)) {
				System.out.println("wrong: " + p + " != " + pCopy);
				fails++;
			}
		}
		if(fails == 0)
			System.out.println("copyTest: good");
		else
			System.out.println("copyTest: " + fails + " fails");

	}
	
	private static void equalsToString() { // checking String contractor good cases
		System.out.println("equalsToString - start");
		int fails = 0;
		for (int i = 0; i < 100; i++) { 
			Polynom p = randomPolynom();
			Polynom pCopy = new Polynom(p.toString());
			if(!p.equals(pCopy)) {
				System.out.println("wrong: " + p + " != " + pCopy);
				fails++;
			}
		}
		if(fails == 0)
			System.out.println("equalsToString: good");
		else
			System.out.println("equalsToString: " + fails + " fails");
	}
	
	private static Polynom randomPolynom() {
		int monoms = (int)(Math.random()*10);
		Polynom p = new Polynom();
		for (int i = 0; i < monoms; i++) {
			p.add(MonomTest.randomMonom());
		}
		return p;
	}
	 
	
	private static void WrongPolynom() { // checking String contractor bad cases
		System.out.println("WrongPolynom - start");
		String[] str = {
			"x+y",
			"3x^12--5",
			"2x*6+13",
			"qwerty",
			"3/x^3+5-13x",
			"(1+x+x^2)",
			"(1+x)*(1-x)"
		};
		int fails = 0;
		for (int i = 0; i < str.length; i++) {
			try {
				new Polynom(str[i]);
				System.out.println("wrong: " + str[i]);
				fails++;
			} catch (Exception e) {
				
			}
		}
		if(fails == 0)
			System.out.println("WrongPolynom: good");
		else
			System.out.println("WrongPolynom: " + fails + " fails");
	}
	
	/*private static void derivativeTest() {
		System.out.println("derivativeTest - start");
		int fails = 0;
		String[] polinoms = {"3x^5-x^3+9.2x-3", "9x^9+8x^3", "2345"};
		String[] derivatives = {"15x^4-3x^2+9.2", "81x^8+24x^2", "0"};
		for (int i = 0; i < polinoms.length; i++) {
			Polynom p = new Polynom(polinoms[i]);
			Polynom d = new Polynom(derivatives[i]);
			if(!p.derivative().equals(d)) {
				System.out.println("derivativeTest fail: '" + p.derivative() 
				+ "' isn't the derivative of '" + p + "'");
				fails++;
			}
		}
		if(fails == 0)
			System.out.println("derivativeTest: good");
		else
			System.out.println("derivativeTest: " + fails + " fails");
	}*/
	
	/*private static void areaTest() {
		System.out.println("areaTest - start (might take a few seconds)");
		int fails = 0;
		String[] polinoms = {"x^2+3x-5", "x^3-x^2+0.5", "x"};
		double[] area = {23.25,38.859375, 4.875};
		for (int i = 0; i < polinoms.length; i++) {
			Polynom p = new Polynom(polinoms[i]);
			double pArea = p.area(2.5, 4, Monom.EPSILON);
			double diff = Math.abs(pArea - area[i]);
			if(diff > Monom.EPSILON) {
				System.out.println("areaTest fail: '" + p 
				+ "' area should be " + area[i] + " and not " + pArea);
				fails++;
			}
		}
		if(fails == 0)
			System.out.println("areaTest: good");
		else
			System.out.println("areaTest: " + fails + " fails");
	}*/
	
	private static void rootTest() {
		System.out.println("rootTest - start");
		int fails = 0;
		String[] polinoms = {"x^4-16", "x^2-9", "x-8"};
		double[] root = {2, 3, 8};
		for (int i = 0; i < polinoms.length; i++) {
			Polynom p = new Polynom(polinoms[i]);
			double pRoot = p.root(1, 10, Monom.EPSILON);
			double diff = Math.abs(pRoot - root[i]);
			if(diff > Monom.EPSILON) {
				System.out.println("rootTest fail: '" + p 
				+ "' root should be " + root[i] + " and not " + pRoot);
				fails++;
			}
		}
		if(fails == 0)
			System.out.println("rootTest: good");
		else
			System.out.println("rootTest: " + fails + " fails");
	}
}
