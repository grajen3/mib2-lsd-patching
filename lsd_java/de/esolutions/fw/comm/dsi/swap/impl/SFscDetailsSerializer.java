/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.swap.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.swap.SFscDetails;

public class SFscDetailsSerializer {
    public static void putOptionalSFscDetails(ISerializer iSerializer, SFscDetails sFscDetails) {
        boolean bl = sFscDetails == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = sFscDetails.getSwid();
            iSerializer.putInt32(n);
            int n2 = sFscDetails.getState();
            iSerializer.putInt32(n2);
            int n3 = sFscDetails.getIndex();
            iSerializer.putInt32(n3);
            short s = sFscDetails.getVersion();
            iSerializer.putInt16(s);
            String string = sFscDetails.getVin();
            iSerializer.putOptionalString(string);
            String string2 = sFscDetails.getDate();
            iSerializer.putOptionalString(string2);
            String string3 = sFscDetails.getVcrn();
            iSerializer.putOptionalString(string3);
        }
    }

    public static void putOptionalSFscDetailsVarArray(ISerializer iSerializer, SFscDetails[] sFscDetailsArray) {
        boolean bl = sFscDetailsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sFscDetailsArray.length);
            for (int i2 = 0; i2 < sFscDetailsArray.length; ++i2) {
                SFscDetailsSerializer.putOptionalSFscDetails(iSerializer, sFscDetailsArray[i2]);
            }
        }
    }

    public static SFscDetails getOptionalSFscDetails(IDeserializer iDeserializer) {
        SFscDetails sFscDetails = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            String string3;
            short s;
            int n;
            int n2;
            int n3;
            sFscDetails = new SFscDetails();
            sFscDetails.swid = n3 = iDeserializer.getInt32();
            sFscDetails.state = n2 = iDeserializer.getInt32();
            sFscDetails.index = n = iDeserializer.getInt32();
            sFscDetails.version = s = iDeserializer.getInt16();
            sFscDetails.vin = string3 = iDeserializer.getOptionalString();
            sFscDetails.date = string2 = iDeserializer.getOptionalString();
            sFscDetails.vcrn = string = iDeserializer.getOptionalString();
        }
        return sFscDetails;
    }

    public static SFscDetails[] getOptionalSFscDetailsVarArray(IDeserializer iDeserializer) {
        SFscDetails[] sFscDetailsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sFscDetailsArray = new SFscDetails[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sFscDetailsArray[i2] = SFscDetailsSerializer.getOptionalSFscDetails(iDeserializer);
            }
        }
        return sFscDetailsArray;
    }
}

