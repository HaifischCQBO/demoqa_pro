package Pages;

import Helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Page_Index {

    private List<WebElement> listCategoryCards;
    public WebDriver driver;
    public Helpers helpers;

    public Page_Index(WebDriver driver){
        this.driver = driver;
        helpers = new Helpers(driver);
    }

    // WEB ELEMENT // WEB ELEMENT //WEB ELEMENT //WEB ELEMENT //WEB ELEMENT //WEB ELEMENT

    private By categorycards_div =  By.xpath("//div[contains(@class,'category-cards')]/div");
    private By elements_textbox_li = By.xpath("//span[text()='Text Box']/parent::li");
    private By elements_checkbox_li = By.xpath("//span[text()='Check Box']/parent::li");
    private By elements_radio_button_li = By.xpath("//span[text()='Radio Button']/parent::li");



    // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES

    private List<WebElement> getCategoryCards(){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(categorycards_div));
        List<WebElement> categoryCards = driver.findElements(categorycards_div);
        System.out.println(categoryCards);
        return categoryCards;
    }

    public WebElement findCategoryCard(int indexCategory){
        if(this.listCategoryCards == null){
            this.listCategoryCards = getCategoryCards();
        }
        if(!this.listCategoryCards.isEmpty()){
            try{
                return this.listCategoryCards.get(indexCategory);
            }catch (IndexOutOfBoundsException e){
                helpers.Print("Indice fuera de rango");
            }
        }
        else{
            helpers.Print("la lista de categoorias Está vacia");
        }
        return null;
    }

    public void goTo_Elements_TextBox(){
        helpers.Click(elements_textbox_li);
    }
    public void goTo_Elements_CheckBox(){
        helpers.Click(elements_checkbox_li);
    }
    public void goTo_Elements_radioButton(){
        helpers.Click(elements_radio_button_li);
    }
}
