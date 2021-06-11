package pageObjects;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//rahulonlinetutor@gmail.com
public class LandingPage {

	
	public WebDriver driver;
	
	 
	
	By flight=By.xpath("//*[@id='flights']");
	
	By tripType=By.xpath("//*[@id='left-search']/div[1]/div/label[2]/input");
	By fromCity=By.xpath("//*[@Name='fromCity']");
	
	By optionFromCity=By.xpath("//*[@id='ui-id-7']/li");
	By toCity=By.xpath("//*[@Name='toCity']");
	By optionToCity=By.xpath("//*[@id='ui-id-8']/li");
	
	By departDate=By.xpath("//*[@id='dpf1']");
//	By selectDate=By.xpath("//div[@class='datepicker-days']/table/tbody/tr[2]//td[@class='day  active']");
	
	By selectDate=By.xpath("/html/body/div[11]/div[1]/table/tbody/tr[4]/td[6]");
	By noOfPassengerAdult=By.xpath("//*[@id='Adults']");
	By noOfPassengerChild=By.xpath("//*[@id='Childs']");
	By travelClass=By.xpath("//select[@Name='cabinClass']");
	By searchFlight=By.xpath("//*[@id='searchFlightsBtn']");
	
	
	

	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}




	public WebElement getFlight()
	{
		 return driver.findElement(flight);
		 	 
		 
	}
	public WebElement getTripType()
	{
		return driver.findElement(tripType);
	}
	public WebElement getFromCity()
	{
		return driver.findElement(fromCity);
	}
	
	public WebElement getOptionFromCity()
	{
		return driver.findElement(optionFromCity);
	}
	
	public WebElement getToCity()
	{
		 return driver.findElement(toCity);
		 	 
		 
	}
	
	public WebElement getOptionToCity()
	{
		 return driver.findElement(optionToCity);
		 	 
		 
	}
	public WebElement getDepartDate()
	{
		return driver.findElement(departDate);
	}
	
	
	public WebElement getSelectDate()
	{	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		return driver.findElement(selectDate);
	}
	public WebElement getNoOfPassengerAdult()
	{
		return driver.findElement(noOfPassengerAdult);
	}
	
	public WebElement getNoOfPassengerChildt()
	{
		return driver.findElement(noOfPassengerChild);
	}
	public WebElement getTravelClass()
	{
		return driver.findElement(travelClass);
	}
	
	
	public SearchPage getSearchFlight()
	{
		driver.findElement(searchFlight).click();
		
		return new SearchPage(driver);
	}
	
	
	
}
