package pl.agatarachanska.model;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class ImagesToolTest {

    @TestFactory
    Collection<DynamicTest> setGoodIcon() {
        return Arrays.asList(
                dynamicTest("Test 1d icon", () -> assertThat(ImagesTool.getImage("01d"),equalTo("/images/01d.png"))),
                dynamicTest("Test 1n icon", () -> assertThat(ImagesTool.getImage("01n"),equalTo("/images/01n.png"))),
                dynamicTest("Test 2d icon", () -> assertThat(ImagesTool.getImage("02d"),equalTo("/images/02d.png"))),
                dynamicTest("Test 2n icon", () -> assertThat(ImagesTool.getImage("02n"),equalTo("/images/02n.png"))),
                dynamicTest("Test 3d icon", () -> assertThat(ImagesTool.getImage("03d"),equalTo("/images/03d.png"))),
                dynamicTest("Test 3n icon", () -> assertThat(ImagesTool.getImage("03n"),equalTo("/images/03n.png"))),
                dynamicTest("Test 4d icon", () -> assertThat(ImagesTool.getImage("04d"),equalTo("/images/04d.png"))),
                dynamicTest("Test 4n icon", () -> assertThat(ImagesTool.getImage("04n"),equalTo("/images/04n.png"))),
                dynamicTest("Test 9d icon", () -> assertThat(ImagesTool.getImage("09d"),equalTo("/images/09d.png"))),
                dynamicTest("Test 9n icon", () -> assertThat(ImagesTool.getImage("09n"),equalTo("/images/09n.png"))),
                dynamicTest("Test 10d icon", () -> assertThat(ImagesTool.getImage("10d"),equalTo("/images/10d.png"))),
                dynamicTest("Test 10n icon", () -> assertThat(ImagesTool.getImage("10n"),equalTo("/images/10n.png"))),
                dynamicTest("Test 11d icon", () -> assertThat(ImagesTool.getImage("11d"),equalTo("/images/11d.png"))),
                dynamicTest("Test 11n icon", () -> assertThat(ImagesTool.getImage("11n"),equalTo("/images/11n.png"))),
                dynamicTest("Test 13d icon", () -> assertThat(ImagesTool.getImage("13d"),equalTo("/images/13d.png"))),
                dynamicTest("Test 13n icon", () -> assertThat(ImagesTool.getImage("13n"),equalTo("/images/13n.png"))),
                dynamicTest("Test 50d icon", () -> assertThat(ImagesTool.getImage("50d"),equalTo("/images/50d.png"))),
                dynamicTest("Test 50n icon", () -> assertThat(ImagesTool.getImage("50n"),equalTo("/images/50n.png"))),
                dynamicTest("Test default icon", () -> assertThat(ImagesTool.getImage("default"),equalTo("/images/icon.png")))
                );
    }

    @TestFactory
    Collection<DynamicTest> setGoodBackground() {
        return Arrays.asList(
                dynamicTest("Test 1d background", () -> assertThat(ImagesTool.getBackground("01d"),equalTo("/images/bg_slonce_1.jpg"))),
                dynamicTest("Test 1n background", () -> assertThat(ImagesTool.getBackground("01n"),equalTo("/images/bg_slonce_2.jpg"))),
                dynamicTest("Test 2d background", () -> assertThat(ImagesTool.getBackground("02d"),equalTo("/images/bg_zachmurzenie_1.jpg"))),
                dynamicTest("Test 2n background", () -> assertThat(ImagesTool.getBackground("02n"),equalTo("/images/bg_zachmurzenie_2.jpg"))),
                dynamicTest("Test 3d background", () -> assertThat(ImagesTool.getBackground("03d"),equalTo("/images/bg_zachmurzenie_1.jpg"))),
                dynamicTest("Test 3n background", () -> assertThat(ImagesTool.getBackground("03n"),equalTo("/images/bg_zachmurzenie_2.jpg"))),
                dynamicTest("Test 4d background", () -> assertThat(ImagesTool.getBackground("04d"),equalTo("/images/bg_zachmurzenie_1.jpg"))),
                dynamicTest("Test 4n background", () -> assertThat(ImagesTool.getBackground("04n"),equalTo("/images/bg_zachmurzenie_2.jpg"))),
                dynamicTest("Test 9d background", () -> assertThat(ImagesTool.getBackground("09d"),equalTo("/images/bg_deszcz_1.jpg"))),
                dynamicTest("Test 9n background", () -> assertThat(ImagesTool.getBackground("09n"),equalTo("/images/bg_deszcz_2.jpg"))),
                dynamicTest("Test 10d background", () -> assertThat(ImagesTool.getBackground("10d"),equalTo("/images/bg_deszcz_1.jpg"))),
                dynamicTest("Test 10n background", () -> assertThat(ImagesTool.getBackground("10n"),equalTo("/images/bg_deszcz_2.jpg"))),
                dynamicTest("Test 11d background", () -> assertThat(ImagesTool.getBackground("11d"),equalTo("/images/bg_burza_1.jpg"))),
                dynamicTest("Test 11n background", () -> assertThat(ImagesTool.getBackground("11n"),equalTo("/images/bg_burza_2.jpg"))),
                dynamicTest("Test 13d background", () -> assertThat(ImagesTool.getBackground("13d"),equalTo("/images/bg_snieg_1.jpg"))),
                dynamicTest("Test 13n background", () -> assertThat(ImagesTool.getBackground("13n"),equalTo("/images/bg_snieg_2.jpg"))),
                dynamicTest("Test 50d background", () -> assertThat(ImagesTool.getBackground("50d"),equalTo("/images/bg_mgla_1.jpg"))),
                dynamicTest("Test 50n background", () -> assertThat(ImagesTool.getBackground("50n"),equalTo("/images/bg_mgla_2.jpg"))),
                dynamicTest("Test default background", () -> assertThat(ImagesTool.getBackground("default"),equalTo("/images/bg_slonce_1.jpg")))
        );
    }

}