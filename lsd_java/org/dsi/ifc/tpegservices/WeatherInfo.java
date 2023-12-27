/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tpegservices;

import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.tpegservices.WeatherData;

public class WeatherInfo {
    public DateTime dateTime;
    public int weatherInfoInterval;
    public WeatherData[] weatherDataList;

    public WeatherInfo() {
        this.dateTime = null;
        this.weatherInfoInterval = 0;
        this.weatherDataList = null;
    }

    public WeatherInfo(DateTime dateTime, int n, WeatherData[] weatherDataArray) {
        this.dateTime = dateTime;
        this.weatherInfoInterval = n;
        this.weatherDataList = weatherDataArray;
    }

    public DateTime getDateTime() {
        return this.dateTime;
    }

    public int getWeatherInfoInterval() {
        return this.weatherInfoInterval;
    }

    public WeatherData[] getWeatherDataList() {
        return this.weatherDataList;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1200);
        stringBuffer.append("WeatherInfo");
        stringBuffer.append('(');
        stringBuffer.append("dateTime");
        stringBuffer.append('=');
        stringBuffer.append(this.dateTime);
        stringBuffer.append(',');
        stringBuffer.append("weatherInfoInterval");
        stringBuffer.append('=');
        stringBuffer.append(this.weatherInfoInterval);
        stringBuffer.append(',');
        stringBuffer.append("weatherDataList");
        stringBuffer.append('[');
        if (this.weatherDataList != null) {
            stringBuffer.append(this.weatherDataList.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.weatherDataList != null) {
            int n = this.weatherDataList.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.weatherDataList[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.weatherDataList);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

