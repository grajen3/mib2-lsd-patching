/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cartimeunitslanguage.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cartimeunitslanguage.UnitmasterSupportedConsumptionUnits;

public class UnitmasterSupportedConsumptionUnitsSerializer {
    public static void putOptionalUnitmasterSupportedConsumptionUnits(ISerializer iSerializer, UnitmasterSupportedConsumptionUnits unitmasterSupportedConsumptionUnits) {
        boolean bl = unitmasterSupportedConsumptionUnits == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = unitmasterSupportedConsumptionUnits.isKWhPerMiles();
            iSerializer.putBool(bl2);
            boolean bl3 = unitmasterSupportedConsumptionUnits.isMilesPerKg();
            iSerializer.putBool(bl3);
            boolean bl4 = unitmasterSupportedConsumptionUnits.isMilesPerM3();
            iSerializer.putBool(bl4);
            boolean bl5 = unitmasterSupportedConsumptionUnits.isMpgeUS();
            iSerializer.putBool(bl5);
        }
    }

    public static void putOptionalUnitmasterSupportedConsumptionUnitsVarArray(ISerializer iSerializer, UnitmasterSupportedConsumptionUnits[] unitmasterSupportedConsumptionUnitsArray) {
        boolean bl = unitmasterSupportedConsumptionUnitsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(unitmasterSupportedConsumptionUnitsArray.length);
            for (int i2 = 0; i2 < unitmasterSupportedConsumptionUnitsArray.length; ++i2) {
                UnitmasterSupportedConsumptionUnitsSerializer.putOptionalUnitmasterSupportedConsumptionUnits(iSerializer, unitmasterSupportedConsumptionUnitsArray[i2]);
            }
        }
    }

    public static UnitmasterSupportedConsumptionUnits getOptionalUnitmasterSupportedConsumptionUnits(IDeserializer iDeserializer) {
        UnitmasterSupportedConsumptionUnits unitmasterSupportedConsumptionUnits = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            unitmasterSupportedConsumptionUnits = new UnitmasterSupportedConsumptionUnits();
            unitmasterSupportedConsumptionUnits.kWhPerMiles = bl5 = iDeserializer.getBool();
            unitmasterSupportedConsumptionUnits.milesPerKg = bl4 = iDeserializer.getBool();
            unitmasterSupportedConsumptionUnits.milesPerM3 = bl3 = iDeserializer.getBool();
            unitmasterSupportedConsumptionUnits.mpgeUS = bl2 = iDeserializer.getBool();
        }
        return unitmasterSupportedConsumptionUnits;
    }

    public static UnitmasterSupportedConsumptionUnits[] getOptionalUnitmasterSupportedConsumptionUnitsVarArray(IDeserializer iDeserializer) {
        UnitmasterSupportedConsumptionUnits[] unitmasterSupportedConsumptionUnitsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            unitmasterSupportedConsumptionUnitsArray = new UnitmasterSupportedConsumptionUnits[n];
            for (int i2 = 0; i2 < n; ++i2) {
                unitmasterSupportedConsumptionUnitsArray[i2] = UnitmasterSupportedConsumptionUnitsSerializer.getOptionalUnitmasterSupportedConsumptionUnits(iDeserializer);
            }
        }
        return unitmasterSupportedConsumptionUnitsArray;
    }
}

