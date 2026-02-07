package Observable;

import Observer.TempObserversUnits;

public interface TempObservable {
    public void add(TempObserversUnits to);

    public void remove(TempObserversUnits to);

    public void updateAll();

    public void updateTemp(int currTemp);

    public int getTemp();
}