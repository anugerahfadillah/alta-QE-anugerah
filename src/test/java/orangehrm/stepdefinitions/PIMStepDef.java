package orangehrm.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import orangehrm.pageobjects.HRMPIMPageObj;
import tasks.ClickOn;
import tasks.InputText;
import tasks.VerifyDisplayed;
import tasks.navigateTo;

public class PIMStepDef {
    @And("{actor} access employee list")
    public void accessEmployee(Actor actor) throws Exception{
        actor.wasAbleTo(navigateTo.theUrl("HRM employee list"));
    }

    @And("{actor} can see new employee list result")
    public void listResult(Actor actor) throws Exception{
        actor.attemptsTo(
                VerifyDisplayed.element("employee list")
        );
    }

    @And("{actor} search for new employee")
    public void filterEmployee(Actor actor) throws Exception{
        actor.attemptsTo(
                InputText.onField("employeeName", "Anugerah"),
                ClickOn.button("search")
        );
    }

    @When("{actor} add new employee with required field only")
    public void addEmployee(Actor actor) throws Exception{
        actor.attemptsTo(
                ClickOn.button("add"),
                InputText.onField("firstName", "Anugerah"),
                InputText.onField("lastName", "Fadillah"),
                ClickOn.button("save")
        );
    }

    @Then("{actor} can see my Personal Details")
    public void personalDetails(Actor actor) throws Exception{
        actor.attemptsTo(VerifyDisplayed.element("Personal Details")
        );
    }

    @When("{actor} update new employee's middle name")
    public void updateEmployee(Actor actor) throws Exception{
        actor.attemptsTo(
                ClickOn.employeeList(),
                ClickOn.button("edit"),
                InputText.onField("editMiddleName" , "Agung"),
                ClickOn.button("save")
        );
    }

    @Then("{actor} can see Personal Details has changed")
    public void updatedEmployee(Actor actor) {
        actor.attemptsTo(
                Ensure.that(HRMPIMPageObj.EDIT_MIDDLE_NAME_FIELD).value().isEqualTo("Agung")
        );
    }

    @And("{actor} delete new employee")
    public void deleteEmployee(Actor actor) throws Exception{
        actor.attemptsTo(
                ClickOn.checkbox(),
                ClickOn.button("delete"),
                ClickOn.button("ok")
        );
    }

    @Then("{actor} can't see deleted employee on list")
    public void deletedEmployee(Actor actor) throws Exception{
        actor.attemptsTo(
                VerifyDisplayed.element("No Employee")
        );
    }

}
