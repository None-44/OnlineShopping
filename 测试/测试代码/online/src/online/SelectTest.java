package online;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class SelectTest extends BaseTest {

    @Test
    public void testSelectBuyer1() {
        loginAsSeller();
        driver.get("http://localhost:8080/#/dashboard/good/manager");

        driver.findElement(By.xpath("//*[@id=\"goods\"]/div[3]/div[3]/table/tbody/tr/td[5]/div/button")).click();
        driver.findElement(By.xpath("//*[@id=\"goods\"]/div[6]/div/div[2]/div/div[4]/div[2]/table/tbody/tr/td[5]/div/div/button")).click();
        driver.findElement(By.xpath("//*[@id=\"goods\"]/div[6]/div/div[3]/span/button[2]")).click();
 
        boolean isElementNotPresent = driver.findElements(By.xpath("//*[@id=\"goods\"]/div[3]/div[5]/div[2]/table/tbody/tr/td[6]/div/div/button[2]")).isEmpty();

        assertTrue("订单提交成功，验证按钮不存在", isElementNotPresent);    }
    
    @Test
    public void testSelectBuyer2() {
        loginAsSeller();
        driver.get("http://localhost:8080/#/dashboard/good/manager");

        driver.findElement(By.xpath("//*[@id=\"goods\"]/div[3]/div[3]/table/tbody/tr/td[5]/div/button")).click();
 
        boolean isElementNotPresent = driver.findElements(By.xpath("//*[@id=\"goods\"]/div[6]/div/div[2]/div/div[3]/table/tbody/tr[2]")).isEmpty();

        assertTrue("订单提交成功，验证按钮不存在", isElementNotPresent);    }

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

