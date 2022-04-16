package tasks;

import fb.pageobjects.checkPointPageObj;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.Collection;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class theMenu {
    public static Question<Collection<String>> displayed(){
        WaitUntil.the(checkPointPageObj.MENU_LIST, isVisible()).forNoMoreThan(25).seconds();

        return Text.ofEach(checkPointPageObj.MENU_LIST).describedAs("the message displayed");
    }
}
