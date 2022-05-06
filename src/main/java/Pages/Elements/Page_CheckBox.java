package Pages.Elements;

import Helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Page_CheckBox {


    public WebDriver driver;
    public Helpers helpers;

    public Page_CheckBox(WebDriver driver){
        this.driver = driver;
        helpers = new Helpers(driver);
    }

    // WEB ELEMENT // WEB ELEMENT //WEB ELEMENT //WEB ELEMENT //WEB ELEMENT //WEB ELEMENT

    private By expand_all_button = By.xpath("//div[@class='rct-options']/button[@title='Expand all']");
    private By toggle_leaf_li = By.xpath("//li[contains(@class, 'leaf')]//input");
    private By selected_folder_div = By.id("result");

    // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES

    public List<WebElement> getCategoryCards(){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(toggle_leaf_li));
        List<WebElement> categoryCards = driver.findElements(toggle_leaf_li);
        return categoryCards;
    }

    public void expand_all_toggle(){
        helpers.Click(expand_all_button);
    }
    public void select_all_leaf_toggle() {
        for(WebElement element : getCategoryCards()){
            helpers.ClickJS(element);
        }
    }
    public boolean validate_folder_checked(WebElement element){
        helpers.Print("Validando: "+ element);
        return helpers.contains_text(helpers.getText(selected_folder_div), helpers.getText(element));
    }

}
