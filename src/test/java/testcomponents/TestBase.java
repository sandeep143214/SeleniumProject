package testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

		public WebDriver driver;

		public WebDriver intializeBrowser() throws IOException, InterruptedException {
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream("./src/main/java/resources/Global.properties");
			prop.load(fis);
			String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
					: prop.getProperty("browser");
			if (browserName.contains("chrome")) {

				driver = new ChromeDriver();
				if (browserName.contains("headless")) {
					ChromeOptions co = new ChromeOptions();
					co.addArguments("--headless");
					driver = new ChromeDriver(co);

				}

			} else if (browserName.contains("firefox")) {
				driver = new FirefoxDriver();
			} else if (browserName.contains("edge")) {
				driver = new EdgeDriver();
			}

			driver.get(prop.getProperty("url"));
			Thread.sleep(2000);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			driver.manage().window().maximize();
			return driver;
		}

//		@BeforeMethod
//		public HomePage lauchApplication() throws IOException, InterruptedException {
//			driver = intializeBrowser();
//			hp = new HomePage(driver);
//			return hp;
//
//		}

		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
		
		
		
		 
		public String getScreenshot(String testcaseName, WebDriver driver) throws IOException {
			TakesScreenshot ts= (TakesScreenshot)driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			File file=new File(".//reports//"+ testcaseName+".png");
			FileUtils.copyFile(source, file );
			return ".//Screenshots"+"//reports//"+ testcaseName+".png";
		}
		}

		
