package pattern.observer;

import pattern.observer.display.CurrentConditionsDisplay;
import pattern.observer.subject.WeatherData;

/**
 * Created by melvin on 2016. 5. 25..
 */
public class ObserverMain {
    public static void main(String[] args) {

        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentDisplay =
                new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);

    }
}
