/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.BCStatisticsReset;

public class BCStatisticsResetSerializer {
    public static void putOptionalBCStatisticsReset(ISerializer iSerializer, BCStatisticsReset bCStatisticsReset) {
        boolean bl = bCStatisticsReset == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = bCStatisticsReset.isTime();
            iSerializer.putBool(bl2);
            boolean bl3 = bCStatisticsReset.isDistance();
            iSerializer.putBool(bl3);
        }
    }

    public static void putOptionalBCStatisticsResetVarArray(ISerializer iSerializer, BCStatisticsReset[] bCStatisticsResetArray) {
        boolean bl = bCStatisticsResetArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCStatisticsResetArray.length);
            for (int i2 = 0; i2 < bCStatisticsResetArray.length; ++i2) {
                BCStatisticsResetSerializer.putOptionalBCStatisticsReset(iSerializer, bCStatisticsResetArray[i2]);
            }
        }
    }

    public static BCStatisticsReset getOptionalBCStatisticsReset(IDeserializer iDeserializer) {
        BCStatisticsReset bCStatisticsReset = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            bCStatisticsReset = new BCStatisticsReset();
            bCStatisticsReset.time = bl3 = iDeserializer.getBool();
            bCStatisticsReset.distance = bl2 = iDeserializer.getBool();
        }
        return bCStatisticsReset;
    }

    public static BCStatisticsReset[] getOptionalBCStatisticsResetVarArray(IDeserializer iDeserializer) {
        BCStatisticsReset[] bCStatisticsResetArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCStatisticsResetArray = new BCStatisticsReset[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCStatisticsResetArray[i2] = BCStatisticsResetSerializer.getOptionalBCStatisticsReset(iDeserializer);
            }
        }
        return bCStatisticsResetArray;
    }
}

