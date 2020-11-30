package stepDeff;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.junit.runners.ParentRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SampleGlueCode {
	WebDriver driver;
	int sentMailcount;

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\seleniumstuff\\zSampleCucumberProj\\src\\main\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() {
		driver.findElement(By.xpath("//img[@class='gb_Ha gbii']")).click();
		driver.findElement(By.xpath("//a[text()='Sign out']")).click();
		driver.quit();
	}

	private void waitForWebelement(String xpath) {
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

	}

	@Given("user launch browser and enter URL as {string} addres")
	public void user_launch_browser_and_enter_URL_as_addres(String url) {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.xpath("//a[contains(text(),'Gmail')]")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Sign in')])[2]")).click();

	}

	@When("user enter emailaddress as {string} and click on Next")
	public void user_enter_emailaddress_as_and_click_on_Next(String emailAddress) {

		String parentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String childWindow : windows) {
			if (!parentWindow.equals(childWindow)) {
				driver.switchTo().window(childWindow);
				System.out.println(driver.getTitle());
				waitForWebelement("//input[(@type='email')]");
				driver.findElement(By.xpath("//input[(@type='email')]")).sendKeys(emailAddress);
				driver.findElement(By.xpath("//input[(@type='email')]")).sendKeys(Keys.ENTER);

			}
		}
	}

	@When("user enter Password as {string} and click on Next")
	public void user_enter_Password_as_and_click_on_Next(String password) {
		waitForWebelement("//input[@name='password']");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Keys.ENTER);
	}


	@When("user click on compose mail")
	public void user_click_on_compose_mail() {
		waitForWebelement("//div[@class='T-I T-I-KE L3']");
		driver.findElement(By.xpath("//div[@class='T-I T-I-KE L3']")).click();
	}

	@When("user enter tomailid as {string} and Subject as {string}")
	public void user_enter_To_addres_as_and_Subject_as(String string, String string2) {
		waitForWebelement("//textarea[@name='to']");
	driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys("testc839@gmail.com");
	waitForWebelement("//input[@name='subjectbox']");
	driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("My Resume");
			
		
	}
	@When("user enter his Message in text body")
	public void user_enter_his_Message_in_text_body(String docString) {
		waitForWebelement("//div[@class='Ar Au']");
		driver.findElement(By.xpath("//div[@class='Am Al editable LW-avf tS-tW']")).sendKeys("Hi \n Please find my attachment \n Thanks & Regards \n Pranava.");
	}

	@When("user attached resume")
	public void user_attached_resume() {
		waitForWebelement("//input[@type='file']");
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("\\src\\test\\resources\\Feature\\Pranava T - QA - Resume -2020.docx");
		
	}

	@When("user click on send button")
	public void user_click_on_send_button() {
		waitForWebelement("//input[@type='file']");
		driver.findElement(By.xpath("//div[text()='Send']")).click(); 
	}

	@Then("user go to sent items and verify")
	public void click_on_sent_mail_tab_and_verify_sent_mail_count_increased_one_value() {
		waitForWebelement("//input[@type='file']");
		driver.findElement(By.xpath("//a[@title='Sent Mail']")).click();
		if (driver.findElement(By.xpath("//div[@class='y6']//b[text()='"+ "']")) != null)
		{
		System.out.println("Wowww.. Email sent sucessfully!!!");
		}
		else
		{
		System.out.println("Failed to send email !!!");
		}
	
		driver.quit();
		
	}

	@Then("click on sign out")
	public void click_on_sign_out() {
		driver.findElement( By.xpath("//a[@class='gb_D gb_Qa gb_i']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Sign out']")).click();
	}


}
