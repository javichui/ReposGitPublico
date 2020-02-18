package pageObject.general;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.implementation.bytecode.Throw;


public class PageObjectBase {

    protected WebDriver driver;

    protected String mainClass;

    
    //Constructor de la clase
    public PageObjectBase(WebDriver driver,  String mainClass) {
        setDriver(driver);
        this.mainClass = mainClass;
    }
    
    public PageObjectBase(WebDriver driver) {
        setDriver(driver);
    }
    
    
    /***************
    Drivers
     ***************/    
    
    // Metodo encargado de devolver el driver
    public WebDriver getDriver() {
        return driver;
    }

    // Metodo encargado de Settear/cambiar el driver por el nuevo
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public boolean seleccionarComboBy(By by, String option) throws Exception {
        try {
            WebDriverWait wdw = new WebDriverWait(getDriver(), 40);
            wdw.until(ExpectedConditions.elementToBeClickable(by));
            WebElement box = driver.findElement(by);
            Select selectBox = new Select(box);
            selectBox.selectByVisibleText(option);
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    
    public boolean seleccionarComboIndex(By by, Integer index) throws Exception {
        try {
            if(index > 3){
                index=3;
            }
            WebDriverWait wdw = new WebDriverWait(getDriver(), 20);
            wdw.until(ExpectedConditions.elementToBeClickable(by));
            WebElement box = driver.findElement(by);
            Select selectBox = new Select(box);
            selectBox.selectByIndex(index);
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    public void esperarAPagina(By by,  String nombrePantalla) {
        try{ 
         WebDriverWait wdw = new WebDriverWait(getDriver(), 40);
         wdw.until(ExpectedConditions.elementToBeClickable(by));
         System.out.println("Carga completa");
        }catch(Exception e)
        {
           
        }
    }
    
    protected void esperarAPaginaJs(WebDriver driver) {
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd -> 
        ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        System.out.println("Pagina Cargada");
    }
    
    
    public void esperarElementoClickeable(By by) {
        try{ 
         WebDriverWait wdw = new WebDriverWait(getDriver(), 40);
         wdw.until(ExpectedConditions.elementToBeClickable(by));
        }catch(Exception e)
        {
           
        }
    }
    
    
    public boolean esperarElementoNoVisible(By by) {
        try{ 
             WebDriverWait wdw = new WebDriverWait(getDriver(), 5);
             wdw.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
             return true;
        }catch(Exception e)
        {
            return false;
        }
    }
    
    
    // Metodo encargado de Esperar a que el elemento/boton este sea clickeable, si es asi, se haria click sobre el.
    public void clickElemento(By by, String nombreBoton) {
        try {
            WebDriverWait wdw = new WebDriverWait(getDriver(), 25);
            wdw.until(ExpectedConditions.elementToBeClickable(by));
             WebElement element = findElement(by);
             element.click();
        //  } 
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    
    public void buscarElemento(By by) throws InterruptedException {
        WebElement element = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform(); 
    }
    
    public String getText(By by) throws Exception {
        String ret = "";
        try {
            WebDriverWait wdw = new WebDriverWait(getDriver(), 40);
            wdw.until(ExpectedConditions.elementToBeClickable(by));
            WebElement we = findElement(by);
            ret = we.getText();
        } catch (Exception e) {
            throw e;
        }
        return ret;
    }
    
    public WebElement findElement(By by) {
        WebElement ret = null;
        try {
            ret = driver.findElement(by);
        } catch (Exception ex) {
        }
        return ret;
    }


}
