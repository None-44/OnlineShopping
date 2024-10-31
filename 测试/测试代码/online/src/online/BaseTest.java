package online;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseTest {
    protected WebDriver driver;

    @Before
    public void setUp() {
 
        System.setProperty("webdriver.edge.driver", "D:\\计算机学习\\edgedriveredg\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver(); 
        driver.manage().window().maximize();
    }
    
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit(); 
        }
    }
}