/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.powermanagement.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.powermanagement.ClampSignal;

public class ClampSignalSerializer {
    public static void putOptionalClampSignal(ISerializer iSerializer, ClampSignal clampSignal) {
        boolean bl = clampSignal == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = clampSignal.isClampS();
            iSerializer.putBool(bl2);
            boolean bl3 = clampSignal.isClamp15();
            iSerializer.putBool(bl3);
            boolean bl4 = clampSignal.isClampX();
            iSerializer.putBool(bl4);
            boolean bl5 = clampSignal.isClamp50();
            iSerializer.putBool(bl5);
        }
    }

    public static void putOptionalClampSignalVarArray(ISerializer iSerializer, ClampSignal[] clampSignalArray) {
        boolean bl = clampSignalArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(clampSignalArray.length);
            for (int i2 = 0; i2 < clampSignalArray.length; ++i2) {
                ClampSignalSerializer.putOptionalClampSignal(iSerializer, clampSignalArray[i2]);
            }
        }
    }

    public static ClampSignal getOptionalClampSignal(IDeserializer iDeserializer) {
        ClampSignal clampSignal = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            clampSignal = new ClampSignal();
            clampSignal.clampS = bl5 = iDeserializer.getBool();
            clampSignal.clamp15 = bl4 = iDeserializer.getBool();
            clampSignal.clampX = bl3 = iDeserializer.getBool();
            clampSignal.clamp50 = bl2 = iDeserializer.getBool();
        }
        return clampSignal;
    }

    public static ClampSignal[] getOptionalClampSignalVarArray(IDeserializer iDeserializer) {
        ClampSignal[] clampSignalArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            clampSignalArray = new ClampSignal[n];
            for (int i2 = 0; i2 < n; ++i2) {
                clampSignalArray[i2] = ClampSignalSerializer.getOptionalClampSignal(iDeserializer);
            }
        }
        return clampSignalArray;
    }
}

