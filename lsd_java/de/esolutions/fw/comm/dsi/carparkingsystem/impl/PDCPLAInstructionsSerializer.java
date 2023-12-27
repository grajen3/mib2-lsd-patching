/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.PDCPLAInstructions;

public class PDCPLAInstructionsSerializer {
    public static void putOptionalPDCPLAInstructions(ISerializer iSerializer, PDCPLAInstructions pDCPLAInstructions) {
        boolean bl = pDCPLAInstructions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = pDCPLAInstructions.isBrakeSymbol();
            iSerializer.putBool(bl2);
            boolean bl3 = pDCPLAInstructions.isSteeringInterventionSymbol();
            iSerializer.putBool(bl3);
            boolean bl4 = pDCPLAInstructions.isPlaDeactivation();
            iSerializer.putBool(bl4);
            boolean bl5 = pDCPLAInstructions.isPlaSearchLeftSide();
            iSerializer.putBool(bl5);
            boolean bl6 = pDCPLAInstructions.isPlaSearchRightSide();
            iSerializer.putBool(bl6);
            boolean bl7 = pDCPLAInstructions.isNeighborLaneWarning();
            iSerializer.putBool(bl7);
        }
    }

    public static void putOptionalPDCPLAInstructionsVarArray(ISerializer iSerializer, PDCPLAInstructions[] pDCPLAInstructionsArray) {
        boolean bl = pDCPLAInstructionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(pDCPLAInstructionsArray.length);
            for (int i2 = 0; i2 < pDCPLAInstructionsArray.length; ++i2) {
                PDCPLAInstructionsSerializer.putOptionalPDCPLAInstructions(iSerializer, pDCPLAInstructionsArray[i2]);
            }
        }
    }

    public static PDCPLAInstructions getOptionalPDCPLAInstructions(IDeserializer iDeserializer) {
        PDCPLAInstructions pDCPLAInstructions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            pDCPLAInstructions = new PDCPLAInstructions();
            pDCPLAInstructions.brakeSymbol = bl7 = iDeserializer.getBool();
            pDCPLAInstructions.steeringInterventionSymbol = bl6 = iDeserializer.getBool();
            pDCPLAInstructions.plaDeactivation = bl5 = iDeserializer.getBool();
            pDCPLAInstructions.plaSearchLeftSide = bl4 = iDeserializer.getBool();
            pDCPLAInstructions.plaSearchRightSide = bl3 = iDeserializer.getBool();
            pDCPLAInstructions.neighborLaneWarning = bl2 = iDeserializer.getBool();
        }
        return pDCPLAInstructions;
    }

    public static PDCPLAInstructions[] getOptionalPDCPLAInstructionsVarArray(IDeserializer iDeserializer) {
        PDCPLAInstructions[] pDCPLAInstructionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            pDCPLAInstructionsArray = new PDCPLAInstructions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                pDCPLAInstructionsArray[i2] = PDCPLAInstructionsSerializer.getOptionalPDCPLAInstructions(iDeserializer);
            }
        }
        return pDCPLAInstructionsArray;
    }
}

