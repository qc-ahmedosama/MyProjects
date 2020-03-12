package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SkyHomePage {
		WebDriver driver;
		
		private final static By  City= By.id("fsc-destination-search");
		private final static By Date = By.id("depart-fsc-datepicker-button");
		private final static By SelectMonth = By.id("depart-calendar__bpk_calendar_nav_select");
		private final static By SelectDay = By.cssSelector("button[aria-label*=\"10 June 2020\"]");
		private final static By DateBack = By.id("return-fsc-datepicker-button");
		private final static By SelectDayBack = By.cssSelector("button[aria-label*=\"18 June 2020\"]");
		private final static By Search = By.cssSelector("button[aria-label=\"Search flights\"]"); 
		FileDataReader readData = new FileDataReader();
		
	public SkyHomePage(WebDriver driver) {
			this.driver = driver;
		}
		
	public void GetURL() {
			driver.get(readData.read("DataDrivenDemoTestData.xlsx", 2, 3));
		}
	
	public void SelectCity(String CityKey) {
			driver.findElement(City).sendKeys(CityKey);

		}
	
	public void SelectDate() {
			driver.findElement(Date).click();
			WebElement testDropDown = driver.findElement(SelectMonth);  
			Select dropdown = new Select(testDropDown);
			dropdown.selectByIndex(3);
			driver.findElement(SelectDay).click();
			driver.findElement(DateBack).click();
			driver.findElement(SelectDayBack).click();
		}
	
	public void Search() {
			driver.findElement(Search).click();
		}
}


	
	