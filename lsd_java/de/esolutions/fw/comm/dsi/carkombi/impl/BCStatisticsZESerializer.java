/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.dsi.carkombi.impl.BCCounterSerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.BCZeroEmissionRelativeSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.BCCounter;
import org.dsi.ifc.carkombi.BCStatisticsZE;
import org.dsi.ifc.carkombi.BCZeroEmissionRelative;

public class BCStatisticsZESerializer {
    public static void putOptionalBCStatisticsZE(ISerializer iSerializer, BCStatisticsZE bCStatisticsZE) {
        boolean bl = bCStatisticsZE == null;
        iSerializer.putBool(bl);
        if (!bl) {
            BCCounter bCCounter = bCStatisticsZE.getTripCounter();
            BCCounterSerializer.putOptionalBCCounter(iSerializer, bCCounter);
            BCCounter bCCounter2 = bCStatisticsZE.getValueCounter();
            BCCounterSerializer.putOptionalBCCounter(iSerializer, bCCounter2);
            BCZeroEmissionRelative bCZeroEmissionRelative = bCStatisticsZE.getZeroEmissionRelative();
            BCZeroEmissionRelativeSerializer.putOptionalBCZeroEmissionRelative(iSerializer, bCZeroEmissionRelative);
        }
    }

    public static void putOptionalBCStatisticsZEVarArray(ISerializer iSerializer, BCStatisticsZE[] bCStatisticsZEArray) {
        boolean bl = bCStatisticsZEArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCStatisticsZEArray.length);
            for (int i2 = 0; i2 < bCStatisticsZEArray.length; ++i2) {
                BCStatisticsZESerializer.putOptionalBCStatisticsZE(iSerializer, bCStatisticsZEArray[i2]);
            }
        }
    }

    public static BCStatisticsZE getOptionalBCStatisticsZE(IDeserializer iDeserializer) {
        BCStatisticsZE bCStatisticsZE = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            BCZeroEmissionRelative bCZeroEmissionRelative;
            BCCounter bCCounter;
            BCCounter bCCounter2;
            bCStatisticsZE = new BCStatisticsZE();
            bCStatisticsZE.tripCounter = bCCounter2 = BCCounterSerializer.getOptionalBCCounter(iDeserializer);
            bCStatisticsZE.valueCounter = bCCounter = BCCounterSerializer.getOptionalBCCounter(iDeserializer);
            bCStatisticsZE.zeroEmissionRelative = bCZeroEmissionRelative = BCZeroEmissionRelativeSerializer.getOptionalBCZeroEmissionRelative(iDeserializer);
        }
        return bCStatisticsZE;
    }

    public static BCStatisticsZE[] getOptionalBCStatisticsZEVarArray(IDeserializer iDeserializer) {
        BCStatisticsZE[] bCStatisticsZEArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCStatisticsZEArray = new BCStatisticsZE[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCStatisticsZEArray[i2] = BCStatisticsZESerializer.getOptionalBCStatisticsZE(iDeserializer);
            }
        }
        return bCStatisticsZEArray;
    }
}

