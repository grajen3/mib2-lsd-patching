/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithOptionMask;

public class CharismaSetupTableWithOptionMaskSerializer {
    public static void putOptionalCharismaSetupTableWithOptionMask(ISerializer iSerializer, CharismaSetupTableWithOptionMask charismaSetupTableWithOptionMask) {
        boolean bl = charismaSetupTableWithOptionMask == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = charismaSetupTableWithOptionMask.getListPosition();
            iSerializer.putInt32(n);
            int n2 = charismaSetupTableWithOptionMask.getFunctionID();
            iSerializer.putInt32(n2);
            int n3 = charismaSetupTableWithOptionMask.getMask();
            iSerializer.putInt32(n3);
            int n4 = charismaSetupTableWithOptionMask.getSetupValue();
            iSerializer.putInt32(n4);
        }
    }

    public static void putOptionalCharismaSetupTableWithOptionMaskVarArray(ISerializer iSerializer, CharismaSetupTableWithOptionMask[] charismaSetupTableWithOptionMaskArray) {
        boolean bl = charismaSetupTableWithOptionMaskArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(charismaSetupTableWithOptionMaskArray.length);
            for (int i2 = 0; i2 < charismaSetupTableWithOptionMaskArray.length; ++i2) {
                CharismaSetupTableWithOptionMaskSerializer.putOptionalCharismaSetupTableWithOptionMask(iSerializer, charismaSetupTableWithOptionMaskArray[i2]);
            }
        }
    }

    public static CharismaSetupTableWithOptionMask getOptionalCharismaSetupTableWithOptionMask(IDeserializer iDeserializer) {
        CharismaSetupTableWithOptionMask charismaSetupTableWithOptionMask = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            charismaSetupTableWithOptionMask = new CharismaSetupTableWithOptionMask();
            charismaSetupTableWithOptionMask.listPosition = n4 = iDeserializer.getInt32();
            charismaSetupTableWithOptionMask.functionID = n3 = iDeserializer.getInt32();
            charismaSetupTableWithOptionMask.mask = n2 = iDeserializer.getInt32();
            charismaSetupTableWithOptionMask.setupValue = n = iDeserializer.getInt32();
        }
        return charismaSetupTableWithOptionMask;
    }

    public static CharismaSetupTableWithOptionMask[] getOptionalCharismaSetupTableWithOptionMaskVarArray(IDeserializer iDeserializer) {
        CharismaSetupTableWithOptionMask[] charismaSetupTableWithOptionMaskArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            charismaSetupTableWithOptionMaskArray = new CharismaSetupTableWithOptionMask[n];
            for (int i2 = 0; i2 < n; ++i2) {
                charismaSetupTableWithOptionMaskArray[i2] = CharismaSetupTableWithOptionMaskSerializer.getOptionalCharismaSetupTableWithOptionMask(iDeserializer);
            }
        }
        return charismaSetupTableWithOptionMaskArray;
    }
}

