package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests extends TestBase {

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("ivanivanov@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8800555353");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__year-select").selectOption("1971");
        $(".react-datepicker__day--019").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("image.jpg");
        $("#currentAddress").setValue("Calgary");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $$(".table-responsive").findBy(text("Student Name")).shouldHave(text("Ivan Ivanov"));
        $$(".table-responsive").findBy(text("Student Email")).shouldHave(text("ivanivanov@gmail.com"));
        $$(".table-responsive").findBy(text("Gender")).shouldHave(text("Male"));
        $$(".table-responsive").findBy(text("Mobile")).shouldHave(text("8800555353"));
        $$(".table-responsive").findBy(text("Date of Birth")).shouldHave(text("19 February,1971"));
        $$(".table-responsive").findBy(text("Subjects")).shouldHave(text("Computer Science"));
        $$(".table-responsive").findBy(text("Hobbies")).shouldHave(text("Sports"));
        $$(".table-responsive").findBy(text("Picture")).shouldHave(text("image.jpg"));
        $$(".table-responsive").findBy(text("Address")).shouldHave(text("Calgary"));
        $$(".table-responsive").findBy(text("State and City")).shouldHave(text("NCR Delhi"));


    }

}
