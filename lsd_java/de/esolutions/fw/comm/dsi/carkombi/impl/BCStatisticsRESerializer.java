/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.comm.dsi.carkombi.impl.BCAverageRecoveredEnergySerializer;
import de.esolutions.fw.comm.dsi.carkombi.impl.BCCounterSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.BCAverageRecoveredEnergy;
import org.dsi.ifc.carkombi.BCCounter;
import org.dsi.ifc.carkombi.BCStatisticsRE;

public class BCStatisticsRESerializer {
    public static void putOptionalBCStatisticsRE(ISerializer iSerializer, BCStatisticsRE bCStatisticsRE) {
        boolean bl = bCStatisticsRE == null;
        iSerializer.putBool(bl);
        if (!bl) {
            BCCounter bCCounter = bCStatisticsRE.getTripCounter();
            BCCounterSerializer.putOptionalBCCounter(iSerializer, bCCounter);
            BCCounter bCCounter2 = bCStatisticsRE.getValueCounter();
            BCCounterSerializer.putOptionalBCCounter(iSerializer, bCCounter2);
            BCAverageRecoveredEnergy bCAverageRecoveredEnergy = bCStatisticsRE.getAverageRecoveredEnergy();
            BCAverageRecoveredEnergySerializer.putOptionalBCAverageRecoveredEnergy(iSerializer, bCAverageRecoveredEnergy);
        }
    }

    public static void putOptionalBCStatisticsREVarArray(ISerializer iSerializer, BCStatisticsRE[] bCStatisticsREArray) {
        boolean bl = bCStatisticsREArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCStatisticsREArray.length);
            for (int i2 = 0; i2 < bCStatisticsREArray.length; ++i2) {
                BCStatisticsRESerializer.putOptionalBCStatisticsRE(iSerializer, bCStatisticsREArray[i2]);
            }
        }
    }

    public static BCStatisticsRE getOptionalBCStatisticsRE(IDeserializer iDeserializer) {
        BCStatisticsRE bCStatisticsRE = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            BCAverageRecoveredEnergy bCAverageRecoveredEnergy;
            BCCounter bCCounter;
            BCCounter bCCounter2;
            bCStatisticsRE = new BCStatisticsRE();
            bCStatisticsRE.tripCounter = bCCounter2 = BCCounterSerializer.getOptionalBCCounter(iDeserializer);
            bCStatisticsRE.valueCounter = bCCounter = BCCounterSerializer.getOptionalBCCounter(iDeserializer);
            bCStatisticsRE.averageRecoveredEnergy = bCAverageRecoveredEnergy = BCAverageRecoveredEnergySerializer.getOptionalBCAverageRecoveredEnergy(iDeserializer);
        }
        return bCStatisticsRE;
    }

    public static BCStatisticsRE[] getOptionalBCStatisticsREVarArray(IDeserializer iDeserializer) {
        BCStatisticsRE[] bCStatisticsREArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCStatisticsREArray = new BCStatisticsRE[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCStatisticsREArray[i2] = BCStatisticsRESerializer.getOptionalBCStatisticsRE(iDeserializer);
            }
        }
        return bCStatisticsREArray;
    }
}

