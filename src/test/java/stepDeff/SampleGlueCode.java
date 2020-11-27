package stepDeff;

import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
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
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "E:\\seleniumstuff\\zSampleCucumberProj\\src\\main\\resources\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
	}

	@After
	public void tearDown() {
		driver.findElement(By.xpath("//img[@class='gb_Ha gbii']")).click();
    	driver.findElement(By.xpath("//a[text()='Sign out']")).click();
        driver.quit();
	}
	private void waitForWebelement(String xpath) {
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		
	}
	@Given("user launch browser and enter URL as {string} addres")
	public void user_launch_browser_and_enter_URL_as_addres(String url) {
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.xpath("//a[contains(text(),'Gmail')]")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Sign in')])[2]")).click();
	
	}

	@When("user enter emailaddress as {string} and click on Next")
	public void user_enter_emailaddress_as_and_click_on_Next(String emailAddress) {
		waitForWebelement("//input[(@type='email')]");
		driver.findElement(By.xpath("//input[(@type='email')]")).sendKeys(emailAddress);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
	}

	@When("user enter Password as {string} and click on Next")
	public void user_enter_Password_as_and_click_on_Next(String string) {
	}

	@When("click on sent mail tab and get sent mails count")
	public void click_on_sent_mail_tab_and_get_sent_mails_count() {
	}

	@When("user click on compose mail")
	public void user_click_on_compose_mail() {
	}

	@When("user enter To addres as {string} and Subject as {string}")
	public void user_enter_To_addres_as_and_Subject_as(String string, String string2) {
	}

	@When("user enter his Message in text body")
	public void user_enter_his_Message_in_text_body(String docString) {
	}

	@When("user attached resume")
	public void user_attached_resume() {
	}

	@When("user click on send button")
	public void user_click_on_send_button() {
	}

	@Then("click on sent mail tab and verify sent mail count increased one value")
	public void click_on_sent_mail_tab_and_verify_sent_mail_count_increased_one_value() {
	}

	@Then("click on sign out")
	public void click_on_sign_out() {
	}

	
	

	
	/*
	
	@Given("user launch browser and enter URL addres")
	public void user_launch_browser() {
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.findElement(By.xpath("//a[contains(text(),'Gmail')]")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Sign in')])[2]")).click();
		
	
		
	}

	@And("user enter URL as {string}")
	public void user_enter_url_gmail_login_page() {
		//log in code 
		driver.findElement(By.id("Email")).sendKeys("createdaccout255@gmail.com");
    	driver.findElement(By.id("next")).click();
    	driver.findElement(By.name("password")).sendKeys("Access@1234*");
    	
    	
	}
	@Given("user click on signIn and should see gmail home page")
	public void user_click_on_signIn() {
		driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb'])")).click();
		
	}


	@And("user click on  Compose mail where it takes to {string}.")
	public void user_click_on_compose_mail_where_it_takes_to(String string) {
		driver.findElement(By.xpath("//div[@class='T-I T-I-KE L3']")).click();
		 	}

	@And("user verified whether the compose page has To, Cc ,Bcc to enter email address")
	public void user_verified_whether_the_compose_page_has_to_cc_bcc_to_enter_email_address() {
		driver.findElement(By.xpath("//textarea[@id=':8z'")).sendKeys("testc839@gmail.com");
	}

	@And("user verified whether it has  Subject, to enter the subject of the mail with {string}")
	public void user_verified_whether_it_has_subject_to_enter_the_subject_of_the_mail_with(String string) {
		driver.findElement(By.xpath("//input[@id=':8h'")).sendKeys("My Resume");
	}

	@And("user verified whether the text body , accepts text {string}")
	public void user_verified_whether_the_text_body_accepts_text(String string) {
		driver.findElement(By.xpath("//div[@id=':9x']")).sendKeys("Hi, How are you? please check my attached Updated Resume");
	}
	@And("user verified  whether text {string} can  be able to edit, delete ,copy, cut , paste  the text  in text body")
	public void user_verified_whether_text_can_be_able_to_edit_delete_copy_cut_paste_the_text_in_text_body(
			String string) {
    	driver.findElement(By.xpath("//div[@id=':9x']")).sendKeys("Test the word");
   	 driver.findElement(By.xpath("//div[@id=':9x']")).sendKeys(Keys.BACK_SPACE);
   	 driver.findElement(By.xpath("//div[@id=':9x']")).sendKeys(Keys.DELETE);
   	 driver.findElement(By.xpath("//div[@id=':9x']")).sendKeys(Keys.CONTROL+"c");
   	 driver.findElement(By.xpath("//div[@id=':9x']")).sendKeys(Keys.CONTROL+"x");
   	 driver.findElement(By.xpath("//div[@id=':9x']")).sendKeys(Keys.CONTROL+"v");
    }

	@And("user attached the file upload file")
	public void user_attached_the_file_upload_file() {
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("\\src\\test\\resources\\Feature\\Pranava T - QA - Resume -2020.docx");
	}


	@When("user sends an email to {string} with subjectline {string}")
	public void user_sends_an_email_to_with_subjectline(String string, String string2) {
		driver.findElement(By.xpath("//div[@id=':86']")).click();
	}

	@Then("the email appears in the sent folder of gmail with subject {string}.")
	public void the_email_appears_in_the_sent_folder_of_gmail_with_subject(String string) {
		driver.findElement(By.xpath("//a[text()='Sent']")).click();
	}

*/
}
