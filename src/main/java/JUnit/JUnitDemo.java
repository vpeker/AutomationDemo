package JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JUnitDemo {

  static WebDriver driver;
  static String baseUrl;

    @BeforeAll
    public static void setUP() {
        baseUrl="https://letskodeit.teachable.com/";
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        System.out.println("@BeforeAll-Initated and navigated to web page");
    }

    @AfterAll
    public  static void tearDown() {
        driver.quit();
        System.out.println("@AfterAll-close the session");
    }

    @BeforeEach
    public void init() {
        driver.navigate().refresh();
        System.out.println("@Beforeeach-refresh the page");
    }

    @AfterEach
    public void done() {
        driver.navigate().refresh();
        System.out.println("@aftereach-refresh the page");
    }

    @Test
    public  void  test1() {
        driver.findElement(By.cssSelector("a.navbar-brand.header-logo")).click();
        System.out.println("@test1");
    }

    @Test
    public  void test2() {
        WebElement logo=driver.findElement(By.cssSelector("a.navbar-brand.header-logo"));
        logo.click();

        System.out.println("@test2");
    }


}