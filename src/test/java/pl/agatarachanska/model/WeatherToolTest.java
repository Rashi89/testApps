package pl.agatarachanska.model;

import org.junit.jupiter.api.Test;

import java.util.ResourceBundle;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

class WeatherToolTest {

    @Test
    void test(){
        //given
        ResourceBundle bundle = ResourceBundle.getBundle("bundles.message");
        WeatherTool weatherTool = new WeatherTool("Lublin", bundle);
        //when
        String name = weatherTool.getCity();
        //then
        assertThat(name, equalTo("Lublin"));
    }

    @Test
    void apiConnectionIsCorrect(){
        //given
        WeatherTool weatherToolSpy = spy(WeatherTool.class);
        given(weatherToolSpy.fetchLocalApi()).willReturn(true);
        weatherToolSpy.setConnectionIsOpen();
        //when
        boolean result = weatherToolSpy.getConnectionIsOpen();
        //then
        assertTrue(result);

    }

    @Test
    void apiConnectionIsValid(){
        //given
        WeatherTool weatherToolSpy = spy(WeatherTool.class);
        given(weatherToolSpy.fetchLocalApi()).willReturn(false);
        weatherToolSpy.setConnectionIsOpen();
        //when
        boolean result = weatherToolSpy.getConnectionIsOpen();
        //then
        assertFalse(result);
    }

    @Test
    void unexpectErrorIsFalseWhenWeCreateNewWeatherTool(){
        //given
        //when
        WeatherTool weatherTool = new WeatherTool();
        //then
        assertFalse(weatherTool.getUnexpectError());
    }

    @Test
    void unexpectErrorIsTrueWhenSomethingIsWrong(){
        //given
        WeatherTool weatherToolSpy = spy(WeatherTool.class);
        given(weatherToolSpy.fetchLocalApi()).willReturn(false);
        weatherToolSpy.setUnexpectError();
        //when
        boolean result = weatherToolSpy.getUnexpectError();
        //then
        assertTrue(result);
    }

    @Test
    void downloadDataFromApiIsSuccessfullInYourRegion(){
        //given
        WeatherTool weatherTool = mock(WeatherTool.class);
        given(weatherTool.weatherInYourRegion()).willReturn(true);
        //when
        boolean result = weatherTool.weatherInYourRegion();
        //then
        assertTrue(result);
    }

    @Test
    void downloadDataFromApiIsNotSuccessfullInYourRegion(){
        //given
        ResourceBundle bundle = ResourceBundle.getBundle("bundles.message");
        WeatherTool weatherTool = new WeatherTool("Kraków", bundle);
        WeatherTool weatherToolSpy = spy(weatherTool);
        given(weatherToolSpy.weatherInYourRegion()).willReturn(false);
        weatherToolSpy.setUnexpectError();
        //when
        boolean result = weatherToolSpy.getUnexpectError();
        //then
        assertTrue(result);
    }

}