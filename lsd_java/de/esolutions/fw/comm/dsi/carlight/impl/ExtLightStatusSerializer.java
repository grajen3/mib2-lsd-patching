/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlight.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carlight.ExtLightStatus;

public class ExtLightStatusSerializer {
    public static void putOptionalExtLightStatus(ISerializer iSerializer, ExtLightStatus extLightStatus) {
        boolean bl = extLightStatus == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = extLightStatus.isHeadlight();
            iSerializer.putBool(bl2);
            boolean bl3 = extLightStatus.isParklightLeft();
            iSerializer.putBool(bl3);
            boolean bl4 = extLightStatus.isParklightRight();
            iSerializer.putBool(bl4);
        }
    }

    public static void putOptionalExtLightStatusVarArray(ISerializer iSerializer, ExtLightStatus[] extLightStatusArray) {
        boolean bl = extLightStatusArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(extLightStatusArray.length);
            for (int i2 = 0; i2 < extLightStatusArray.length; ++i2) {
                ExtLightStatusSerializer.putOptionalExtLightStatus(iSerializer, extLightStatusArray[i2]);
            }
        }
    }

    public static ExtLightStatus getOptionalExtLightStatus(IDeserializer iDeserializer) {
        ExtLightStatus extLightStatus = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            extLightStatus = new ExtLightStatus();
            extLightStatus.headlight = bl4 = iDeserializer.getBool();
            extLightStatus.parklightLeft = bl3 = iDeserializer.getBool();
            extLightStatus.parklightRight = bl2 = iDeserializer.getBool();
        }
        return extLightStatus;
    }

    public static ExtLightStatus[] getOptionalExtLightStatusVarArray(IDeserializer iDeserializer) {
        ExtLightStatus[] extLightStatusArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            extLightStatusArray = new ExtLightStatus[n];
            for (int i2 = 0; i2 < n; ++i2) {
                extLightStatusArray[i2] = ExtLightStatusSerializer.getOptionalExtLightStatus(iDeserializer);
            }
        }
        return extLightStatusArray;
    }
}

