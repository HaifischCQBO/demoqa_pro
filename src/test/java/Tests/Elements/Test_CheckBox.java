package Tests.Elements;

import Baseclass.BaseClass;
import Helpers.Helpers;
import Pages.Elements.Page_CheckBox;
import Pages.Elements.Page_TextBox;
import Pages.Page_Index;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_CheckBox extends BaseClass {


    @Test
    public void Elements_CheckBox_Select_all_checkbox(){

        Helpers helpers = new Helpers(driver);
        Page_Index page_index = new Page_Index(driver);
        helpers.Click(page_index.findCategoryCard(0));
        page_index.goTo_Elements_CheckBox();

        Page_CheckBox page_checkBox = new Page_CheckBox(driver);
        page_checkBox.expand_all_toggle();
        page_checkBox.select_all_leaf_toggle();

        for(WebElement element : page_checkBox.getCategoryCards()){
            Assert.assertTrue(page_checkBox.validate_folder_checked(element));
        }
    }
}
