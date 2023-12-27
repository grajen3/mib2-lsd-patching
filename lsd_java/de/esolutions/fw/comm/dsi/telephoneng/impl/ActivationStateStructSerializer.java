/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephoneng.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.telephoneng.ActivationStateStruct;

public class ActivationStateStructSerializer {
    public static void putOptionalActivationStateStruct(ISerializer iSerializer, ActivationStateStruct activationStateStruct) {
        boolean bl = activationStateStruct == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = activationStateStruct.getTelActivationState();
            iSerializer.putInt32(n);
            int n2 = activationStateStruct.getTelPhoneModuleState();
            iSerializer.putInt32(n2);
            int n3 = activationStateStruct.getTelMode();
            iSerializer.putInt32(n3);
            short s = activationStateStruct.getTelFeat();
            iSerializer.putInt16(s);
            String string = activationStateStruct.getTelHFPVersion();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalActivationStateStructVarArray(ISerializer iSerializer, ActivationStateStruct[] activationStateStructArray) {
        boolean bl = activationStateStructArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(activationStateStructArray.length);
            for (int i2 = 0; i2 < activationStateStructArray.length; ++i2) {
                ActivationStateStructSerializer.putOptionalActivationStateStruct(iSerializer, activationStateStructArray[i2]);
            }
        }
    }

    public static ActivationStateStruct getOptionalActivationStateStruct(IDeserializer iDeserializer) {
        ActivationStateStruct activationStateStruct = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            short s;
            int n;
            int n2;
            int n3;
            activationStateStruct = new ActivationStateStruct();
            activationStateStruct.telActivationState = n3 = iDeserializer.getInt32();
            activationStateStruct.telPhoneModuleState = n2 = iDeserializer.getInt32();
            activationStateStruct.telMode = n = iDeserializer.getInt32();
            activationStateStruct.telFeat = s = iDeserializer.getInt16();
            activationStateStruct.telHFPVersion = string = iDeserializer.getOptionalString();
        }
        return activationStateStruct;
    }

    public static ActivationStateStruct[] getOptionalActivationStateStructVarArray(IDeserializer iDeserializer) {
        ActivationStateStruct[] activationStateStructArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            activationStateStructArray = new ActivationStateStruct[n];
            for (int i2 = 0; i2 < n; ++i2) {
                activationStateStructArray[i2] = ActivationStateStructSerializer.getOptionalActivationStateStruct(iDeserializer);
            }
        }
        return activationStateStructArray;
    }
}

