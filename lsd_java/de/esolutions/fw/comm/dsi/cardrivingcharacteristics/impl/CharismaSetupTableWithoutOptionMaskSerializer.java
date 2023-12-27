/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask;

public class CharismaSetupTableWithoutOptionMaskSerializer {
    public static void putOptionalCharismaSetupTableWithoutOptionMask(ISerializer iSerializer, CharismaSetupTableWithoutOptionMask charismaSetupTableWithoutOptionMask) {
        boolean bl = charismaSetupTableWithoutOptionMask == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = charismaSetupTableWithoutOptionMask.getListPosition();
            iSerializer.putInt32(n);
            int n2 = charismaSetupTableWithoutOptionMask.getFunctionID();
            iSerializer.putInt32(n2);
            int n3 = charismaSetupTableWithoutOptionMask.getSetupValue();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalCharismaSetupTableWithoutOptionMaskVarArray(ISerializer iSerializer, CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray) {
        boolean bl = charismaSetupTableWithoutOptionMaskArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(charismaSetupTableWithoutOptionMaskArray.length);
            for (int i2 = 0; i2 < charismaSetupTableWithoutOptionMaskArray.length; ++i2) {
                CharismaSetupTableWithoutOptionMaskSerializer.putOptionalCharismaSetupTableWithoutOptionMask(iSerializer, charismaSetupTableWithoutOptionMaskArray[i2]);
            }
        }
    }

    public static CharismaSetupTableWithoutOptionMask getOptionalCharismaSetupTableWithoutOptionMask(IDeserializer iDeserializer) {
        CharismaSetupTableWithoutOptionMask charismaSetupTableWithoutOptionMask = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            charismaSetupTableWithoutOptionMask = new CharismaSetupTableWithoutOptionMask();
            charismaSetupTableWithoutOptionMask.listPosition = n3 = iDeserializer.getInt32();
            charismaSetupTableWithoutOptionMask.functionID = n2 = iDeserializer.getInt32();
            charismaSetupTableWithoutOptionMask.setupValue = n = iDeserializer.getInt32();
        }
        return charismaSetupTableWithoutOptionMask;
    }

    public static CharismaSetupTableWithoutOptionMask[] getOptionalCharismaSetupTableWithoutOptionMaskVarArray(IDeserializer iDeserializer) {
        CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            charismaSetupTableWithoutOptionMaskArray = new CharismaSetupTableWithoutOptionMask[n];
            for (int i2 = 0; i2 < n; ++i2) {
                charismaSetupTableWithoutOptionMaskArray[i2] = CharismaSetupTableWithoutOptionMaskSerializer.getOptionalCharismaSetupTableWithoutOptionMask(iDeserializer);
            }
        }
        return charismaSetupTableWithoutOptionMaskArray;
    }
}

