/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.PDCManeuverAssistState;

public class PDCManeuverAssistStateSerializer {
    public static void putOptionalPDCManeuverAssistState(ISerializer iSerializer, PDCManeuverAssistState pDCManeuverAssistState) {
        boolean bl = pDCManeuverAssistState == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = pDCManeuverAssistState.isActivity();
            iSerializer.putBool(bl2);
            boolean bl3 = pDCManeuverAssistState.isSteeringIntervention();
            iSerializer.putBool(bl3);
            boolean bl4 = pDCManeuverAssistState.isBrakingIntervention();
            iSerializer.putBool(bl4);
            boolean bl5 = pDCManeuverAssistState.isAvailability();
            iSerializer.putBool(bl5);
        }
    }

    public static void putOptionalPDCManeuverAssistStateVarArray(ISerializer iSerializer, PDCManeuverAssistState[] pDCManeuverAssistStateArray) {
        boolean bl = pDCManeuverAssistStateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(pDCManeuverAssistStateArray.length);
            for (int i2 = 0; i2 < pDCManeuverAssistStateArray.length; ++i2) {
                PDCManeuverAssistStateSerializer.putOptionalPDCManeuverAssistState(iSerializer, pDCManeuverAssistStateArray[i2]);
            }
        }
    }

    public static PDCManeuverAssistState getOptionalPDCManeuverAssistState(IDeserializer iDeserializer) {
        PDCManeuverAssistState pDCManeuverAssistState = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            pDCManeuverAssistState = new PDCManeuverAssistState();
            pDCManeuverAssistState.activity = bl5 = iDeserializer.getBool();
            pDCManeuverAssistState.steeringIntervention = bl4 = iDeserializer.getBool();
            pDCManeuverAssistState.brakingIntervention = bl3 = iDeserializer.getBool();
            pDCManeuverAssistState.availability = bl2 = iDeserializer.getBool();
        }
        return pDCManeuverAssistState;
    }

    public static PDCManeuverAssistState[] getOptionalPDCManeuverAssistStateVarArray(IDeserializer iDeserializer) {
        PDCManeuverAssistState[] pDCManeuverAssistStateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            pDCManeuverAssistStateArray = new PDCManeuverAssistState[n];
            for (int i2 = 0; i2 < n; ++i2) {
                pDCManeuverAssistStateArray[i2] = PDCManeuverAssistStateSerializer.getOptionalPDCManeuverAssistState(iDeserializer);
            }
        }
        return pDCManeuverAssistStateArray;
    }
}

