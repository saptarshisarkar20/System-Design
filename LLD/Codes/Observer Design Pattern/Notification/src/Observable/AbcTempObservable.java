package Observable;

import Observer.TempObserversUnits;

import java.util.ArrayList;
import java.util.List;

public class AbcTempObservable implements TempObservable {
    List<TempObserversUnits> observerList = new ArrayList<>();
    int currentTemp;

    @Override
    public void add(TempObserversUnits to) {
        this.observerList.add(to);
    }

    @Override
    public void remove(TempObserversUnits to) {
        this.observerList.remove(to);
    }

    @Override
    public void updateAll() {
        for (TempObserversUnits tou : observerList) {
            tou.update();
        }
    }

    @Override
    public void updateTemp(int tempNow) {
        int temp = currentTemp;
        this.currentTemp = tempNow;
        if (Math.abs(this.currentTemp - temp) >= 10) {
            updateAll();
        }
    }


    @Override
    public int getTemp() {
        return this.currentTemp;
    }
}