/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.TourImportStatus;

public class TourImportStatusSerializer {
    public static void putOptionalTourImportStatus(ISerializer iSerializer, TourImportStatus tourImportStatus) {
        boolean bl = tourImportStatus == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = tourImportStatus.getCurrentIndex();
            iSerializer.putInt32(n);
            int n2 = tourImportStatus.getLastIndex();
            iSerializer.putInt32(n2);
            int n3 = tourImportStatus.getStatus();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalTourImportStatusVarArray(ISerializer iSerializer, TourImportStatus[] tourImportStatusArray) {
        boolean bl = tourImportStatusArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(tourImportStatusArray.length);
            for (int i2 = 0; i2 < tourImportStatusArray.length; ++i2) {
                TourImportStatusSerializer.putOptionalTourImportStatus(iSerializer, tourImportStatusArray[i2]);
            }
        }
    }

    public static TourImportStatus getOptionalTourImportStatus(IDeserializer iDeserializer) {
        TourImportStatus tourImportStatus = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            tourImportStatus = new TourImportStatus();
            tourImportStatus.currentIndex = n3 = iDeserializer.getInt32();
            tourImportStatus.lastIndex = n2 = iDeserializer.getInt32();
            tourImportStatus.status = n = iDeserializer.getInt32();
        }
        return tourImportStatus;
    }

    public static TourImportStatus[] getOptionalTourImportStatusVarArray(IDeserializer iDeserializer) {
        TourImportStatus[] tourImportStatusArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            tourImportStatusArray = new TourImportStatus[n];
            for (int i2 = 0; i2 < n; ++i2) {
                tourImportStatusArray[i2] = TourImportStatusSerializer.getOptionalTourImportStatus(iDeserializer);
            }
        }
        return tourImportStatusArray;
    }
}

