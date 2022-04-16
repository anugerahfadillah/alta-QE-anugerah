package fb.stepdefinitions;

import io.cucumber.java.en.But;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import tasks.theMenu;
import tasks.theMessage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.not;

//menampilkan pesan error pada checkpoint page facebook
public class checkPointStepDef {
    @Then("{actor} can't see my news feed")
    public void validateNewsFeed(Actor actor){
        actor.should(seeThat(theMenu.displayed(), not(contains("News Feed"))));
    }
    @But("{actor} see FB has disabled my account")
    public void validateAccountIsDisable(Actor actor){
        actor.should(
                seeThat(
                        theMessage.displayed(), contains(
                                "Your account has been disabled"
                        )
                )
        );

        actor.attemptsTo(
                Ensure.thatTheCurrentPage().currentUrl().contains("checkpoint")
        );
    }


}
