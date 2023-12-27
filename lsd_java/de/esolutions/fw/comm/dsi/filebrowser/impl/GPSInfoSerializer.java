/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.filebrowser.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.filebrowser.GPSInfo;

public class GPSInfoSerializer {
    public static void putOptionalGPSInfo(ISerializer iSerializer, GPSInfo gPSInfo) {
        boolean bl = gPSInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            float f2 = gPSInfo.getLatitudeDecimalDegrees();
            iSerializer.putFloat(f2);
            float f3 = gPSInfo.getLongitudeDecimalDegrees();
            iSerializer.putFloat(f3);
            float f4 = gPSInfo.getAltitudeMetersAboveSeaLevel();
            iSerializer.putFloat(f4);
        }
    }

    public static void putOptionalGPSInfoVarArray(ISerializer iSerializer, GPSInfo[] gPSInfoArray) {
        boolean bl = gPSInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(gPSInfoArray.length);
            for (int i2 = 0; i2 < gPSInfoArray.length; ++i2) {
                GPSInfoSerializer.putOptionalGPSInfo(iSerializer, gPSInfoArray[i2]);
            }
        }
    }

    public static GPSInfo getOptionalGPSInfo(IDeserializer iDeserializer) {
        GPSInfo gPSInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            float f2;
            float f3;
            float f4;
            gPSInfo = new GPSInfo();
            gPSInfo.latitudeDecimalDegrees = f4 = iDeserializer.getFloat();
            gPSInfo.longitudeDecimalDegrees = f3 = iDeserializer.getFloat();
            gPSInfo.altitudeMetersAboveSeaLevel = f2 = iDeserializer.getFloat();
        }
        return gPSInfo;
    }

    public static GPSInfo[] getOptionalGPSInfoVarArray(IDeserializer iDeserializer) {
        GPSInfo[] gPSInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            gPSInfoArray = new GPSInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                gPSInfoArray[i2] = GPSInfoSerializer.getOptionalGPSInfo(iDeserializer);
            }
        }
        return gPSInfoArray;
    }
}

