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
import junit.framework.Assert;
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
		test = extent.createTest("Testing Start ");
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
			test = extent.createTest("Test Case - Search Internet : Search Engine -: "+ url + " Search Text -: "+ SerachText);
		//	test.createNode();
			System.out.println("Inside test");
			glSearchObj serachObj = new glSearchObj(driver);
			

			serachObj.googlesearch(url,SerachText);
			test.pass("Search text entered into search box "+SerachText);
			serachObj.googlesearchenter();
			test.pass("Search engine started");

		}catch(Exception e){
			System.out.println(e.getMessage());
			test.fail("Object search failed"+e.getMessage());
			test.addScreenCaptureFromPath("screenshot.png");

		}
	}

	@Test(priority = 2)
	public void testCase2() throws IOException{
		
		try{
			test = extent.createTest("testCase2- Sample test case ");
		//	test.createNode("testCase2");
			glSearchObj serachObj = new glSearchObj(driver);

			serachObj.googlesearch("https://www.facebook.com/","Looking for quest");
			test.pass("Search text entered in google search box"+" Looking for quest");
			serachObj.googlesearchenter();
			test.pass("Google search engine started");
			//	throw new Exception(" froce failed");

		}	catch(Exception e){
			System.out.println(e.getMessage());
			test.fail("Object search on search engile :" + e.getMessage());
			Assert.assertTrue(false);
			test.addScreenCaptureFromPath("screenshot.png");
		}

	}
	@Test
	public void testCase3() throws IOException{
		try{
			test = extent.createTest("testCase3 Sample test case ");
		//	test.createNode("testCase3");
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
		
		extent.flush();		
		utility.SendAttachmentInEmail.SendReport("subhankar.panigrahi@gmail.com");
		System.out.println("Testing completed");
		
	}


}
