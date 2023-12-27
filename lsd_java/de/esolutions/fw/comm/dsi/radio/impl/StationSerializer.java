/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio.impl;

import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.Station;

public class StationSerializer {
    public static void putOptionalStation(ISerializer iSerializer, Station station) {
        boolean bl = station == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = station.getName();
            iSerializer.putOptionalString(string);
            long l = station.getFrequency();
            iSerializer.putInt64(l);
            int n = station.getPi();
            iSerializer.putInt32(n);
            int n2 = station.getReceptionQuality();
            iSerializer.putInt32(n2);
            int n3 = station.getPtyCode();
            iSerializer.putInt32(n3);
            int n4 = station.getWaveband();
            iSerializer.putInt32(n4);
            boolean bl2 = station.isRds();
            iSerializer.putBool(bl2);
            boolean bl3 = station.isTp();
            iSerializer.putBool(bl3);
            boolean bl4 = station.isTa();
            iSerializer.putBool(bl4);
            boolean bl5 = station.isTmc();
            iSerializer.putBool(bl5);
            boolean bl6 = station.isScrollingPS();
            iSerializer.putBool(bl6);
            boolean bl7 = station.isRadioText();
            iSerializer.putBool(bl7);
            String string2 = station.getRealPS();
            iSerializer.putOptionalString(string2);
            boolean bl8 = station.isHd();
            iSerializer.putBool(bl8);
            String string3 = station.getShortNameHD();
            iSerializer.putOptionalString(string3);
            String string4 = station.getLongNameHD();
            iSerializer.putOptionalString(string4);
            boolean bl9 = station.isFullDigital();
            iSerializer.putBool(bl9);
            int n5 = station.getServiceId();
            iSerializer.putInt32(n5);
            int n6 = station.getSubscription();
            iSerializer.putInt32(n6);
            boolean bl10 = station.isEon();
            iSerializer.putBool(bl10);
            boolean bl11 = station.isCoChannel();
            iSerializer.putBool(bl11);
            ResourceLocator resourceLocator = station.getStationArt();
            ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator);
        }
    }

    public static void putOptionalStationVarArray(ISerializer iSerializer, Station[] stationArray) {
        boolean bl = stationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(stationArray.length);
            for (int i2 = 0; i2 < stationArray.length; ++i2) {
                StationSerializer.putOptionalStation(iSerializer, stationArray[i2]);
            }
        }
    }

    public static Station getOptionalStation(IDeserializer iDeserializer) {
        Station station = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            ResourceLocator resourceLocator;
            boolean bl2;
            boolean bl3;
            int n;
            int n2;
            boolean bl4;
            String string;
            String string2;
            boolean bl5;
            String string3;
            boolean bl6;
            boolean bl7;
            boolean bl8;
            boolean bl9;
            boolean bl10;
            boolean bl11;
            int n3;
            int n4;
            int n5;
            int n6;
            long l;
            String string4;
            station = new Station();
            station.name = string4 = iDeserializer.getOptionalString();
            station.frequency = l = iDeserializer.getInt64();
            station.pi = n6 = iDeserializer.getInt32();
            station.receptionQuality = n5 = iDeserializer.getInt32();
            station.ptyCode = n4 = iDeserializer.getInt32();
            station.waveband = n3 = iDeserializer.getInt32();
            station.rds = bl11 = iDeserializer.getBool();
            station.tp = bl10 = iDeserializer.getBool();
            station.ta = bl9 = iDeserializer.getBool();
            station.tmc = bl8 = iDeserializer.getBool();
            station.scrollingPS = bl7 = iDeserializer.getBool();
            station.radioText = bl6 = iDeserializer.getBool();
            station.realPS = string3 = iDeserializer.getOptionalString();
            station.hd = bl5 = iDeserializer.getBool();
            station.shortNameHD = string2 = iDeserializer.getOptionalString();
            station.longNameHD = string = iDeserializer.getOptionalString();
            station.fullDigital = bl4 = iDeserializer.getBool();
            station.serviceId = n2 = iDeserializer.getInt32();
            station.subscription = n = iDeserializer.getInt32();
            station.eon = bl3 = iDeserializer.getBool();
            station.coChannel = bl2 = iDeserializer.getBool();
            station.stationArt = resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
        }
        return station;
    }

    public static Station[] getOptionalStationVarArray(IDeserializer iDeserializer) {
        Station[] stationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            stationArray = new Station[n];
            for (int i2 = 0; i2 < n; ++i2) {
                stationArray[i2] = StationSerializer.getOptionalStation(iDeserializer);
            }
        }
        return stationArray;
    }
}

