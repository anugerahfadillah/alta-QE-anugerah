package fb.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.cdimascio.dotenv.Dotenv;
import net.serenitybdd.screenplay.Actor;
import tasks.ClickOn;
import tasks.InputText;
import tasks.navigateTo;

public class loginStepDef {
    @Given("{actor} open facebook login page")
    public void loadFBLoginPage(Actor actor) throws Exception {
        actor.wasAbleTo(navigateTo.theUrl("FB login"));
    }
    @When("{actor} input email and password")
    public void inputField(Actor actor) throws Exception{
        Dotenv dotenv = Dotenv.load();

        String email = dotenv.get("EMAIL");
        String password = dotenv.get("PASSWORD");

        actor.attemptsTo(
                InputText.onField("email field", email),
                InputText.onField("password field", password)
        );
    }
    @And("{actor} click button login")
    public void clickButton(Actor actor) throws Exception{
        actor.attemptsTo(
                ClickOn.button("FB login")
        );
    }
}
