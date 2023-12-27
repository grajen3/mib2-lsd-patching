/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.UGDOSoftkeys;

public class UGDOSoftkeysSerializer {
    public static void putOptionalUGDOSoftkeys(ISerializer iSerializer, UGDOSoftkeys uGDOSoftkeys) {
        boolean bl = uGDOSoftkeys == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = uGDOSoftkeys.isSoftkey1();
            iSerializer.putBool(bl2);
            boolean bl3 = uGDOSoftkeys.isSoftkey2();
            iSerializer.putBool(bl3);
            boolean bl4 = uGDOSoftkeys.isSoftkey3();
            iSerializer.putBool(bl4);
            boolean bl5 = uGDOSoftkeys.isSoftkey4();
            iSerializer.putBool(bl5);
            boolean bl6 = uGDOSoftkeys.isSoftkey5();
            iSerializer.putBool(bl6);
            boolean bl7 = uGDOSoftkeys.isSoftkey6();
            iSerializer.putBool(bl7);
            boolean bl8 = uGDOSoftkeys.isSoftkey7();
            iSerializer.putBool(bl8);
            boolean bl9 = uGDOSoftkeys.isSoftkey8();
            iSerializer.putBool(bl9);
            boolean bl10 = uGDOSoftkeys.isSoftkey9();
            iSerializer.putBool(bl10);
            boolean bl11 = uGDOSoftkeys.isSoftkey10();
            iSerializer.putBool(bl11);
            boolean bl12 = uGDOSoftkeys.isSoftkey11();
            iSerializer.putBool(bl12);
            boolean bl13 = uGDOSoftkeys.isSoftkey12();
            iSerializer.putBool(bl13);
            boolean bl14 = uGDOSoftkeys.isSoftkey13();
            iSerializer.putBool(bl14);
            boolean bl15 = uGDOSoftkeys.isSoftkey14();
            iSerializer.putBool(bl15);
            boolean bl16 = uGDOSoftkeys.isSoftkey15();
            iSerializer.putBool(bl16);
        }
    }

    public static void putOptionalUGDOSoftkeysVarArray(ISerializer iSerializer, UGDOSoftkeys[] uGDOSoftkeysArray) {
        boolean bl = uGDOSoftkeysArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(uGDOSoftkeysArray.length);
            for (int i2 = 0; i2 < uGDOSoftkeysArray.length; ++i2) {
                UGDOSoftkeysSerializer.putOptionalUGDOSoftkeys(iSerializer, uGDOSoftkeysArray[i2]);
            }
        }
    }

    public static UGDOSoftkeys getOptionalUGDOSoftkeys(IDeserializer iDeserializer) {
        UGDOSoftkeys uGDOSoftkeys = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            boolean bl8;
            boolean bl9;
            boolean bl10;
            boolean bl11;
            boolean bl12;
            boolean bl13;
            boolean bl14;
            boolean bl15;
            boolean bl16;
            uGDOSoftkeys = new UGDOSoftkeys();
            uGDOSoftkeys.softkey1 = bl16 = iDeserializer.getBool();
            uGDOSoftkeys.softkey2 = bl15 = iDeserializer.getBool();
            uGDOSoftkeys.softkey3 = bl14 = iDeserializer.getBool();
            uGDOSoftkeys.softkey4 = bl13 = iDeserializer.getBool();
            uGDOSoftkeys.softkey5 = bl12 = iDeserializer.getBool();
            uGDOSoftkeys.softkey6 = bl11 = iDeserializer.getBool();
            uGDOSoftkeys.softkey7 = bl10 = iDeserializer.getBool();
            uGDOSoftkeys.softkey8 = bl9 = iDeserializer.getBool();
            uGDOSoftkeys.softkey9 = bl8 = iDeserializer.getBool();
            uGDOSoftkeys.softkey10 = bl7 = iDeserializer.getBool();
            uGDOSoftkeys.softkey11 = bl6 = iDeserializer.getBool();
            uGDOSoftkeys.softkey12 = bl5 = iDeserializer.getBool();
            uGDOSoftkeys.softkey13 = bl4 = iDeserializer.getBool();
            uGDOSoftkeys.softkey14 = bl3 = iDeserializer.getBool();
            uGDOSoftkeys.softkey15 = bl2 = iDeserializer.getBool();
        }
        return uGDOSoftkeys;
    }

    public static UGDOSoftkeys[] getOptionalUGDOSoftkeysVarArray(IDeserializer iDeserializer) {
        UGDOSoftkeys[] uGDOSoftkeysArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            uGDOSoftkeysArray = new UGDOSoftkeys[n];
            for (int i2 = 0; i2 < n; ++i2) {
                uGDOSoftkeysArray[i2] = UGDOSoftkeysSerializer.getOptionalUGDOSoftkeys(iDeserializer);
            }
        }
        return uGDOSoftkeysArray;
    }
}

