package pages.components;

import demoqa.DataGenerator;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    DataGenerator dataGenerator = new DataGenerator();

    public void setDate() {
        $("#dateOfBirthInput").scrollIntoView(true).click();
        $("#dateOfBirthInput").clear();
        $("#dateOfBirthInput").setValue(dataGenerator.RandomDate());

    }
}
