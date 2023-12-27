/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.comm.dsi.carparkingsystem.impl.PDCCrashWarningFrontRearSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.PDCCrashWarningRightLeftSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.PDCCrashWarning;
import org.dsi.ifc.carparkingsystem.PDCCrashWarningFrontRear;
import org.dsi.ifc.carparkingsystem.PDCCrashWarningRightLeft;

public class PDCCrashWarningSerializer {
    public static void putOptionalPDCCrashWarning(ISerializer iSerializer, PDCCrashWarning pDCCrashWarning) {
        boolean bl = pDCCrashWarning == null;
        iSerializer.putBool(bl);
        if (!bl) {
            PDCCrashWarningFrontRear pDCCrashWarningFrontRear = pDCCrashWarning.getSectorsFront();
            PDCCrashWarningFrontRearSerializer.putOptionalPDCCrashWarningFrontRear(iSerializer, pDCCrashWarningFrontRear);
            PDCCrashWarningFrontRear pDCCrashWarningFrontRear2 = pDCCrashWarning.getSectorsRear();
            PDCCrashWarningFrontRearSerializer.putOptionalPDCCrashWarningFrontRear(iSerializer, pDCCrashWarningFrontRear2);
            PDCCrashWarningRightLeft pDCCrashWarningRightLeft = pDCCrashWarning.getSectorsRight();
            PDCCrashWarningRightLeftSerializer.putOptionalPDCCrashWarningRightLeft(iSerializer, pDCCrashWarningRightLeft);
            PDCCrashWarningRightLeft pDCCrashWarningRightLeft2 = pDCCrashWarning.getSectorsLeft();
            PDCCrashWarningRightLeftSerializer.putOptionalPDCCrashWarningRightLeft(iSerializer, pDCCrashWarningRightLeft2);
        }
    }

    public static void putOptionalPDCCrashWarningVarArray(ISerializer iSerializer, PDCCrashWarning[] pDCCrashWarningArray) {
        boolean bl = pDCCrashWarningArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(pDCCrashWarningArray.length);
            for (int i2 = 0; i2 < pDCCrashWarningArray.length; ++i2) {
                PDCCrashWarningSerializer.putOptionalPDCCrashWarning(iSerializer, pDCCrashWarningArray[i2]);
            }
        }
    }

    public static PDCCrashWarning getOptionalPDCCrashWarning(IDeserializer iDeserializer) {
        PDCCrashWarning pDCCrashWarning = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            PDCCrashWarningRightLeft pDCCrashWarningRightLeft;
            PDCCrashWarningRightLeft pDCCrashWarningRightLeft2;
            PDCCrashWarningFrontRear pDCCrashWarningFrontRear;
            PDCCrashWarningFrontRear pDCCrashWarningFrontRear2;
            pDCCrashWarning = new PDCCrashWarning();
            pDCCrashWarning.sectorsFront = pDCCrashWarningFrontRear2 = PDCCrashWarningFrontRearSerializer.getOptionalPDCCrashWarningFrontRear(iDeserializer);
            pDCCrashWarning.sectorsRear = pDCCrashWarningFrontRear = PDCCrashWarningFrontRearSerializer.getOptionalPDCCrashWarningFrontRear(iDeserializer);
            pDCCrashWarning.sectorsRight = pDCCrashWarningRightLeft2 = PDCCrashWarningRightLeftSerializer.getOptionalPDCCrashWarningRightLeft(iDeserializer);
            pDCCrashWarning.sectorsLeft = pDCCrashWarningRightLeft = PDCCrashWarningRightLeftSerializer.getOptionalPDCCrashWarningRightLeft(iDeserializer);
        }
        return pDCCrashWarning;
    }

    public static PDCCrashWarning[] getOptionalPDCCrashWarningVarArray(IDeserializer iDeserializer) {
        PDCCrashWarning[] pDCCrashWarningArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            pDCCrashWarningArray = new PDCCrashWarning[n];
            for (int i2 = 0; i2 < n; ++i2) {
                pDCCrashWarningArray[i2] = PDCCrashWarningSerializer.getOptionalPDCCrashWarning(iDeserializer);
            }
        }
        return pDCCrashWarningArray;
    }
}

