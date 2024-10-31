package online;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class PublishTest extends BaseTest {

    @Test
    public void testPublishProduct() {
        loginAsSeller();
        driver.get("http://localhost:8080/#/dashboard/good/manager");

        driver.findElement(By.xpath("//*[@id=\"goods\"]/div[3]/div[5]/div[1]/table/thead/tr/th[6]/div/div/button")).click();
        
        driver.findElement(By.xpath("//*[@id=\"goods\"]/div[5]/div/div[2]/form/div[1]/div/div/input")).sendKeys("Product 1");
        driver.findElement(By.xpath("//*[@id=\"goods\"]/div[5]/div/div[2]/form/div[2]/div/div/input")).sendKeys("This is a description.");
        driver.findElement(By.xpath("//*[@id=\"goods\"]/div[5]/div/div[2]/form/div[3]/div/div/input")).sendKeys("C:\\path\\to\\image.jpg");
        driver.findElement(By.xpath("//*[@id=\"goods\"]/div[5]/div/div[2]/form/div[4]/div/div/textarea")).sendKeys("100");
        driver.findElement(By.xpath("//*[@id=\"goods\"]/div[5]/div/div[3]/span/button[2]")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10); 
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"goods\"]/div[3]/div[4]/div[2]/table/tbody/tr")));

        assertTrue(driver.findElement(By.xpath("//*[@id=\"goods\"]/div[3]/div[4]/div[2]/table/tbody/tr")).isDisplayed());
    }

    private void loginAsSeller() {
    	driver.get("http://localhost:8080/#/login");

        driver.findElement(By.xpath("//*[@id=\"app\"]/section/main/div/div[1]/form/div[1]/div/div/input")).sendKeys("admin");
        driver.findElement(By.xpath("//*[@id=\"app\"]/section/main/div/div[1]/form/div[2]/div/div/input")).sendKeys("1");
        driver.findElement(By.xpath("//*[@id=\"app\"]/section/main/div/div[2]/button")).click();

        String expectedUrl = "http://localhost:8080/#/dashboard/good/manager";
        
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }
}
