/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tpegservices.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.tpegservices.WeatherData;

public class WeatherDataSerializer {
    public static void putOptionalWeatherData(ISerializer iSerializer, WeatherData weatherData) {
        boolean bl = weatherData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = weatherData.getWeatherType();
            iSerializer.putInt32(n);
            int n2 = weatherData.getWeatherInfoType();
            iSerializer.putInt32(n2);
            int n3 = weatherData.getMaxTemperature();
            iSerializer.putInt32(n3);
            int n4 = weatherData.getMinTemperature();
            iSerializer.putInt32(n4);
            int n5 = weatherData.getAverageTemperature();
            iSerializer.putInt32(n5);
        }
    }

    public static void putOptionalWeatherDataVarArray(ISerializer iSerializer, WeatherData[] weatherDataArray) {
        boolean bl = weatherDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(weatherDataArray.length);
            for (int i2 = 0; i2 < weatherDataArray.length; ++i2) {
                WeatherDataSerializer.putOptionalWeatherData(iSerializer, weatherDataArray[i2]);
            }
        }
    }

    public static WeatherData getOptionalWeatherData(IDeserializer iDeserializer) {
        WeatherData weatherData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            weatherData = new WeatherData();
            weatherData.weatherType = n5 = iDeserializer.getInt32();
            weatherData.weatherInfoType = n4 = iDeserializer.getInt32();
            weatherData.maxTemperature = n3 = iDeserializer.getInt32();
            weatherData.minTemperature = n2 = iDeserializer.getInt32();
            weatherData.averageTemperature = n = iDeserializer.getInt32();
        }
        return weatherData;
    }

    public static WeatherData[] getOptionalWeatherDataVarArray(IDeserializer iDeserializer) {
        WeatherData[] weatherDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            weatherDataArray = new WeatherData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                weatherDataArray[i2] = WeatherDataSerializer.getOptionalWeatherData(iDeserializer);
            }
        }
        return weatherDataArray;
    }
}

