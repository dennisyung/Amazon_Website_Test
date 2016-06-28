package test.java.unittests;

import static org.junit.Assert.*;
import static test.java.implementation.utils.TestConstants.*;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class UtilitiesUnitTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Starting the test for Utilities Constants");
		//Getting the JSONObject from file
    	//Test data json string
    	//JSONObject obj = getJsonDataFromFile(TESTDATA_FILEPATH);
    	//System.out.println(obj.toString());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Done the tests for Utilities Constants");
	}

	@Test
	public void test() {
		//Test JSONObject to HashMap conversion
    	//HashMap<String,Object> map = convertFromJsonObjectToHashMap(obj);
	}

}
