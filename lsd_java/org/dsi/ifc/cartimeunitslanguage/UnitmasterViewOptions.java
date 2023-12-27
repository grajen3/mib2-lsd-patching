/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cartimeunitslanguage;

import org.dsi.ifc.cartimeunitslanguage.UnitmasterConfiguration;
import org.dsi.ifc.global.CarViewOption;

public class UnitmasterViewOptions {
    public CarViewOption dateFormat;
    public CarViewOption clockFormat;
    public CarViewOption language;
    public CarViewOption temperatureUnit;
    public CarViewOption distanceUnit;
    public CarViewOption speedUnit;
    public CarViewOption pressureUnit;
    public CarViewOption volumeUnit;
    public CarViewOption consumptionPetrolUnit;
    public CarViewOption consumptionGasUnit;
    public CarViewOption umSetFactoryDefault;
    public CarViewOption consumptionElectricUnit;
    public CarViewOption skin;
    public CarViewOption weightUnit;
    public UnitmasterConfiguration umConfiguration;

    public UnitmasterViewOptions() {
        this.dateFormat = null;
        this.clockFormat = null;
        this.language = null;
        this.temperatureUnit = null;
        this.distanceUnit = null;
        this.speedUnit = null;
        this.pressureUnit = null;
        this.volumeUnit = null;
        this.consumptionPetrolUnit = null;
        this.consumptionGasUnit = null;
        this.umSetFactoryDefault = null;
        this.consumptionElectricUnit = null;
        this.skin = null;
        this.weightUnit = null;
        this.umConfiguration = null;
    }

    public UnitmasterViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5, CarViewOption carViewOption6, CarViewOption carViewOption7, CarViewOption carViewOption8, CarViewOption carViewOption9, CarViewOption carViewOption10, CarViewOption carViewOption11, CarViewOption carViewOption12, CarViewOption carViewOption13, UnitmasterConfiguration unitmasterConfiguration) {
        this.dateFormat = carViewOption;
        this.clockFormat = carViewOption2;
        this.language = carViewOption3;
        this.temperatureUnit = carViewOption4;
        this.distanceUnit = carViewOption5;
        this.speedUnit = carViewOption6;
        this.pressureUnit = carViewOption7;
        this.volumeUnit = carViewOption8;
        this.consumptionPetrolUnit = carViewOption9;
        this.consumptionGasUnit = carViewOption10;
        this.umSetFactoryDefault = carViewOption11;
        this.consumptionElectricUnit = carViewOption12;
        this.skin = carViewOption13;
        this.weightUnit = null;
        this.umConfiguration = unitmasterConfiguration;
    }

    public UnitmasterViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5, CarViewOption carViewOption6, CarViewOption carViewOption7, CarViewOption carViewOption8, CarViewOption carViewOption9, CarViewOption carViewOption10, CarViewOption carViewOption11, CarViewOption carViewOption12, CarViewOption carViewOption13, CarViewOption carViewOption14, UnitmasterConfiguration unitmasterConfiguration) {
        this.dateFormat = carViewOption;
        this.clockFormat = carViewOption2;
        this.language = carViewOption3;
        this.temperatureUnit = carViewOption4;
        this.distanceUnit = carViewOption5;
        this.speedUnit = carViewOption6;
        this.pressureUnit = carViewOption7;
        this.volumeUnit = carViewOption8;
        this.consumptionPetrolUnit = carViewOption9;
        this.consumptionGasUnit = carViewOption10;
        this.umSetFactoryDefault = carViewOption11;
        this.consumptionElectricUnit = carViewOption12;
        this.skin = carViewOption13;
        this.weightUnit = carViewOption14;
        this.umConfiguration = unitmasterConfiguration;
    }

    public CarViewOption getDateFormat() {
        return this.dateFormat;
    }

    public CarViewOption getClockFormat() {
        return this.clockFormat;
    }

    public CarViewOption getLanguage() {
        return this.language;
    }

    public CarViewOption getTemperatureUnit() {
        return this.temperatureUnit;
    }

    public CarViewOption getDistanceUnit() {
        return this.distanceUnit;
    }

    public CarViewOption getSpeedUnit() {
        return this.speedUnit;
    }

    public CarViewOption getPressureUnit() {
        return this.pressureUnit;
    }

    public CarViewOption getVolumeUnit() {
        return this.volumeUnit;
    }

    public CarViewOption getConsumptionPetrolUnit() {
        return this.consumptionPetrolUnit;
    }

    public CarViewOption getConsumptionGasUnit() {
        return this.consumptionGasUnit;
    }

    public CarViewOption getConsumptionElectricUnit() {
        return this.consumptionElectricUnit;
    }

    public CarViewOption getSkin() {
        return this.skin;
    }

    public CarViewOption getWeightUnit() {
        return this.weightUnit;
    }

    public CarViewOption getUmSetFactoryDefault() {
        return this.umSetFactoryDefault;
    }

    public UnitmasterConfiguration getUmConfiguration() {
        return this.umConfiguration;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(15550);
        stringBuffer.append("UnitmasterViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("dateFormat");
        stringBuffer.append('=');
        stringBuffer.append(this.dateFormat);
        stringBuffer.append(',');
        stringBuffer.append("clockFormat");
        stringBuffer.append('=');
        stringBuffer.append(this.clockFormat);
        stringBuffer.append(',');
        stringBuffer.append("language");
        stringBuffer.append('=');
        stringBuffer.append(this.language);
        stringBuffer.append(',');
        stringBuffer.append("temperatureUnit");
        stringBuffer.append('=');
        stringBuffer.append(this.temperatureUnit);
        stringBuffer.append(',');
        stringBuffer.append("distanceUnit");
        stringBuffer.append('=');
        stringBuffer.append(this.distanceUnit);
        stringBuffer.append(',');
        stringBuffer.append("speedUnit");
        stringBuffer.append('=');
        stringBuffer.append(this.speedUnit);
        stringBuffer.append(',');
        stringBuffer.append("pressureUnit");
        stringBuffer.append('=');
        stringBuffer.append(this.pressureUnit);
        stringBuffer.append(',');
        stringBuffer.append("volumeUnit");
        stringBuffer.append('=');
        stringBuffer.append(this.volumeUnit);
        stringBuffer.append(',');
        stringBuffer.append("consumptionPetrolUnit");
        stringBuffer.append('=');
        stringBuffer.append(this.consumptionPetrolUnit);
        stringBuffer.append(',');
        stringBuffer.append("consumptionGasUnit");
        stringBuffer.append('=');
        stringBuffer.append(this.consumptionGasUnit);
        stringBuffer.append(',');
        stringBuffer.append("umSetFactoryDefault");
        stringBuffer.append('=');
        stringBuffer.append(this.umSetFactoryDefault);
        stringBuffer.append(',');
        stringBuffer.append("consumptionElectricUnit");
        stringBuffer.append('=');
        stringBuffer.append(this.consumptionElectricUnit);
        stringBuffer.append(',');
        stringBuffer.append("skin");
        stringBuffer.append('=');
        stringBuffer.append(this.skin);
        stringBuffer.append(',');
        stringBuffer.append("weightUnit");
        stringBuffer.append('=');
        stringBuffer.append(this.weightUnit);
        stringBuffer.append(',');
        stringBuffer.append("umConfiguration");
        stringBuffer.append('=');
        stringBuffer.append(this.umConfiguration);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

