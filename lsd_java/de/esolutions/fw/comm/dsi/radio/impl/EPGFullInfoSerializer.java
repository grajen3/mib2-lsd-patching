/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio.impl;

import de.esolutions.fw.comm.dsi.radio.impl.EPGExtendedFullProgramInfoSerializer;
import de.esolutions.fw.comm.dsi.radio.impl.EPGFullProgramInfoSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.radio.EPGExtendedFullProgramInfo;
import org.dsi.ifc.radio.EPGFullInfo;
import org.dsi.ifc.radio.EPGFullProgramInfo;

public class EPGFullInfoSerializer {
    public static void putOptionalEPGFullInfo(ISerializer iSerializer, EPGFullInfo ePGFullInfo) {
        boolean bl = ePGFullInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = ePGFullInfo.getEnsID();
            iSerializer.putInt32(n);
            int n2 = ePGFullInfo.getEnsECC();
            iSerializer.putInt32(n2);
            long l = ePGFullInfo.getSID();
            iSerializer.putInt64(l);
            int n3 = ePGFullInfo.getSCIDI();
            iSerializer.putInt32(n3);
            EPGFullProgramInfo ePGFullProgramInfo = ePGFullInfo.getNowProgramInfo();
            EPGFullProgramInfoSerializer.putOptionalEPGFullProgramInfo(iSerializer, ePGFullProgramInfo);
            EPGFullProgramInfo ePGFullProgramInfo2 = ePGFullInfo.getNextProgramInfo();
            EPGFullProgramInfoSerializer.putOptionalEPGFullProgramInfo(iSerializer, ePGFullProgramInfo2);
            EPGExtendedFullProgramInfo ePGExtendedFullProgramInfo = ePGFullInfo.getExtendedProgramInfo();
            EPGExtendedFullProgramInfoSerializer.putOptionalEPGExtendedFullProgramInfo(iSerializer, ePGExtendedFullProgramInfo);
        }
    }

    public static void putOptionalEPGFullInfoVarArray(ISerializer iSerializer, EPGFullInfo[] ePGFullInfoArray) {
        boolean bl = ePGFullInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(ePGFullInfoArray.length);
            for (int i2 = 0; i2 < ePGFullInfoArray.length; ++i2) {
                EPGFullInfoSerializer.putOptionalEPGFullInfo(iSerializer, ePGFullInfoArray[i2]);
            }
        }
    }

    public static EPGFullInfo getOptionalEPGFullInfo(IDeserializer iDeserializer) {
        EPGFullInfo ePGFullInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            EPGExtendedFullProgramInfo ePGExtendedFullProgramInfo;
            EPGFullProgramInfo ePGFullProgramInfo;
            EPGFullProgramInfo ePGFullProgramInfo2;
            int n;
            long l;
            int n2;
            int n3;
            ePGFullInfo = new EPGFullInfo();
            ePGFullInfo.ensID = n3 = iDeserializer.getInt32();
            ePGFullInfo.ensECC = n2 = iDeserializer.getInt32();
            ePGFullInfo.sID = l = iDeserializer.getInt64();
            ePGFullInfo.sCIDI = n = iDeserializer.getInt32();
            ePGFullInfo.nowProgramInfo = ePGFullProgramInfo2 = EPGFullProgramInfoSerializer.getOptionalEPGFullProgramInfo(iDeserializer);
            ePGFullInfo.nextProgramInfo = ePGFullProgramInfo = EPGFullProgramInfoSerializer.getOptionalEPGFullProgramInfo(iDeserializer);
            ePGFullInfo.extendedProgramInfo = ePGExtendedFullProgramInfo = EPGExtendedFullProgramInfoSerializer.getOptionalEPGExtendedFullProgramInfo(iDeserializer);
        }
        return ePGFullInfo;
    }

    public static EPGFullInfo[] getOptionalEPGFullInfoVarArray(IDeserializer iDeserializer) {
        EPGFullInfo[] ePGFullInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            ePGFullInfoArray = new EPGFullInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                ePGFullInfoArray[i2] = EPGFullInfoSerializer.getOptionalEPGFullInfo(iDeserializer);
            }
        }
        return ePGFullInfoArray;
    }
}

