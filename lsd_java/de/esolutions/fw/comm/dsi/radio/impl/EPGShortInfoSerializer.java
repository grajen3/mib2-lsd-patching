/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio.impl;

import de.esolutions.fw.comm.dsi.radio.impl.EPGExtendedShortProgramInfoSerializer;
import de.esolutions.fw.comm.dsi.radio.impl.EPGShortProgramInfoSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.radio.EPGExtendedShortProgramInfo;
import org.dsi.ifc.radio.EPGShortInfo;
import org.dsi.ifc.radio.EPGShortProgramInfo;

public class EPGShortInfoSerializer {
    public static void putOptionalEPGShortInfo(ISerializer iSerializer, EPGShortInfo ePGShortInfo) {
        boolean bl = ePGShortInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = ePGShortInfo.getEnsID();
            iSerializer.putInt32(n);
            int n2 = ePGShortInfo.getEnsECC();
            iSerializer.putInt32(n2);
            long l = ePGShortInfo.getSID();
            iSerializer.putInt64(l);
            int n3 = ePGShortInfo.getSCIDI();
            iSerializer.putInt32(n3);
            EPGShortProgramInfo ePGShortProgramInfo = ePGShortInfo.getNowProgramInfo();
            EPGShortProgramInfoSerializer.putOptionalEPGShortProgramInfo(iSerializer, ePGShortProgramInfo);
            EPGShortProgramInfo ePGShortProgramInfo2 = ePGShortInfo.getNextProgramInfo();
            EPGShortProgramInfoSerializer.putOptionalEPGShortProgramInfo(iSerializer, ePGShortProgramInfo2);
            EPGExtendedShortProgramInfo ePGExtendedShortProgramInfo = ePGShortInfo.getExtendedProgramInfo();
            EPGExtendedShortProgramInfoSerializer.putOptionalEPGExtendedShortProgramInfo(iSerializer, ePGExtendedShortProgramInfo);
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
            EPGExtendedShortProgramInfo ePGExtendedShortProgramInfo;
            EPGShortProgramInfo ePGShortProgramInfo;
            EPGShortProgramInfo ePGShortProgramInfo2;
            int n;
            long l;
            int n2;
            int n3;
            ePGShortInfo = new EPGShortInfo();
            ePGShortInfo.ensID = n3 = iDeserializer.getInt32();
            ePGShortInfo.ensECC = n2 = iDeserializer.getInt32();
            ePGShortInfo.sID = l = iDeserializer.getInt64();
            ePGShortInfo.sCIDI = n = iDeserializer.getInt32();
            ePGShortInfo.nowProgramInfo = ePGShortProgramInfo2 = EPGShortProgramInfoSerializer.getOptionalEPGShortProgramInfo(iDeserializer);
            ePGShortInfo.nextProgramInfo = ePGShortProgramInfo = EPGShortProgramInfoSerializer.getOptionalEPGShortProgramInfo(iDeserializer);
            ePGShortInfo.extendedProgramInfo = ePGExtendedShortProgramInfo = EPGExtendedShortProgramInfoSerializer.getOptionalEPGExtendedShortProgramInfo(iDeserializer);
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

