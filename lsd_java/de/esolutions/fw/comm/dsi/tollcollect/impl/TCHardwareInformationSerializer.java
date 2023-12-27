/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tollcollect.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.tollcollect.TCHardwareInformation;

public class TCHardwareInformationSerializer {
    public static void putOptionalTCHardwareInformation(ISerializer iSerializer, TCHardwareInformation tCHardwareInformation) {
        boolean bl = tCHardwareInformation == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = tCHardwareInformation.getKey();
            iSerializer.putInt32(n);
            String string = tCHardwareInformation.getValue();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalTCHardwareInformationVarArray(ISerializer iSerializer, TCHardwareInformation[] tCHardwareInformationArray) {
        boolean bl = tCHardwareInformationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(tCHardwareInformationArray.length);
            for (int i2 = 0; i2 < tCHardwareInformationArray.length; ++i2) {
                TCHardwareInformationSerializer.putOptionalTCHardwareInformation(iSerializer, tCHardwareInformationArray[i2]);
            }
        }
    }

    public static TCHardwareInformation getOptionalTCHardwareInformation(IDeserializer iDeserializer) {
        TCHardwareInformation tCHardwareInformation = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            int n;
            tCHardwareInformation = new TCHardwareInformation();
            tCHardwareInformation.key = n = iDeserializer.getInt32();
            tCHardwareInformation.value = string = iDeserializer.getOptionalString();
        }
        return tCHardwareInformation;
    }

    public static TCHardwareInformation[] getOptionalTCHardwareInformationVarArray(IDeserializer iDeserializer) {
        TCHardwareInformation[] tCHardwareInformationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            tCHardwareInformationArray = new TCHardwareInformation[n];
            for (int i2 = 0; i2 < n; ++i2) {
                tCHardwareInformationArray[i2] = TCHardwareInformationSerializer.getOptionalTCHardwareInformation(iDeserializer);
            }
        }
        return tCHardwareInformationArray;
    }
}

