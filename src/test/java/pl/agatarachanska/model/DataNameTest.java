package pl.agatarachanska.model;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class DataNameTest {
    @Test
    void testCorrectDay() {
        //given
        Clock clock = Clock.fixed(Instant.parse("2021-10-25T10:15:30.00Z"), ZoneId.of("UTC"));
        Date date = Date.from(Instant.now(clock));
        ResourceBundle bundle = ResourceBundle.getBundle("bundles.message");
        DataName dataName = new DataName();
        dataName.setDate(date);
        //when
        String result  = dataName.createDayName(bundle);
        //then
        assertThat(result, equalTo(bundle.getString("poniedzialek")+" 25-10-2021"));
    }
}