/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.sdars.impl;

import de.esolutions.fw.comm.dsi.sdars.impl.EPGProgramInfoSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.sdars.EPGProgramInfo;
import org.dsi.ifc.sdars.EPGShortInfo;

public class EPGShortInfoSerializer {
    public static void putOptionalEPGShortInfo(ISerializer iSerializer, EPGShortInfo ePGShortInfo) {
        boolean bl = ePGShortInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = ePGShortInfo.getSID();
            iSerializer.putInt32(n);
            EPGProgramInfo[] ePGProgramInfoArray = ePGShortInfo.getEpgProgramInfo();
            EPGProgramInfoSerializer.putOptionalEPGProgramInfoVarArray(iSerializer, ePGProgramInfoArray);
        }
    }

    public static void putOptionalEPGShortInfoVarArray(ISerializer iSerializer, EPGShortInfo[] ePGShortInfoArray) {
        boolean bl = ePGShortInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(ePGShortInfoArray.length);
            for (int i2 = 0; i2 < ePGShortInfoArray.length; ++i2) {
                EPGShortInfoSerializer.putOptionalEPGShortInfo(iSerializer, ePGShortInfoArray[i2]);
            }
        }
    }

    public static EPGShortInfo getOptionalEPGShortInfo(IDeserializer iDeserializer) {
        EPGShortInfo ePGShortInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            ePGShortInfo = new EPGShortInfo();
            ePGShortInfo.sID = n = iDeserializer.getInt32();
            EPGProgramInfo[] ePGProgramInfoArray = EPGProgramInfoSerializer.getOptionalEPGProgramInfoVarArray(iDeserializer);
            ePGShortInfo.epgProgramInfo = ePGProgramInfoArray;
        }
        return ePGShortInfo;
    }

    public static EPGShortInfo[] getOptionalEPGShortInfoVarArray(IDeserializer iDeserializer) {
        EPGShortInfo[] ePGShortInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            ePGShortInfoArray = new EPGShortInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                ePGShortInfoArray[i2] = EPGShortInfoSerializer.getOptionalEPGShortInfo(iDeserializer);
            }
        }
        return ePGShortInfoArray;
    }
}

