package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//rahulonlinetutor@gmail.com
public class SearchPage {

	
	public WebDriver driver;
	
	By fromCitySearch=By.xpath("//div[@class='col-sm-4']//span[1]");
	By toCitySearch=By.xpath("//div[@class='col-sm-4']//span[3]");
	
	
	
	
	public SearchPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}




	public WebElement getFromCitySearch()
	{
		return driver.findElement(fromCitySearch);
	}
	

	public WebElement getToCitySearch()
	{
		return driver.findElement(toCitySearch);
	}
	
	
	
}
