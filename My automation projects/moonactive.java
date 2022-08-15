import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;

public class moonactive {

	public static void main(String[] args) throws InterruptedException {
		
		//Giving Eclipse the location of the ChromeDriver.
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
        
		
		//Setting the ChromeDriver.
		WebDriver driver = new ChromeDriver();
        
        //Open Google Chrome window in full screen.
        driver.manage().window().maximize();
        
        //Open the official Web page of MoonActive
        driver.get("https://www.moonactive.com/");
        
        //Select and click the Career button.
        WebElement carrer=driver.
        findElement(By.cssSelector("#menu-item-74"));
        carrer.click();
        
        //Select and click the R&D button.
        WebElement RD=driver.
        findElement(By.cssSelector(".job-dept-container-wrap.dept-r-d"));
        RD.click();
        
        //Need to add here to select country/city.
        
        //Open the job application (Have to find a way to select the job title correctly
        Thread.sleep(2000); 
        
        Actions builder = new Actions(driver);
        builder.keyDown(Keys.TAB).perform();
        builder.keyDown(Keys.TAB).perform();
        builder.keyDown(Keys.TAB).perform();
        builder.keyDown(Keys.TAB).perform();
        builder.keyDown(Keys.TAB).perform();
        builder.keyDown(Keys.TAB).perform();
        builder.keyDown(Keys.TAB).perform();
        builder.keyDown(Keys.TAB).perform();
        builder.keyDown(Keys.TAB).perform();
        builder.keyDown(Keys.TAB).perform();
        builder.keyDown(Keys.TAB).perform();
        builder.keyDown(Keys.TAB).perform();
        builder.keyDown(Keys.TAB).perform();
        builder.keyDown(Keys.TAB).perform();
        builder.keyDown(Keys.TAB).perform();
        builder.keyDown(Keys.ENTER).perform();
        
        //Wait for page to load
        Thread.sleep(3000); 
        
        //Scroll down the page
        JavascriptExecutor scroolDown = (JavascriptExecutor) driver;
        scroolDown.executeScript("window.scrollBy(0, 1750)", " ");
        
        //Add first name + Last name + Email + Phone.
        builder.keyDown(Keys.TAB).perform();
        builder.keyDown(Keys.TAB).perform();
        builder.keyDown(Keys.TAB).perform();
        builder.keyDown(Keys.TAB).perform();
        builder.keyDown(Keys.TAB).perform();
        builder.keyDown(Keys.TAB).perform();
        Thread.sleep(1500);
        builder.sendKeys("david").perform();
        builder.keyDown(Keys.TAB).perform();
        Thread.sleep(1500);
        builder.sendKeys("azani").perform();
        builder.keyDown(Keys.TAB).perform();
        Thread.sleep(1500);
        builder.sendKeys("davidazani@gmail.com").perform();
        builder.keyDown(Keys.TAB).perform();
        Thread.sleep(1500);
        builder.sendKeys("0533369882").perform();
        builder.keyDown(Keys.TAB).perform();
        Thread.sleep(1500);
        builder.sendKeys("This is an automated program which send my CV to the company instead doing it manually").perform();
        
        //Attach CV file. (is it possible?)
        
}