/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio.impl;

import de.esolutions.fw.comm.dsi.radio.impl.EPGFullProgramInfoSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.radio.EPGExtendedFullProgramInfo;
import org.dsi.ifc.radio.EPGFullProgramInfo;

public class EPGExtendedFullProgramInfoSerializer {
    public static void putOptionalEPGExtendedFullProgramInfo(ISerializer iSerializer, EPGExtendedFullProgramInfo ePGExtendedFullProgramInfo) {
        boolean bl = ePGExtendedFullProgramInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            EPGFullProgramInfo[] ePGFullProgramInfoArray = ePGExtendedFullProgramInfo.getFullProgramInfoList();
            EPGFullProgramInfoSerializer.putOptionalEPGFullProgramInfoVarArray(iSerializer, ePGFullProgramInfoArray);
        }
    }

    public static void putOptionalEPGExtendedFullProgramInfoVarArray(ISerializer iSerializer, EPGExtendedFullProgramInfo[] ePGExtendedFullProgramInfoArray) {
        boolean bl = ePGExtendedFullProgramInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(ePGExtendedFullProgramInfoArray.length);
            for (int i2 = 0; i2 < ePGExtendedFullProgramInfoArray.length; ++i2) {
                EPGExtendedFullProgramInfoSerializer.putOptionalEPGExtendedFullProgramInfo(iSerializer, ePGExtendedFullProgramInfoArray[i2]);
            }
        }
    }

    public static EPGExtendedFullProgramInfo getOptionalEPGExtendedFullProgramInfo(IDeserializer iDeserializer) {
        EPGExtendedFullProgramInfo ePGExtendedFullProgramInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            ePGExtendedFullProgramInfo = new EPGExtendedFullProgramInfo();
            EPGFullProgramInfo[] ePGFullProgramInfoArray = EPGFullProgramInfoSerializer.getOptionalEPGFullProgramInfoVarArray(iDeserializer);
            ePGExtendedFullProgramInfo.fullProgramInfoList = ePGFullProgramInfoArray;
        }
        return ePGExtendedFullProgramInfo;
    }

    public static EPGExtendedFullProgramInfo[] getOptionalEPGExtendedFullProgramInfoVarArray(IDeserializer iDeserializer) {
        EPGExtendedFullProgramInfo[] ePGExtendedFullProgramInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            ePGExtendedFullProgramInfoArray = new EPGExtendedFullProgramInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                ePGExtendedFullProgramInfoArray[i2] = EPGExtendedFullProgramInfoSerializer.getOptionalEPGExtendedFullProgramInfo(iDeserializer);
            }
        }
        return ePGExtendedFullProgramInfoArray;
    }
}

