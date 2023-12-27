/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec.impl;

import de.esolutions.fw.comm.asi.fec.SFecDetails;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class SFecDetailsSerializer {
    public static void putOptionalSFecDetails(ISerializer iSerializer, SFecDetails sFecDetails) {
        boolean bl = sFecDetails == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sFecDetails.getFsid();
            iSerializer.putUInt32(l);
            long l2 = sFecDetails.getIndex();
            iSerializer.putUInt32(l2);
            int n = sFecDetails.getState();
            iSerializer.putEnum(n);
            short s = sFecDetails.getVersion();
            iSerializer.putUInt8(s);
            String string = sFecDetails.getVin();
            iSerializer.putOptionalString(string);
            String string2 = sFecDetails.getVcrn();
            iSerializer.putOptionalString(string2);
            String string3 = sFecDetails.getDate();
            iSerializer.putOptionalString(string3);
        }
    }

    public static void putOptionalSFecDetailsVarArray(ISerializer iSerializer, SFecDetails[] sFecDetailsArray) {
        boolean bl = sFecDetailsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sFecDetailsArray.length);
            for (int i2 = 0; i2 < sFecDetailsArray.length; ++i2) {
                SFecDetailsSerializer.putOptionalSFecDetails(iSerializer, sFecDetailsArray[i2]);
            }
        }
    }

    public static SFecDetails getOptionalSFecDetails(IDeserializer iDeserializer) {
        SFecDetails sFecDetails = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            String string3;
            short s;
            int n;
            long l;
            long l2;
            sFecDetails = new SFecDetails();
            sFecDetails.fsid = l2 = iDeserializer.getUInt32();
            sFecDetails.index = l = iDeserializer.getUInt32();
            sFecDetails.state = n = iDeserializer.getEnum();
            sFecDetails.version = s = iDeserializer.getUInt8();
            sFecDetails.vin = string3 = iDeserializer.getOptionalString();
            sFecDetails.vcrn = string2 = iDeserializer.getOptionalString();
            sFecDetails.date = string = iDeserializer.getOptionalString();
        }
        return sFecDetails;
    }

    public static SFecDetails[] getOptionalSFecDetailsVarArray(IDeserializer iDeserializer) {
        SFecDetails[] sFecDetailsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sFecDetailsArray = new SFecDetails[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sFecDetailsArray[i2] = SFecDetailsSerializer.getOptionalSFecDetails(iDeserializer);
            }
        }
        return sFecDetailsArray;
    }
}

