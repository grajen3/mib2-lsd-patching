/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.api.climate.modelclient;

import de.vw.mib.collections.ObjectArrayList;

public class TemperatureRange {
    public final int TEMPERATURE_CELSIUS_RANGE_STEPS;
    public final int TEMPERATURE_FAHRENHEIT_RANGE_STEPS;
    public final int TEMPERATURE_CELSIUS_FIRST_ELEMENT;
    public final int TEMPERATURE_CELSIUS_SECOND_ELEMENT;
    public final int TEMPERATURE_CELSIUS_ASL_MIN;
    public final int TEMPERATURE_CELSIUS_MODEL_MIN;
    public final int TEMPERATURE_CELSIUS_MAX;
    public final int TEMPERATURE_CELSIUS_STEP;
    public final int TEMPERATURE_FAHRENHEIT_MIN;
    public final int TEMPERATURE_FAHRENHEIT_MAX;
    public final int TEMPERATURE_FAHRENHEIT_STEP;
    public ObjectArrayList celsiusRange = new ObjectArrayList();
    public ObjectArrayList fahrenheitRange = new ObjectArrayList();

    public TemperatureRange() {
        this.TEMPERATURE_CELSIUS_RANGE_STEPS = 29;
        this.TEMPERATURE_FAHRENHEIT_RANGE_STEPS = 30;
        this.TEMPERATURE_CELSIUS_FIRST_ELEMENT = 155;
        this.TEMPERATURE_CELSIUS_SECOND_ELEMENT = 5;
        this.TEMPERATURE_CELSIUS_ASL_MIN = 160;
        this.TEMPERATURE_CELSIUS_MODEL_MIN = 155;
        this.TEMPERATURE_CELSIUS_MAX = 300;
        this.TEMPERATURE_CELSIUS_STEP = 5;
        this.TEMPERATURE_FAHRENHEIT_MIN = 590;
        this.TEMPERATURE_FAHRENHEIT_MAX = 880;
        this.TEMPERATURE_FAHRENHEIT_STEP = 10;
        this.celsiusRange.add(new Integer(155));
        this.celsiusRange.add(new Integer(5));
        this.fillCelsiusRange();
        this.fillFahrenheitRange();
    }

    private void fillCelsiusRange() {
        int n = 0;
        int n2 = 160;
        while (n < 29) {
            this.celsiusRange.add(new Integer(n2));
            ++n;
            n2 += 5;
        }
    }

    private void fillFahrenheitRange() {
        int n = 0;
        int n2 = 590;
        while (n < 30) {
            this.fahrenheitRange.add(new Integer(n2));
            ++n;
            n2 += 10;
        }
    }
}

