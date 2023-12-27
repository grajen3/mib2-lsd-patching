/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.dsi.carkombi.impl.BCCounterSerializer;
import de.esolutions.fw.comm.dsi.global.impl.CarBCConsumptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.BCCounter;
import org.dsi.ifc.carkombi.BCStatisticsAC;
import org.dsi.ifc.global.CarBCConsumption;

public class BCStatisticsACSerializer {
    public static void putOptionalBCStatisticsAC(ISerializer iSerializer, BCStatisticsAC bCStatisticsAC) {
        boolean bl = bCStatisticsAC == null;
        iSerializer.putBool(bl);
        if (!bl) {
            BCCounter bCCounter = bCStatisticsAC.getTripCounter();
            BCCounterSerializer.putOptionalBCCounter(iSerializer, bCCounter);
            BCCounter bCCounter2 = bCStatisticsAC.getValueCounter();
            BCCounterSerializer.putOptionalBCCounter(iSerializer, bCCounter2);
            CarBCConsumption carBCConsumption = bCStatisticsAC.getAverageConsumption();
            CarBCConsumptionSerializer.putOptionalCarBCConsumption(iSerializer, carBCConsumption);
        }
    }

    public static void putOptionalBCStatisticsACVarArray(ISerializer iSerializer, BCStatisticsAC[] bCStatisticsACArray) {
        boolean bl = bCStatisticsACArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCStatisticsACArray.length);
            for (int i2 = 0; i2 < bCStatisticsACArray.length; ++i2) {
                BCStatisticsACSerializer.putOptionalBCStatisticsAC(iSerializer, bCStatisticsACArray[i2]);
            }
        }
    }

    public static BCStatisticsAC getOptionalBCStatisticsAC(IDeserializer iDeserializer) {
        BCStatisticsAC bCStatisticsAC = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarBCConsumption carBCConsumption;
            BCCounter bCCounter;
            BCCounter bCCounter2;
            bCStatisticsAC = new BCStatisticsAC();
            bCStatisticsAC.tripCounter = bCCounter2 = BCCounterSerializer.getOptionalBCCounter(iDeserializer);
            bCStatisticsAC.valueCounter = bCCounter = BCCounterSerializer.getOptionalBCCounter(iDeserializer);
            bCStatisticsAC.averageConsumption = carBCConsumption = CarBCConsumptionSerializer.getOptionalCarBCConsumption(iDeserializer);
        }
        return bCStatisticsAC;
    }

    public static BCStatisticsAC[] getOptionalBCStatisticsACVarArray(IDeserializer iDeserializer) {
        BCStatisticsAC[] bCStatisticsACArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCStatisticsACArray = new BCStatisticsAC[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCStatisticsACArray[i2] = BCStatisticsACSerializer.getOptionalBCStatisticsAC(iDeserializer);
            }
        }
        return bCStatisticsACArray;
    }
}

