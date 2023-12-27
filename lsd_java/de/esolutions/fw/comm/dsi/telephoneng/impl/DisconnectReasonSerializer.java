/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephoneng.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.telephoneng.DisconnectReason;

public class DisconnectReasonSerializer {
    public static void putOptionalDisconnectReason(ISerializer iSerializer, DisconnectReason disconnectReason) {
        boolean bl = disconnectReason == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = disconnectReason.getDisconnectReason();
            iSerializer.putInt32(n);
            int n2 = disconnectReason.getCallId();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalDisconnectReasonVarArray(ISerializer iSerializer, DisconnectReason[] disconnectReasonArray) {
        boolean bl = disconnectReasonArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(disconnectReasonArray.length);
            for (int i2 = 0; i2 < disconnectReasonArray.length; ++i2) {
                DisconnectReasonSerializer.putOptionalDisconnectReason(iSerializer, disconnectReasonArray[i2]);
            }
        }
    }

    public static DisconnectReason getOptionalDisconnectReason(IDeserializer iDeserializer) {
        DisconnectReason disconnectReason = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            disconnectReason = new DisconnectReason();
            disconnectReason.disconnectReason = n2 = iDeserializer.getInt32();
            disconnectReason.callId = n = iDeserializer.getInt32();
        }
        return disconnectReason;
    }

    public static DisconnectReason[] getOptionalDisconnectReasonVarArray(IDeserializer iDeserializer) {
        DisconnectReason[] disconnectReasonArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            disconnectReasonArray = new DisconnectReason[n];
            for (int i2 = 0; i2 < n; ++i2) {
                disconnectReasonArray[i2] = DisconnectReasonSerializer.getOptionalDisconnectReason(iDeserializer);
            }
        }
        return disconnectReasonArray;
    }
}

