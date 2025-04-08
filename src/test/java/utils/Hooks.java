package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.*;

public class Hooks {
	public  static ExtentReports extent;
	public  static ExtentTest extentTest;

    @BeforeAll
    public static void setupReport() {
    	if(extent==null) {
    	 ExtentSparkReporter sparkReporter = new ExtentSparkReporter("C:\\Users\\sakum\\eclipse-workspace\\BDD_Restassured\\target\\ExtentReport.html");
    	   
    	    extent = new ExtentReports();
    	    extent.attachReporter(sparkReporter);
    	    
    	    extent.setSystemInfo("OS", System.getProperty("os.name"));
    	    extent.setSystemInfo("Tester", "Sanath Kumar");
    	    System.out.println("101");
    }}
    	@Before
    	public void beforeScenario(Scenario scenario) {
    		Hooks.extentTest = Hooks.extent.createTest(scenario.getName());
    }

    	@After
    	public void afterScenario(Scenario scenario) {
    		 if (scenario.isFailed()) {
    		        Hooks.extentTest.fail("Scenario failed: " + scenario.getName());
    		    } else {
    		        Hooks.extentTest.pass("Scenario passed: " + scenario.getName());
    		    }
    	}

    @AfterAll
    public static void tearDownReport() {
    	if (extent != null) {
            extent.flush(); 
            System.out.println("Extent Report generated successfully!");
        }
        
        //ExtentReportManager.getInstance().flush();
        
    }
}

