package Ex1;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import com.google.gson.Gson;

public class Functions_GUI extends ArrayList<function> implements functions {

	@Override
	public void initFromFile(String file) throws IOException {
		java.util.List<String> sl = null;
		try {
			sl = Files.readAllLines(Paths.get(file));
		} catch (IOException e) {
			throw new IOException("file '"+file+"' not exist");
		}
		clear();
		ComplexFunction cf = new ComplexFunction(new Monom(0,0));
		for (int i = 0; i < sl.size(); i++) {
			try {
				add(cf.initFromString(sl.get(i)));
			} catch (Exception e) {
				throw new IOException("file is not in correct format");
			}
		}

	}

	@Override
	public void saveToFile(String file) throws IOException {
		ArrayList<String> sl = new ArrayList<String>();
		for (int i = 0; i < size(); i++) {
			sl.add(get(i).toString());
		}

		Files.write(Paths.get(file), sl);

	}

	@Override
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution) {
		
		StdDraw.setCanvasSize(width, height);
		StdDraw.setXscale(rx.get_min(), rx.get_max());
		StdDraw.setYscale(ry.get_min(), ry.get_max());
		// axis
		StdDraw.line(rx.get_min(), 0, rx.get_max(), 0);
		StdDraw.line(0, ry.get_min(), 0, ry.get_max());
		
		for (int i = (int)rx.get_min()+1; i < rx.get_max(); i++) {
			if(i == 0)
				continue;
			StdDraw.line(i, -0.2, i, 0.2);
			StdDraw.text(i, -0.5, i+"");
		}
		
		for (int i = (int)ry.get_min()+1; i < ry.get_max(); i++) {
			if(i == 0)
				continue;
			StdDraw.line(-0.2, i, 0.2, i);
			StdDraw.text(0.5, i, i+"");
		}
		Color[] colors = {StdDraw.BLUE, StdDraw.YELLOW, StdDraw.RED, StdDraw.PRINCETON_ORANGE,
				StdDraw.PINK ,StdDraw.BOOK_BLUE, StdDraw.MAGENTA, StdDraw.ORANGE, StdDraw.LIGHT_GRAY,
				StdDraw.GREEN, StdDraw.DARK_GRAY, StdDraw.CYAN, StdDraw.BOOK_RED, StdDraw.BOOK_BLUE,
				StdDraw.BOOK_LIGHT_BLUE, StdDraw.GRAY};
		
		double x_step = rx.size()/resolution;
		for (int i = 0; i < size(); i++) {
			StdDraw.setPenColor(colors[i % colors.length]);
			function fun = get(i);
			Double f, fStep = null;
			try {
				f = fun.f(rx.get_min());				
			} catch (Exception e) {
				f=null;
			}
			for (double x = rx.get_min(); x < rx.get_max(); x += x_step) {
				try {
					fStep = fun.f(x+x_step);
					if(f != null && fStep != null)
						StdDraw.line(x, f, x+x_step, fStep);
				} catch (Exception e) {
					fStep = null;
				} finally {
					f = fStep;										
				}
			}	
		}
	}

	@Override
	public void drawFunctions(String json_file) {
		Gson gson = new Gson();	
		Reader reader=null;
		GUI_params params;
		try {
			reader = new FileReader(json_file);
			params = gson.fromJson(reader, GUI_params.class);
		} catch (FileNotFoundException e) {
			params = new GUI_params();
		}
		
		Range rx = new Range(params.Range_X[0], params.Range_X[1]);
		Range ry = new Range(params.Range_Y[0], params.Range_Y[1]);
		drawFunctions(params.Width, params.Height, rx, ry, params.Resolution);
	}
	
	private class GUI_params{
		int Width = 1000;
		int Height = 600;
		double[] Range_X = {-10, 10};
		double[] Range_Y = {-10, 10};
		int Resolution = 200;
		
	}

}
