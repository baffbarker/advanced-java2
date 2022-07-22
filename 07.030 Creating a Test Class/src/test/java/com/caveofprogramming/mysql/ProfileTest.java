package com.caveofprogramming.mysql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.caveofprogramming.db.Profile;

public class ProfileTest {
	
	@Test
	public void testLoadDbConfig() {
		var props = Profile.getProperties("db");
		
		assertNotNull("cannot load db properties", props);
		
		var dbName = props.getProperty("database");
		
		assertEquals("dbName incorrect", "peopletest", dbName);
	}

}
