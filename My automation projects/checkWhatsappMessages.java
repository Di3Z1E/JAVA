package whatsapp;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class checkWhatsappMessages {

	public static void main(String[] args) throws InterruptedException {		
		//Setting up
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("user-data-dir=\\Users\\david\\AppData\\Local\\Google\\Chrome\\User Data\\Default"); //location of the google chrome profile
		option.addArguments("--profile-directory=Profile 2"); //secondary profile
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://web.whatsapp.com/");
		driver.manage().window().maximize();
		
		Thread.sleep(8000); //Wait for WhatsApp to load		
		
		Runnable loop = new Runnable() {
		    public void run() {
                String name = "WhatsApp"; //expected string
                String msgcheck = driver.getTitle(); //actual string
                if (name.equals(msgcheck)) {
                	System.out.println("*********************************************");
                	System.out.println("Checking for new messages on WhatsApp: ");
                    System.out.println("There is (0) " + driver.getTitle() + " messages.");
                    System.out.println("*********************************************");
                } else {
                	for (int i = 0; i < 50; ++i) System.out.println(); //create space between messages
                	System.out.println("*********************************************");
                	System.out.println("Checking for new messages on WhatsApp: ");
                    System.out.println("There is " + driver.getTitle() + " messages.");
                    System.out.println("*********************************************");
                }
		    }
		};
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		executor.scheduleAtFixedRate(loop, 0, 5, TimeUnit.SECONDS); //Set amount of wait time (0 = mintues) (5 = seconds)        
	}
	}
