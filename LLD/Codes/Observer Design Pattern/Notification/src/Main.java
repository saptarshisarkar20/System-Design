import Observable.AbcTempObservable;
import Observable.TempObservable;
import Observer.PhoneObserver;
import Observer.TempObserversUnits;
import Observer.TvUnitObserver;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TempObservable tempObservable = new AbcTempObservable();

        TempObserversUnits ph1 = new PhoneObserver("1", tempObservable);
        TempObserversUnits ph2 = new PhoneObserver("2", tempObservable);
        TempObserversUnits tv1 = new TvUnitObserver("3", tempObservable);
        TempObserversUnits tv2 = new TvUnitObserver("4", tempObservable);

        tempObservable.add(ph1);
        tempObservable.add(ph2);
        tempObservable.add(tv1);
        tempObservable.add(tv2);

        tempObservable.updateTemp(23);
        tempObservable.updateTemp(27);
        tempObservable.updateTemp(15);
        tempObservable.updateTemp(21);
        tempObservable.updateTemp(42);

    }
}