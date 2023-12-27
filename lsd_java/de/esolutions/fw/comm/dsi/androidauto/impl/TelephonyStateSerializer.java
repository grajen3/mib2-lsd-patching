/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.androidauto.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.androidauto.TelephonyState;

public class TelephonyStateSerializer {
    public static void putOptionalTelephonyState(ISerializer iSerializer, TelephonyState telephonyState) {
        boolean bl = telephonyState == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = telephonyState.getSignalStrength();
            iSerializer.putInt32(n);
            int n2 = telephonyState.getRegistrationStatus();
            iSerializer.putInt32(n2);
            boolean bl2 = telephonyState.isAirplaneMode();
            iSerializer.putBool(bl2);
            String string = telephonyState.getMobileOperator();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalTelephonyStateVarArray(ISerializer iSerializer, TelephonyState[] telephonyStateArray) {
        boolean bl = telephonyStateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(telephonyStateArray.length);
            for (int i2 = 0; i2 < telephonyStateArray.length; ++i2) {
                TelephonyStateSerializer.putOptionalTelephonyState(iSerializer, telephonyStateArray[i2]);
            }
        }
    }

    public static TelephonyState getOptionalTelephonyState(IDeserializer iDeserializer) {
        TelephonyState telephonyState = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            boolean bl2;
            int n;
            int n2;
            telephonyState = new TelephonyState();
            telephonyState.signalStrength = n2 = iDeserializer.getInt32();
            telephonyState.registrationStatus = n = iDeserializer.getInt32();
            telephonyState.airplaneMode = bl2 = iDeserializer.getBool();
            telephonyState.mobileOperator = string = iDeserializer.getOptionalString();
        }
        return telephonyState;
    }

    public static TelephonyState[] getOptionalTelephonyStateVarArray(IDeserializer iDeserializer) {
        TelephonyState[] telephonyStateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            telephonyStateArray = new TelephonyState[n];
            for (int i2 = 0; i2 < n; ++i2) {
                telephonyStateArray[i2] = TelephonyStateSerializer.getOptionalTelephonyState(iDeserializer);
            }
        }
        return telephonyStateArray;
    }
}

