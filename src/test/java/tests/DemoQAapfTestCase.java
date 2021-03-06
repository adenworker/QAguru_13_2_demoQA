package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class DemoQAapfTestCase {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1800x900";
    }

    @Test
    void QAapf() {

        open("/automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue("Pilot");

        $("#lastName").setValue("Pirx");

        $("#userEmail").setValue("pilot@pirx.pl");

        $(byText("Male")).click();

        $("#userNumber").setValue("4812345678");

        $("#dateOfBirthInput").click();
//        SelenideElement dateOfBirthInput = ($(".react-datepicker__month-select"));
//        actions().moveToElement(dateOfBirthInput).click(dateOfBirthInput).perform();
        $(".react-datepicker__month-select").click();
        $(byText("August")).click();
        $(".react-datepicker__year-select").click();
        $(byText("1966")).scrollIntoView(true).click();
        $(byText("15")).click();

        $(".subjects-auto-complete__input").click();
        $("#subjectsInput").sendKeys("English");
        $("#subjectsInput").pressEnter();

        $(byText("Reading")).click();
        $(byText("Music")).click();

//        $("#form-control-file").uploadFile(new File("meh.jpg"));
        $("#uploadPicture").uploadFromClasspath("meh.jpg");

        $("#currentAddress").setValue("House No. 4 on Bohdan Lepky Street");

        $("#state").click();
        $(byText("Haryana")).click();

        $("#city").click();
        $(byText("Karnal")).click();

        $("#submit").click();

        $(".modal-content").shouldHave(
                text("Pilot"),
                text("Pirx"),
                text("pilot@pirx.pl"),
                text("Male"),
                text("15 August,1966"),
                text("Reading, Music"),
                text("meh.jpg"),
                text("House No. 4 on Bohdan Lepky Street"),
                text("Haryana"),
                text("Karnal"),
                text("English"));

    }


}
