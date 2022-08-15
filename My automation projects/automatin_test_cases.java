import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class swagLabs {

    public static void main(String[] args) throws InterruptedException {
        // Create the main method to work around the site
        System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        //Test cases to run
        tc_01_FailedLogin(driver, "standard_user", "123123");
        tc_02_FailedLogin(driver, "standard_user", "asd");
        tc_03_FailedLogin(driver, "asde", "secret_sauce");
        tc_04_FailedLogin(driver, "awd", "dasd");
        tc_05_FailedLogin(driver, "asd", "");
        tc_06_FailedLogin(driver, "", "secret_sauce");
        tc_07_FailedLogin(driver, "", "asd");
        tc_08_FailedLogin(driver, "", "");
        tc_09_FailedLogin(driver, "standard_user", "secret_sauce");


    }
    //Login 
    public static void login(WebDriver driver, String userName, String password) {
        //Refresh the page
        driver.navigate().refresh();

        //Insert user name
        driver.findElement(By.cssSelector("[name='user-name']")).sendKeys(userName);

        //Insert password
        driver.findElement(By.cssSelector("#password")).sendKeys(password);

        //Click to login
        driver.findElement(By.cssSelector(".submit-button.btn_action")).click();

    }

    //Failed login - Valid User name & Invalid password - TC01
    public static void tc_01_FailedLogin(WebDriver driver, String userName, String password) throws InterruptedException {
        login(driver, userName, password);

        String expected = "Epic sadface: Username and password do not match any user in this service";
        String actual = driver.findElement(By.cssSelector(" h3")).getText();
        if (expected.equals(actual)) {
            System.out.println("TC01 - Failed login - Vaild usernaem & invalid password - Passed!");
        } else {
            System.out.println("TC01 - Failed login - Vaild usernaem & invalid password - Failed!");
        }
    }

    //Failed login - Valid User name & Invalid password - TC02
    public static void tc_02_FailedLogin(WebDriver driver, String userName, String password) throws InterruptedException {
        login(driver, userName, password);

        String expected = "Epic sadface: Username and password do not match any user in this service";
        String actual = driver.findElement(By.cssSelector(" h3")).getText();
        if (expected.equals(actual)) {
            System.out.println("Failed login - Valid User name & Invalid password - TC02 - Passed!");
        } else {
            System.out.println("Failed login - Valid User name & Invalid password - TC02 - Failed!");
        }
    }

    //Failed login - Invalid User name & valid password - TC03
    public static void tc_03_FailedLogin(WebDriver driver, String userName, String password) throws InterruptedException {
        login(driver, userName, password);

        String expected = "Epic sadface: Username and password do not match any user in this service";
        String actual = driver.findElement(By.cssSelector(" h3")).getText();
        if (expected.equals(actual)) {
            System.out.println("Failed login - Invalid User name & valid password - TC03 - Passed!");
        } else {
            System.out.println("Failed login - Invalid User name & valid password - TC03 - Failed!");
        }
    }

    //Failed login - Invalid User name & Invalid password - TC04
    public static void tc_04_FailedLogin(WebDriver driver, String userName, String password) throws InterruptedException {
        login(driver, userName, password);

        String expected = "Epic sadface: Username and password do not match any user in this service";
        String actual = driver.findElement(By.cssSelector(" h3")).getText();
        if (expected.equals(actual)) {
            System.out.println("Failed login - Invalid User name & Invalid password - TC04 - Passed!");
        } else {
            System.out.println("Failed login - Invalid User name & Invalid password - TC04 - Failed!");
        }
    }

    //Failed login - Invalid User name & NULL password - TC05
    public static void tc_05_FailedLogin(WebDriver driver, String userName, String password) throws InterruptedException {
        login(driver, userName, password);

        String expected = "Epic sadface: Password is required";
        String actual = driver.findElement(By.cssSelector(" h3")).getText();
        if (expected.equals(actual)) {
            System.out.println("Failed login - Invalid User name & NULL password - TC05 - Passed!");
        } else {
            System.out.println("Failed login - Invalid User name & NULL password - TC05 - Failed!");
        }
    }

    //Failed login - null User name & valid password - TC06
    public static void tc_06_FailedLogin(WebDriver driver, String userName, String password) throws InterruptedException {
        login(driver, userName, password);

        String expected = "Epic sadface: Username is required";
        String actual = driver.findElement(By.cssSelector(" h3")).getText();
        if (expected.equals(actual)) {
            System.out.println("Failed login - null User name & valid password - TC06 - Passed!");
        } else {
            System.out.println("Failed login - null User name & valid password - TC06 - Failed!");
        }

    }

    //Failed login - null User name & Invalid password - TC07
    public static void tc_07_FailedLogin(WebDriver driver, String userName, String password) throws InterruptedException {
        login(driver, userName, password);

        String expected = "Epic sadface: Username is required";
        String actual = driver.findElement(By.cssSelector(" h3")).getText();
        if (expected.equals(actual)) {
            System.out.println("Failed login - null User name & Invalid password - TC07 - Passed!");
        } else {
            System.out.println("Failed login - null User name & Invalid password - TC07 - Failed!");
        }

    }

    //Failed login - null User name & null password - TC08
    public static void tc_08_FailedLogin(WebDriver driver, String userName, String password) throws InterruptedException {
        login(driver, userName, password);

        String expected = "Epic sadface: Username is required";
        String actual = driver.findElement(By.cssSelector(" h3")).getText();
        if (expected.equals(actual)) {
            System.out.println("Failed login - null User name & null password - TC08 - Passed!");
        } else {
            System.out.println("Failed login - null User name & null password - TC08 - Failed!");
        }

    }

    //login - valid User name & valid password - TC09
    public static void tc_09_FailedLogin(WebDriver driver, String userName, String password) throws InterruptedException {
        login(driver, userName, password);

        String expected = "PRODUCTS";
        String actual = driver.findElement(By.cssSelector("[class='title']")).getText();
        if (expected.equals(actual)) {
            System.out.println("login - valid User name & valid password - TC09 - Passed!");
        } else {
            System.out.println("login - valid User name & valid password - TC09 - Failed!");
        }

    }

}