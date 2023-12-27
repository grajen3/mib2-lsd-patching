/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardrivingcharacteristics.SpoilerPositions;

public class SpoilerPositionsSerializer {
    public static void putOptionalSpoilerPositions(ISerializer iSerializer, SpoilerPositions spoilerPositions) {
        boolean bl = spoilerPositions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = spoilerPositions.isPosition0();
            iSerializer.putBool(bl2);
            boolean bl3 = spoilerPositions.isPosition1();
            iSerializer.putBool(bl3);
            boolean bl4 = spoilerPositions.isPosition2();
            iSerializer.putBool(bl4);
            boolean bl5 = spoilerPositions.isPosition3();
            iSerializer.putBool(bl5);
            boolean bl6 = spoilerPositions.isPosition4();
            iSerializer.putBool(bl6);
            boolean bl7 = spoilerPositions.isPosition5();
            iSerializer.putBool(bl7);
        }
    }

    public static void putOptionalSpoilerPositionsVarArray(ISerializer iSerializer, SpoilerPositions[] spoilerPositionsArray) {
        boolean bl = spoilerPositionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(spoilerPositionsArray.length);
            for (int i2 = 0; i2 < spoilerPositionsArray.length; ++i2) {
                SpoilerPositionsSerializer.putOptionalSpoilerPositions(iSerializer, spoilerPositionsArray[i2]);
            }
        }
    }

    public static SpoilerPositions getOptionalSpoilerPositions(IDeserializer iDeserializer) {
        SpoilerPositions spoilerPositions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            spoilerPositions = new SpoilerPositions();
            spoilerPositions.position0 = bl7 = iDeserializer.getBool();
            spoilerPositions.position1 = bl6 = iDeserializer.getBool();
            spoilerPositions.position2 = bl5 = iDeserializer.getBool();
            spoilerPositions.position3 = bl4 = iDeserializer.getBool();
            spoilerPositions.position4 = bl3 = iDeserializer.getBool();
            spoilerPositions.position5 = bl2 = iDeserializer.getBool();
        }
        return spoilerPositions;
    }

    public static SpoilerPositions[] getOptionalSpoilerPositionsVarArray(IDeserializer iDeserializer) {
        SpoilerPositions[] spoilerPositionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            spoilerPositionsArray = new SpoilerPositions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                spoilerPositionsArray[i2] = SpoilerPositionsSerializer.getOptionalSpoilerPositions(iDeserializer);
            }
        }
        return spoilerPositionsArray;
    }
}

