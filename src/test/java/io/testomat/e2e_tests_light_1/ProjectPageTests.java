package io.testomat.e2e_tests_light_1;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectPageTests extends BaseTest {

    String baseUrl = env.get("BASE_URL");
    String userEmail = env.get("USER_EMAIL");
    String password = env.get("PASSWORD");
    String projectName = "manufacture light";

    @Test
    public void userCanFindAndOpenProjectWithTests() {

        login(baseUrl, userEmail, password);

        searchProject(projectName);

        openProjectPage(projectName);

        // logout
        //...

    }

    @Test
    public void test2() {

        login(baseUrl, userEmail, password);

    }

    private static void openProjectPage(String projectName) {
        $(byText(projectName)).click();
        $(".first h2").shouldHave(Condition.text(projectName));
        $(".first [href*='/readme']").shouldHave(Condition.text("Readme"));
    }

    private static void searchProject(String projectName) {
        $("#search").setValue(projectName);
    }

    private static void login(String url, String userEmail, String password) {
        open(url);
        $("#content-desktop #user_email").setValue(userEmail);
        $("#content-desktop #user_password").setValue(password);
        $("#content-desktop #user_remember_me").click();
        $("#content-desktop [name='commit']").click();
        $(".common-flash-success-right").shouldBe(Condition.visible);
    }

}
