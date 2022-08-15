import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;

public class FXP {

	public static void main(String[] args) throws InterruptedException {
		
		//Enable notifications
		Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 1);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
		
		//Setting up Selenium
        System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.fxp.co.il/");
        Actions builder = new Actions(driver);
        
		/* Since we are using live site we don't want to insert values each time to the code so we create a random string to that for us */
        
        //Create random string
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder(10);
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		String randomString = sb.toString();
		
		/* the first process of creating the account */
		
		//Register to FXP with random name + mail
        WebElement reg = driver.findElement(By.xpath("//*[@id=\"sticky_menu_header\"]/div[5]/a"));
        reg.click();
        
        WebElement username = driver.findElement(By.xpath("//*[@id=\"regusername\"]"));
        username.click();
        Thread.sleep(500);
        builder.sendKeys(randomString).perform();
        
        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        password.click();
        Thread.sleep(500);
        builder.sendKeys("123qwe").perform();
        
        WebElement typePasswordAgain = driver.findElement(By.xpath("//*[@id=\"passwordconfirm\"]"));
        typePasswordAgain.click();
        Thread.sleep(500);
        builder.sendKeys("123qwe").perform();
        
        driver.findElement(By.xpath("//*[@id=\"email\"]")).click();
        builder.sendKeys(randomString + "@gmail.com").perform();
        Thread.sleep(2000);
        
        builder.keyDown(Keys.TAB).perform();
        Thread.sleep(1500);

        driver.findElement(By.xpath("//*[@id=\"submitBtn\"]")).click();
        Thread.sleep(500);
        
        
        //Check if the profile is made or not
        String chkNewProfile = driver.findElement(By.cssSelector("#user_header_2020_fxp > span > a > b")).getText();
        String expected = randomString;
		if (chkNewProfile.equals(expected)) {
			System.out.println("The new profile has been created successfully, user name is: " + chkNewProfile + "and password is: 123qwe" );
		}else {
			System.out.println("The new profile has not been created, closing the program." + chkNewProfile);
			driver.close();
		}
		
		//Get another profile to follow him
        driver.get("https://www.fxp.co.il/member.php?u=892957"); 
        Thread.sleep(500);
        
        driver.findElement(By.xpath("//*[@id='userinfoblock']/div/div[1]")).click();
        Thread.sleep(750);

	}
}