package Helpers;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Helpers {
    private static WebDriver driver;
    private static Faker faker;
    WebDriverWait wait;
    private int seconds = 20;
    public Helpers(){
    }
    public Helpers(WebDriver driver){
        this.driver = driver;
        this.faker = new Faker();
        this.wait = new WebDriverWait(driver,seconds);
    }

    public void getURL(String url) {
        Print("Se ingresa a la URL:" + url);
        driver.get(url);
    }
    public String getXMLParameter(String Key) {
        return Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter(Key);
    }
    public Boolean isDisabled(By by) {
       WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        if(element.isEnabled()){
            return true;
        }else{
            return false;
        }
    }

    public void Wait(int secs){
        try {
            Thread.sleep(secs*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void Print(String texto){
        System.out.println(texto + "\r\n");
    }

    public void Click(By by) {
        /* metodo que hace scroll hasta el elemento al que se va a hacer click y hace click a ese elemento
         * Se realizó para corregir el error de click interceptado por otro elemento en la sección "Web Tables"
         * Es necesario para los casos de prueba de Web tables
         * realizado por: Elián Andrés Díaz Vargas
         */
        // Espera dinamica
        wait.until(ExpectedConditions.elementToBeClickable(by));
        // ----------------------------------------------------

        WebElement elemento = driver.findElement(by);

        // ----------------------------------------------------

        elemento.click();
        Print("Se realiza Click a Elemento:" + by);
    }
    public void Click(WebElement elemento) {
        /* metodo que hace scroll hasta el elemento al que se va a hacer click y hace click a ese elemento
         * Se realizó para corregir el error de click interceptado por otro elemento en la sección "Web Tables"
         * Es necesario para los casos de prueba de Web tables
         * realizado por: Elián Andrés Díaz Vargas
         */
        // Espera dinamica
        wait.until(ExpectedConditions.elementToBeClickable(elemento));
        // ----------------------------------------------------

        elemento.click();
        Print("Se realiza Click a Elemento:" + elemento);
    }

    public void ClickJS(By by) {
        WebElement element = driver.findElement(by);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void ClickJS(WebElement webElement) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", webElement);
    }

    public void sendText(By by, String text) {
        WebElement elemento =  wait.until(ExpectedConditions.elementToBeClickable(by));
        elemento.sendKeys(text);
        Print("Se envia texto "+ text +" a Elemento:"+ by);
    }
    public boolean compare_text(String origin, String subject){
        return origin.equals(subject);
    }
    public boolean contains_text(String origin, String subject){
        Print("Se compara Origen: " + origin + " con Objetivo: " + subject);
        return origin.contains(subject);
    }
    public String getText(By by){
        WebElement elemento =  wait.until(ExpectedConditions.presenceOfElementLocated(by));
        String texto_extraido = elemento.getText();
        Print("Se extrae texto: "+ texto_extraido+ " del elemento: " +by );
        return texto_extraido;
    }
    public String getText(WebElement elemento){
        String texto_extraido = elemento.getText();
        Print("Se extrae texto: "+ texto_extraido+ " del elemento: " + elemento );
        return texto_extraido;
    }
    // ---------------FAKER METHODS-------------------------------------
    public String fake_first_name(){
        return faker.name().firstName();
    }
    public String fake_email_address(){
        return faker.internet().emailAddress();
    }
    public String fake_address(){
        return faker.address().streetAddress();
    }

    // ---------------FAKER METHODS-------------------------------------
}
