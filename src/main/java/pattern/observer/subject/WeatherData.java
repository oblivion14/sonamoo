package pattern.observer.subject;

import pattern.observer.Observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by melvin on 2016. 5. 25..
 */
public class WeatherData implements Subject{
    //
    private ArrayList<Observer> observerArrayList;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        this.observerArrayList = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        //
        observerArrayList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        //
        int observerSize = observerArrayList.size();
        if(observerSize >= 0){
            observerArrayList.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
        //
        for(Observer observer : observerArrayList){
            observer.update(temperature, humidity, pressure);
        }
    }

    public void notifyObservers(List<Observer> observerList){
        Iterator<Observer> iterator = observerList.iterator();
        Observer observer;

        while(iterator.hasNext()){
            observer = iterator.next();
            observer.update(temperature, humidity, pressure);
        }
    }

    public void setMeasurements(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;

        measurementsChanged();
    }

    private void measurementsChanged() {
        // 변경 사항을 수신받을 옵저버들을 선택
//        List<Observer> observerList = observerArrayList.subList(0,1);
//        notifyObservers(observerList);

        notifyObserver();

    }
}
