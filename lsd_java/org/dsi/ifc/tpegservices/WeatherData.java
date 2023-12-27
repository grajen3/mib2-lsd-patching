/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tpegservices;

public class WeatherData {
    public int weatherType;
    public int weatherInfoType;
    public int maxTemperature;
    public int minTemperature;
    public int averageTemperature;

    public WeatherData() {
        this.weatherType = 0;
        this.weatherInfoType = 0;
        this.maxTemperature = 0;
        this.minTemperature = 0;
        this.averageTemperature = 0;
    }

    public WeatherData(int n, int n2, int n3, int n4, int n5) {
        this.weatherType = n;
        this.weatherInfoType = n2;
        this.maxTemperature = n3;
        this.minTemperature = n4;
        this.averageTemperature = n5;
    }

    public int getWeatherType() {
        return this.weatherType;
    }

    public int getWeatherInfoType() {
        return this.weatherInfoType;
    }

    public int getMaxTemperature() {
        return this.maxTemperature;
    }

    public int getMinTemperature() {
        return this.minTemperature;
    }

    public int getAverageTemperature() {
        return this.averageTemperature;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("WeatherData");
        stringBuffer.append('(');
        stringBuffer.append("weatherType");
        stringBuffer.append('=');
        stringBuffer.append(this.weatherType);
        stringBuffer.append(',');
        stringBuffer.append("weatherInfoType");
        stringBuffer.append('=');
        stringBuffer.append(this.weatherInfoType);
        stringBuffer.append(',');
        stringBuffer.append("maxTemperature");
        stringBuffer.append('=');
        stringBuffer.append(this.maxTemperature);
        stringBuffer.append(',');
        stringBuffer.append("minTemperature");
        stringBuffer.append('=');
        stringBuffer.append(this.minTemperature);
        stringBuffer.append(',');
        stringBuffer.append("averageTemperature");
        stringBuffer.append('=');
        stringBuffer.append(this.averageTemperature);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

