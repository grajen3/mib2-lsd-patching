/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.comm.dsi.carparkingsystem.impl.PDCPLAInstructionsSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.PDCPLAParkingSpotSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.PDCPLAInstructions;
import org.dsi.ifc.carparkingsystem.PDCPLAParkingSpot;
import org.dsi.ifc.carparkingsystem.PDCPLAStatus;

public class PDCPLAStatusSerializer {
    public static void putOptionalPDCPLAStatus(ISerializer iSerializer, PDCPLAStatus pDCPLAStatus) {
        boolean bl = pDCPLAStatus == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = pDCPLAStatus.getMode();
            iSerializer.putInt32(n);
            PDCPLAParkingSpot pDCPLAParkingSpot = pDCPLAStatus.getParkingSpot();
            PDCPLAParkingSpotSerializer.putOptionalPDCPLAParkingSpot(iSerializer, pDCPLAParkingSpot);
            int n2 = pDCPLAStatus.getDrivingDirection();
            iSerializer.putInt32(n2);
            PDCPLAInstructions pDCPLAInstructions = pDCPLAStatus.getInstructions();
            PDCPLAInstructionsSerializer.putOptionalPDCPLAInstructions(iSerializer, pDCPLAInstructions);
            int n3 = pDCPLAStatus.getPreSelection();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalPDCPLAStatusVarArray(ISerializer iSerializer, PDCPLAStatus[] pDCPLAStatusArray) {
        boolean bl = pDCPLAStatusArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(pDCPLAStatusArray.length);
            for (int i2 = 0; i2 < pDCPLAStatusArray.length; ++i2) {
                PDCPLAStatusSerializer.putOptionalPDCPLAStatus(iSerializer, pDCPLAStatusArray[i2]);
            }
        }
    }

    public static PDCPLAStatus getOptionalPDCPLAStatus(IDeserializer iDeserializer) {
        PDCPLAStatus pDCPLAStatus = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            PDCPLAInstructions pDCPLAInstructions;
            int n2;
            PDCPLAParkingSpot pDCPLAParkingSpot;
            int n3;
            pDCPLAStatus = new PDCPLAStatus();
            pDCPLAStatus.mode = n3 = iDeserializer.getInt32();
            pDCPLAStatus.parkingSpot = pDCPLAParkingSpot = PDCPLAParkingSpotSerializer.getOptionalPDCPLAParkingSpot(iDeserializer);
            pDCPLAStatus.drivingDirection = n2 = iDeserializer.getInt32();
            pDCPLAStatus.instructions = pDCPLAInstructions = PDCPLAInstructionsSerializer.getOptionalPDCPLAInstructions(iDeserializer);
            pDCPLAStatus.preSelection = n = iDeserializer.getInt32();
        }
        return pDCPLAStatus;
    }

    public static PDCPLAStatus[] getOptionalPDCPLAStatusVarArray(IDeserializer iDeserializer) {
        PDCPLAStatus[] pDCPLAStatusArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            pDCPLAStatusArray = new PDCPLAStatus[n];
            for (int i2 = 0; i2 < n; ++i2) {
                pDCPLAStatusArray[i2] = PDCPLAStatusSerializer.getOptionalPDCPLAStatus(iDeserializer);
            }
        }
        return pDCPLAStatusArray;
    }
}

