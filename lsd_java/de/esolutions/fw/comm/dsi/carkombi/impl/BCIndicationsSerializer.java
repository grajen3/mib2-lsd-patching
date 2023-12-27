/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.BCIndications;

public class BCIndicationsSerializer {
    public static void putOptionalBCIndications(ISerializer iSerializer, BCIndications bCIndications) {
        boolean bl = bCIndications == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = bCIndications.isWashingWater();
            iSerializer.putBool(bl2);
            boolean bl3 = bCIndications.isOilLevel();
            iSerializer.putBool(bl3);
            boolean bl4 = bCIndications.isTyrePressure();
            iSerializer.putBool(bl4);
            boolean bl5 = bCIndications.isTankLevel();
            iSerializer.putBool(bl5);
        }
    }

    public static void putOptionalBCIndicationsVarArray(ISerializer iSerializer, BCIndications[] bCIndicationsArray) {
        boolean bl = bCIndicationsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCIndicationsArray.length);
            for (int i2 = 0; i2 < bCIndicationsArray.length; ++i2) {
                BCIndicationsSerializer.putOptionalBCIndications(iSerializer, bCIndicationsArray[i2]);
            }
        }
    }

    public static BCIndications getOptionalBCIndications(IDeserializer iDeserializer) {
        BCIndications bCIndications = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            bCIndications = new BCIndications();
            bCIndications.washingWater = bl5 = iDeserializer.getBool();
            bCIndications.oilLevel = bl4 = iDeserializer.getBool();
            bCIndications.tyrePressure = bl3 = iDeserializer.getBool();
            bCIndications.tankLevel = bl2 = iDeserializer.getBool();
        }
        return bCIndications;
    }

    public static BCIndications[] getOptionalBCIndicationsVarArray(IDeserializer iDeserializer) {
        BCIndications[] bCIndicationsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCIndicationsArray = new BCIndications[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCIndicationsArray[i2] = BCIndicationsSerializer.getOptionalBCIndications(iDeserializer);
            }
        }
        return bCIndicationsArray;
    }
}

