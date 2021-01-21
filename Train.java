package poezd;

import java.util.Random;
import java.util.ArrayList;

public class Train implements ITrain {

    private final ArrayList<Car> cars;
    private int position = 0;
    private static final Random r;

    static {
        r = new Random();
    }

    private static int len;

    public Train(int len) {
        cars = new ArrayList<>(len);
        this.len = len;
        addCars();
        randomizeLights();

    }

    private void randomizeLights() {
        for (Car car : cars) {
            car.setLight(r.nextInt(2) == 1);
        }
    }

    private void addCars() {
            for (int i = 0; i < len; i++) {
                cars.add(new Car());
            }
    }

    @Override
    public void stepsForward(int steps) {
        for (int i = 0; i < steps; i++) {
            position++;
            if(position==len) position = 0;
        }
    }

    @Override
    public void stepsBack(int steps) {
        for (int i = steps; i > 0; i--) {
            position--;
            if(position==-1) position = len-1;
        }
    }

    @Override
    public void lightOn() {
        cars.get(position).setLight(true);
    }

    @Override
    public void lightOff() {
        cars.get(position).setLight(false);
    }

    @Override
    public boolean isLightOn() {
        return cars.get(position).isLightOn();
    }
}