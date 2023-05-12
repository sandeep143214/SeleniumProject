package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	WebDriver driver;

	public AbstractComponents(WebDriver driver) {
		this.driver = driver;

	}

	public static void selectByValue(WebDriver driver, By locator, String value) {
		WebElement element = driver.findElement(locator);
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public static void selectByVisibleText(WebDriver driver, By locator, String text) {
		WebElement element = driver.findElement(locator);
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public static void selectByIndex(WebDriver driver, By locator, int index) {
		WebElement element = driver.findElement(locator);
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void clikElementByUsingJS(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click(0);", ele);
	}

	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void waitForWebElementToAppear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ele));

	}
	public void clickUsingActions(WebElement Ele){
		Actions a=new Actions(driver);
		a.moveToElement(Ele).click().build().perform();
	}

}
