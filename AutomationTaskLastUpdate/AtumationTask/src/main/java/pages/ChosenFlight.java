package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChosenFlight {
		WebDriver driver;
		private final static By Outbound = By.xpath("//h6[text()='Wed, 10 Jun 2020']");
		private final static By Return = By.xpath("//h6[text()='Thu, 18 Jun 2020']");
	
	public ChosenFlight(WebDriver driver) {
		this.driver = driver;
	}
	
	public String GetTime() {
		
		return driver.findElement(Outbound).getText() + driver.findElement(Return).getText();
		 
	}

}


//System.out.println(driver.findElement(By.xpath("//*[@id=\"details-modal\"]/div/div/div[1]/div[1]/div[2]/div/div/div[2]/div/div[2]/div[1]/span")).getText());
//System.out.println(driver.findElement(By.xpath("//*[@id=\"details-modal\"]/div/div/div[1]/div[1]/div[2]/div/div/div[2]/div/div[2]/div[2]/span")).getText());

