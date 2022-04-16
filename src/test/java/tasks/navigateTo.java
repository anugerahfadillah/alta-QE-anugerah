package tasks;

import fb.pageobjects.loginPageObj;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import orangehrm.pageobjects.HRMLoginPageObj;
import orangehrm.pageobjects.HRMPIMPageObj;

public class navigateTo {
    public static Performable theUrl(String urlType) throws Exception{
        Class url;

        switch (urlType){
            case "FB login":
                url = loginPageObj.class;
                break;
            case "HRM login":
                url = HRMLoginPageObj.class;
                break;
            case "HRM employee list":
                url = HRMPIMPageObj.class;
                break;
            default:
                throw new Exception("There is no url type: "+ urlType);
        }

        return Task.where("{0} access the login url",
                Open.browserOn().the(url));
    }
}
