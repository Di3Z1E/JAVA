import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise4 {

	public static void main(String[] args) {
		//Setting up Selenium
        System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://login.salesforce.com/");
        
        //Enter user name
        driver.findElement(By.cssSelector("#username")).sendKeys("David");
        
        //Enter password
        driver.findElement(By.cssSelector("#password")).sendKeys("123qwe");
        
        //Check the remember me box
        driver.findElement(By.cssSelector(".fl.pr.db.tn3")).click();
        
        WebElement checkbox = driver.findElement(By.id("rememberUn"));
        if (checkbox.isSelected()) {
        	System.out.println("The checkbox is selection state is " + checkbox.isSelected() + " Continue to log in");
		} else {
			System.out.println("the checkbox is marked as false! shutting down the program.");
			driver.close();
		}
        
        //Press Login
        driver.findElement(By.cssSelector("#Login")).click();
            
	}

}
