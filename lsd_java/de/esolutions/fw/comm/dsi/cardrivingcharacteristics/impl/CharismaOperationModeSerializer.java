/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardrivingcharacteristics.CharismaOperationMode;

public class CharismaOperationModeSerializer {
    public static void putOptionalCharismaOperationMode(ISerializer iSerializer, CharismaOperationMode charismaOperationMode) {
        boolean bl = charismaOperationMode == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = charismaOperationMode.isEvMode();
            iSerializer.putBool(bl2);
            boolean bl3 = charismaOperationMode.isHybridMode();
            iSerializer.putBool(bl3);
            boolean bl4 = charismaOperationMode.isSustainingMode();
            iSerializer.putBool(bl4);
            boolean bl5 = charismaOperationMode.isChargingMode();
            iSerializer.putBool(bl5);
            boolean bl6 = charismaOperationMode.isSocControlMode();
            iSerializer.putBool(bl6);
            boolean bl7 = charismaOperationMode.isHybridSportMode();
            iSerializer.putBool(bl7);
        }
    }

    public static void putOptionalCharismaOperationModeVarArray(ISerializer iSerializer, CharismaOperationMode[] charismaOperationModeArray) {
        boolean bl = charismaOperationModeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(charismaOperationModeArray.length);
            for (int i2 = 0; i2 < charismaOperationModeArray.length; ++i2) {
                CharismaOperationModeSerializer.putOptionalCharismaOperationMode(iSerializer, charismaOperationModeArray[i2]);
            }
        }
    }

    public static CharismaOperationMode getOptionalCharismaOperationMode(IDeserializer iDeserializer) {
        CharismaOperationMode charismaOperationMode = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            charismaOperationMode = new CharismaOperationMode();
            charismaOperationMode.evMode = bl7 = iDeserializer.getBool();
            charismaOperationMode.hybridMode = bl6 = iDeserializer.getBool();
            charismaOperationMode.sustainingMode = bl5 = iDeserializer.getBool();
            charismaOperationMode.chargingMode = bl4 = iDeserializer.getBool();
            charismaOperationMode.socControlMode = bl3 = iDeserializer.getBool();
            charismaOperationMode.hybridSportMode = bl2 = iDeserializer.getBool();
        }
        return charismaOperationMode;
    }

    public static CharismaOperationMode[] getOptionalCharismaOperationModeVarArray(IDeserializer iDeserializer) {
        CharismaOperationMode[] charismaOperationModeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            charismaOperationModeArray = new CharismaOperationMode[n];
            for (int i2 = 0; i2 < n; ++i2) {
                charismaOperationModeArray[i2] = CharismaOperationModeSerializer.getOptionalCharismaOperationMode(iDeserializer);
            }
        }
        return charismaOperationModeArray;
    }
}

