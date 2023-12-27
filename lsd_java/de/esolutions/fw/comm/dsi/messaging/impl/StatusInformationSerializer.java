/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.messaging.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.messaging.StatusInformation;

public class StatusInformationSerializer {
    public static void putOptionalStatusInformation(ISerializer iSerializer, StatusInformation statusInformation) {
        boolean bl = statusInformation == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = statusInformation.getMessageId();
            iSerializer.putOptionalString(string);
            int n = statusInformation.getStatus();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalStatusInformationVarArray(ISerializer iSerializer, StatusInformation[] statusInformationArray) {
        boolean bl = statusInformationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(statusInformationArray.length);
            for (int i2 = 0; i2 < statusInformationArray.length; ++i2) {
                StatusInformationSerializer.putOptionalStatusInformation(iSerializer, statusInformationArray[i2]);
            }
        }
    }

    public static StatusInformation getOptionalStatusInformation(IDeserializer iDeserializer) {
        StatusInformation statusInformation = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            String string;
            statusInformation = new StatusInformation();
            statusInformation.messageId = string = iDeserializer.getOptionalString();
            statusInformation.status = n = iDeserializer.getInt32();
        }
        return statusInformation;
    }

    public static StatusInformation[] getOptionalStatusInformationVarArray(IDeserializer iDeserializer) {
        StatusInformation[] statusInformationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            statusInformationArray = new StatusInformation[n];
            for (int i2 = 0; i2 < n; ++i2) {
                statusInformationArray[i2] = StatusInformationSerializer.getOptionalStatusInformation(iDeserializer);
            }
        }
        return statusInformationArray;
    }
}

