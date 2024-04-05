package genericScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class HandlingPropertyFile {
	public static String getProperty(String path, String key) throws Exception
	{
		FileInputStream fis = new FileInputStream(path);
		Properties p = new Properties();
		
		p.load(fis);
		
		return p.getProperty(key);
	}
}
