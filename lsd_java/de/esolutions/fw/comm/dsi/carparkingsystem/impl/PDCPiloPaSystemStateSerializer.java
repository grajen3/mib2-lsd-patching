/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.PDCPiloPaSystemState;

public class PDCPiloPaSystemStateSerializer {
    public static void putOptionalPDCPiloPaSystemState(ISerializer iSerializer, PDCPiloPaSystemState pDCPiloPaSystemState) {
        boolean bl = pDCPiloPaSystemState == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = pDCPiloPaSystemState.isPp();
            iSerializer.putBool(bl2);
            boolean bl3 = pDCPiloPaSystemState.isGp();
            iSerializer.putBool(bl3);
        }
    }

    public static void putOptionalPDCPiloPaSystemStateVarArray(ISerializer iSerializer, PDCPiloPaSystemState[] pDCPiloPaSystemStateArray) {
        boolean bl = pDCPiloPaSystemStateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(pDCPiloPaSystemStateArray.length);
            for (int i2 = 0; i2 < pDCPiloPaSystemStateArray.length; ++i2) {
                PDCPiloPaSystemStateSerializer.putOptionalPDCPiloPaSystemState(iSerializer, pDCPiloPaSystemStateArray[i2]);
            }
        }
    }

    public static PDCPiloPaSystemState getOptionalPDCPiloPaSystemState(IDeserializer iDeserializer) {
        PDCPiloPaSystemState pDCPiloPaSystemState = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            pDCPiloPaSystemState = new PDCPiloPaSystemState();
            pDCPiloPaSystemState.pp = bl3 = iDeserializer.getBool();
            pDCPiloPaSystemState.gp = bl2 = iDeserializer.getBool();
        }
        return pDCPiloPaSystemState;
    }

    public static PDCPiloPaSystemState[] getOptionalPDCPiloPaSystemStateVarArray(IDeserializer iDeserializer) {
        PDCPiloPaSystemState[] pDCPiloPaSystemStateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            pDCPiloPaSystemStateArray = new PDCPiloPaSystemState[n];
            for (int i2 = 0; i2 < n; ++i2) {
                pDCPiloPaSystemStateArray[i2] = PDCPiloPaSystemStateSerializer.getOptionalPDCPiloPaSystemState(iDeserializer);
            }
        }
        return pDCPiloPaSystemStateArray;
    }
}

