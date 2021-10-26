package pl.agatarachanska.model;

import org.hamcrest.MatcherAssert;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ResourceBundle;

import static net.javacrumbs.jsonunit.JsonMatchers.jsonEquals;
import static net.javacrumbs.jsonunit.core.util.ResourceUtils.resource;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.spy;

class WeatherManagerTest {

    @Test
    void readJsonFileFromURL() throws IOException {
        //given
        ResourceBundle bundle = ResourceBundle.getBundle("bundles.message");
        WeatherManager weatherManager = new WeatherManager("Lublin",bundle);
        String url ="file:///D:/Programowanie/projekty_w_java/apkaPogodowaTesty3/src/test/resources/test.json";
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
        String url ="file:///D:/Programowanie/projekty_w_java/apkaPogodowaTesty3/src/test/resources/data.json";
        given(weatherManagerSpy.getApi()).willReturn(url);
        //when
        weatherManagerSpy.fetchDataWeather();
        //then
        assertThat(weatherManagerSpy.getTemperature(),equalTo(11));
        assertThat(weatherManagerSpy.getIcon(),equalTo("04d"));
        assertThat(weatherManagerSpy.getDescription(),equalTo("zachmurzenie duże"));
        assertThat(weatherManagerSpy.getPressure(),equalTo("1022"));

    }

}