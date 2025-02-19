package io.testomat.e2e_tests_light_1;

import com.codeborne.selenide.Condition;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectPageTests {

    Dotenv dotenv = Dotenv.load();

    String baseUrl = dotenv.get("BASE_URL");
    String username = dotenv.get("USEREMAIL");
    String password = dotenv.get("PASSWORD");
    String projectName = "manufacture light";

    @Test
    public void userCanFindAndOpenProjectWithTests() {

        login(baseUrl, username, password);

        searchProject(projectName);

        openProjectPage(projectName);

        // logout
        //...

    }

    @Test
    public void test2() {

        login(baseUrl, username, password);

    }

    private static void openProjectPage(String projectName) {
        $(byText(projectName)).click();
        $(".first h2").shouldHave(Condition.text(projectName));
        $(".first [href*='/readme']").shouldHave(Condition.text("Readme"));
    }

    private static void searchProject(String projectName) {
        $("#search").setValue(projectName);
    }

    private static void login(String url, String username, String password) {
        open(url);
        $("#content-desktop #user_email").setValue(username);
        $("#content-desktop #user_password").setValue(password);
        $("#content-desktop #user_remember_me").click();
        $("#content-desktop [name='commit']").click();
        $(".common-flash-success-right").shouldBe(Condition.visible);
    }

}
