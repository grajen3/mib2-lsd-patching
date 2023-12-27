/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlOperationMessages;

public class SuspensionControlOperationMessagesSerializer {
    public static void putOptionalSuspensionControlOperationMessages(ISerializer iSerializer, SuspensionControlOperationMessages suspensionControlOperationMessages) {
        boolean bl = suspensionControlOperationMessages == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = suspensionControlOperationMessages.getFailureReason();
            iSerializer.putInt32(n);
            int n2 = suspensionControlOperationMessages.getSelectionConfirmation();
            iSerializer.putInt32(n2);
            int n3 = suspensionControlOperationMessages.getProcessFinished();
            iSerializer.putInt32(n3);
            int n4 = suspensionControlOperationMessages.getRegulation();
            iSerializer.putInt32(n4);
        }
    }

    public static void putOptionalSuspensionControlOperationMessagesVarArray(ISerializer iSerializer, SuspensionControlOperationMessages[] suspensionControlOperationMessagesArray) {
        boolean bl = suspensionControlOperationMessagesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(suspensionControlOperationMessagesArray.length);
            for (int i2 = 0; i2 < suspensionControlOperationMessagesArray.length; ++i2) {
                SuspensionControlOperationMessagesSerializer.putOptionalSuspensionControlOperationMessages(iSerializer, suspensionControlOperationMessagesArray[i2]);
            }
        }
    }

    public static SuspensionControlOperationMessages getOptionalSuspensionControlOperationMessages(IDeserializer iDeserializer) {
        SuspensionControlOperationMessages suspensionControlOperationMessages = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            suspensionControlOperationMessages = new SuspensionControlOperationMessages();
            suspensionControlOperationMessages.failureReason = n4 = iDeserializer.getInt32();
            suspensionControlOperationMessages.selectionConfirmation = n3 = iDeserializer.getInt32();
            suspensionControlOperationMessages.processFinished = n2 = iDeserializer.getInt32();
            suspensionControlOperationMessages.regulation = n = iDeserializer.getInt32();
        }
        return suspensionControlOperationMessages;
    }

    public static SuspensionControlOperationMessages[] getOptionalSuspensionControlOperationMessagesVarArray(IDeserializer iDeserializer) {
        SuspensionControlOperationMessages[] suspensionControlOperationMessagesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            suspensionControlOperationMessagesArray = new SuspensionControlOperationMessages[n];
            for (int i2 = 0; i2 < n; ++i2) {
                suspensionControlOperationMessagesArray[i2] = SuspensionControlOperationMessagesSerializer.getOptionalSuspensionControlOperationMessages(iDeserializer);
            }
        }
        return suspensionControlOperationMessagesArray;
    }
}

