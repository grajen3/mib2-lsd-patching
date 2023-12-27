/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.SIAResetValues;

public class SIAResetValuesSerializer {
    public static void putOptionalSIAResetValues(ISerializer iSerializer, SIAResetValues sIAResetValues) {
        boolean bl = sIAResetValues == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = sIAResetValues.isDistanceOil();
            iSerializer.putBool(bl2);
            boolean bl3 = sIAResetValues.isTimeOil();
            iSerializer.putBool(bl3);
            boolean bl4 = sIAResetValues.isInspectionDistance();
            iSerializer.putBool(bl4);
            boolean bl5 = sIAResetValues.isInspectionTime();
            iSerializer.putBool(bl5);
        }
    }

    public static void putOptionalSIAResetValuesVarArray(ISerializer iSerializer, SIAResetValues[] sIAResetValuesArray) {
        boolean bl = sIAResetValuesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sIAResetValuesArray.length);
            for (int i2 = 0; i2 < sIAResetValuesArray.length; ++i2) {
                SIAResetValuesSerializer.putOptionalSIAResetValues(iSerializer, sIAResetValuesArray[i2]);
            }
        }
    }

    public static SIAResetValues getOptionalSIAResetValues(IDeserializer iDeserializer) {
        SIAResetValues sIAResetValues = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            sIAResetValues = new SIAResetValues();
            sIAResetValues.distanceOil = bl5 = iDeserializer.getBool();
            sIAResetValues.timeOil = bl4 = iDeserializer.getBool();
            sIAResetValues.inspectionDistance = bl3 = iDeserializer.getBool();
            sIAResetValues.inspectionTime = bl2 = iDeserializer.getBool();
        }
        return sIAResetValues;
    }

    public static SIAResetValues[] getOptionalSIAResetValuesVarArray(IDeserializer iDeserializer) {
        SIAResetValues[] sIAResetValuesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sIAResetValuesArray = new SIAResetValues[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sIAResetValuesArray[i2] = SIAResetValuesSerializer.getOptionalSIAResetValues(iDeserializer);
            }
        }
        return sIAResetValuesArray;
    }
}

