package POMPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class glSearchObj {
	WebDriver driver = null;
	By searchbox = By.name("q");
	By serachbutton = By.name("btnk");
	
	public glSearchObj(WebDriver driver){
		this.driver = driver;
		
	}
	
	public void googlesearch(String url,String searchtext){
		driver.get(url);
		driver.findElement(searchbox).sendKeys(searchtext);
	}
	public void googlesearchenter(){
		driver.findElement(searchbox).sendKeys(Keys.ENTER);
	}
	public void browserBack(){
		driver.navigate().back();
	}

}
