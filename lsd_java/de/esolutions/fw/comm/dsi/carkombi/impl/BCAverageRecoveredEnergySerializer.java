/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.BCAverageRecoveredEnergy;

public class BCAverageRecoveredEnergySerializer {
    public static void putOptionalBCAverageRecoveredEnergy(ISerializer iSerializer, BCAverageRecoveredEnergy bCAverageRecoveredEnergy) {
        boolean bl = bCAverageRecoveredEnergy == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = bCAverageRecoveredEnergy.getState();
            iSerializer.putInt32(n);
            int n2 = bCAverageRecoveredEnergy.getValue();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalBCAverageRecoveredEnergyVarArray(ISerializer iSerializer, BCAverageRecoveredEnergy[] bCAverageRecoveredEnergyArray) {
        boolean bl = bCAverageRecoveredEnergyArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCAverageRecoveredEnergyArray.length);
            for (int i2 = 0; i2 < bCAverageRecoveredEnergyArray.length; ++i2) {
                BCAverageRecoveredEnergySerializer.putOptionalBCAverageRecoveredEnergy(iSerializer, bCAverageRecoveredEnergyArray[i2]);
            }
        }
    }

    public static BCAverageRecoveredEnergy getOptionalBCAverageRecoveredEnergy(IDeserializer iDeserializer) {
        BCAverageRecoveredEnergy bCAverageRecoveredEnergy = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            bCAverageRecoveredEnergy = new BCAverageRecoveredEnergy();
            bCAverageRecoveredEnergy.state = n2 = iDeserializer.getInt32();
            bCAverageRecoveredEnergy.value = n = iDeserializer.getInt32();
        }
        return bCAverageRecoveredEnergy;
    }

    public static BCAverageRecoveredEnergy[] getOptionalBCAverageRecoveredEnergyVarArray(IDeserializer iDeserializer) {
        BCAverageRecoveredEnergy[] bCAverageRecoveredEnergyArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCAverageRecoveredEnergyArray = new BCAverageRecoveredEnergy[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCAverageRecoveredEnergyArray[i2] = BCAverageRecoveredEnergySerializer.getOptionalBCAverageRecoveredEnergy(iDeserializer);
            }
        }
        return bCAverageRecoveredEnergyArray;
    }
}

