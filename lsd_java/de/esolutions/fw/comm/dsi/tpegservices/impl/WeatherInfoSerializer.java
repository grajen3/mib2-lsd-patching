/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tpegservices.impl;

import de.esolutions.fw.comm.dsi.global.impl.DateTimeSerializer;
import de.esolutions.fw.comm.dsi.tpegservices.impl.WeatherDataSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.tpegservices.WeatherData;
import org.dsi.ifc.tpegservices.WeatherInfo;

public class WeatherInfoSerializer {
    public static void putOptionalWeatherInfo(ISerializer iSerializer, WeatherInfo weatherInfo) {
        boolean bl = weatherInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            DateTime dateTime = weatherInfo.getDateTime();
            DateTimeSerializer.putOptionalDateTime(iSerializer, dateTime);
            int n = weatherInfo.getWeatherInfoInterval();
            iSerializer.putInt32(n);
            WeatherData[] weatherDataArray = weatherInfo.getWeatherDataList();
            WeatherDataSerializer.putOptionalWeatherDataVarArray(iSerializer, weatherDataArray);
        }
    }

    public static void putOptionalWeatherInfoVarArray(ISerializer iSerializer, WeatherInfo[] weatherInfoArray) {
        boolean bl = weatherInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(weatherInfoArray.length);
            for (int i2 = 0; i2 < weatherInfoArray.length; ++i2) {
                WeatherInfoSerializer.putOptionalWeatherInfo(iSerializer, weatherInfoArray[i2]);
            }
        }
    }

    public static WeatherInfo getOptionalWeatherInfo(IDeserializer iDeserializer) {
        WeatherInfo weatherInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            DateTime dateTime;
            weatherInfo = new WeatherInfo();
            weatherInfo.dateTime = dateTime = DateTimeSerializer.getOptionalDateTime(iDeserializer);
            weatherInfo.weatherInfoInterval = n = iDeserializer.getInt32();
            WeatherData[] weatherDataArray = WeatherDataSerializer.getOptionalWeatherDataVarArray(iDeserializer);
            weatherInfo.weatherDataList = weatherDataArray;
        }
        return weatherInfo;
    }

    public static WeatherInfo[] getOptionalWeatherInfoVarArray(IDeserializer iDeserializer) {
        WeatherInfo[] weatherInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            weatherInfoArray = new WeatherInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                weatherInfoArray[i2] = WeatherInfoSerializer.getOptionalWeatherInfo(iDeserializer);
            }
        }
        return weatherInfoArray;
    }
}

