package com.caveofprogramming.db;

import java.io.IOException;
import java.util.Properties;

public class Profile {
	public static Properties getProperties(String name) {
		Properties props = new Properties();

		String env = System.getProperty("env");
		
		if(env == null) {
			env = "dev";
		}
		
		String propertiesFile = String.format("/config/%s.%s.properties", name, env);
		
		try {
			props.load(App.class.getResourceAsStream(propertiesFile));
		} catch (IOException e1) {
			throw new RuntimeException("Cannot load proeprties file:" + propertiesFile);
		}
		
		return props;
	}
}
