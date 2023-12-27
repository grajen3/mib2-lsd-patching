/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.climate.service;

import de.vw.mib.asl.api.car.climate.ClimateTemperature;

final class ClimateTemperatureImpl
implements ClimateTemperature {
    private static final int CLIMATE_TEMP_LIMIT_BEFORE_LOW_FAHRENHEIT;
    private static final int CLIMATE_TEMP_LIMIT_BEFORE_LOW_CELSIUS;
    private static final int CLIMATE_TEMP_LIMIT_BEFORE_HI_FAHRENHEIT;
    private static final int CLIMATE_TEMP_LIMIT_BEFORE_HI_CELSIUS;
    private static final int CLIMATE_TEMP_STEP_SIZE_CELSIUS;
    private static final int CLIMATE_TEMP_STEP_SIZE_FAHRENHEIT;
    private static final int CLIMATE_TEMP_LOW;
    private static final int CLIMATE_TEMP_HIGH;
    private final int temperature;
    private final int unit;
    private final int zoneMember;

    public ClimateTemperatureImpl(int n, int n2, int n3) {
        this.temperature = n2;
        this.unit = n3;
        this.zoneMember = n;
    }

    @Override
    public int getTemperature() {
        return this.temperature;
    }

    @Override
    public int getUnit() {
        return this.unit;
    }

    @Override
    public int getZoneMember() {
        return this.zoneMember;
    }

    @Override
    public ClimateTemperature createTemperatureInUnit(int n) {
        return null;
    }

    @Override
    public ClimateTemperature increaseTemperature() {
        int n;
        switch (this.getUnit()) {
            case 1: {
                if (this.getTemperature() + 4 > 148) {
                    n = 255;
                    break;
                }
                if (this.getTemperature() + 4 < 40) {
                    n = 40;
                    break;
                }
                n = this.getTemperature() + 4;
                break;
            }
            case 0: {
                if (this.getTemperature() + 5 > 195) {
                    n = 255;
                    break;
                }
                if (this.getTemperature() + 5 < 60) {
                    n = 60;
                    break;
                }
                n = this.getTemperature() + 5;
                break;
            }
            default: {
                n = this.getTemperature();
            }
        }
        return new ClimateTemperatureImpl(this.getZoneMember(), n, this.getUnit());
    }

    @Override
    public ClimateTemperature decreaseTemperature() {
        int n;
        switch (this.getUnit()) {
            case 1: {
                if (this.getTemperature() - 4 < 40) {
                    n = 0;
                    break;
                }
                if (this.getTemperature() - 4 > 148) {
                    n = 148;
                    break;
                }
                n = this.getTemperature() - 4;
                break;
            }
            case 0: {
                if (this.getTemperature() - 5 < 60) {
                    n = 0;
                    break;
                }
                if (this.getTemperature() - 5 > 195) {
                    n = 195;
                    break;
                }
                n = this.getTemperature() - 5;
                break;
            }
            default: {
                n = this.getTemperature();
            }
        }
        return new ClimateTemperatureImpl(this.getZoneMember(), n, this.getUnit());
    }

    public int evlauteClimateBarTemperature(int n, int n2) {
        int n3;
        switch (n2) {
            case 1: {
                if (n > 148) {
                    n3 = 255;
                    break;
                }
                if (n < 40) {
                    n3 = 0;
                    break;
                }
                n3 = n;
                break;
            }
            case 0: {
                if (n > 195) {
                    n3 = 255;
                    break;
                }
                if (n < 60) {
                    n3 = 0;
                    break;
                }
                n3 = n;
                break;
            }
            default: {
                n3 = n;
            }
        }
        return n3;
    }
}

