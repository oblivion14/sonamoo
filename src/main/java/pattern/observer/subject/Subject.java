package pattern.observer.subject;

import pattern.observer.Observer;

/**
 * Created by melvin on 2016. 5. 25..
 */
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();
}
