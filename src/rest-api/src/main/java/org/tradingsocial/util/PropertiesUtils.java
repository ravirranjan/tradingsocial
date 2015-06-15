package org.tradingsocial.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesUtils {

	private final static Logger log = LoggerFactory.getLogger(PropertiesUtils.class);

	public static Properties getProperties(String propFile) {
		InputStream input = null;
		Properties props = null;
		try {
			if (props == null) {
				props = new Properties();
				input = PropertiesUtils.class.getClassLoader().getResourceAsStream(propFile);
			
				if (input == null) {
					log.debug("Sorry, unable to find " + propFile);
					return null;
				}

				// load a properties file from class path, inside static method
				props.load(input);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return props;
	}

}
