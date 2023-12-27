/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.SIAServiceAttributes;

public class SIAServiceAttributesSerializer {
    public static void putOptionalSIAServiceAttributes(ISerializer iSerializer, SIAServiceAttributes sIAServiceAttributes) {
        boolean bl = sIAServiceAttributes == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = sIAServiceAttributes.isBrakeFluid();
            iSerializer.putBool(bl2);
            boolean bl3 = sIAServiceAttributes.isSparkPlug();
            iSerializer.putBool(bl3);
            boolean bl4 = sIAServiceAttributes.isAirFilter();
            iSerializer.putBool(bl4);
            boolean bl5 = sIAServiceAttributes.isFuelFilter();
            iSerializer.putBool(bl5);
            boolean bl6 = sIAServiceAttributes.isTyreSealant();
            iSerializer.putBool(bl6);
            boolean bl7 = sIAServiceAttributes.isGearboxOil();
            iSerializer.putBool(bl7);
            boolean bl8 = sIAServiceAttributes.isEngineOil();
            iSerializer.putBool(bl8);
        }
    }

    public static void putOptionalSIAServiceAttributesVarArray(ISerializer iSerializer, SIAServiceAttributes[] sIAServiceAttributesArray) {
        boolean bl = sIAServiceAttributesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sIAServiceAttributesArray.length);
            for (int i2 = 0; i2 < sIAServiceAttributesArray.length; ++i2) {
                SIAServiceAttributesSerializer.putOptionalSIAServiceAttributes(iSerializer, sIAServiceAttributesArray[i2]);
            }
        }
    }

    public static SIAServiceAttributes getOptionalSIAServiceAttributes(IDeserializer iDeserializer) {
        SIAServiceAttributes sIAServiceAttributes = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            boolean bl8;
            sIAServiceAttributes = new SIAServiceAttributes();
            sIAServiceAttributes.brakeFluid = bl8 = iDeserializer.getBool();
            sIAServiceAttributes.sparkPlug = bl7 = iDeserializer.getBool();
            sIAServiceAttributes.airFilter = bl6 = iDeserializer.getBool();
            sIAServiceAttributes.fuelFilter = bl5 = iDeserializer.getBool();
            sIAServiceAttributes.tyreSealant = bl4 = iDeserializer.getBool();
            sIAServiceAttributes.gearboxOil = bl3 = iDeserializer.getBool();
            sIAServiceAttributes.engineOil = bl2 = iDeserializer.getBool();
        }
        return sIAServiceAttributes;
    }

    public static SIAServiceAttributes[] getOptionalSIAServiceAttributesVarArray(IDeserializer iDeserializer) {
        SIAServiceAttributes[] sIAServiceAttributesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sIAServiceAttributesArray = new SIAServiceAttributes[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sIAServiceAttributesArray[i2] = SIAServiceAttributesSerializer.getOptionalSIAServiceAttributes(iDeserializer);
            }
        }
        return sIAServiceAttributesArray;
    }
}

