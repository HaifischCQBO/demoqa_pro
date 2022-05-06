package Pages.Elements;

import Helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page_RadioButton {


    public WebDriver driver;
    public Helpers helpers;

    public Page_RadioButton(WebDriver driver){
        this.driver = driver;
        helpers = new Helpers(driver);
    }

    // WEB ELEMENT // WEB ELEMENT //WEB ELEMENT //WEB ELEMENT //WEB ELEMENT //WEB ELEMENT

    public By yes_radiobutton = By.id("yesRadio");
    public By impressive_radiobutton = By.id("impressiveRadio");
    public By no_radiobutton = By.id("noRadio");
    public By selected_p = By.className("text-success");


    // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES


    public void select_yes_radiobutton(){
        helpers.ClickJS(yes_radiobutton);
    }
    public void select_impressive_radiobutton(){
        helpers.ClickJS(impressive_radiobutton);
    }
    public Boolean validate_radiobutton_disabled(){
        return helpers.isDisabled(no_radiobutton);
    }

    public String getCheckedOption(){
        return helpers.getText(selected_p);
    }


}
