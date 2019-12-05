package Ex1;

import java.io.IOException;
import java.util.ArrayList;
import com.google.gson.Gson;

public class Functions_GUI extends ArrayList<function> implements functions {
	
	@Override
	public void initFromFile(String file) throws IOException {
		Gson g = new Gson();
		
	}

	@Override
	public void saveToFile(String file) throws IOException {
		/*
		 * Gson g = new Gson(); String json = g.toJson(this); Functions_GUI fg =
		 * g.fromJson(json, Functions_GUI.class); for (int i = 0; i < fg.size(); i++) {
		 * System.out.println(get(i)); }
		 */
	}

	@Override
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawFunctions(String json_file) {
		// TODO Auto-generated method stub

	}

}
