package fb.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.facebook.com/login")
public class loginPageObj extends PageObject {
    public static Target EMAIL = Target.the("email field")
            .locatedBy("#email");
    public static Target PASSWORD = Target.the("password field")
            .locatedBy("#pass");
    public static Target LOGIN_BUTTON = Target.the("login button")
            .locatedBy("#loginbutton");
}