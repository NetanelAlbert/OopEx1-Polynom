package Ex1;

import java.awt.List;
import java.io.IOException;
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
			throw new IOException("file not exist");
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

	}

	@Override
	public void drawFunctions(String json_file) {
		// TODO Auto-generated method stub

	}

}
