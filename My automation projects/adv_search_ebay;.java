import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise3 {

	public static void main(String[] args) {
		//Setting up Selenium
        System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/sch/ebayadvsearch");
        
        
        //Add values to ‘Enter keywords or item number’ search bar
        driver.findElement(By.cssSelector("#_nkw")).sendKeys("tent");
        
        //Add values to ‘Exclude words' search bar
        driver.findElement(By.cssSelector("#_ex_kw")).sendKeys("some words");
        
        //Click on the Buy it now box
        driver.findElement(By.cssSelector("#LH_BIN")).click();
        
        //Click search at the bottom of the page
        driver.findElement(By.cssSelector("#searchBtnLowerLnk")).click();
        
        //Going back to the advanced search page
        driver.navigate().back();
        
        //Click search from the top of the page
        driver.findElement(By.cssSelector("#adv_search_from > fieldset:nth-child(2) > div.adv-s.mb.space-top > button")).click();
	}

}
