import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class partA {

    public static void main(String[] args) throws InterruptedException {

        // Create the main method to work around the site
        System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        /* Login to the site */
        //Insert Username
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");

        //Insert password
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");

        //Click LGOIN
        driver.findElement(By.cssSelector("#login-button")).click();

        //Check if the user logged in
        String strUrl = driver.getCurrentUrl();
        String actualUrl = "https://www.saucedemo.com/inventory.html";
        if (strUrl.equals(actualUrl)) {
            System.out.println("Current Url is: " + strUrl + " Continue to purchase the item.");
        } else {
            System.out.println("You didn't logged in! /n closing program. ");
            driver.close();
        }

        //Add some time to site to load completely
        Thread.sleep(500);

        /* Select and purchase an item */

        //Click on the item
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-onesie")).click();

        //Click on the cart
        driver.findElement(By.cssSelector("#shopping_cart_container > a")).click();

        //Check if the Item is the same as it clicked.
        String expectedItem = "Sauce Labs Onesie";
        String actualItem = driver.findElement(By.cssSelector("#item_2_title_link > div")).getText();

        if (expectedItem.equals(actualItem)) {
            System.out.println("The choosen item is: " + actualItem + " continue to purchase");
        } else {
            System.out.println("The item in the cart is not the one we need!");
            driver.close();
        }

        /* Check out */

        //Add some time to site to load completely
        Thread.sleep(500);

        //Click on the checkout button
        driver.findElement(By.cssSelector("#checkout")).click();

        //Check if the site is the correct one to place an order
        String headTitle = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span")).getText();
        String expectedHeadTitle = "CHECKOUT: YOUR INFORMATION";

        if (headTitle.equals(expectedHeadTitle)) {
            System.out.println("You are in the correct page, moving on.");
        } else {
            System.out.println("you are not in the desired page " + headTitle + "something went worng, closing the program.");
            driver.close();
        }

        //Add some time to site to load completely
        Thread.sleep(500);

        //Insert first name
        driver.findElement(By.cssSelector("#first-name")).sendKeys("David");

        //Insert last name
        driver.findElement(By.cssSelector("#last-name")).sendKeys("Azani");

        //Insert postal code
        driver.findElement(By.cssSelector("#postal-code")).sendKeys("3525408");

        //Click CONTINUE
        driver.findElement(By.cssSelector("#continue")).click();

        //Add some time to site to load completely
        Thread.sleep(500);

        //Check if the site is the correct one to place an order
        String finalStep = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span")).getText();
        String expectedFinalStep = "CHECKOUT: OVERVIEW";

        if (finalStep.equals(expectedFinalStep)) {
            System.out.println("You are in the correct page," + finalStep + " moving on.");
        } else {
            System.out.println("You are not in the correct page," + finalStep + " closing.");
            driver.close();
        }

        Thread.sleep(500);

        driver.findElement(By.cssSelector("#finish")).click();

        //Add some time to site to load completely

        /* Final CHECK to see if the whole process went legitly */

        String finalPage = driver.findElement(By.cssSelector("#checkout_complete_container > h2")).getText();
        String expectedFinal = "THANK YOU FOR YOUR ORDER";

        if (finalPage.equals(expectedFinal)) {
            System.out.println("TEST CASE PASSED!");
            driver.close();
        } else {
            System.out.println("TEST CASE FAILED!");
            driver.close();
        }

    }

}
