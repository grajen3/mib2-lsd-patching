/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephone.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.telephone.SIMAliasInformation;

public class SIMAliasInformationSerializer {
    public static void putOptionalSIMAliasInformation(ISerializer iSerializer, SIMAliasInformation sIMAliasInformation) {
        boolean bl = sIMAliasInformation == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = sIMAliasInformation.getBtAddress();
            iSerializer.putOptionalString(string);
            String string2 = sIMAliasInformation.getImsi();
            iSerializer.putOptionalString(string2);
            String string3 = sIMAliasInformation.getActiveName();
            iSerializer.putOptionalString(string3);
            String string4 = sIMAliasInformation.getInactiveName();
            iSerializer.putOptionalString(string4);
        }
    }

    public static void putOptionalSIMAliasInformationVarArray(ISerializer iSerializer, SIMAliasInformation[] sIMAliasInformationArray) {
        boolean bl = sIMAliasInformationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sIMAliasInformationArray.length);
            for (int i2 = 0; i2 < sIMAliasInformationArray.length; ++i2) {
                SIMAliasInformationSerializer.putOptionalSIMAliasInformation(iSerializer, sIMAliasInformationArray[i2]);
            }
        }
    }

    public static SIMAliasInformation getOptionalSIMAliasInformation(IDeserializer iDeserializer) {
        SIMAliasInformation sIMAliasInformation = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            String string3;
            String string4;
            sIMAliasInformation = new SIMAliasInformation();
            sIMAliasInformation.btAddress = string4 = iDeserializer.getOptionalString();
            sIMAliasInformation.imsi = string3 = iDeserializer.getOptionalString();
            sIMAliasInformation.activeName = string2 = iDeserializer.getOptionalString();
            sIMAliasInformation.inactiveName = string = iDeserializer.getOptionalString();
        }
        return sIMAliasInformation;
    }

    public static SIMAliasInformation[] getOptionalSIMAliasInformationVarArray(IDeserializer iDeserializer) {
        SIMAliasInformation[] sIMAliasInformationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sIMAliasInformationArray = new SIMAliasInformation[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sIMAliasInformationArray[i2] = SIMAliasInformationSerializer.getOptionalSIMAliasInformation(iDeserializer);
            }
        }
        return sIMAliasInformationArray;
    }
}

