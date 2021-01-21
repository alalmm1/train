package poezd;

import java.util.Random;

public class Solution {
    public static void main(String[] args) {

        Train train = new Train(500);
        int count=0;
        boolean this_is_the_end = false;
        int pos_now=0;
        train.lightOn();
        do {
            train.stepsForward(1);
            pos_now++;
            if (!train.isLightOn()) {
                do {
                    train.stepsForward(1);
                    pos_now++;
                    count = pos_now;
                } while (!train.isLightOn());
            }
            train.lightOff();
            train.stepsBack(pos_now);
            if (!train.isLightOn()) this_is_the_end = true;
            count = pos_now;
            pos_now = 0;
        } while (!this_is_the_end);
        System.out.println(new StringBuilder().append("length of train is ").append(count).append(" carriages").toString());
    }
}
