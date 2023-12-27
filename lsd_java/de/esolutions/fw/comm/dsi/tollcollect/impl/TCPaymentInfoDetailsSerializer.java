/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tollcollect.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.tollcollect.TCPaymentInfoDetails;

public class TCPaymentInfoDetailsSerializer {
    public static void putOptionalTCPaymentInfoDetails(ISerializer iSerializer, TCPaymentInfoDetails tCPaymentInfoDetails) {
        boolean bl = tCPaymentInfoDetails == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = tCPaymentInfoDetails.getEntranceMotorwayName();
            iSerializer.putOptionalString(string);
            String string2 = tCPaymentInfoDetails.getEntranceIC();
            iSerializer.putOptionalString(string2);
            String string3 = tCPaymentInfoDetails.getExitMotorwayName();
            iSerializer.putOptionalString(string3);
            String string4 = tCPaymentInfoDetails.getExitIC();
            iSerializer.putOptionalString(string4);
            boolean bl2 = tCPaymentInfoDetails.isIsFlatRate();
            iSerializer.putBool(bl2);
        }
    }

    public static void putOptionalTCPaymentInfoDetailsVarArray(ISerializer iSerializer, TCPaymentInfoDetails[] tCPaymentInfoDetailsArray) {
        boolean bl = tCPaymentInfoDetailsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(tCPaymentInfoDetailsArray.length);
            for (int i2 = 0; i2 < tCPaymentInfoDetailsArray.length; ++i2) {
                TCPaymentInfoDetailsSerializer.putOptionalTCPaymentInfoDetails(iSerializer, tCPaymentInfoDetailsArray[i2]);
            }
        }
    }

    public static TCPaymentInfoDetails getOptionalTCPaymentInfoDetails(IDeserializer iDeserializer) {
        TCPaymentInfoDetails tCPaymentInfoDetails = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            String string;
            String string2;
            String string3;
            String string4;
            tCPaymentInfoDetails = new TCPaymentInfoDetails();
            tCPaymentInfoDetails.entranceMotorwayName = string4 = iDeserializer.getOptionalString();
            tCPaymentInfoDetails.entranceIC = string3 = iDeserializer.getOptionalString();
            tCPaymentInfoDetails.exitMotorwayName = string2 = iDeserializer.getOptionalString();
            tCPaymentInfoDetails.exitIC = string = iDeserializer.getOptionalString();
            tCPaymentInfoDetails.isFlatRate = bl2 = iDeserializer.getBool();
        }
        return tCPaymentInfoDetails;
    }

    public static TCPaymentInfoDetails[] getOptionalTCPaymentInfoDetailsVarArray(IDeserializer iDeserializer) {
        TCPaymentInfoDetails[] tCPaymentInfoDetailsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            tCPaymentInfoDetailsArray = new TCPaymentInfoDetails[n];
            for (int i2 = 0; i2 < n; ++i2) {
                tCPaymentInfoDetailsArray[i2] = TCPaymentInfoDetailsSerializer.getOptionalTCPaymentInfoDetails(iDeserializer);
            }
        }
        return tCPaymentInfoDetailsArray;
    }
}

