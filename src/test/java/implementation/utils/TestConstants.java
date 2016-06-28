package test.java.implementation.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.apache.commons.lang3.StringEscapeUtils;


public final class TestConstants {

	//Paths for the different drivers (for different browsers).  Note - FireFox driver comes default with WebDriver.
    public static final String PROJECT_PATH = "C:\\Users\\den\\workspace\\Amazon_Website_Test";
    public static final String IMPLEMENTATION_UTILS_PATH = PROJECT_PATH + "\\src\\test\\java\\implementation\\utils";
    public static final String CHROME_DRIVER_PATH = PROJECT_PATH + "\\src\\test\\resources\\testdata\\drivers\\chromedriver_win32\\chromedriver.exe";
    public static final String IE_DRIVER_PATH = PROJECT_PATH + "\\src\\test\\resources\\testdata\\drivers\\internetexplorer_driver\\IEDriverServer.exe";
    
    //Path to the feature files
    public static final String FEATURE_RELATIVE_PATH = "src/test/resources/featureFiles";
    
    //Path to the cucumber "glue".  I.e. the path to the cucumber step definitions:
    public static final String STEPDEFS_RELATIVE_PATH = "test.java.bddtest";
    
    //Paths for JSON data - for data driven solutions
    public static final String TESTDATA_PATH = PROJECT_PATH + "\\src\\test\\resources\\testdata";
    
    //Absolute paths for specific JSON data files
    //*****ALL DATA IS READ FROM THIS FILE PATH DEFINITION ******* (Modify path as appropriate)
    public static final String TESTDATA_FILEPATH = TESTDATA_PATH + "\\testdata.json";
    
    //Reference to the JSON Root data object
    public static final JSONObject JSON_ROOT_DATA_OBJ = getJsonDataFromFile(TESTDATA_FILEPATH);
    
    
    //Reference to the JSON test data object
    public static final JSONObject JSON_TEST_DATA_OBJ = getTestData();
    //The browser type used for running the test
    public static final String TEST_BROWSER_TYPE = getBrowserType();
    //The timeout in seconds to wait for any implicit action
    public static final long TEST_WAIT_TIMEOUT = getWaitTimeOut();
    //The boolean of whether to run the test using debug logging or not
    public static final boolean TEST_DEBUG_MODE = getDebugMode();
    //The login data returned as a list of JSONOBjects
    public static final JSONArray TEST_VALID_LOGIN_DATA_JSONARRAY = getValidLoginData();
    //The wishlist data returned as a list of JSONOBjects
    public static final JSONObject TEST_WISHLIST_DATA = getWishListData();   
    
    //The generalcapabilities hashmap
    public static final HashMap<String, Object> TEST_GENERAL_CAPABILITIES = getGeneralCapabilities();
    //The firefox desired Capabilities
    public static final DesiredCapabilities TEST_FIREFOX_DESIRED_CAPABILITIES = getFirefoxCapabilities();
    //The Chrome desired Capabilities
    public static final DesiredCapabilities TEST_CHROME_DESIRED_CAPABILITIES = getChromeCapabilities();
    //The IE desired Capabilities
    public static final DesiredCapabilities TEST_IE_DESIRED_CAPABILITIES = getIECapabilities();    
    
    
    
    public TestConstants()
    {
        //This constructor is only used for using the java reflection methods to dynamically get the field's by referencing variable name
    	//See the method below - replaceConstantVariablesWithValues 
    	
    }
    
    private static ArrayList<String> getConstantVariablesToReplaceInJSON()
    {
    	ArrayList<String> list = new ArrayList<String>();
    	list.add("PROJECT_PATH");
    	list.add("TESTDATA_PATH");
        return list;
    }
    
    private static JSONObject getJsonDataFromFile(String filepath)
    {
    	JSONObject jsonObj = null;
    	JSONParser jsnparser = new JSONParser();
    	try {
			jsonObj = (JSONObject) jsnparser.parse(new FileReader(filepath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObj;
    }
    
    private static String getBrowserType()
    {
    	JSONObject obj = getJsonDataFromFile(TESTDATA_FILEPATH);
    	JSONObject runOptions = (JSONObject) obj.get("runoptions");
    	String browserType = (String) runOptions.get("browsertype");
    	
    	return browserType;
    }
    
    private static long getWaitTimeOut()
    {
    	JSONObject obj = getJsonDataFromFile(TESTDATA_FILEPATH);
    	JSONObject runOptions = (JSONObject) obj.get("runoptions");
    	long waitTimeOut = (long) runOptions.get("waittimeout");
    	
    	return waitTimeOut;
    }
    
    private static Boolean getDebugMode()
    {
    	JSONObject obj = getJsonDataFromFile(TESTDATA_FILEPATH);
    	JSONObject runOptions = (JSONObject) obj.get("runoptions");
    	Boolean debugMode = (Boolean) runOptions.get("debugmode");
    	
    	return debugMode;
    }

    private static JSONObject getTestData()
    {
    	JSONObject obj = getJsonDataFromFile(TESTDATA_FILEPATH);
    	JSONObject testData = (JSONObject) obj.get("testdata");

    	return testData;
    }
    
    private static JSONArray getValidLoginData()
    {
    	JSONObject obj = getJsonDataFromFile(TESTDATA_FILEPATH);
    	JSONObject testData = (JSONObject) obj.get("testdata");
    	JSONArray loginCredentials = (JSONArray) testData.get("validlogindata");
    	return loginCredentials;
    }
    
    private static JSONObject getWishListData()
    {
    	JSONObject obj = getJsonDataFromFile(TESTDATA_FILEPATH);
    	JSONObject testData = (JSONObject) obj.get("testdata");
    	JSONObject wishListData = (JSONObject) testData.get("wishlistdata");
    	return wishListData;
    }
    
    private static HashMap <String,Object> getGeneralCapabilities()
    {
    	JSONObject obj = getJsonDataFromFile(TESTDATA_FILEPATH);
    	JSONObject runOptionsObj = (JSONObject) obj.get("runoptions");
    	JSONObject generalCapab = (JSONObject) runOptionsObj.get("generalcapabilities");
    	HashMap <String,Object> generalCapabMap = convertFromJsonObjectToHashMap(generalCapab);
    	return generalCapabMap;
    }
    
    private static DesiredCapabilities getFirefoxCapabilities()
    {
    	JSONObject obj = getJsonDataFromFile(TESTDATA_FILEPATH);
    	JSONObject runOptionsObj = (JSONObject) obj.get("runoptions");
    	JSONObject firefoxCapab = (JSONObject) runOptionsObj.get("firefoxcapabilities");
    	HashMap <String,Object> firefoxCapabMap = convertFromJsonObjectToHashMap(firefoxCapab);
    	
    	//Merge the generalcapabilities with the firefox capabilities map
    	HashMap <String,Object> generalCapabMap = getGeneralCapabilities();
    	firefoxCapabMap.putAll(generalCapabMap);
    	DesiredCapabilities cap = new DesiredCapabilities(firefoxCapabMap);
    	return cap;
    }
    
    private static DesiredCapabilities getIECapabilities()
    {
    	JSONObject obj = getJsonDataFromFile(TESTDATA_FILEPATH);
    	JSONObject runOptionsObj = (JSONObject) obj.get("runoptions");
    	JSONObject ieCapab = (JSONObject) runOptionsObj.get("iecapabilities");
    	HashMap <String,Object> ieCapabMap = convertFromJsonObjectToHashMap(ieCapab);
    	HashMap <String,Object> generalCapabMap = getGeneralCapabilities();
    	ieCapabMap.putAll(generalCapabMap);
    	DesiredCapabilities cap = new DesiredCapabilities(ieCapabMap);
    	return cap;
    }
    
    private static HashMap <String,Object> getChromeOptions()
    {
    	JSONObject obj = getJsonDataFromFile(TESTDATA_FILEPATH);
    	JSONObject runOptionsObj = (JSONObject) obj.get("runoptions");
    	JSONObject chromeOptions = (JSONObject) runOptionsObj.get("chromeoptions");
    	HashMap <String,Object> chromeOptionsMap = convertFromJsonObjectToHashMap(chromeOptions);
    	chromeOptionsMap = replaceConstantVariablesWithValues(chromeOptionsMap, getConstantVariablesToReplaceInJSON());
    	return chromeOptionsMap;
    }
    
    private static DesiredCapabilities getChromeCapabilities()
    {
    	HashMap<String,Object> options = getChromeOptions();
    	DesiredCapabilities capChrome = DesiredCapabilities.chrome();
    	capChrome.setCapability(ChromeOptions.CAPABILITY, options);
    	//Merge the general capabilities to the other chrome options capabilities
    	HashMap <String,Object> generalCapabMap = getGeneralCapabilities();
    	DesiredCapabilities generalCap = new DesiredCapabilities(generalCapabMap);
    	capChrome.merge(generalCap);
    	return capChrome;
    }
    
    //If there are any constants used in the JSON source, we need to ensure that
    //all instances are replaced with the corresponding constant value.
    //Example - if PROJECT_PATH is referenced in JSON, it needs to have it's actual
    //path value substituted.  We will use this method to process any HashMap object
    //@map - the HashMap to use for input to process
    //@constantVariables - the List of constant Variables you want to search in hashmap and replace with its literal value
    @SuppressWarnings("unchecked")
	private static HashMap<String, Object> replaceConstantVariablesWithValues(HashMap<String, Object> map, List <String> constantVariables)
    {
    	
    	for (Object key : map.keySet())
    	{
    		System.out.println("key <" + key.toString() + "> + class instance: " + map.get(key).getClass().toString());
    		//If the item's value is another Map
    		if (map.get(key) instanceof Map<?, ?>)  //Check if the value of key is another map instead of a primitive value or string
    		{
    			//In this case, iterate through the map and recursively call the method
    			replaceConstantVariablesWithValues((HashMap<String, Object>) map.get(key), constantVariables);
    		}
    		else if (map.get(key) instanceof ArrayList)
    		{
    			for (Object item : (ArrayList<Object>) map.get(key))
    			{
    				if (item instanceof Map<?, ?>)
    				{
    	    			replaceConstantVariablesWithValues((HashMap<String, Object>)item, constantVariables);	
    				}
    				
    				else if (item instanceof String)
    				{
        				//Replace each constantVariable in the string  
        				for (String variable : constantVariables)
        				{
            	            String fieldValue = getFieldFromClass(variable);
            	            fieldValue = StringEscapeUtils.escapeJava(fieldValue);
            				System.out.println("Attempting to now replace variable <" + variable + "> with value <" + fieldValue + ">");
            	    		String newValue = map.get(key).toString().replaceAll(variable, fieldValue);
                			map.put((String)key, newValue);
        				}
    				}
    			}
    		}
    		else  //Otherwise, the value of the key is not another map (i.e String), and we would like to process it here
    		{
    			if (map.get(key) instanceof String)  //If it's a String then process the key's value
    			{
    				//Replace each constantVariable in the string  
    				for (String variable : constantVariables)
    				{
        	            String fieldValue = getFieldFromClass(variable);
        				System.out.println("Attempting to now replace variable <" + variable + "> with value <" + fieldValue + ">");
        	    		String newValue = map.get(key).toString().replaceAll(variable, fieldValue);
            			map.put((String)key, newValue);
    				}
    				
    			}
    		}
    	}
		return map;
    	
    }
    
    @SuppressWarnings("unchecked")
	private static String getFieldFromClass(String variable)
    {
    	Object clazz = new TestConstants();  //We create this to obtain the getClass and getField methods later
    	Field field = null;
		Class <Object> fieldType = null;
		Object fieldTypeObj = null;
	    String fieldValue = "";
		try
		{
		    field = clazz.getClass().getField(variable);
		    fieldType = (Class<Object>) field.getType();
		    fieldTypeObj = fieldType.newInstance();
		}
		catch(NoSuchFieldException e)
		{
			System.out.println("ERROR - Can NOT get Field from class, field does not exist: " + variable);
			e.printStackTrace();
		}
		catch(IllegalAccessException e)
		{
			System.out.println("ERROR - problem getting the field type or instance");
			e.printStackTrace();
		}
		catch(InstantiationException e)
		{
			System.out.println("ERROR - problem getting the field type or instance");
			e.printStackTrace();
		}
		//If the variable to extract value is static, then we can pass a null value to the get() method
		//Also want to check that the variable type is a String
		if (Modifier.isStatic(field.getModifiers()) && (fieldTypeObj instanceof String))
		{
			try {
				fieldValue = (String) field.get(null);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//Otherwise if the requested variable is non-static, since in our case there are no non-static variables  of concern, just ignore
		else
		{
			System.out.println("Constant variable: <" + variable + "> does not have a static modifier.  We will not replace this variable with a value");
		}
		
		return fieldValue;
    }
    
    
    private static HashMap<String,Object> convertFromJsonObjectToHashMap(JSONObject obj)
    {
    	HashMap<String, Object> retmap = new HashMap<String,Object>();
    	Gson gson = new Gson();
    	String JSONString = obj.toJSONString();
    	Type hashMapType = new TypeToken<HashMap<String,Object>>() {}.getType();
    	retmap = gson.fromJson(JSONString, hashMapType);
    	return retmap;
    }
    
    
    //You can test out whether the JSON is read correctly via the main method
    public static void main (String[] args)
    {
    	//Test data json string
    	JSONObject obj = getJsonDataFromFile(TESTDATA_FILEPATH);
    	System.out.println(obj.toString());
    	
    	//JSONObject to HashMap conversion
    	HashMap<String,Object> map = convertFromJsonObjectToHashMap(obj);
    	System.out.println(map.toString());
    	
    	//Chrome desired capabiliites
    	//DesiredCapabilities chromeCap = getChromeCapabilities();
    	//System.out.println(chromeCap.toString());
    	
    	//Chrome options
    	HashMap<String, Object> chromeOptions = getChromeOptions();
    	System.out.println(chromeOptions.toString());
    	
    	//Chrome capabiliites
    	DesiredCapabilities chromeCapabilities = getChromeCapabilities();
    	System.out.println(chromeCapabilities.toString());
    	/*
    	//general capabiliites
    	HashMap<String, Object> generalCapabilities = getGeneralCapabilities();
    	System.out.println(generalCapabilities.toString());
    	
    	//IE capabiliites
    	DesiredCapabilities iecap = getIECapabilities();
    	System.out.println(iecap.toString());
    	
    	//Firefox capabilities
    	DesiredCapabilities firefoxcap = getFirefoxCapabilities();
    	System.out.println(firefoxcap.toString());
    	
    	//validlogindata
    	JSONArray data = getValidLoginData();
    	System.out.println(data);
    	
    	//validlogindata
    	Boolean mode = getDebugMode();
    	System.out.println(mode);
    	
    	//browsertype
    	String type = getBrowserType();
    	System.out.println(type);
    	
    	
    	*/
    	
    	HashMap <String, Object> x = new HashMap <String, Object>();
    	x.put("arg", "blalalala");
    	List<String> lst = new ArrayList<String>();
    	lst.add("hello");
    	lst.add("hello2");
    	x.put("second", lst);
    	System.out.println(x);
    	
    }
    
    
}
