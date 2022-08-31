package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InvokeBrowser {

	public static WebDriver OpenBrowser(String url, String Browser) {
		WebDriver driver;
	//	String Browser ="edge";
	//	String url ="https://google.com";
		switch (Browser.toLowerCase()) {
        case "chrome":
        	WebDriverManager.chromedriver().setup();
       /* 	ChromeOptions options = new ChromeOptions();
    		options.addArguments("--headless");
        	
        	driver = new ChromeDriver(options); */
        	driver = new ChromeDriver();
    		
            break;
        case "edge":
        	WebDriverManager.edgedriver().setup();
    		driver = new EdgeDriver();
            break;
        case "firefox":
        	WebDriverManager.firefoxdriver().setup();
    		driver = new FirefoxDriver();
            break;
        default: 
        	WebDriverManager.chromedriver().setup();
    		driver = new ChromeDriver();
            break;
	    }

		driver.get(url);
		//driverMap.put(Thread.currentThread().getId(),driver);
		driver.manage().window().maximize();
		driver.manage().window().maximize();
		return driver;
		
	}

	}


