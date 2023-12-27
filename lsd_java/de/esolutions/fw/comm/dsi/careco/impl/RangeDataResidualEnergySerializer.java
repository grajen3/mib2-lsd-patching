/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.careco.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.careco.RangeDataResidualEnergy;

public class RangeDataResidualEnergySerializer {
    public static void putOptionalRangeDataResidualEnergy(ISerializer iSerializer, RangeDataResidualEnergy rangeDataResidualEnergy) {
        boolean bl = rangeDataResidualEnergy == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = rangeDataResidualEnergy.getState();
            iSerializer.putInt32(n);
            float f2 = rangeDataResidualEnergy.getValue();
            iSerializer.putFloat(f2);
            int n2 = rangeDataResidualEnergy.getUnit();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalRangeDataResidualEnergyVarArray(ISerializer iSerializer, RangeDataResidualEnergy[] rangeDataResidualEnergyArray) {
        boolean bl = rangeDataResidualEnergyArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(rangeDataResidualEnergyArray.length);
            for (int i2 = 0; i2 < rangeDataResidualEnergyArray.length; ++i2) {
                RangeDataResidualEnergySerializer.putOptionalRangeDataResidualEnergy(iSerializer, rangeDataResidualEnergyArray[i2]);
            }
        }
    }

    public static RangeDataResidualEnergy getOptionalRangeDataResidualEnergy(IDeserializer iDeserializer) {
        RangeDataResidualEnergy rangeDataResidualEnergy = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            float f2;
            int n2;
            rangeDataResidualEnergy = new RangeDataResidualEnergy();
            rangeDataResidualEnergy.state = n2 = iDeserializer.getInt32();
            rangeDataResidualEnergy.value = f2 = iDeserializer.getFloat();
            rangeDataResidualEnergy.unit = n = iDeserializer.getInt32();
        }
        return rangeDataResidualEnergy;
    }

    public static RangeDataResidualEnergy[] getOptionalRangeDataResidualEnergyVarArray(IDeserializer iDeserializer) {
        RangeDataResidualEnergy[] rangeDataResidualEnergyArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            rangeDataResidualEnergyArray = new RangeDataResidualEnergy[n];
            for (int i2 = 0; i2 < n; ++i2) {
                rangeDataResidualEnergyArray[i2] = RangeDataResidualEnergySerializer.getOptionalRangeDataResidualEnergy(iDeserializer);
            }
        }
        return rangeDataResidualEnergyArray;
    }
}

