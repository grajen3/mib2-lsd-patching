/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl;

import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.TransferState;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class TransferStateSerializer {
    public static void putOptionalTransferState(ISerializer iSerializer, TransferState transferState) {
        boolean bl = transferState == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = transferState.getState();
            iSerializer.putInt32(n);
            String string = transferState.getDeviceId();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalTransferStateVarArray(ISerializer iSerializer, TransferState[] transferStateArray) {
        boolean bl = transferStateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(transferStateArray.length);
            for (int i2 = 0; i2 < transferStateArray.length; ++i2) {
                TransferStateSerializer.putOptionalTransferState(iSerializer, transferStateArray[i2]);
            }
        }
    }

    public static TransferState getOptionalTransferState(IDeserializer iDeserializer) {
        TransferState transferState = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            int n;
            transferState = new TransferState();
            transferState.state = n = iDeserializer.getInt32();
            transferState.deviceId = string = iDeserializer.getOptionalString();
        }
        return transferState;
    }

    public static TransferState[] getOptionalTransferStateVarArray(IDeserializer iDeserializer) {
        TransferState[] transferStateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            transferStateArray = new TransferState[n];
            for (int i2 = 0; i2 < n; ++i2) {
                transferStateArray[i2] = TransferStateSerializer.getOptionalTransferState(iDeserializer);
            }
        }
        return transferStateArray;
    }
}

