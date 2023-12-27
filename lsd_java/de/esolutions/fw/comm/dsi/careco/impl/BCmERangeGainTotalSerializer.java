/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.careco.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.careco.BCmERangeGainTotal;

public class BCmERangeGainTotalSerializer {
    public static void putOptionalBCmERangeGainTotal(ISerializer iSerializer, BCmERangeGainTotal bCmERangeGainTotal) {
        boolean bl = bCmERangeGainTotal == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = bCmERangeGainTotal.getRangeGainTotalValue();
            iSerializer.putInt32(n);
            int n2 = bCmERangeGainTotal.getRangeUnit();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalBCmERangeGainTotalVarArray(ISerializer iSerializer, BCmERangeGainTotal[] bCmERangeGainTotalArray) {
        boolean bl = bCmERangeGainTotalArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCmERangeGainTotalArray.length);
            for (int i2 = 0; i2 < bCmERangeGainTotalArray.length; ++i2) {
                BCmERangeGainTotalSerializer.putOptionalBCmERangeGainTotal(iSerializer, bCmERangeGainTotalArray[i2]);
            }
        }
    }

    public static BCmERangeGainTotal getOptionalBCmERangeGainTotal(IDeserializer iDeserializer) {
        BCmERangeGainTotal bCmERangeGainTotal = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            bCmERangeGainTotal = new BCmERangeGainTotal();
            bCmERangeGainTotal.rangeGainTotalValue = n2 = iDeserializer.getInt32();
            bCmERangeGainTotal.rangeUnit = n = iDeserializer.getInt32();
        }
        return bCmERangeGainTotal;
    }

    public static BCmERangeGainTotal[] getOptionalBCmERangeGainTotalVarArray(IDeserializer iDeserializer) {
        BCmERangeGainTotal[] bCmERangeGainTotalArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCmERangeGainTotalArray = new BCmERangeGainTotal[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCmERangeGainTotalArray[i2] = BCmERangeGainTotalSerializer.getOptionalBCmERangeGainTotal(iDeserializer);
            }
        }
        return bCmERangeGainTotalArray;
    }
}

