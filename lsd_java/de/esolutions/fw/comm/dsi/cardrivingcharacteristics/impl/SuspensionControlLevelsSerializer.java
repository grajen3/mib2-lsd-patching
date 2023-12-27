/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlLevels;

public class SuspensionControlLevelsSerializer {
    public static void putOptionalSuspensionControlLevels(ISerializer iSerializer, SuspensionControlLevels suspensionControlLevels) {
        boolean bl = suspensionControlLevels == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = suspensionControlLevels.isLevel1();
            iSerializer.putBool(bl2);
            boolean bl3 = suspensionControlLevels.isLevel2();
            iSerializer.putBool(bl3);
            boolean bl4 = suspensionControlLevels.isLevel3();
            iSerializer.putBool(bl4);
            boolean bl5 = suspensionControlLevels.isLevel4();
            iSerializer.putBool(bl5);
            boolean bl6 = suspensionControlLevels.isLevel5();
            iSerializer.putBool(bl6);
            boolean bl7 = suspensionControlLevels.isLevel6();
            iSerializer.putBool(bl7);
            boolean bl8 = suspensionControlLevels.isLevel7();
            iSerializer.putBool(bl8);
        }
    }

    public static void putOptionalSuspensionControlLevelsVarArray(ISerializer iSerializer, SuspensionControlLevels[] suspensionControlLevelsArray) {
        boolean bl = suspensionControlLevelsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(suspensionControlLevelsArray.length);
            for (int i2 = 0; i2 < suspensionControlLevelsArray.length; ++i2) {
                SuspensionControlLevelsSerializer.putOptionalSuspensionControlLevels(iSerializer, suspensionControlLevelsArray[i2]);
            }
        }
    }

    public static SuspensionControlLevels getOptionalSuspensionControlLevels(IDeserializer iDeserializer) {
        SuspensionControlLevels suspensionControlLevels = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            boolean bl8;
            suspensionControlLevels = new SuspensionControlLevels();
            suspensionControlLevels.level1 = bl8 = iDeserializer.getBool();
            suspensionControlLevels.level2 = bl7 = iDeserializer.getBool();
            suspensionControlLevels.level3 = bl6 = iDeserializer.getBool();
            suspensionControlLevels.level4 = bl5 = iDeserializer.getBool();
            suspensionControlLevels.level5 = bl4 = iDeserializer.getBool();
            suspensionControlLevels.level6 = bl3 = iDeserializer.getBool();
            suspensionControlLevels.level7 = bl2 = iDeserializer.getBool();
        }
        return suspensionControlLevels;
    }

    public static SuspensionControlLevels[] getOptionalSuspensionControlLevelsVarArray(IDeserializer iDeserializer) {
        SuspensionControlLevels[] suspensionControlLevelsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            suspensionControlLevelsArray = new SuspensionControlLevels[n];
            for (int i2 = 0; i2 < n; ++i2) {
                suspensionControlLevelsArray[i2] = SuspensionControlLevelsSerializer.getOptionalSuspensionControlLevels(iDeserializer);
            }
        }
        return suspensionControlLevelsArray;
    }
}

