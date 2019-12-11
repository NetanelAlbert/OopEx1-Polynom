package Ex1Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import Ex1.ComplexFunction;
import Ex1.Functions_GUI;
import Ex1.Monom;

class UnitTestFunctions_GUI {
	public static String[] cfs =  {
			"comp(comp(-4.0x^2+5.0x^3-2.0x^4,-2.0+x^2),0)",
			"max(plus(x,-3),6.0x^3)",
			"div(div(3.0x^8,2.0+x^3-12.0x^7+x^2),-2.0x^3)",
			"max(comp(4.0x^8,-x-2.0x^2+4.0x^6),7.0x^5-x^5)",
			"max(max(3.0x^6-4.0x^4,-4.0-3.0x^9),1.5)",
			"max(-2.0x^3,-x)",
			"mul(2.0x^4,-2.0x^2-x^5)",
			"min(mul(x-2.0x^3-5.0x^6,5.0x^3-5.0x^4-3.0x^5),x-x^4)",
			"div(4.0x^5,-2.0x^6+4.0x^8)",
			"plus(plus(-9.0x^3+4.0x^8,0),-2.0x^3)",
			"mul(comp(-4.0,0),-2.0x^3)",
			"comp(comp(0.7x,-x^3),4.0x^3+x^4+x^2)",
			"plus(max(-1+x^3+x^5,0.2x),3.0x^9)",
			"comp(-3.0x^2+3.0x^4-5.0x^8,x^3-x^4-9.0x^5)",
			"comp(3.0x^6+7.0x^3,3x+1)",
			"plus(-3.0x^3,-2.0x^6+2.0x^2)",
			"div(comp(0.2x^3,x-1),3.0x)",
			"mul(max(-4.0x^6-x^8,0),5.0x^2+4.0x^3)",
			"plus(3.0x^6,4.0x^4)"
	};
	
	@Test
	void testSaveAndInitFileAndDrow() {
		Functions_GUI fgui1 = new Functions_GUI();
		ComplexFunction cf = new ComplexFunction(new Monom(0,0));
		for (int i = 0; i < cfs.length; i++) {
			fgui1.add(cf.initFromString(cfs[i]));
		}
		try {
			fgui1.saveToFile("UnitTestFunctions_GUI.txt");
		} catch (IOException e) {
			fail(e.getMessage());
		}
		Functions_GUI fgui2 = new Functions_GUI();
		try {
			fgui2.initFromFile("UnitTestFunctions_GUI.txt");
		} catch (IOException e) {
			fail(e.getMessage());
		}
		for (int i = 0; i < fgui1.size(); i++) {
			assertEquals(fgui1.get(i), fgui2.get(i));	
		}
		
		// draw GUI
		fgui1.drawFunctions("GUI_params.txt");
	}
	
}
