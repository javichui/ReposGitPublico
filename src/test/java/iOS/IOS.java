package iOS;
 

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import pageObject.general.PageObjectBase;


public class IOS {

    public static WebDriver driver; 
    
    @Test
    public void Android() throws Exception {
       
    try {  
        String url = "https://www.everis.com/global/es";    
            
        System.setProperty("webdriver.chrome.driver",
                "C:\\PA_proyectos\\drivers\\chromedriver.exe");
        
   
        String path = "C://Users//jgarzonm//Documents//Santander//AppiumGrid-master";
        
        System.out.println("Mod. Capabilities");
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability("automationName", "uiautomator2");
        cap.setCapability("platformName", "IOS");
        cap.setCapability("deviceName", "IPhone X");
        cap.setCapability("app", path + "//App//calculadora.apk");
        //cap.setCapability("appWaitActivity", "org.wordpress.android.ui.accounts.SignInActivity");
        cap.setCapability("appPackage", "com.digitalchemy.calculator.freedecimal");
        
 
     
        String HUB = "http://localhost:4444/wd/hub";
        URL url1 = new URL(HUB);

        driver   = new AndroidDriver<MobileElement>(new URL("http://localhost:4729/wd/hub"), cap);
       PageObjectBase pO = new PageObjectBase(driver);
 
        System.out.println("HOLII"); 
        
        pO.esperarElementoClickeable(By.id("com.digitalchemy.calculator.freedecimal:id/n4"));
        driver.findElement(By.id("com.digitalchemy.calculator.freedecimal:id/n4")).click();
        driver.findElement(By.id("com.digitalchemy.calculator.freedecimal:id/multiply")).click();
        driver.findElement(By.id("com.digitalchemy.calculator.freedecimal:id/n6")).click();
        try {
            driver.findElement(By.id("com.digitalchemy.calculator.freedecimal:id/equals")).click();
        } catch (Exception e) {
            throw e;
        }
        pO.esperarElementoClickeable(By.className("android.view.View"));
        System.out.println(pO.getText(By.className("android.view.View")));
        if(pO.getText(By.className("android.view.View")).equals("24")) {
            System.out.println("Calculo Correcto");
        } else {
            System.out.println("Calculo incorrecto");
        }
        driver.quit();

    } catch (Exception e) {
        System.out.println("----------------------------------------------------------");
        System.out.println("---- El caso de prueba no ha finalizado correctamente ----");
        System.out.println("----------------------------------------------------------");
        
        throw e;
    }  finally {
        driver.quit();
    }
  }
    
}