package Observer;

import Observable.TempObservable;

public class PhoneObserver implements TempObserversUnits {

    String phId;
    TempObservable tempObservable;

    public PhoneObserver(String phId, TempObservable tempObservable) {
        this.phId = phId;
        this.tempObservable = tempObservable;
    }

    @Override
    public void update() {
        getUpdate(this.tempObservable.getTemp());
    }

    public void getUpdate(int currTemp) {
        System.out.println("Smart Phone : " + phId + " Temp Changed to -> " + currTemp);
    }
}