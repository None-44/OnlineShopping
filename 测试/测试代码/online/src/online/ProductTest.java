package online;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductTest extends BaseTest {

    @Test
    public void testModifyProduct() {
        loginAsSeller();
        driver.get("http://localhost:8080/#/dashboard/good/manager");

        WebDriverWait wait = new WebDriverWait(driver, 10); // 最多等待10秒
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"goods\"]/div[3]/div[5]/div[2]/table/tbody/tr/td[6]/div/div/button[1]")));

        driver.findElement(By.xpath("//*[@id=\"goods\"]/div[3]/div[5]/div[2]/table/tbody/tr/td[6]/div/div/button[1]")).click();

        driver.findElement(By.xpath("//*[@id=\"goods\"]/div[4]/div/div[2]/form/div[1]/div/div/input")).clear(); 
        driver.findElement(By.xpath("//*[@id=\"goods\"]/div[4]/div/div[2]/form/div[1]/div/div/input")).sendKeys("修改后的商品名称");

        driver.findElement(By.xpath("//*[@id=\"goods\"]/div[4]/div/div[2]/form/div[2]/div/div/input")).clear(); 
        driver.findElement(By.xpath("//*[@id=\"goods\"]/div[4]/div/div[2]/form/div[2]/div/div/input")).sendKeys("这是修改后的商品描述");

        driver.findElement(By.xpath("//*[@id=\"goods\"]/div[4]/div/div[2]/form/div[3]/div/div/input")).clear(); 
        driver.findElement(By.xpath("//*[@id=\"goods\"]/div[4]/div/div[2]/form/div[3]/div/div/input")).sendKeys("200");

        driver.findElement(By.xpath("//*[@id=\"goods\"]/div[4]/div/div[3]/span/button[2]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"goods\"]/div[3]/div[3]/table/tbody/tr/td[2]/div")));

        String actualProductName = driver.findElement(By.xpath("//*[@id=\"goods\"]/div[3]/div[3]/table/tbody/tr/td[2]/div")).getText();
        String expectedProductName = "修改后的商品名称";

        assertEquals("商品修改失败，名称不匹配！", expectedProductName, actualProductName);
    }

    private void loginAsSeller() {
        driver.get("http://localhost:8080/#/login");

        driver.findElement(By.xpath("//*[@id='app']/section/main/div/div[1]/form/div[1]/div/div/input")).sendKeys("admin"); 
        driver.findElement(By.xpath("//*[@id='app']/section/main/div/div[1]/form/div[2]/div/div/input")).sendKeys("1"); 
        driver.findElement(By.xpath("//*[@id='app']/section/main/div/div[2]/button")).click(); 
    }
}