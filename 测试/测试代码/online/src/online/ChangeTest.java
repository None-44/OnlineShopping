package online;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class ChangeTest extends BaseTest {

    @Test
    public void testChangePassword1() {
        loginAsSeller();
        driver.get("http://localhost:8080/#/dashboard/changePassword");

        driver.findElement(By.xpath("//*[@id=\"app\"]/div/section/section/main/div/div/div[1]/form/div[1]/div/div/input")).sendKeys("2");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/section/section/main/div/div/div[1]/form/div[2]/div/div/input")).sendKeys("newpassword123");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/section/section/main/div/div/div[2]/button")).click();

        String currentUrl = driver.getCurrentUrl();
        assertTrue("页面没有跳转到登录页面", currentUrl.equals("http://localhost:8080/#/dashboard/changePassword"));
    }

    @Test
    public void testChangePassword2() {
        loginAsSeller();
        driver.get("http://localhost:8080/#/dashboard/changePassword");

        driver.findElement(By.xpath("//*[@id=\"app\"]/div/section/section/main/div/div/div[1]/form/div[1]/div/div/input")).sendKeys("1");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/section/section/main/div/div/div[1]/form/div[2]/div/div/input")).sendKeys("1");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/section/section/main/div/div/div[2]/button")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10); // 最多等待10秒
        wait.until(ExpectedConditions.urlContains("/login"));

        String currentUrl = driver.getCurrentUrl();
        assertTrue("页面没有跳转到登录页面", currentUrl.equals("http://localhost:8080/#/login"));
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
