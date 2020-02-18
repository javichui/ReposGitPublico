package pageObject.calculadora;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObject.general.PageObjectBase;

public class CalculadoraPage extends PageObjectBase {

  //Localizadores situacion
    private By buttonNumber4= By.id("com.digitalchemy.calculator.freedecimal:id/n4");
    private By buttonNumber6 = By.id("com.digitalchemy.calculator.freedecimal:id/n6");
    private By buttonMultiply = By.id("com.digitalchemy.calculator.freedecimal:id/multiply");
    private By buttonEquals = By.id("com.digitalchemy.calculator.freedecimal:id/equals");
    private By textResult = By.className("android.view.View");
    
    
    /*****Constructor*****/
    //Constructor de la clase
    public CalculadoraPage(WebDriver driver, String mainClass) {
        super(driver, mainClass);
    }

    //Acceder al detalle de la primera situacion ya que esta deberia ser la ultima creada
    public void realizarCalculo() throws InterruptedException {     
        esperarElementoClickeable(buttonNumber4);
        clickElemento(buttonNumber4, "button 4");
        esperarElementoClickeable(buttonMultiply);
        clickElemento(buttonMultiply, "button Multiply");
        esperarElementoClickeable(buttonNumber6);
        clickElemento(buttonNumber6, "button 6");
    }

    public String obtenerResultado() throws Exception {
        esperarElementoClickeable(buttonEquals);
        clickElemento(buttonEquals, "button Equals");
        esperarElementoClickeable(textResult);
        return getText(By.className("android.view.View")); 
    }

    
    
    public void esperarSincronizacion() {
        esperarAPagina(buttonNumber4, "Calculadora");
    }

    
    
    
    
}
