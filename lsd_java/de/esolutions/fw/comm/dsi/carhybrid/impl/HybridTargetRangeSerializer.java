/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.HybridTargetRange;

public class HybridTargetRangeSerializer {
    public static void putOptionalHybridTargetRange(ISerializer iSerializer, HybridTargetRange hybridTargetRange) {
        boolean bl = hybridTargetRange == null;
        iSerializer.putBool(bl);
        if (!bl) {
            short s = hybridTargetRange.getMaxRange();
            iSerializer.putInt16(s);
            short s2 = hybridTargetRange.getRange();
            iSerializer.putInt16(s2);
            int n = hybridTargetRange.getRangeUnit();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalHybridTargetRangeVarArray(ISerializer iSerializer, HybridTargetRange[] hybridTargetRangeArray) {
        boolean bl = hybridTargetRangeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(hybridTargetRangeArray.length);
            for (int i2 = 0; i2 < hybridTargetRangeArray.length; ++i2) {
                HybridTargetRangeSerializer.putOptionalHybridTargetRange(iSerializer, hybridTargetRangeArray[i2]);
            }
        }
    }

    public static HybridTargetRange getOptionalHybridTargetRange(IDeserializer iDeserializer) {
        HybridTargetRange hybridTargetRange = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            short s;
            short s2;
            hybridTargetRange = new HybridTargetRange();
            hybridTargetRange.maxRange = s2 = iDeserializer.getInt16();
            hybridTargetRange.range = s = iDeserializer.getInt16();
            hybridTargetRange.rangeUnit = n = iDeserializer.getInt32();
        }
        return hybridTargetRange;
    }

    public static HybridTargetRange[] getOptionalHybridTargetRangeVarArray(IDeserializer iDeserializer) {
        HybridTargetRange[] hybridTargetRangeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            hybridTargetRangeArray = new HybridTargetRange[n];
            for (int i2 = 0; i2 < n; ++i2) {
                hybridTargetRangeArray[i2] = HybridTargetRangeSerializer.getOptionalHybridTargetRange(iDeserializer);
            }
        }
        return hybridTargetRangeArray;
    }
}

