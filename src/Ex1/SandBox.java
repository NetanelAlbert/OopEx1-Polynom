package Ex1;

import com.google.gson.Gson;

public class SandBox {

	public static void main(String[] args) {
		ComplexFunction cf1 = new ComplexFunction("div", new Polynom("x+1"), new Monom(3,4));
		//function cf2 = cf1.initFromString("Mul(3x^5-4X,plus(x,7x))");
		System.out.println("cf1: "+cf1);
		//System.out.println("cf2: "+cf2);
		Gson g = new Gson();
	}

}
