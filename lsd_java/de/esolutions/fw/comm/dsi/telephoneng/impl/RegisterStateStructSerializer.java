/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephoneng.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.telephoneng.RegisterStateStruct;

public class RegisterStateStructSerializer {
    public static void putOptionalRegisterStateStruct(ISerializer iSerializer, RegisterStateStruct registerStateStruct) {
        boolean bl = registerStateStruct == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = registerStateStruct.getTelRegisterState();
            iSerializer.putInt32(n);
            String string = registerStateStruct.getTelLongProviderName();
            iSerializer.putOptionalString(string);
            String string2 = registerStateStruct.getTelNumProviderName();
            iSerializer.putOptionalString(string2);
            int n2 = registerStateStruct.getTelRegMode();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalRegisterStateStructVarArray(ISerializer iSerializer, RegisterStateStruct[] registerStateStructArray) {
        boolean bl = registerStateStructArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(registerStateStructArray.length);
            for (int i2 = 0; i2 < registerStateStructArray.length; ++i2) {
                RegisterStateStructSerializer.putOptionalRegisterStateStruct(iSerializer, registerStateStructArray[i2]);
            }
        }
    }

    public static RegisterStateStruct getOptionalRegisterStateStruct(IDeserializer iDeserializer) {
        RegisterStateStruct registerStateStruct = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            String string;
            String string2;
            int n2;
            registerStateStruct = new RegisterStateStruct();
            registerStateStruct.telRegisterState = n2 = iDeserializer.getInt32();
            registerStateStruct.telLongProviderName = string2 = iDeserializer.getOptionalString();
            registerStateStruct.telNumProviderName = string = iDeserializer.getOptionalString();
            registerStateStruct.telRegMode = n = iDeserializer.getInt32();
        }
        return registerStateStruct;
    }

    public static RegisterStateStruct[] getOptionalRegisterStateStructVarArray(IDeserializer iDeserializer) {
        RegisterStateStruct[] registerStateStructArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            registerStateStructArray = new RegisterStateStruct[n];
            for (int i2 = 0; i2 < n; ++i2) {
                registerStateStructArray[i2] = RegisterStateStructSerializer.getOptionalRegisterStateStruct(iDeserializer);
            }
        }
        return registerStateStructArray;
    }
}

