package android;
 

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

import base.TestCaseBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import pageObject.calculadora.CalculadoraPage;
import pageObject.general.PageObjectBase;


public class androidCalculadora extends TestCaseBase{

    public static WebDriver driver; 
    
 
    
    @Test public void Android() throws Exception {
       
    try {   
        WebDriver driver = getDriver();
        
        String mainClass = this.getClass().getSimpleName();
        
        final PageObjectBase pO = new PageObjectBase(driver, mainClass);
        final CalculadoraPage cP = new CalculadoraPage(driver, mainClass);

        cP.esperarSincronizacion();
        
        cP.realizarCalculo();
        
       String resultado = cP.obtenerResultado();
       System.out.println("El resultado final es:  " + resultado);

    } catch (Exception e) {
        System.out.println("----------------------------------------------------------");
        System.out.println("---- El caso de prueba no ha finalizado correctamente ----");
        System.out.println("----------------------------------------------------------");
        
        throw e;
    } 
  }
    
}