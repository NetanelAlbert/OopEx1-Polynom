package Ex1;

import java.io.IOException;

import org.junit.Test.None;

import com.google.gson.Gson;

public class SandBox {

	public static void main(String[] args) {
		ComplexFunction cf1 = new ComplexFunction("min", new Polynom("x+5"), new Monom(3,2));
		
		Functions_GUI fgui = new Functions_GUI();
		/*fgui.add(cf1);
		fgui.add(cf1.initFromString("max(0.3x^5, 1.2x^7)"));
		fgui.add(cf1.initFromString("2 + 3x + x^4"));
		fgui.add(cf1.initFromString("3"));
		fgui.add(cf1.initFromString("comp(2.5x - x^3, div(8x, 5))"));
		*/
		ComplexFunction cf2 = (ComplexFunction)cf1.initFromString("div(x,x+1)");//("div(1,x-2)");
		
		fgui.add(cf2);
		
		fgui.drawFunctions("blaGUI_params.txt");
		
	}

}
