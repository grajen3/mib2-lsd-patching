/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.speechrec.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.speechrec.NBestSlot;

public class NBestSlotSerializer {
    public static void putOptionalNBestSlot(ISerializer iSerializer, NBestSlot nBestSlot) {
        boolean bl = nBestSlot == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = nBestSlot.getId();
            iSerializer.putInt32(n);
            String string = nBestSlot.getRecognizedString();
            iSerializer.putOptionalString(string);
            long l = nBestSlot.getObjectId();
            iSerializer.putInt64(l);
            int n2 = nBestSlot.getIndex();
            iSerializer.putInt32(n2);
            String string2 = nBestSlot.getObjectStringId();
            iSerializer.putOptionalString(string2);
        }
    }

    public static void putOptionalNBestSlotVarArray(ISerializer iSerializer, NBestSlot[] nBestSlotArray) {
        boolean bl = nBestSlotArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(nBestSlotArray.length);
            for (int i2 = 0; i2 < nBestSlotArray.length; ++i2) {
                NBestSlotSerializer.putOptionalNBestSlot(iSerializer, nBestSlotArray[i2]);
            }
        }
    }

    public static NBestSlot getOptionalNBestSlot(IDeserializer iDeserializer) {
        NBestSlot nBestSlot = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            int n;
            long l;
            String string2;
            int n2;
            nBestSlot = new NBestSlot();
            nBestSlot.id = n2 = iDeserializer.getInt32();
            nBestSlot.recognizedString = string2 = iDeserializer.getOptionalString();
            nBestSlot.objectId = l = iDeserializer.getInt64();
            nBestSlot.index = n = iDeserializer.getInt32();
            nBestSlot.objectStringId = string = iDeserializer.getOptionalString();
        }
        return nBestSlot;
    }

    public static NBestSlot[] getOptionalNBestSlotVarArray(IDeserializer iDeserializer) {
        NBestSlot[] nBestSlotArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            nBestSlotArray = new NBestSlot[n];
            for (int i2 = 0; i2 < n; ++i2) {
                nBestSlotArray[i2] = NBestSlotSerializer.getOptionalNBestSlot(iDeserializer);
            }
        }
        return nBestSlotArray;
    }
}

