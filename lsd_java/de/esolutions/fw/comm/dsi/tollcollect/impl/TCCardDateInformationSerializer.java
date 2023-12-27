/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tollcollect.impl;

import de.esolutions.fw.comm.dsi.global.impl.DateTimeSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.tollcollect.TCCardDateInformation;

public class TCCardDateInformationSerializer {
    public static void putOptionalTCCardDateInformation(ISerializer iSerializer, TCCardDateInformation tCCardDateInformation) {
        boolean bl = tCCardDateInformation == null;
        iSerializer.putBool(bl);
        if (!bl) {
            DateTime dateTime = tCCardDateInformation.getExpirationDate();
            DateTimeSerializer.putOptionalDateTime(iSerializer, dateTime);
            DateTime dateTime2 = tCCardDateInformation.getIssueDate();
            DateTimeSerializer.putOptionalDateTime(iSerializer, dateTime2);
        }
    }

    public static void putOptionalTCCardDateInformationVarArray(ISerializer iSerializer, TCCardDateInformation[] tCCardDateInformationArray) {
        boolean bl = tCCardDateInformationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(tCCardDateInformationArray.length);
            for (int i2 = 0; i2 < tCCardDateInformationArray.length; ++i2) {
                TCCardDateInformationSerializer.putOptionalTCCardDateInformation(iSerializer, tCCardDateInformationArray[i2]);
            }
        }
    }

    public static TCCardDateInformation getOptionalTCCardDateInformation(IDeserializer iDeserializer) {
        TCCardDateInformation tCCardDateInformation = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            DateTime dateTime;
            DateTime dateTime2;
            tCCardDateInformation = new TCCardDateInformation();
            tCCardDateInformation.expirationDate = dateTime2 = DateTimeSerializer.getOptionalDateTime(iDeserializer);
            tCCardDateInformation.issueDate = dateTime = DateTimeSerializer.getOptionalDateTime(iDeserializer);
        }
        return tCCardDateInformation;
    }

    public static TCCardDateInformation[] getOptionalTCCardDateInformationVarArray(IDeserializer iDeserializer) {
        TCCardDateInformation[] tCCardDateInformationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            tCCardDateInformationArray = new TCCardDateInformation[n];
            for (int i2 = 0; i2 < n; ++i2) {
                tCCardDateInformationArray[i2] = TCCardDateInformationSerializer.getOptionalTCCardDateInformation(iDeserializer);
            }
        }
        return tCCardDateInformationArray;
    }
}

