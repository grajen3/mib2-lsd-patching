/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.UGDODestinationReached;

public class UGDODestinationReachedSerializer {
    public static void putOptionalUGDODestinationReached(ISerializer iSerializer, UGDODestinationReached uGDODestinationReached) {
        boolean bl = uGDODestinationReached == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = uGDODestinationReached.isSoftkey1();
            iSerializer.putBool(bl2);
            boolean bl3 = uGDODestinationReached.isSoftkey2();
            iSerializer.putBool(bl3);
            boolean bl4 = uGDODestinationReached.isSoftkey3();
            iSerializer.putBool(bl4);
            boolean bl5 = uGDODestinationReached.isSoftkey4();
            iSerializer.putBool(bl5);
            boolean bl6 = uGDODestinationReached.isSoftkey5();
            iSerializer.putBool(bl6);
            boolean bl7 = uGDODestinationReached.isSoftkey6();
            iSerializer.putBool(bl7);
            boolean bl8 = uGDODestinationReached.isSoftkey7();
            iSerializer.putBool(bl8);
            boolean bl9 = uGDODestinationReached.isSoftkey8();
            iSerializer.putBool(bl9);
            boolean bl10 = uGDODestinationReached.isSoftkey9();
            iSerializer.putBool(bl10);
            boolean bl11 = uGDODestinationReached.isSoftkey10();
            iSerializer.putBool(bl11);
            boolean bl12 = uGDODestinationReached.isSoftkey11();
            iSerializer.putBool(bl12);
            boolean bl13 = uGDODestinationReached.isSoftkey12();
            iSerializer.putBool(bl13);
            boolean bl14 = uGDODestinationReached.isSoftkey13();
            iSerializer.putBool(bl14);
            boolean bl15 = uGDODestinationReached.isSoftkey14();
            iSerializer.putBool(bl15);
            boolean bl16 = uGDODestinationReached.isSoftkey15();
            iSerializer.putBool(bl16);
        }
    }

    public static void putOptionalUGDODestinationReachedVarArray(ISerializer iSerializer, UGDODestinationReached[] uGDODestinationReachedArray) {
        boolean bl = uGDODestinationReachedArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(uGDODestinationReachedArray.length);
            for (int i2 = 0; i2 < uGDODestinationReachedArray.length; ++i2) {
                UGDODestinationReachedSerializer.putOptionalUGDODestinationReached(iSerializer, uGDODestinationReachedArray[i2]);
            }
        }
    }

    public static UGDODestinationReached getOptionalUGDODestinationReached(IDeserializer iDeserializer) {
        UGDODestinationReached uGDODestinationReached = null;
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
            uGDODestinationReached = new UGDODestinationReached();
            uGDODestinationReached.softkey1 = bl16 = iDeserializer.getBool();
            uGDODestinationReached.softkey2 = bl15 = iDeserializer.getBool();
            uGDODestinationReached.softkey3 = bl14 = iDeserializer.getBool();
            uGDODestinationReached.softkey4 = bl13 = iDeserializer.getBool();
            uGDODestinationReached.softkey5 = bl12 = iDeserializer.getBool();
            uGDODestinationReached.softkey6 = bl11 = iDeserializer.getBool();
            uGDODestinationReached.softkey7 = bl10 = iDeserializer.getBool();
            uGDODestinationReached.softkey8 = bl9 = iDeserializer.getBool();
            uGDODestinationReached.softkey9 = bl8 = iDeserializer.getBool();
            uGDODestinationReached.softkey10 = bl7 = iDeserializer.getBool();
            uGDODestinationReached.softkey11 = bl6 = iDeserializer.getBool();
            uGDODestinationReached.softkey12 = bl5 = iDeserializer.getBool();
            uGDODestinationReached.softkey13 = bl4 = iDeserializer.getBool();
            uGDODestinationReached.softkey14 = bl3 = iDeserializer.getBool();
            uGDODestinationReached.softkey15 = bl2 = iDeserializer.getBool();
        }
        return uGDODestinationReached;
    }

    public static UGDODestinationReached[] getOptionalUGDODestinationReachedVarArray(IDeserializer iDeserializer) {
        UGDODestinationReached[] uGDODestinationReachedArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            uGDODestinationReachedArray = new UGDODestinationReached[n];
            for (int i2 = 0; i2 < n; ++i2) {
                uGDODestinationReachedArray[i2] = UGDODestinationReachedSerializer.getOptionalUGDODestinationReached(iDeserializer);
            }
        }
        return uGDODestinationReachedArray;
    }
}

