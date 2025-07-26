package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Get_Json_data {

	public List<HashMap<String, String>> getJsonDataToMap() throws IOException {
		
		// Read Json to String
		String jsonData = FileUtils.readFileToString(
			    new File("Selenium_java_framework/src/main/java/resources/test_data.json"),
			    StandardCharsets.UTF_8);
	
 
 //Read Json Data and conver that into Hapmap format and sends
 	ObjectMapper mapper=new ObjectMapper();
 	List<HashMap<String, String>> data = mapper.readValue(jsonData, new TypeReference<List<HashMap<String, String>>>() {});

		return data;
	}
	
	
}
