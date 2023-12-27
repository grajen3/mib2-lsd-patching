/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio.impl;

import de.esolutions.fw.comm.dsi.global.impl.DateTimeSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.radio.EPGShortProgramInfo;

public class EPGShortProgramInfoSerializer {
    public static void putOptionalEPGShortProgramInfo(ISerializer iSerializer, EPGShortProgramInfo ePGShortProgramInfo) {
        boolean bl = ePGShortProgramInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = ePGShortProgramInfo.getProgramInfo();
            iSerializer.putOptionalString(string);
            DateTime dateTime = ePGShortProgramInfo.getStartTime();
            DateTimeSerializer.putOptionalDateTime(iSerializer, dateTime);
            DateTime dateTime2 = ePGShortProgramInfo.getEndTime();
            DateTimeSerializer.putOptionalDateTime(iSerializer, dateTime2);
        }
    }

    public static void putOptionalEPGShortProgramInfoVarArray(ISerializer iSerializer, EPGShortProgramInfo[] ePGShortProgramInfoArray) {
        boolean bl = ePGShortProgramInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(ePGShortProgramInfoArray.length);
            for (int i2 = 0; i2 < ePGShortProgramInfoArray.length; ++i2) {
                EPGShortProgramInfoSerializer.putOptionalEPGShortProgramInfo(iSerializer, ePGShortProgramInfoArray[i2]);
            }
        }
    }

    public static EPGShortProgramInfo getOptionalEPGShortProgramInfo(IDeserializer iDeserializer) {
        EPGShortProgramInfo ePGShortProgramInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            DateTime dateTime;
            DateTime dateTime2;
            String string;
            ePGShortProgramInfo = new EPGShortProgramInfo();
            ePGShortProgramInfo.programInfo = string = iDeserializer.getOptionalString();
            ePGShortProgramInfo.startTime = dateTime2 = DateTimeSerializer.getOptionalDateTime(iDeserializer);
            ePGShortProgramInfo.endTime = dateTime = DateTimeSerializer.getOptionalDateTime(iDeserializer);
        }
        return ePGShortProgramInfo;
    }

    public static EPGShortProgramInfo[] getOptionalEPGShortProgramInfoVarArray(IDeserializer iDeserializer) {
        EPGShortProgramInfo[] ePGShortProgramInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            ePGShortProgramInfoArray = new EPGShortProgramInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                ePGShortProgramInfoArray[i2] = EPGShortProgramInfoSerializer.getOptionalEPGShortProgramInfo(iDeserializer);
            }
        }
        return ePGShortProgramInfoArray;
    }
}

