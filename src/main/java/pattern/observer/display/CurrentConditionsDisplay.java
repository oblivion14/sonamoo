package pattern.observer.display;

import pattern.observer.Observer;
import pattern.observer.subject.Subject;

/**
 * Created by melvin on 2016. 5. 25..
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement{

    private Subject weatherData;
    private float temperature;
    private float humidity;
    private float pressure;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;

        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;

        display();
    }

    @Override
    public void display() {
        System.out.println("온도 : " + temperature);
        System.out.println("습도 : " + humidity);
        System.out.println("기압 : " + pressure);
        System.out.println();

    }
}
