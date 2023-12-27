/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.BCVehicleStateUpdateInfoAH;

public class BCVehicleStateUpdateInfoAHSerializer {
    public static void putOptionalBCVehicleStateUpdateInfoAH(ISerializer iSerializer, BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH) {
        boolean bl = bCVehicleStateUpdateInfoAH == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = bCVehicleStateUpdateInfoAH.getArrayContent();
            iSerializer.putInt32(n);
            int n2 = bCVehicleStateUpdateInfoAH.getRecordContent();
            iSerializer.putInt32(n2);
            int n3 = bCVehicleStateUpdateInfoAH.getStartElement();
            iSerializer.putInt32(n3);
            int n4 = bCVehicleStateUpdateInfoAH.getNumOfElements();
            iSerializer.putInt32(n4);
            int n5 = bCVehicleStateUpdateInfoAH.getTransactionID();
            iSerializer.putInt32(n5);
            int n6 = bCVehicleStateUpdateInfoAH.getAsgID();
            iSerializer.putInt32(n6);
        }
    }

    public static void putOptionalBCVehicleStateUpdateInfoAHVarArray(ISerializer iSerializer, BCVehicleStateUpdateInfoAH[] bCVehicleStateUpdateInfoAHArray) {
        boolean bl = bCVehicleStateUpdateInfoAHArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCVehicleStateUpdateInfoAHArray.length);
            for (int i2 = 0; i2 < bCVehicleStateUpdateInfoAHArray.length; ++i2) {
                BCVehicleStateUpdateInfoAHSerializer.putOptionalBCVehicleStateUpdateInfoAH(iSerializer, bCVehicleStateUpdateInfoAHArray[i2]);
            }
        }
    }

    public static BCVehicleStateUpdateInfoAH getOptionalBCVehicleStateUpdateInfoAH(IDeserializer iDeserializer) {
        BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            bCVehicleStateUpdateInfoAH = new BCVehicleStateUpdateInfoAH();
            bCVehicleStateUpdateInfoAH.arrayContent = n6 = iDeserializer.getInt32();
            bCVehicleStateUpdateInfoAH.recordContent = n5 = iDeserializer.getInt32();
            bCVehicleStateUpdateInfoAH.startElement = n4 = iDeserializer.getInt32();
            bCVehicleStateUpdateInfoAH.numOfElements = n3 = iDeserializer.getInt32();
            bCVehicleStateUpdateInfoAH.transactionID = n2 = iDeserializer.getInt32();
            bCVehicleStateUpdateInfoAH.asgID = n = iDeserializer.getInt32();
        }
        return bCVehicleStateUpdateInfoAH;
    }

    public static BCVehicleStateUpdateInfoAH[] getOptionalBCVehicleStateUpdateInfoAHVarArray(IDeserializer iDeserializer) {
        BCVehicleStateUpdateInfoAH[] bCVehicleStateUpdateInfoAHArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCVehicleStateUpdateInfoAHArray = new BCVehicleStateUpdateInfoAH[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCVehicleStateUpdateInfoAHArray[i2] = BCVehicleStateUpdateInfoAHSerializer.getOptionalBCVehicleStateUpdateInfoAH(iDeserializer);
            }
        }
        return bCVehicleStateUpdateInfoAHArray;
    }
}

