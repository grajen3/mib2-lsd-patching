/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.sdars.impl;

import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.sdars.StationInfo;

public class StationInfoSerializer {
    public static void putOptionalStationInfo(ISerializer iSerializer, StationInfo stationInfo) {
        boolean bl = stationInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            short s = stationInfo.getStationNumber();
            iSerializer.putInt16(s);
            int n = stationInfo.getSID();
            iSerializer.putInt32(n);
            String string = stationInfo.getShortLabel();
            iSerializer.putOptionalString(string);
            String string2 = stationInfo.getFullLabel();
            iSerializer.putOptionalString(string2);
            int n2 = stationInfo.getSubscription();
            iSerializer.putInt32(n2);
            short s2 = stationInfo.getCategoryNumber();
            iSerializer.putInt16(s2);
            boolean bl2 = stationInfo.isMature();
            iSerializer.putBool(bl2);
            ResourceLocator resourceLocator = stationInfo.getChannelArt();
            ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator);
        }
    }

    public static void putOptionalStationInfoVarArray(ISerializer iSerializer, StationInfo[] stationInfoArray) {
        boolean bl = stationInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(stationInfoArray.length);
            for (int i2 = 0; i2 < stationInfoArray.length; ++i2) {
                StationInfoSerializer.putOptionalStationInfo(iSerializer, stationInfoArray[i2]);
            }
        }
    }

    public static StationInfo getOptionalStationInfo(IDeserializer iDeserializer) {
        StationInfo stationInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            ResourceLocator resourceLocator;
            boolean bl2;
            short s;
            int n;
            String string;
            String string2;
            int n2;
            short s2;
            stationInfo = new StationInfo();
            stationInfo.stationNumber = s2 = iDeserializer.getInt16();
            stationInfo.sID = n2 = iDeserializer.getInt32();
            stationInfo.shortLabel = string2 = iDeserializer.getOptionalString();
            stationInfo.fullLabel = string = iDeserializer.getOptionalString();
            stationInfo.subscription = n = iDeserializer.getInt32();
            stationInfo.categoryNumber = s = iDeserializer.getInt16();
            stationInfo.mature = bl2 = iDeserializer.getBool();
            stationInfo.channelArt = resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
        }
        return stationInfo;
    }

    public static StationInfo[] getOptionalStationInfoVarArray(IDeserializer iDeserializer) {
        StationInfo[] stationInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            stationInfoArray = new StationInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                stationInfoArray[i2] = StationInfoSerializer.getOptionalStationInfo(iDeserializer);
            }
        }
        return stationInfoArray;
    }
}

