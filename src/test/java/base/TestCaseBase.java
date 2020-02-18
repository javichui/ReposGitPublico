package base;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestCaseBase {

    protected WebDriver driver;
    private String mobileA = "android"; 
    private String mobileTypeNexus = "Nexus 6"; 
    
    @Parameters({"platform","gridIp", "mobileType"})
    @BeforeMethod
    public void setUp(String platform, String gridIp, String mobileType) throws Exception{
        DesiredCapabilities cap=new DesiredCapabilities();
        String HUB = "http://"+gridIp+"/wd/hub";
        URL url = new URL(HUB);
        
        
        if(mobileA.equals(platform))
        {
            if(mobileTypeNexus.equals(mobileType))
            {
            System.out.println("==== INICIANDO ANDROID ====");
            System.out.println("Inicializando test: " + this.getClass().getSimpleName());
            System.out.println("===========================");
           
            
            System.setProperty("webdriver.chrome.driver",
                    "C:\\PA_proyectos\\drivers\\chromedriver.exe");
            
       
            String path = "C://Users//jgarzonm//Documents//Santander//GridMobile";
             
            //Modify Capabilities
         
            cap.setCapability("automationName", "uiautomator2");
            cap.setCapability("platformName", "Android");
            cap.setCapability("deviceName", "Nexus 6");
            cap.setCapability("app", path + "//App//calculadora.apk");
            cap.setCapability("appPackage", "com.digitalchemy.calculator.freedecimal");

        

            driver   = new AndroidDriver<MobileElement>(url, cap);
            }
        } else {
             
            
            cap.setCapability("platformName", "iOS");
            cap.setCapability("platformVersion", "11.4");
            cap.setCapability("deviceName", "iPhone 8");
            cap.setCapability(CapabilityType.BROWSER_NAME, "safari");
           // cap.setCapability("app", “location of .app or .ipa file“);
       
            driver   = new IOSDriver<MobileElement>(url, cap);
        }
       
  
        


        
    }

    
  //Abre el navegador en la página indicada
    public void irALogin(final String paginaDestino){
        driver.get("http://www.google.com");
    }

    
    protected void setDriver(final WebDriver driver1) {
        this.driver = driver1;
    }

    public WebDriver getDriver() {
        return driver;
    }

    
    
    
    //Cierra el n avegador tras finalizar la ejecución del caso de prueba
    @AfterMethod public void tearDown() {
        System.out.println("==== Finalizando ====");
        System.out.println("Finalizando test: " + this.getClass().getSimpleName());
        System.out.println("=====================");
        
        driver.quit();
    }

    
    
    
    
}
