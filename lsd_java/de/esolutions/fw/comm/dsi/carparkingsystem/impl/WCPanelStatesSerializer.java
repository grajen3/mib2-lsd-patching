/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.WCPanelStates;

public class WCPanelStatesSerializer {
    public static void putOptionalWCPanelStates(ISerializer iSerializer, WCPanelStates wCPanelStates) {
        boolean bl = wCPanelStates == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = wCPanelStates.isPairedBefore();
            iSerializer.putBool(bl2);
            boolean bl3 = wCPanelStates.isSecured();
            iSerializer.putBool(bl3);
            boolean bl4 = wCPanelStates.isJustPaired();
            iSerializer.putBool(bl4);
            boolean bl5 = wCPanelStates.isDefaultPin();
            iSerializer.putBool(bl5);
        }
    }

    public static void putOptionalWCPanelStatesVarArray(ISerializer iSerializer, WCPanelStates[] wCPanelStatesArray) {
        boolean bl = wCPanelStatesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(wCPanelStatesArray.length);
            for (int i2 = 0; i2 < wCPanelStatesArray.length; ++i2) {
                WCPanelStatesSerializer.putOptionalWCPanelStates(iSerializer, wCPanelStatesArray[i2]);
            }
        }
    }

    public static WCPanelStates getOptionalWCPanelStates(IDeserializer iDeserializer) {
        WCPanelStates wCPanelStates = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            wCPanelStates = new WCPanelStates();
            wCPanelStates.pairedBefore = bl5 = iDeserializer.getBool();
            wCPanelStates.secured = bl4 = iDeserializer.getBool();
            wCPanelStates.justPaired = bl3 = iDeserializer.getBool();
            wCPanelStates.defaultPin = bl2 = iDeserializer.getBool();
        }
        return wCPanelStates;
    }

    public static WCPanelStates[] getOptionalWCPanelStatesVarArray(IDeserializer iDeserializer) {
        WCPanelStates[] wCPanelStatesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            wCPanelStatesArray = new WCPanelStates[n];
            for (int i2 = 0; i2 < n; ++i2) {
                wCPanelStatesArray[i2] = WCPanelStatesSerializer.getOptionalWCPanelStates(iDeserializer);
            }
        }
        return wCPanelStatesArray;
    }
}

