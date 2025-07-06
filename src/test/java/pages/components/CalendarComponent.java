package pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {
        public void setDate(String day, String month, String year) {
            $(".react-datepicker__month-select").selectOption(month);
            $(".react-datepicker__year-select").selectOption(year);
            String formattedDay = String.format("%03d", Integer.parseInt(day));
            $(".react-datepicker__day--" + formattedDay + ":not(.react-datepicker__day--outside-month)")
                    .click();

//            private SelenideElement monthSelect = $(".react-datepicker__month-select"),
//                    yearSelect = $(".react-datepicker__year-select");
//
//            private ElementsCollection daySelect = $$(".react-datepicker__day");
//
//            public void setDate(String month, String year, String day) {
//                monthSelect.selectOption(month);
//                yearSelect.selectOption(year);
//                daySelect.findBy(text(day)).click();
            }
//            $(".react-datepicker__day.react-datepicker__day--0"+day+":not(.react-datepicker__day--outside-month)").click();
        }
