package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void solutionsTest() {
        open("https://github.com/");
        $("div.HeaderMenu").$(byText("Solutions")).hover();
        $$("ul.list-style-none a")
                .findBy(text("Enterprise"))
                .click();
        actions().moveToElement($("div")).click().perform();
        $("div").shouldBe(visible);
        $("div").shouldHave(text("The AI-powered developer platform"));
    }
}
