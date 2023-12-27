/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.sdars.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.sdars.EPGProgramInfo;

public class EPGProgramInfoSerializer {
    public static void putOptionalEPGProgramInfo(ISerializer iSerializer, EPGProgramInfo ePGProgramInfo) {
        boolean bl = ePGProgramInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = ePGProgramInfo.getProgramID();
            iSerializer.putInt32(n);
            int n2 = ePGProgramInfo.getSeriesID();
            iSerializer.putInt32(n2);
            int n3 = ePGProgramInfo.getStartTime();
            iSerializer.putInt32(n3);
            int n4 = ePGProgramInfo.getEndTime();
            iSerializer.putInt32(n4);
            String string = ePGProgramInfo.getShortProgramName();
            iSerializer.putOptionalString(string);
            String string2 = ePGProgramInfo.getLongProgramName();
            iSerializer.putOptionalString(string2);
            int n5 = ePGProgramInfo.getEpgFlag();
            iSerializer.putInt32(n5);
        }
    }

    public static void putOptionalEPGProgramInfoVarArray(ISerializer iSerializer, EPGProgramInfo[] ePGProgramInfoArray) {
        boolean bl = ePGProgramInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(ePGProgramInfoArray.length);
            for (int i2 = 0; i2 < ePGProgramInfoArray.length; ++i2) {
                EPGProgramInfoSerializer.putOptionalEPGProgramInfo(iSerializer, ePGProgramInfoArray[i2]);
            }
        }
    }

    public static EPGProgramInfo getOptionalEPGProgramInfo(IDeserializer iDeserializer) {
        EPGProgramInfo ePGProgramInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            String string;
            String string2;
            int n2;
            int n3;
            int n4;
            int n5;
            ePGProgramInfo = new EPGProgramInfo();
            ePGProgramInfo.programID = n5 = iDeserializer.getInt32();
            ePGProgramInfo.seriesID = n4 = iDeserializer.getInt32();
            ePGProgramInfo.startTime = n3 = iDeserializer.getInt32();
            ePGProgramInfo.endTime = n2 = iDeserializer.getInt32();
            ePGProgramInfo.shortProgramName = string2 = iDeserializer.getOptionalString();
            ePGProgramInfo.longProgramName = string = iDeserializer.getOptionalString();
            ePGProgramInfo.epgFlag = n = iDeserializer.getInt32();
        }
        return ePGProgramInfo;
    }

    public static EPGProgramInfo[] getOptionalEPGProgramInfoVarArray(IDeserializer iDeserializer) {
        EPGProgramInfo[] ePGProgramInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            ePGProgramInfoArray = new EPGProgramInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                ePGProgramInfoArray[i2] = EPGProgramInfoSerializer.getOptionalEPGProgramInfo(iDeserializer);
            }
        }
        return ePGProgramInfoArray;
    }
}

