/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardrivingcharacteristics.SpoilerType;

public class SpoilerTypeSerializer {
    public static void putOptionalSpoilerType(ISerializer iSerializer, SpoilerType spoilerType) {
        boolean bl = spoilerType == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = spoilerType.isBasis();
            iSerializer.putBool(bl2);
            boolean bl3 = spoilerType.isFlaps();
            iSerializer.putBool(bl3);
            boolean bl4 = spoilerType.isAngle();
            iSerializer.putBool(bl4);
        }
    }

    public static void putOptionalSpoilerTypeVarArray(ISerializer iSerializer, SpoilerType[] spoilerTypeArray) {
        boolean bl = spoilerTypeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(spoilerTypeArray.length);
            for (int i2 = 0; i2 < spoilerTypeArray.length; ++i2) {
                SpoilerTypeSerializer.putOptionalSpoilerType(iSerializer, spoilerTypeArray[i2]);
            }
        }
    }

    public static SpoilerType getOptionalSpoilerType(IDeserializer iDeserializer) {
        SpoilerType spoilerType = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            spoilerType = new SpoilerType();
            spoilerType.basis = bl4 = iDeserializer.getBool();
            spoilerType.flaps = bl3 = iDeserializer.getBool();
            spoilerType.angle = bl2 = iDeserializer.getBool();
        }
        return spoilerType;
    }

    public static SpoilerType[] getOptionalSpoilerTypeVarArray(IDeserializer iDeserializer) {
        SpoilerType[] spoilerTypeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            spoilerTypeArray = new SpoilerType[n];
            for (int i2 = 0; i2 < n; ++i2) {
                spoilerTypeArray[i2] = SpoilerTypeSerializer.getOptionalSpoilerType(iDeserializer);
            }
        }
        return spoilerTypeArray;
    }
}

