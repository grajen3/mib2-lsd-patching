/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.comm.dsi.carparkingsystem.impl.PDCWallDetectionFrontRearSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.PDCWallDetectionRightLeftSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.PDCWallDetection;
import org.dsi.ifc.carparkingsystem.PDCWallDetectionFrontRear;
import org.dsi.ifc.carparkingsystem.PDCWallDetectionRightLeft;

public class PDCWallDetectionSerializer {
    public static void putOptionalPDCWallDetection(ISerializer iSerializer, PDCWallDetection pDCWallDetection) {
        boolean bl = pDCWallDetection == null;
        iSerializer.putBool(bl);
        if (!bl) {
            PDCWallDetectionFrontRear pDCWallDetectionFrontRear = pDCWallDetection.getSectorsFront();
            PDCWallDetectionFrontRearSerializer.putOptionalPDCWallDetectionFrontRear(iSerializer, pDCWallDetectionFrontRear);
            PDCWallDetectionFrontRear pDCWallDetectionFrontRear2 = pDCWallDetection.getSectorsRear();
            PDCWallDetectionFrontRearSerializer.putOptionalPDCWallDetectionFrontRear(iSerializer, pDCWallDetectionFrontRear2);
            PDCWallDetectionRightLeft pDCWallDetectionRightLeft = pDCWallDetection.getSectorsRight();
            PDCWallDetectionRightLeftSerializer.putOptionalPDCWallDetectionRightLeft(iSerializer, pDCWallDetectionRightLeft);
            PDCWallDetectionRightLeft pDCWallDetectionRightLeft2 = pDCWallDetection.getSectorsLeft();
            PDCWallDetectionRightLeftSerializer.putOptionalPDCWallDetectionRightLeft(iSerializer, pDCWallDetectionRightLeft2);
        }
    }

    public static void putOptionalPDCWallDetectionVarArray(ISerializer iSerializer, PDCWallDetection[] pDCWallDetectionArray) {
        boolean bl = pDCWallDetectionArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(pDCWallDetectionArray.length);
            for (int i2 = 0; i2 < pDCWallDetectionArray.length; ++i2) {
                PDCWallDetectionSerializer.putOptionalPDCWallDetection(iSerializer, pDCWallDetectionArray[i2]);
            }
        }
    }

    public static PDCWallDetection getOptionalPDCWallDetection(IDeserializer iDeserializer) {
        PDCWallDetection pDCWallDetection = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            PDCWallDetectionRightLeft pDCWallDetectionRightLeft;
            PDCWallDetectionRightLeft pDCWallDetectionRightLeft2;
            PDCWallDetectionFrontRear pDCWallDetectionFrontRear;
            PDCWallDetectionFrontRear pDCWallDetectionFrontRear2;
            pDCWallDetection = new PDCWallDetection();
            pDCWallDetection.sectorsFront = pDCWallDetectionFrontRear2 = PDCWallDetectionFrontRearSerializer.getOptionalPDCWallDetectionFrontRear(iDeserializer);
            pDCWallDetection.sectorsRear = pDCWallDetectionFrontRear = PDCWallDetectionFrontRearSerializer.getOptionalPDCWallDetectionFrontRear(iDeserializer);
            pDCWallDetection.sectorsRight = pDCWallDetectionRightLeft2 = PDCWallDetectionRightLeftSerializer.getOptionalPDCWallDetectionRightLeft(iDeserializer);
            pDCWallDetection.sectorsLeft = pDCWallDetectionRightLeft = PDCWallDetectionRightLeftSerializer.getOptionalPDCWallDetectionRightLeft(iDeserializer);
        }
        return pDCWallDetection;
    }

    public static PDCWallDetection[] getOptionalPDCWallDetectionVarArray(IDeserializer iDeserializer) {
        PDCWallDetection[] pDCWallDetectionArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            pDCWallDetectionArray = new PDCWallDetection[n];
            for (int i2 = 0; i2 < n; ++i2) {
                pDCWallDetectionArray[i2] = PDCWallDetectionSerializer.getOptionalPDCWallDetection(iDeserializer);
            }
        }
        return pDCWallDetectionArray;
    }
}

