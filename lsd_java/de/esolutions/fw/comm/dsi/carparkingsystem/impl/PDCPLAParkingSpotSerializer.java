/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.PDCPLAParkingSpot;

public class PDCPLAParkingSpotSerializer {
    public static void putOptionalPDCPLAParkingSpot(ISerializer iSerializer, PDCPLAParkingSpot pDCPLAParkingSpot) {
        boolean bl = pDCPLAParkingSpot == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = pDCPLAParkingSpot.isBackwardParkboxSlotLeftFound();
            iSerializer.putBool(bl2);
            boolean bl3 = pDCPLAParkingSpot.isBackwardParkboxSlotRightFound();
            iSerializer.putBool(bl3);
            boolean bl4 = pDCPLAParkingSpot.isForwardParkboxSlotLeftFound();
            iSerializer.putBool(bl4);
            boolean bl5 = pDCPLAParkingSpot.isForwardParkboxSlotRightFound();
            iSerializer.putBool(bl5);
            boolean bl6 = pDCPLAParkingSpot.isBackwardParallelToRoadSlotLeftFound();
            iSerializer.putBool(bl6);
            boolean bl7 = pDCPLAParkingSpot.isBackwardParallelToRoadSlotRightFound();
            iSerializer.putBool(bl7);
            boolean bl8 = pDCPLAParkingSpot.isForwardParkboxSlotMiddleFound();
            iSerializer.putBool(bl8);
        }
    }

    public static void putOptionalPDCPLAParkingSpotVarArray(ISerializer iSerializer, PDCPLAParkingSpot[] pDCPLAParkingSpotArray) {
        boolean bl = pDCPLAParkingSpotArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(pDCPLAParkingSpotArray.length);
            for (int i2 = 0; i2 < pDCPLAParkingSpotArray.length; ++i2) {
                PDCPLAParkingSpotSerializer.putOptionalPDCPLAParkingSpot(iSerializer, pDCPLAParkingSpotArray[i2]);
            }
        }
    }

    public static PDCPLAParkingSpot getOptionalPDCPLAParkingSpot(IDeserializer iDeserializer) {
        PDCPLAParkingSpot pDCPLAParkingSpot = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            boolean bl8;
            pDCPLAParkingSpot = new PDCPLAParkingSpot();
            pDCPLAParkingSpot.backwardParkboxSlotLeftFound = bl8 = iDeserializer.getBool();
            pDCPLAParkingSpot.backwardParkboxSlotRightFound = bl7 = iDeserializer.getBool();
            pDCPLAParkingSpot.forwardParkboxSlotLeftFound = bl6 = iDeserializer.getBool();
            pDCPLAParkingSpot.forwardParkboxSlotRightFound = bl5 = iDeserializer.getBool();
            pDCPLAParkingSpot.backwardParallelToRoadSlotLeftFound = bl4 = iDeserializer.getBool();
            pDCPLAParkingSpot.backwardParallelToRoadSlotRightFound = bl3 = iDeserializer.getBool();
            pDCPLAParkingSpot.forwardParkboxSlotMiddleFound = bl2 = iDeserializer.getBool();
        }
        return pDCPLAParkingSpot;
    }

    public static PDCPLAParkingSpot[] getOptionalPDCPLAParkingSpotVarArray(IDeserializer iDeserializer) {
        PDCPLAParkingSpot[] pDCPLAParkingSpotArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            pDCPLAParkingSpotArray = new PDCPLAParkingSpot[n];
            for (int i2 = 0; i2 < n; ++i2) {
                pDCPLAParkingSpotArray[i2] = PDCPLAParkingSpotSerializer.getOptionalPDCPLAParkingSpot(iDeserializer);
            }
        }
        return pDCPLAParkingSpotArray;
    }
}

