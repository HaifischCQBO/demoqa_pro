package Tests.Elements;

import Baseclass.BaseClass;
import Helpers.Helpers;
import Pages.Elements.Page_RadioButton;
import Pages.Page_Index;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_RadioButton extends BaseClass {


    @Test
    public void Elements_radioButton_Select_Yes(){

        Helpers helpers = new Helpers(driver);
        Page_Index page_index = new Page_Index(driver);
        helpers.Click(page_index.findCategoryCard(0));
        page_index.goTo_Elements_radioButton();

        Page_RadioButton page_radioButton = new Page_RadioButton(driver);
        page_radioButton.select_yes_radiobutton();
        Assert.assertTrue(helpers.compare_text(page_radioButton.getCheckedOption(), "Yes"));
    }
    @Test
    public void Elements_radioButton_Select_Impressive(){

        Helpers helpers = new Helpers(driver);
        Page_Index page_index = new Page_Index(driver);
        helpers.Click(page_index.findCategoryCard(0));
        page_index.goTo_Elements_radioButton();

        Page_RadioButton page_radioButton = new Page_RadioButton(driver);
        page_radioButton.select_impressive_radiobutton();
        Assert.assertTrue(helpers.compare_text(page_radioButton.getCheckedOption(), "Impressive"));
    }
    @Test
    public void Elements_radioButton_disable_No(){

        Helpers helpers = new Helpers(driver);
        Page_Index page_index = new Page_Index(driver);
        helpers.Click(page_index.findCategoryCard(0));
        page_index.goTo_Elements_radioButton();

        Page_RadioButton page_radioButton = new Page_RadioButton(driver);
        Assert.assertFalse(page_radioButton.validate_radiobutton_disabled());
    }
}
