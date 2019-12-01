package Ex1;
/**
 * This class represents a simple (naive) tester for the Monom class, 
 */
public class MonomTest {
	public static void main(String[] args) {
		System.out.println("MonomTest:\n");

		equalsToString();
		wrongMonom();
		
		System.out.println("\nEnd of MonomTest");
	}
	
	private static void equalsToString() { // checking String contractor good cases
		int fails = 0;
		for (int i = 0; i < 100; i++) { 
			Monom m = randomMonom();
			Monom mCopy = new Monom(m.toString());
			if(!m.equals(mCopy)) {
				System.out.println("wrong: " + m + " != " + mCopy);
				fails++;
			}
		}
		if(fails == 0)
			System.out.println("equalsToString: good");
		else
			System.out.println("equalsToString: " + fails + " fails");
	}

	private static void wrongMonom() { // checking String contractor bad cases
		String[] str = {
		"1.0x^2.2"
		,"23.0.2x^8"
		, "4.0xx"
		, "-56.0y^3"
		, "-(78.0)"
		, "1.0x^2^8"
		, "3*4X^2"
		, "3x^^7"
		, "x^x"
		, "x-^1"
		, "x8^3"
		, "x^2*3"
		, "8-x"};
		int fails = 0;
		for (int i = 0; i < str.length; i++) {
			try {
				new Monom(str[i]);
				System.out.println("wrong: " + str[i]);
				fails++;
			} catch (Exception e) {
				
			}
		}
		if(fails == 0)
			System.out.println("wrongMonom: good");
		else
			System.out.println("wrongMonom: " + fails + " fails");
	}
	
	public static Monom randomMonom() {
		double c = Math.random()*100*(Math.random()-0.5); //some number in range -50 to 50
		int p = (int)(Math.random()*10);
		return new Monom(c,p);
	}
	
	
}