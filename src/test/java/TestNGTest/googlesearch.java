package TestNGTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import POMPages.glSearchObj;
import Practice.InvokeBrowser;


public class googlesearch {
	static WebDriver driver;
	
	@BeforeTest
	public void setupTest() {
		String url = "https://google.com";
		String browser = "chrome";
		driver = InvokeBrowser.OpenBrowser(url, browser);
	}
	@Test
	public static void serchtest(){

		glSearchObj serachObj = new glSearchObj(driver);
		serachObj.googlesearch("subhankar Panigrahi");
		serachObj.googlesearchenter();

	}
	@AfterTest
	public void teardownTest() {
		driver.close();
		driver.quit();
	}

}
