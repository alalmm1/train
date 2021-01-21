package poezd;

public interface ITrain {
    void stepsForward(int steps);
    void stepsBack(int steps);
    void lightOn();
    void lightOff();
    boolean isLightOn();
}
