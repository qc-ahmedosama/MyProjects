package roundTest;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.ChosenFlight;
import pages.FlightsPage;
import pages.SkyHomePage;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class TestRound {
		
		WebDriver driver;
		SkyHomePage sky;
		FlightsPage flight;
		ChosenFlight chosen;
		FileDataReader readData;
		
	 @BeforeClass
	 public void beforeClass() {
		 WebDriverManager.firefoxdriver().setup();
		 driver = new FirefoxDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 sky = new SkyHomePage(driver);
		 flight = new FlightsPage(driver);
		 chosen = new ChosenFlight(driver);
			   
	  }
		
	  @Test
	  public void roundTest() {
		  readData = new FileDataReader();
		 sky.GetURL();
		 sky.SelectCity(readData.read("DataDrivenDemoTestData.xlsx", 2, 2));
		 sky.SelectDate();
		 sky.Search();
		 flight.Cheaper();
		 flight.shortest();
		 flight.ChoseFlight();
		 	
		 assertEquals(chosen.GetTime(),
		 readData.read("DataDrivenDemoTestData.xlsx", 3, 2) +
		 readData.read("DataDrivenDemoTestData.xlsx", 4, 2));
		 
//		 System.out.println(driver.findElement(By.xpath("(//h6[@class='BpkText_bpk-text__2NHsO BpkText_bpk-text--base__2vfTl LegHeader_legDate__wjV4s'])[1]")).getText());
//		 System.out.println(driver.findElement(By.xpath("(//h6[@class='BpkText_bpk-text__2NHsO BpkText_bpk-text--base__2vfTl LegHeader_legDate__wjV4s'])[2]")).getText());
	  }
	  

	
	  @AfterClass
	  public void afterClass() {
		  driver.quit();
	  }

}

//Page 1
//driver.get("https://www.skyscanner.net/");
//driver.findElement(By.xpath("//input[@class='BpkInput_bpk-input__3-aQd SingleDestControls_fsc-large-above-tablet__1WC8y SingleDestControls_fsc-docked-middle-above-tablet___J8b1 SingleDestControls_fsc-docked-last-on-tablet__uU4v_ LocationSelector_fsc-location-input__2eRlW']")).sendKeys("Amsterdam (AMS)");
//driver.findElement(By.xpath("//*[@id=\"depart-fsc-datepicker-button\"]")).click();
//WebElement testDropDown = driver.findElement(By.xpath("//select[@class=\"BpkSelect_bpk-select__1L6LK\"]"));  
//	Select dropdown = new Select(testDropDown);
//	dropdown.selectByIndex(3);
//	driver.findElement(By.xpath("//button[@aria-label=\"Wednesday, 10 June 2020\"]")).click();
//	
//	driver.findElement(By.xpath("//button[@id=\"return-fsc-datepicker-button\"]")).click();
//	driver.findElement(By.xpath("//button[@aria-label=\"Thursday, 18 June 2020\"]")).click();
//	
//	driver.findElement(By.xpath("//button[@aria-label=\"Search flights\"]")).click();

//Page 2
//WebElement cheapDrop =driver.findElement(By.xpath("//select[@id=\"secondarySort\"]"));
//Select cheapDownList = new Select(cheapDrop);
//cheapDownList.selectByIndex(1);
//driver.findElement(By.xpath("//*[@id=\"stops_content\"]/div/div/div[2]/label")).click();
//driver.findElement(By.xpath("//*[@id=\"stops_content\"]/div/div/div[3]/label")).click();
//driver.findElement(By.xpath("//*[@id=\"app-root\"]/div[2]/div[2]/div[1]/div[3]/div[1]/div[3]/a/div/div[3]/div/div/div/span")).click();

//Page 3
//driver.findElement(By.xpath("//*[@id=\"details-modal\"]/div/div/div[1]/div[1]/button")).click();
//
////System.out.println(driver.findElement(By.xpath("//*[@id=\"details-modal\"]/div/div/div[1]/div[1]/div[2]/div/div/div[2]/div/div[2]/div[1]/span")).getText());
////System.out.println(driver.findElement(By.xpath("//*[@id=\"details-modal\"]/div/div/div[1]/div[1]/div[2]/div/div/div[2]/div/div[2]/div[2]/span")).getText());
//
//assertEquals(driver.findElement(By.xpath("//*[@id=\"details-modal\"]/div/div/div[1]/div[1]/div[2]/div/div/div[2]/div/div[2]/div[1]/span")).getText(), startTime);
//assertEquals(driver.findElement(By.xpath("//*[@id=\"details-modal\"]/div/div/div[1]/div[1]/div[2]/div/div/div[2]/div/div[2]/div[2]/span")).getText(), arrTine);

