/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaprogramada2.datos1.register;

import java.util.Random;

/**
 *
 *
 */
public class DurationProvider {

    private int min;
    private int max;

    public DurationProvider() {
    }

    public DurationProvider(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getDuration() {
        return min + new Random().nextInt(max - min);
    }

}
