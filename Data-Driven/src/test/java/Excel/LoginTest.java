package Excel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {
	WebDriver driver;
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://thinking-tester-contact-list.herokuapp.com/addUser");
	}
	@Test(dataProvider = "loginData")
	public void loginTest(String firstName, String lastName, String email, String password) {
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("submit")).click();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@DataProvider(name = "loginData")
	public Object[][] getData(){
		return
				ExcelReader.readExcel("TestData.xlsx");
	}
	

}
