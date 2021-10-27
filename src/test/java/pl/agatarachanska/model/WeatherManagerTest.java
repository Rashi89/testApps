package pl.agatarachanska.model;

import org.json.JSONException;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ResourceBundle;

import static net.javacrumbs.jsonunit.JsonMatchers.jsonEquals;
import static net.javacrumbs.jsonunit.core.util.ResourceUtils.resource;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.spy;

class WeatherManagerTest {

    @Test
    void newWeatherMenagerShouldSetCity() {
        //given
        ResourceBundle bundle = ResourceBundle.getBundle("bundles.message");
        //when
        WeatherManager weatherManager = new WeatherManager("Lublin", bundle);
        //then
        assertThat(weatherManager.getCity(), equalTo("Lublin"));
    }

    @Test
    void readJsonFileFromURLIsCorrect() throws IOException {
        //given
        ResourceBundle bundle = ResourceBundle.getBundle("bundles.message");
        WeatherManager weatherManager = new WeatherManager("Lublin",bundle);
        File file = new File("src/test/resources/test.json");
        String path = file.getAbsolutePath();
        String url ="file:///"+path;
        //when
        //then
        assertThat(weatherManager.readJsonFromURL(url), jsonEquals(resource("test.json")));
    }

    @Test
    void readJsonFileFromURLThrowException() {
        //given
        ResourceBundle bundle = ResourceBundle.getBundle("bundles.message");
        WeatherManager weatherManager = new WeatherManager("Lublin",bundle);
        String url ="";
        //when
        //then
        assertThrows(IOException.class,() -> weatherManager.readJsonFromURL(url));
    }

    @Test
    void readDataWeatherFromFileIsCorrect(){
        //given
        ResourceBundle bundle = ResourceBundle.getBundle("bundles.message");
        WeatherManager weatherManager = new WeatherManager("Lublin",bundle);
        WeatherManager weatherManagerSpy = spy(weatherManager);
        File file = new File("src/test/resources/data.json");
        String path = file.getAbsolutePath();
        String url ="file:///"+path;
        given(weatherManagerSpy.getApi()).willReturn(url);
        //when
        weatherManagerSpy.fetchDataWeather();
        //then
        assertThat(weatherManagerSpy.getTemperature(),equalTo(11));
        assertThat(weatherManagerSpy.getIcon(),equalTo("04d"));
        assertThat(weatherManagerSpy.getDescription(),equalTo("zachmurzenie duże"));
        assertThat(weatherManagerSpy.getPressure(),equalTo("1022"));

    }

    @Test
    void fetchDataWeatherShouldThrowException() {
        //given
        ResourceBundle bundle = ResourceBundle.getBundle("bundles.message");
        WeatherManager weatherManager = new WeatherManager("Lublin",bundle);
        WeatherManager weatherManagerSpy = spy(weatherManager);
        String url = null;
        given(weatherManagerSpy.getApi()).willReturn(url);
        //when
        weatherManagerSpy.fetchDataWeather();
        //then
        assertTrue(weatherManagerSpy.getUnexpectErrors());
    }

}