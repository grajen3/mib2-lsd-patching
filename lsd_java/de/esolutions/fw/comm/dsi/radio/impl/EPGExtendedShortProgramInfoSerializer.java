/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio.impl;

import de.esolutions.fw.comm.dsi.radio.impl.EPGShortProgramInfoSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.radio.EPGExtendedShortProgramInfo;
import org.dsi.ifc.radio.EPGShortProgramInfo;

public class EPGExtendedShortProgramInfoSerializer {
    public static void putOptionalEPGExtendedShortProgramInfo(ISerializer iSerializer, EPGExtendedShortProgramInfo ePGExtendedShortProgramInfo) {
        boolean bl = ePGExtendedShortProgramInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            EPGShortProgramInfo[] ePGShortProgramInfoArray = ePGExtendedShortProgramInfo.getShortProgramInfoList();
            EPGShortProgramInfoSerializer.putOptionalEPGShortProgramInfoVarArray(iSerializer, ePGShortProgramInfoArray);
        }
    }

    public static void putOptionalEPGExtendedShortProgramInfoVarArray(ISerializer iSerializer, EPGExtendedShortProgramInfo[] ePGExtendedShortProgramInfoArray) {
        boolean bl = ePGExtendedShortProgramInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(ePGExtendedShortProgramInfoArray.length);
            for (int i2 = 0; i2 < ePGExtendedShortProgramInfoArray.length; ++i2) {
                EPGExtendedShortProgramInfoSerializer.putOptionalEPGExtendedShortProgramInfo(iSerializer, ePGExtendedShortProgramInfoArray[i2]);
            }
        }
    }

    public static EPGExtendedShortProgramInfo getOptionalEPGExtendedShortProgramInfo(IDeserializer iDeserializer) {
        EPGExtendedShortProgramInfo ePGExtendedShortProgramInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            ePGExtendedShortProgramInfo = new EPGExtendedShortProgramInfo();
            EPGShortProgramInfo[] ePGShortProgramInfoArray = EPGShortProgramInfoSerializer.getOptionalEPGShortProgramInfoVarArray(iDeserializer);
            ePGExtendedShortProgramInfo.shortProgramInfoList = ePGShortProgramInfoArray;
        }
        return ePGExtendedShortProgramInfo;
    }

    public static EPGExtendedShortProgramInfo[] getOptionalEPGExtendedShortProgramInfoVarArray(IDeserializer iDeserializer) {
        EPGExtendedShortProgramInfo[] ePGExtendedShortProgramInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            ePGExtendedShortProgramInfoArray = new EPGExtendedShortProgramInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                ePGExtendedShortProgramInfoArray[i2] = EPGExtendedShortProgramInfoSerializer.getOptionalEPGExtendedShortProgramInfo(iDeserializer);
            }
        }
        return ePGExtendedShortProgramInfoArray;
    }
}

