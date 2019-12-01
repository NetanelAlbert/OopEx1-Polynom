package Ex1;

public class SandBox {

	public static void main(String[] args) {
		Polynom p = new Polynom("x^3-8x+4");
		Monom m = new Monom("x^2");
		p.multiply(m);
		System.out.println(p);
		
	}

}
