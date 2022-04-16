package tasks;

import fb.pageobjects.loginPageObj;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import orangehrm.pageobjects.HRMLoginPageObj;
import orangehrm.pageobjects.HRMPIMPageObj;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ClickOn {
    public static Performable employeeList(){
        return Task.where("{0} click first employee",
                Click.on(HRMPIMPageObj.FIRST_EMPLOYEE_LIST));
    }
    public static Performable checkbox(){
        return Task.where("{0} click checkbox on first employee",
                Click.on(HRMPIMPageObj.FIRST_EMPLOYEE_CHECKBOX));
    }

    public static Performable button(String buttonType) throws Exception{
        Target button;

        switch (buttonType){
            case "FB login":
                button = loginPageObj.LOGIN_BUTTON;
                break;
            case "HRM login":
                button = HRMLoginPageObj.LOGIN_BUTTON;
                break;
            case "add":
                button = HRMPIMPageObj.ADD_BUTTON;
                break;
            case "save":
                button = HRMPIMPageObj.SAVE_BUTTON;
                break;
            case "edit":
                button = HRMPIMPageObj.EDIT_BUTTON;
                break;
            case "delete":
                button = HRMPIMPageObj.DELETE_BUTTON;
                break;
            case "ok":
                button = HRMPIMPageObj.OK_BUTTON;
                break;
            case "search":
                button = HRMPIMPageObj.SEARCH_BUTTON;
                break;
            default:
                throw new Exception("There is no button type: "+ buttonType);
        }

        WaitUntil.the(button, isVisible()).forNoMoreThan(25).seconds();

        return Task.where("{0} click "+ buttonType + " button",
                Click.on(button));
    }
}
