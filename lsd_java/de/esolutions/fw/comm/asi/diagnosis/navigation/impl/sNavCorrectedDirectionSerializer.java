/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.navigation.impl;

import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCorrectedDirection;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sNavCorrectedDirectionSerializer {
    public static void putOptionalsNavCorrectedDirection(ISerializer iSerializer, sNavCorrectedDirection sNavCorrectedDirection2) {
        boolean bl = sNavCorrectedDirection2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sNavCorrectedDirection2.getMsg_id();
            iSerializer.putUInt32(l);
            int n = sNavCorrectedDirection2.getDirectionCorrected();
            iSerializer.putUInt16(n);
            boolean bl2 = sNavCorrectedDirection2.isStatusOK();
            iSerializer.putBool(bl2);
        }
    }

    public static void putOptionalsNavCorrectedDirectionVarArray(ISerializer iSerializer, sNavCorrectedDirection[] sNavCorrectedDirectionArray) {
        boolean bl = sNavCorrectedDirectionArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sNavCorrectedDirectionArray.length);
            for (int i2 = 0; i2 < sNavCorrectedDirectionArray.length; ++i2) {
                sNavCorrectedDirectionSerializer.putOptionalsNavCorrectedDirection(iSerializer, sNavCorrectedDirectionArray[i2]);
            }
        }
    }

    public static sNavCorrectedDirection getOptionalsNavCorrectedDirection(IDeserializer iDeserializer) {
        sNavCorrectedDirection sNavCorrectedDirection2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            int n;
            long l;
            sNavCorrectedDirection2 = new sNavCorrectedDirection();
            sNavCorrectedDirection2.msg_id = l = iDeserializer.getUInt32();
            sNavCorrectedDirection2.directionCorrected = n = iDeserializer.getUInt16();
            sNavCorrectedDirection2.statusOK = bl2 = iDeserializer.getBool();
        }
        return sNavCorrectedDirection2;
    }

    public static sNavCorrectedDirection[] getOptionalsNavCorrectedDirectionVarArray(IDeserializer iDeserializer) {
        sNavCorrectedDirection[] sNavCorrectedDirectionArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sNavCorrectedDirectionArray = new sNavCorrectedDirection[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sNavCorrectedDirectionArray[i2] = sNavCorrectedDirectionSerializer.getOptionalsNavCorrectedDirection(iDeserializer);
            }
        }
        return sNavCorrectedDirectionArray;
    }
}

