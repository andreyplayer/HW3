import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutomationPracticeForm {

    @BeforeAll
    static void testInit() {

        open("https://demoqa.com/automation-practice-form");
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

    }

    @Test
    void demoqaPracticeFormTest() {

        $("#firstName").setValue("Andrey");
        $("#lastName").setValue("Andreev");
        $("#userEmail").setValue("andrey.andreev@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("0123456789");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("January")).click();
        $(".react-datepicker__year-select").$(byText("1990")).click();
        $(".react-datepicker__month-container").$(byText("16")).click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("pictures/sample.png");
        $("#currentAddress").setValue("My Home address");
        $("#state").click();
        $("#state").$(byText("NCR")).click();
        $("#city").click();
        $("#city").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-header").shouldHave(text("Thanks for submitting the form"));

        $(".modal-body").shouldHave(text("Andrey"));
        $(".modal-body").shouldHave(text("Andreev"));
        $(".modal-body").shouldHave(text("andrey.andreev@gmail.com"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("0123456789"));
        $(".modal-body").shouldHave(text("16 January,1990"));
        $(".modal-body").shouldHave(text("Maths"));
        $(".modal-body").shouldHave(text("Sports, Reading"));
        $(".modal-body").shouldHave(text("sample.png"));
        $(".modal-body").shouldHave(text("My Home address"));
        $(".modal-body").shouldHave(text("NCR Delhi"));

        $("#closeLargeModal").click();

    }

}
