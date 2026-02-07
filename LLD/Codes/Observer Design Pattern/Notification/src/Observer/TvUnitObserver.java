package Observer;

import Observable.TempObservable;

public class TvUnitObserver implements TempObserversUnits {

    String tvId;
    TempObservable tempObservable;

    public TvUnitObserver(String tvId, TempObservable tempObservable) {
        this.tvId = tvId;
        this.tempObservable = tempObservable;
    }

    @Override
    public void update() {
        getUpdate(this.tempObservable.getTemp());
    }

    public void getUpdate(int currTemp) {
        System.out.println("TV UNIT : " + tvId + " Temp Changed to -> " + currTemp);
    }
}