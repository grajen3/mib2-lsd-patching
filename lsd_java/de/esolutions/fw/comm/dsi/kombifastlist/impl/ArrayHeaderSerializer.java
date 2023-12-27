/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombifastlist.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombifastlist.ArrayHeader;

public class ArrayHeaderSerializer {
    public static void putOptionalArrayHeader(ISerializer iSerializer, ArrayHeader arrayHeader) {
        boolean bl = arrayHeader == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = arrayHeader.getMode();
            iSerializer.putInt32(n);
            int n2 = arrayHeader.getRecordAddress();
            iSerializer.putInt32(n2);
            long l = arrayHeader.getStart();
            iSerializer.putInt64(l);
            int n3 = arrayHeader.getRelativeJump();
            iSerializer.putInt32(n3);
            int n4 = arrayHeader.getElements();
            iSerializer.putInt32(n4);
            int n5 = arrayHeader.getAbsoluteListPos();
            iSerializer.putInt32(n5);
            int n6 = arrayHeader.getJobModification();
            iSerializer.putInt32(n6);
            int n7 = arrayHeader.getJobID();
            iSerializer.putInt32(n7);
            int n8 = arrayHeader.getJobPriority();
            iSerializer.putInt32(n8);
        }
    }

    public static void putOptionalArrayHeaderVarArray(ISerializer iSerializer, ArrayHeader[] arrayHeaderArray) {
        boolean bl = arrayHeaderArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(arrayHeaderArray.length);
            for (int i2 = 0; i2 < arrayHeaderArray.length; ++i2) {
                ArrayHeaderSerializer.putOptionalArrayHeader(iSerializer, arrayHeaderArray[i2]);
            }
        }
    }

    public static ArrayHeader getOptionalArrayHeader(IDeserializer iDeserializer) {
        ArrayHeader arrayHeader = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            long l;
            int n7;
            int n8;
            arrayHeader = new ArrayHeader();
            arrayHeader.mode = n8 = iDeserializer.getInt32();
            arrayHeader.recordAddress = n7 = iDeserializer.getInt32();
            arrayHeader.start = l = iDeserializer.getInt64();
            arrayHeader.relativeJump = n6 = iDeserializer.getInt32();
            arrayHeader.elements = n5 = iDeserializer.getInt32();
            arrayHeader.absoluteListPos = n4 = iDeserializer.getInt32();
            arrayHeader.jobModification = n3 = iDeserializer.getInt32();
            arrayHeader.jobID = n2 = iDeserializer.getInt32();
            arrayHeader.jobPriority = n = iDeserializer.getInt32();
        }
        return arrayHeader;
    }

    public static ArrayHeader[] getOptionalArrayHeaderVarArray(IDeserializer iDeserializer) {
        ArrayHeader[] arrayHeaderArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            arrayHeaderArray = new ArrayHeader[n];
            for (int i2 = 0; i2 < n; ++i2) {
                arrayHeaderArray[i2] = ArrayHeaderSerializer.getOptionalArrayHeader(iDeserializer);
            }
        }
        return arrayHeaderArray;
    }
}

