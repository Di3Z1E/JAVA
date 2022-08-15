import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise2 {

	public static void main(String[] args) {
		
		//Setting up Selenium
        System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://login.salesforce.com/");

        //Click on forgot password
        driver.findElement(By.cssSelector("#forgot_password_link")).click();
        
        //Get details about the site
        String title = driver.getTitle();
        if (title.equals("Forgot Your Password")) {
			System.out.println("Title is corrcet, continue to next steps.");
		}
        
        //Add user name
        driver.findElement(By.cssSelector("#un")).sendKeys("David");
        
        //Click on Continue
        driver.findElement(By.cssSelector("#continue")).click();
        
        //Check for error msg
        String actual = driver.findElement(By.cssSelector(".mb16.error")).getText();
        String expected = "We can’t find a username that matches what you entered. Verify that your username is an email address (for example, username@company.com).";
        if (expected.equals(actual)) {
			System.out.println(actual);
		}
        
	}

}
