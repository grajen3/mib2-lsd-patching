/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.PDCPLASystemState;

public class PDCPLASystemStateSerializer {
    public static void putOptionalPDCPLASystemState(ISerializer iSerializer, PDCPLASystemState pDCPLASystemState) {
        boolean bl = pDCPLASystemState == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = pDCPLASystemState.isPdcSystemState();
            iSerializer.putBool(bl2);
            boolean bl3 = pDCPLASystemState.isPlaSystemState();
            iSerializer.putBool(bl3);
        }
    }

    public static void putOptionalPDCPLASystemStateVarArray(ISerializer iSerializer, PDCPLASystemState[] pDCPLASystemStateArray) {
        boolean bl = pDCPLASystemStateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(pDCPLASystemStateArray.length);
            for (int i2 = 0; i2 < pDCPLASystemStateArray.length; ++i2) {
                PDCPLASystemStateSerializer.putOptionalPDCPLASystemState(iSerializer, pDCPLASystemStateArray[i2]);
            }
        }
    }

    public static PDCPLASystemState getOptionalPDCPLASystemState(IDeserializer iDeserializer) {
        PDCPLASystemState pDCPLASystemState = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            pDCPLASystemState = new PDCPLASystemState();
            pDCPLASystemState.pdcSystemState = bl3 = iDeserializer.getBool();
            pDCPLASystemState.plaSystemState = bl2 = iDeserializer.getBool();
        }
        return pDCPLASystemState;
    }

    public static PDCPLASystemState[] getOptionalPDCPLASystemStateVarArray(IDeserializer iDeserializer) {
        PDCPLASystemState[] pDCPLASystemStateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            pDCPLASystemStateArray = new PDCPLASystemState[n];
            for (int i2 = 0; i2 < n; ++i2) {
                pDCPLASystemStateArray[i2] = PDCPLASystemStateSerializer.getOptionalPDCPLASystemState(iDeserializer);
            }
        }
        return pDCPLASystemStateArray;
    }
}

