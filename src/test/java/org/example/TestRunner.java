package org.example;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        plugin = "pretty",  //помогает интегрировать сторонние плагины и изменять формат отображения логов во время прогона тестов и в генерируемых репортах
        monochrome = true, //цвет логов в терминале
        tags = "@amazon", //фильтры запускаемых тестов по тегам
        glue = "org.example",  //пакет в котором находятся классы с реализацией шагов и хуков
        features = "src/test/resources/features"               //путь к файлу с фича файлами
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
