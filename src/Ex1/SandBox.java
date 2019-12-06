package Ex1;

import java.io.IOException;

import org.junit.Test.None;

import com.google.gson.Gson;

public class SandBox {

	public static void main(String[] args) {
		ComplexFunction cf1 = new ComplexFunction("div", new Polynom("x+1"), new Monom(3,4));
		function cf2 = cf1.initFromString("Mul(3x^5-4X,plus(x,7x))");
		Functions_GUI fgui = new Functions_GUI();
		Functions_GUI fgui2 = new Functions_GUI();
		fgui.add(cf1);
		fgui.add(cf2);
		
		try {
			fgui.saveToFile("Functions_GUI.txt");
			fgui2.initFromFile("Functions_GUI.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i < fgui2.size(); i++) {
			System.out.println(fgui2.get(i));
		}
		
		
	}

}
