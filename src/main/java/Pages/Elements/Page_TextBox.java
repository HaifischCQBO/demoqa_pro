package Pages.Elements;

import Helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page_TextBox {


    public WebDriver driver;
    public Helpers helpers;

    public Page_TextBox(WebDriver driver){
        this.driver = driver;
        helpers = new Helpers(driver);
    }

    // WEB ELEMENT // WEB ELEMENT //WEB ELEMENT //WEB ELEMENT //WEB ELEMENT //WEB ELEMENT

    private By full_name_input = By.id("userName");
    private By email_input = By.id("userEmail");
    private By currentAddress_textarea = By.id("currentAddress");
    private By permanentAddress_textarea = By.id("permanentAddress");
    private By submit_button = By.id("submit");

    private By name_p = By.id("name");
    private By email_p = By.id("email");
    private By currentAddress_p = By.xpath("//p[@id='currentAddress']");
    private By permanentAddress_p = By.xpath("//p[@id='permanentAddress']");



    // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES

    public String fill_first_name(){
        String fake_first_name = helpers.fake_first_name();
        helpers.sendText(full_name_input,fake_first_name );
        return fake_first_name;

    } public String fill_email_address(){
        String fake_email_address = helpers.fake_email_address();
        helpers.sendText(email_input, fake_email_address);
        return fake_email_address;

    } public String fill_currentAddress(){
        String fake_address = helpers.fake_address();
        helpers.sendText(currentAddress_textarea, fake_address);
        return fake_address;

    } public String fill_permanentAddress(){
        String fake_address = helpers.fake_address();
        helpers.sendText(permanentAddress_textarea, fake_address);
        return fake_address;
    }
    public boolean check_fake_first_name(String text){
        return helpers.contains_text(helpers.getText(name_p), text);
    }
    public boolean check_fake_email_address(String text){
        return helpers.contains_text(helpers.getText(email_p), text);
    }
    public boolean check_fake_currentAddress(String text){
        return helpers.contains_text(helpers.getText(currentAddress_p), text);
    }
    public boolean check_fake_permanentAddress(String text){
        return helpers.contains_text(helpers.getText(permanentAddress_p), text);
    }

    public void submit_form(){
        helpers.Click(submit_button);
    }

}
