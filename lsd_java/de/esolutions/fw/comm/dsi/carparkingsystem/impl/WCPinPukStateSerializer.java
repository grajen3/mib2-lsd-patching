/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.WCPinPukState;

public class WCPinPukStateSerializer {
    public static void putOptionalWCPinPukState(ISerializer iSerializer, WCPinPukState wCPinPukState) {
        boolean bl = wCPinPukState == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = wCPinPukState.getSerialNumber();
            iSerializer.putOptionalString(string);
            int n = wCPinPukState.getState();
            iSerializer.putInt32(n);
            int n2 = wCPinPukState.getLockTime();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalWCPinPukStateVarArray(ISerializer iSerializer, WCPinPukState[] wCPinPukStateArray) {
        boolean bl = wCPinPukStateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(wCPinPukStateArray.length);
            for (int i2 = 0; i2 < wCPinPukStateArray.length; ++i2) {
                WCPinPukStateSerializer.putOptionalWCPinPukState(iSerializer, wCPinPukStateArray[i2]);
            }
        }
    }

    public static WCPinPukState getOptionalWCPinPukState(IDeserializer iDeserializer) {
        WCPinPukState wCPinPukState = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            String string;
            wCPinPukState = new WCPinPukState();
            wCPinPukState.serialNumber = string = iDeserializer.getOptionalString();
            wCPinPukState.state = n2 = iDeserializer.getInt32();
            wCPinPukState.lockTime = n = iDeserializer.getInt32();
        }
        return wCPinPukState;
    }

    public static WCPinPukState[] getOptionalWCPinPukStateVarArray(IDeserializer iDeserializer) {
        WCPinPukState[] wCPinPukStateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            wCPinPukStateArray = new WCPinPukState[n];
            for (int i2 = 0; i2 < n; ++i2) {
                wCPinPukStateArray[i2] = WCPinPukStateSerializer.getOptionalWCPinPukState(iDeserializer);
            }
        }
        return wCPinPukStateArray;
    }
}

