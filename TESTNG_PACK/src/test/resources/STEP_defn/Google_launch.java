package STEP_defn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;


public class Google_launch {
	WebDriver driver;
	
	@Given("Browser launch")
	public void browser_launch() {
		System.setProperty("webdriver.chrome.driver","D:\\tools\\Selenium\\doy\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.get("https://www.youtube.com/");
	}
	
	@And("Navigate to google")
	public void navigate_to_google() {
		System.out.println("More More More More More");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	    
	}
	
	
	
	@Given("^Browsers launch$")
	public void browsers_launch()  {
		System.setProperty("webdriver.chrome.driver","D:\\tools\\Selenium\\doy\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.get("https://mvnrepository.com/artifact/io.cucumber/cucumber-core/6.7.0");
	
	}

	@And("^Navigate to Maven$")
	public void navigate_to_Maven()  {
		System.out.println("More More More More More");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	    
	}

}
