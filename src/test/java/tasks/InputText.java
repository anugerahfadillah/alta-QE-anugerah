package tasks;

import fb.pageobjects.loginPageObj;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import orangehrm.pageobjects.HRMLoginPageObj;
import orangehrm.pageobjects.HRMPIMPageObj;

public class InputText {
    public static Performable onField(String fieldType, String value) throws Exception{
        Target field = null;

        switch (fieldType){
            case "email field":
                field = loginPageObj.EMAIL;
                break;
            case "password field":
                field = loginPageObj.PASSWORD;
                break;
            case "HRM username":
                field = HRMLoginPageObj.USERNAME_FIELD;
                break;
            case "HRM password":
                field = HRMLoginPageObj.PASSWORD_FIELD;
                break;
            case "firstName":
                field = HRMPIMPageObj.FIRST_NAME_FIELD;
                break;
            case "lastName":
                field = HRMPIMPageObj.LAST_NAME_FIELD;
                break;
            case "editMiddleName":
                field = HRMPIMPageObj.EDIT_MIDDLE_NAME_FIELD;
                break;
            case "employeeName":
                field = HRMPIMPageObj.EMPLOYEE_NAME;
                break;
            default:
                throw new Exception("There is no field type: "+ fieldType);
        }

        return Task.where("{0} input: '"+ value + "'",
                Enter.theValue(value).into(field));
    }
}
