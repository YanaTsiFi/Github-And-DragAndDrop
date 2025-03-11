package tests;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000; // default 4000
    }


    @Test
    void DragAndDropActions() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        SelenideElement source = $("#column-a");
        SelenideElement target = $("#column-b");
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.clickAndHold(source)
                .moveToElement(target)
                .release()
                .perform();
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
    @Test
    void DragAndDropMethod() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        SelenideElement source = $("#column-a");
        SelenideElement target = $("#column-b");
        source.dragAndDrop(DragAndDropOptions.to(target));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
