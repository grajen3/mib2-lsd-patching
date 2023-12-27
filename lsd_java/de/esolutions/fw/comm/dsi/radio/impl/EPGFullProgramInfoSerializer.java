/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio.impl;

import de.esolutions.fw.comm.dsi.radio.impl.EPGShortProgramInfoSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.radio.EPGFullProgramInfo;
import org.dsi.ifc.radio.EPGShortProgramInfo;

public class EPGFullProgramInfoSerializer {
    public static void putOptionalEPGFullProgramInfo(ISerializer iSerializer, EPGFullProgramInfo ePGFullProgramInfo) {
        boolean bl = ePGFullProgramInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            EPGShortProgramInfo ePGShortProgramInfo = ePGFullProgramInfo.getShortInfo();
            EPGShortProgramInfoSerializer.putOptionalEPGShortProgramInfo(iSerializer, ePGShortProgramInfo);
            int n = ePGFullProgramInfo.getContentGroup();
            iSerializer.putInt32(n);
            String string = ePGFullProgramInfo.getDetailProgramInfo();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalEPGFullProgramInfoVarArray(ISerializer iSerializer, EPGFullProgramInfo[] ePGFullProgramInfoArray) {
        boolean bl = ePGFullProgramInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(ePGFullProgramInfoArray.length);
            for (int i2 = 0; i2 < ePGFullProgramInfoArray.length; ++i2) {
                EPGFullProgramInfoSerializer.putOptionalEPGFullProgramInfo(iSerializer, ePGFullProgramInfoArray[i2]);
            }
        }
    }

    public static EPGFullProgramInfo getOptionalEPGFullProgramInfo(IDeserializer iDeserializer) {
        EPGFullProgramInfo ePGFullProgramInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            int n;
            EPGShortProgramInfo ePGShortProgramInfo;
            ePGFullProgramInfo = new EPGFullProgramInfo();
            ePGFullProgramInfo.shortInfo = ePGShortProgramInfo = EPGShortProgramInfoSerializer.getOptionalEPGShortProgramInfo(iDeserializer);
            ePGFullProgramInfo.contentGroup = n = iDeserializer.getInt32();
            ePGFullProgramInfo.detailProgramInfo = string = iDeserializer.getOptionalString();
        }
        return ePGFullProgramInfo;
    }

    public static EPGFullProgramInfo[] getOptionalEPGFullProgramInfoVarArray(IDeserializer iDeserializer) {
        EPGFullProgramInfo[] ePGFullProgramInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            ePGFullProgramInfoArray = new EPGFullProgramInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                ePGFullProgramInfoArray[i2] = EPGFullProgramInfoSerializer.getOptionalEPGFullProgramInfo(iDeserializer);
            }
        }
        return ePGFullProgramInfoArray;
    }
}

