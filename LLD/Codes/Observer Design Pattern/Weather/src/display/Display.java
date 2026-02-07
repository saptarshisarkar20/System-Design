package display;

import weather.Weather;

public interface Display {
    void update(Weather weather);
    void display(Weather weather);
}