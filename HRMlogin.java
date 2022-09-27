package Testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRMlogin {
		// TODO Auto-generated method stub
		@Test(priority=2)
		void HrmLogin() throws InterruptedException
		{
			System.setProperty("webdriver.chrome.driver", "C:\\lahari\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.manage().window().maximize();
			Thread.sleep(1000);
			driver.findElement(By.name("username")).clear();
			driver.findElement(By.name("username")).sendKeys("Admin");
			driver.findElement(By.name("password")).clear();
			//driver.findElement(By.cssSelector("css=#txtPassword")).sendKeys("Admin");
			driver.findElement(By.name("password")).sendKeys("admin123");
			driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		}

		@Test(priority =1)
		void reSetPassword() throws InterruptedException
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Ashok\\chromedriver.exe");
			String expectedResult="Forgot your password?";
			WebDriver driver;
			driver=new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			Thread.sleep(500);
			driver.findElement(By.linkText("Forgot your password?")).click();
			driver.findElement(By.id("btnCancel")).click();
			String actualResult=driver.findElement(By.linkText("Forgot your password?")).getText();
			Assert.assertEquals(actualResult, expectedResult);
		}
		@Test(priority =0)
		void webTable()
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Ashok\\chromedriver.exe");
			  WebDriver driver = new ChromeDriver();
			  driver.get("D:\\Training\\Selenium\\seleniumexamples//WebTable.html");
			String before_xpath = "//table/tbody/tr["; 
			String after_xpath = "]/td[2]";
			List rows = driver.findElements(By.xpath("//table/tbody/tr"));
			int rowSize = rows.size();
			System.out.println("RowSize " +rowSize);
			for (int i = 2; i <= rowSize; i++) {
			String firstNames = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println("First Name " +firstNames);
			// Now click the checkBox where first Name would be Ashok
			if (firstNames.contains("Ashok")) {
			// click the checkBox
			driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[1]/input")).click(); 
			System.out.println("candidate has been selected");
			break;
			}
		}
		}

}
