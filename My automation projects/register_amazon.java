import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise1 {

	public static void main(String[] args) {
		
		//Setting up Selenium
        System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prd.canvusapps.com/signup");

        //Generate new values each time
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder(10);
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		
		String fullName = sb.toString();
        
		//Add random name to the first field
        driver.findElement(By.cssSelector("#user_name")).sendKeys(fullName);
        
        //Add random Email
        driver.findElement(By.cssSelector("#user_email")).sendKeys(fullName + "@gmail.com");
        
        //Insert Password & re-assure.
        driver.findElement(By.cssSelector("#user_password")).sendKeys("123qwe");
        driver.findElement(By.cssSelector("#user_password_confirmation")).sendKeys("123qwe");
        
        //Enter Company Name
        driver.findElement(By.cssSelector("#company_name")).sendKeys(fullName);
        
        //Click on the Sign-Up button
        driver.findElement(By.cssSelector(".submit")).click();
	}

}