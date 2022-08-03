import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;

public class SendCvAuto01 {

	public static void main(String[] args) throws InterruptedException {
		
		//Giving Eclipse the location of the ChromeDriver.
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
        
		
		//Setting the ChromeDriver.
		WebDriver driver = new ChromeDriver();
		Actions builder = new Actions(driver);
		Actions actions = new Actions(driver);

		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder(10);
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		String output = sb.toString();
		
        //Open Google window in full screen.
        driver.manage().window().maximize();
        
        //Open FXP
        driver.get("https://fxp.co.il");       
        
        //Register to FXP   
        WebElement reg = driver.findElement(By.xpath("//*[@id=\"sticky_menu_header\"]/div[5]/a"));
        reg.click();
       
        WebElement username = driver.findElement(By.xpath("//*[@id=\"regusername\"]"));
        username.click();
        Thread.sleep(500);
        builder.sendKeys(output).perform();
        
        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        password.click();
        Thread.sleep(500);
        builder.sendKeys("123fgh@@Hb").perform();
        
        WebElement typePasswordAgain = driver.findElement(By.xpath("//*[@id=\"passwordconfirm\"]"));
        typePasswordAgain.click();
        Thread.sleep(500);
        builder.sendKeys("123fgh@@Hb").perform();
        
        driver.findElement(By.xpath("//*[@id=\"email\"]")).click();
        builder.sendKeys(output + "@gmail.com").perform();
        Thread.sleep(2000);
        
        builder.keyDown(Keys.TAB).perform();
        Thread.sleep(1500);

        driver.findElement(By.xpath("//*[@id=\"submitBtn\"]")).click();
        
}
}