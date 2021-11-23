package basepackage;


import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.RegistrationPage;
import utils.Config;


import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    public RegistrationPage registrationPage;
    protected final Properties config = Config.loadProperties("D:\\Java\\AllProgram\\VodienRegisterTest\\src\\test\\resources\\test.properties");

    @BeforeTest
    public void setup(){

        System.setProperty("webdriver.chrome.driver", config.getProperty("chromedriver"));
        driver = new ChromeDriver();
       // driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
      //  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // явное ожидание

        driver.manage().window().maximize();
        driver.get("https://www.vodien.com.au/register"      /*config.getProperty("registration_url") */  );
    }

    @AfterTest
    public void cleanup() {
      //  System.out.println("cleanup  BaseTest");
        driver.manage().deleteAllCookies();
        //TestHelper.sleep5Seconds();

        driver.quit();
      //  if(driver!=null)driver.close();
        try {
      //      System.out.println("sleep BaseTest");
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

