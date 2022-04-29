package resources;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import io.ous.jtoml.ParseException;

public class employeejsonreader {
	public HashMap<String, String> employeeJsondata() throws org.json.simple.parser.ParseException {
		HashMap<String, String> hm = null;
		JSONParser jsonParser = new JSONParser();
		try {

			FileReader file = new FileReader("C:\\Users\\saita\\Desktop\\Manju Workspace\\MAVEN1\\src\\test\\java\\resources\\employees.json");

			Object obj = jsonParser.parse(file);
            JSONObject empobj = (JSONObject) obj;
			hm = (HashMap<String, String>) empobj.get("Employee");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		

		return hm;
	}
}
