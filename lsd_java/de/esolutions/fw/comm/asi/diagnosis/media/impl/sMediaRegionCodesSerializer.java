/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.media.impl;

import de.esolutions.fw.comm.asi.diagnosis.media.sMediaRegionCodes;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sMediaRegionCodesSerializer {
    public static void putOptionalsMediaRegionCodes(ISerializer iSerializer, sMediaRegionCodes sMediaRegionCodes2) {
        boolean bl = sMediaRegionCodes2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sMediaRegionCodes2.getMsg_id();
            iSerializer.putUInt32(l);
            short s = sMediaRegionCodes2.getNumberSlots();
            iSerializer.putUInt8(s);
            boolean[] blArray = sMediaRegionCodes2.getSlotActive();
            iSerializer.putOptionalBoolVarArray(blArray);
            short[] sArray = sMediaRegionCodes2.getRegionCodeType();
            iSerializer.putOptionalUInt8VarArray(sArray);
            short[] sArray2 = sMediaRegionCodes2.getRegionCode();
            iSerializer.putOptionalUInt8VarArray(sArray2);
        }
    }

    public static void putOptionalsMediaRegionCodesVarArray(ISerializer iSerializer, sMediaRegionCodes[] sMediaRegionCodesArray) {
        boolean bl = sMediaRegionCodesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sMediaRegionCodesArray.length);
            for (int i2 = 0; i2 < sMediaRegionCodesArray.length; ++i2) {
                sMediaRegionCodesSerializer.putOptionalsMediaRegionCodes(iSerializer, sMediaRegionCodesArray[i2]);
            }
        }
    }

    public static sMediaRegionCodes getOptionalsMediaRegionCodes(IDeserializer iDeserializer) {
        sMediaRegionCodes sMediaRegionCodes2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            short s;
            long l;
            sMediaRegionCodes2 = new sMediaRegionCodes();
            sMediaRegionCodes2.msg_id = l = iDeserializer.getUInt32();
            sMediaRegionCodes2.numberSlots = s = iDeserializer.getUInt8();
            boolean[] blArray = iDeserializer.getOptionalBoolVarArray();
            sMediaRegionCodes2.slotActive = blArray;
            short[] sArray = iDeserializer.getOptionalUInt8VarArray();
            sMediaRegionCodes2.regionCodeType = sArray;
            short[] sArray2 = iDeserializer.getOptionalUInt8VarArray();
            sMediaRegionCodes2.regionCode = sArray2;
        }
        return sMediaRegionCodes2;
    }

    public static sMediaRegionCodes[] getOptionalsMediaRegionCodesVarArray(IDeserializer iDeserializer) {
        sMediaRegionCodes[] sMediaRegionCodesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sMediaRegionCodesArray = new sMediaRegionCodes[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sMediaRegionCodesArray[i2] = sMediaRegionCodesSerializer.getOptionalsMediaRegionCodes(iDeserializer);
            }
        }
        return sMediaRegionCodesArray;
    }
}

