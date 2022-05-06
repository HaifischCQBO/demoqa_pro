package Tests.Elements;

import Baseclass.BaseClass;
import Helpers.Helpers;
import Pages.Elements.Page_TextBox;
import Pages.Page_Index;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Test_TextBox extends BaseClass {


    @Test
    public void Elements_Textbox_Complete_textboxs_fields(){

        Helpers helpers = new Helpers(driver);
        Page_Index page_index = new Page_Index(driver);
        helpers.Click(page_index.findCategoryCard(0));
        page_index.goTo_Elements_TextBox();

        //FILLING STAGE
        Page_TextBox page_textBox = new Page_TextBox(driver);
        String first_name = page_textBox.fill_first_name();
        String email_address = page_textBox.fill_email_address();
        String currentAddress = page_textBox.fill_currentAddress();
        String permanentAddress = page_textBox.fill_permanentAddress();
        page_textBox.submit_form();

        //VALIDATION STAGE
        Assert.assertTrue(page_textBox.check_fake_first_name(first_name), "Name no es el mismo");
        Assert.assertTrue(page_textBox.check_fake_email_address(email_address), "Email no es el mismo");
        Assert.assertTrue(page_textBox.check_fake_currentAddress(currentAddress), "Current Address no es el mismo");
        Assert.assertTrue(page_textBox.check_fake_permanentAddress(permanentAddress), "Permanent Address no es el mismo");



    }
}
