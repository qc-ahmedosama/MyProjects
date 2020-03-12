package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FlightsPage {
	
		WebDriver driver;
		private final static By SelectCheaper= By.id("secondarySort");
		private final static By OneStop =By.cssSelector("input[aria-label=\"1 stop\"]");
		private final static By TwoStops = By.cssSelector("input[aria-label=\"2+ stops\"]");
		private final static By ChooseF = By.cssSelector("button[class*=\"ctaButton\"]");
	
	public FlightsPage(WebDriver driver) {
		this.driver = driver;
	}
	public void Cheaper() {
		WebElement cheapDrop =driver.findElement(SelectCheaper);
		Select cheapDownList = new Select(cheapDrop);
		cheapDownList.selectByIndex(1);
	}
	public void shortest() {
//		driver.findElement(OneStop).click();
//		driver.findElement(TwoStops).click();
		
		//To avoid the permanent overlay of element
		WebElement oneStop = driver.findElement(OneStop);
		WebElement twoStop = driver.findElement(TwoStops);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", oneStop);
		executor.executeScript("arguments[0].click();", twoStop);
	}
	public void ChoseFlight() {
		//To avoid the permanent overlay of element
		WebElement chooseF = driver.findElement(ChooseF);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", chooseF);
	}
}


