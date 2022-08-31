package TestNGTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import POMPages.glSearchObj;
import Practice.InvokeBrowser;
import utility.excelDataprovide;


public class TestNGExtentREport {
	WebDriver driver = null;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	String browser;
	


	@DataProvider(name= "test1data")
	public Object[][] getData(){
		System.out.println("Inside get data");
		String excelpath = "/testData/testdata.xlsx";
		String sheetName = "Sheet1";
		String Datakey = "mytestdata1";

		Object Data[][] = excelDataprovide.read(excelpath,sheetName);
		return Data;
	}
	@BeforeTest
	public void testNGsetup(){

		htmlReporter = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		test = extent.createTest("MyFirstTest");
		test.log(Status.INFO, "starting Test Cases");
		test.info("Testing sampl information to be added");
		System.out.println("Inside before test");
	}

	@BeforeMethod
	public void testSetup()throws Exception{
		try{
			String url = "https://google.com";
			browser = "Chrome";
			driver = InvokeBrowser.OpenBrowser(url,browser);
			System.out.println("browser launched");
			test.pass(browser+ " browser launched");
			//	Thread.sleep(1000);
		}catch(Exception e){
			System.out.println(e.getMessage());
			test.fail("Failed browser launch"+e.getMessage());
			test.addScreenCaptureFromPath("screenshot.png");

		}

	}
	@Test(dataProvider="test1data")
	public void testCase1(String url, String SerachText) throws Exception{
		try{
			System.out.println("Inside test");
			glSearchObj serachObj = new glSearchObj(driver);

			serachObj.googlesearch(SerachText);
			test.pass("Search text entered in google search box "+SerachText);
			serachObj.googlesearchenter();
			test.pass("Google search engine started");

		}catch(Exception e){
			System.out.println(e.getMessage());
			test.fail("Object search failed"+e.getMessage());
			test.addScreenCaptureFromPath("screenshot.png");

		}
	}

	@Test(priority = 2)
	public void testCase2() throws IOException{
		try{
			glSearchObj serachObj = new glSearchObj(driver);

			serachObj.googlesearch("Looking for quest");
			test.pass("Search text entered in google search box"+" Looking for quest");
			serachObj.googlesearchenter();
			test.pass("Google search engine started");
			//	throw new Exception(" froce failed");

		}	catch(Exception e){
			System.out.println(e.getMessage());
			test.fail("Object search on googlesearch"+e.getMessage());
			test.addScreenCaptureFromPath("screenshot.png");
		}

	}
	@Test
	public void testCase3() throws IOException{
		try{
			System.out.println("placeholder for a TC3");
			test.pass("Google search engine started");
			//	throw new Exception(" froce failed");

		}	catch(Exception e){
			System.out.println(e.getMessage());
			test.fail("Tc3 Fail message"+e.getMessage());
			test.addScreenCaptureFromPath("screenshot.png");
		}

	}

	@AfterMethod
	public void teaDown(){
		driver.close();
		//	driver.quit();
		test.pass(browser +" browser Closed");
	}
	@AfterTest
	public void testNGflush(){
		System.out.println("Testing completed");
		extent.flush();		
	}


}
