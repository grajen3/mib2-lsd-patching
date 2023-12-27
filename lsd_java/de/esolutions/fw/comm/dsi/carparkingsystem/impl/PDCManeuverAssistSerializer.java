/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.PDCManeuverAssist;

public class PDCManeuverAssistSerializer {
    public static void putOptionalPDCManeuverAssist(ISerializer iSerializer, PDCManeuverAssist pDCManeuverAssist) {
        boolean bl = pDCManeuverAssist == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = pDCManeuverAssist.isBraking();
            iSerializer.putBool(bl2);
            boolean bl3 = pDCManeuverAssist.isSteering();
            iSerializer.putBool(bl3);
        }
    }

    public static void putOptionalPDCManeuverAssistVarArray(ISerializer iSerializer, PDCManeuverAssist[] pDCManeuverAssistArray) {
        boolean bl = pDCManeuverAssistArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(pDCManeuverAssistArray.length);
            for (int i2 = 0; i2 < pDCManeuverAssistArray.length; ++i2) {
                PDCManeuverAssistSerializer.putOptionalPDCManeuverAssist(iSerializer, pDCManeuverAssistArray[i2]);
            }
        }
    }

    public static PDCManeuverAssist getOptionalPDCManeuverAssist(IDeserializer iDeserializer) {
        PDCManeuverAssist pDCManeuverAssist = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            pDCManeuverAssist = new PDCManeuverAssist();
            pDCManeuverAssist.braking = bl3 = iDeserializer.getBool();
            pDCManeuverAssist.steering = bl2 = iDeserializer.getBool();
        }
        return pDCManeuverAssist;
    }

    public static PDCManeuverAssist[] getOptionalPDCManeuverAssistVarArray(IDeserializer iDeserializer) {
        PDCManeuverAssist[] pDCManeuverAssistArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            pDCManeuverAssistArray = new PDCManeuverAssist[n];
            for (int i2 = 0; i2 < n; ++i2) {
                pDCManeuverAssistArray[i2] = PDCManeuverAssistSerializer.getOptionalPDCManeuverAssist(iDeserializer);
            }
        }
        return pDCManeuverAssistArray;
    }
}

