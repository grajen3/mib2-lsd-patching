/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.careco.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.careco.BCmECurrentRange;

public class BCmECurrentRangeSerializer {
    public static void putOptionalBCmECurrentRange(ISerializer iSerializer, BCmECurrentRange bCmECurrentRange) {
        boolean bl = bCmECurrentRange == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = bCmECurrentRange.getRangeGainValuePrimary();
            iSerializer.putInt32(n);
            int n2 = bCmECurrentRange.getRangeGainValueSecondary();
            iSerializer.putInt32(n2);
            int n3 = bCmECurrentRange.getRangeGainValueTotal();
            iSerializer.putInt32(n3);
            int n4 = bCmECurrentRange.getRangeValuePrimary();
            iSerializer.putInt32(n4);
            int n5 = bCmECurrentRange.getRangeValueSecondary();
            iSerializer.putInt32(n5);
            int n6 = bCmECurrentRange.getRangeValueTotal();
            iSerializer.putInt32(n6);
            int n7 = bCmECurrentRange.getRangeUnit();
            iSerializer.putInt32(n7);
        }
    }

    public static void putOptionalBCmECurrentRangeVarArray(ISerializer iSerializer, BCmECurrentRange[] bCmECurrentRangeArray) {
        boolean bl = bCmECurrentRangeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCmECurrentRangeArray.length);
            for (int i2 = 0; i2 < bCmECurrentRangeArray.length; ++i2) {
                BCmECurrentRangeSerializer.putOptionalBCmECurrentRange(iSerializer, bCmECurrentRangeArray[i2]);
            }
        }
    }

    public static BCmECurrentRange getOptionalBCmECurrentRange(IDeserializer iDeserializer) {
        BCmECurrentRange bCmECurrentRange = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            bCmECurrentRange = new BCmECurrentRange();
            bCmECurrentRange.rangeGainValuePrimary = n7 = iDeserializer.getInt32();
            bCmECurrentRange.rangeGainValueSecondary = n6 = iDeserializer.getInt32();
            bCmECurrentRange.rangeGainValueTotal = n5 = iDeserializer.getInt32();
            bCmECurrentRange.rangeValuePrimary = n4 = iDeserializer.getInt32();
            bCmECurrentRange.rangeValueSecondary = n3 = iDeserializer.getInt32();
            bCmECurrentRange.rangeValueTotal = n2 = iDeserializer.getInt32();
            bCmECurrentRange.rangeUnit = n = iDeserializer.getInt32();
        }
        return bCmECurrentRange;
    }

    public static BCmECurrentRange[] getOptionalBCmECurrentRangeVarArray(IDeserializer iDeserializer) {
        BCmECurrentRange[] bCmECurrentRangeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCmECurrentRangeArray = new BCmECurrentRange[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCmECurrentRangeArray[i2] = BCmECurrentRangeSerializer.getOptionalBCmECurrentRange(iDeserializer);
            }
        }
        return bCmECurrentRangeArray;
    }
}

