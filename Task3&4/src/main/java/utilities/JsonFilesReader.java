package utilities;


import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class JsonFilesReader {

    public static String readJsonDataFromFile(String key,String fileName) throws IOException, ParseException {
        String projPath = System.getProperty("user.dir");
        FileReader reader = new FileReader(projPath + "\\TestData\\"+fileName);
        JSONParser parser = new JSONParser();
        JSONObject data = (JSONObject) parser.parse(reader);
        data.get(key);
        return data.get(key).toString();

    }

    public static String readJsonDataUsingPathAsJsonString(String jsonPath,String fileName) throws IOException, ParseException {
        String projPath = System.getProperty("user.dir");
        FileReader reader = new FileReader(projPath + "\\TestData\\"+fileName);

            Map data = JsonPath.from(reader).getMap(jsonPath);
            new JSONObject(data);
            return new JSONObject(data).toJSONString();
    }
    public static String readJsonDataUsingPathAsValue(String jsonPath,String fileName) throws IOException, ParseException {
        String projPath = System.getProperty("user.dir");
        FileReader reader = new FileReader(projPath + "\\TestData\\"+fileName);

        String data = JsonPath.from(reader).getString(jsonPath);
        return data;

    }
    public static String readJsonDataFromFile(String fileName) throws IOException, ParseException {
        String projPath = System.getProperty("user.dir");
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(projPath + "\\TestData\\"+fileName);
        JSONObject obj = (JSONObject) jsonParser.parse(reader);
        return obj.toString();
    }
}
