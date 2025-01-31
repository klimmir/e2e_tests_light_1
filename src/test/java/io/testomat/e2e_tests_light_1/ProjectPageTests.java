package io.testomat.e2e_tests_light_1;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectPageTests {

    @Test
    public void userCanFindAndOpenProjectWithTests() {
        open("https://app.testomat.io/");

        // login
        $("#content-desktop #user_email").setValue("klimmir@gmail.com");
        $("#content-desktop #user_password").setValue("KKZ8Z!h34c5DihK");
        $("#content-desktop #user_remember_me").click();
        $("#content-desktop [name='commit']").click();
        $(".common-flash-success-right").shouldBe(Condition.visible);

        // search the test project
        $("#search").setValue("manufacture light");

        // open the project page
        $(byText("manufacture light")).click();
        $(".first h2").shouldHave(Condition.text("manufacture light"));


    }

}
