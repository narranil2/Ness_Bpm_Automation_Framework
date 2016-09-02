package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyConfig {

	Properties properties = new Properties();
	InputStream inputStream = null;

	public PropertyConfig() {
		loadProperties();
	}

	private void loadProperties() {
		try {
			inputStream = new FileInputStream("src/main/resources/config.properties");
			properties.load(inputStream);
		} catch (IOException e) {
			System.out.println("Exception Occured:::"+e.getMessage());
		}
	}

	public String readProperty(String key) {
		return properties.getProperty(key);
	}

}
