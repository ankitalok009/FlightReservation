package FlightReservation;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.SearchPage;
import resources.Base;
import resources.TestData;



public class HomePage extends Base{
	public WebDriver driver;
	
	private String TestCase;
	private String FromCity;
	private String FromCityCode;
	private String ToCity;
	private String ToCityCode;
	private String DepartureDate;	
	private String CountAdultPassengers;
	private String CountChildPassengers;
	private String TravelClass;

	
//	 public static Logger log =LogManager.getLogger(Base.class.getName());
	
	@DataProvider(name="ExcelDataProvider")
	private Object[][] testData() throws Exception{
		
		
		Object[][] arrayObject= TestData.getData("test1","Sheet1");
		System.out.println("in Data provider ");
		return arrayObject;
	}
	
	@Test(dataProvider = "ExcelDataProvider")
	private void intializeTest(String... TestSheet ) {
		
		System.out.println("In test initialize");
		TestCase=TestSheet[0];
		FromCity=TestSheet[1];
		FromCityCode=TestSheet[2];
		ToCity=TestSheet[3];	
		ToCityCode=TestSheet[4];	
		DepartureDate=TestSheet[5];	
		CountAdultPassengers=TestSheet[6];	
		CountChildPassengers=TestSheet[7];
		TravelClass=TestSheet[8];
		
		System.out.println(TestCase);

		
	}
	
	
	@Test(dependsOnMethods = "intializeTest")
	
	private void basePageNavigation() throws IOException, InterruptedException
	{
		driver =initializeDriver();
		//one is inheritance

		// creating object to that class and invoke methods of it
		driver.get(prop.getProperty("url"));
		LandingPage l=new LandingPage(driver);
	//	SearchPage lp=l.getSearchFlight(); //driver.findElement(By.css()
		l.getFlight().click();
		l.getTripType().click();
		l.getFromCity().sendKeys(FromCityCode);
		l.getOptionFromCity().click();
		l.getToCity().sendKeys(ToCityCode);
		l.getOptionToCity().click();
		
		l.getDepartDate().click();
	//	Thread.sleep(2000);
		
	//	Actions builder=new Actions(driver);
	//	builder.moveToElement(l.getSelectDate()).click().build().perform();
		
		
		l.getSelectDate().click();
		
		
		l.getNoOfPassengerAdult().click();
		
		Select adl= new Select(l.getNoOfPassengerAdult());
		adl.selectByVisibleText("2");
		
		Select chd= new Select(l.getNoOfPassengerChildt());
		chd.selectByVisibleText("2"); 
		Select clsTrav= new Select(l.getTravelClass());
	//	clsTrav.selectByValue("C");;
		clsTrav.selectByVisibleText("Business Class");
		
		//l.getSearchFlight();
		
		SearchPage lp=l.getSearchFlight();
		
		Assert.assertEquals(lp.getFromCitySearch().getText(), "Mumbai");
		Assert.assertEquals(lp.getToCitySearch().getText(), "Delhi");
		System.out.println("Search text "+lp.getFromCitySearch().getText());
		
		System.out.println("Search text "+lp.getToCitySearch().getText());
		
		
		
		driver.close();
//		log.info(text);
	
		
		
		
		
		}
	
	
	



	
}
