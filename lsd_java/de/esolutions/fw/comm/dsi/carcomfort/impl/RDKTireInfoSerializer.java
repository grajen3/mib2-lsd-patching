/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.dsi.carcomfort.impl.RDKSpeedLimitSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.RDKSpeedLimit;
import org.dsi.ifc.carcomfort.RDKTireInfo;

public class RDKTireInfoSerializer {
    public static void putOptionalRDKTireInfo(ISerializer iSerializer, RDKTireInfo rDKTireInfo) {
        boolean bl = rDKTireInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = rDKTireInfo.getPosition();
            iSerializer.putInt32(n);
            String string = rDKTireInfo.getVendorName();
            iSerializer.putOptionalString(string);
            String string2 = rDKTireInfo.getWheelSize();
            iSerializer.putOptionalString(string2);
            int n2 = rDKTireInfo.getWheelType();
            iSerializer.putInt32(n2);
            int n3 = rDKTireInfo.getFrontPressure1();
            iSerializer.putInt32(n3);
            int n4 = rDKTireInfo.getFrontPressure2();
            iSerializer.putInt32(n4);
            int n5 = rDKTireInfo.getFrontPressure3();
            iSerializer.putInt32(n5);
            int n6 = rDKTireInfo.getRearPressure1();
            iSerializer.putInt32(n6);
            int n7 = rDKTireInfo.getRearPressure2();
            iSerializer.putInt32(n7);
            int n8 = rDKTireInfo.getRearPressure3();
            iSerializer.putInt32(n8);
            int n9 = rDKTireInfo.getSpareWheelPressure();
            iSerializer.putInt32(n9);
            int n10 = rDKTireInfo.getPressureUnit();
            iSerializer.putInt32(n10);
            RDKSpeedLimit rDKSpeedLimit = rDKTireInfo.getSpeedLimit1();
            RDKSpeedLimitSerializer.putOptionalRDKSpeedLimit(iSerializer, rDKSpeedLimit);
            RDKSpeedLimit rDKSpeedLimit2 = rDKTireInfo.getSpeedLimit2();
            RDKSpeedLimitSerializer.putOptionalRDKSpeedLimit(iSerializer, rDKSpeedLimit2);
            RDKSpeedLimit rDKSpeedLimit3 = rDKTireInfo.getSpeedLimit3();
            RDKSpeedLimitSerializer.putOptionalRDKSpeedLimit(iSerializer, rDKSpeedLimit3);
            int n11 = rDKTireInfo.getFrontPressure4();
            iSerializer.putInt32(n11);
            int n12 = rDKTireInfo.getRearPressure4();
            iSerializer.putInt32(n12);
        }
    }

    public static void putOptionalRDKTireInfoVarArray(ISerializer iSerializer, RDKTireInfo[] rDKTireInfoArray) {
        boolean bl = rDKTireInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(rDKTireInfoArray.length);
            for (int i2 = 0; i2 < rDKTireInfoArray.length; ++i2) {
                RDKTireInfoSerializer.putOptionalRDKTireInfo(iSerializer, rDKTireInfoArray[i2]);
            }
        }
    }

    public static RDKTireInfo getOptionalRDKTireInfo(IDeserializer iDeserializer) {
        RDKTireInfo rDKTireInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            RDKSpeedLimit rDKSpeedLimit;
            RDKSpeedLimit rDKSpeedLimit2;
            RDKSpeedLimit rDKSpeedLimit3;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            int n10;
            int n11;
            String string;
            String string2;
            int n12;
            rDKTireInfo = new RDKTireInfo();
            rDKTireInfo.position = n12 = iDeserializer.getInt32();
            rDKTireInfo.vendorName = string2 = iDeserializer.getOptionalString();
            rDKTireInfo.wheelSize = string = iDeserializer.getOptionalString();
            rDKTireInfo.wheelType = n11 = iDeserializer.getInt32();
            rDKTireInfo.frontPressure1 = n10 = iDeserializer.getInt32();
            rDKTireInfo.frontPressure2 = n9 = iDeserializer.getInt32();
            rDKTireInfo.frontPressure3 = n8 = iDeserializer.getInt32();
            rDKTireInfo.rearPressure1 = n7 = iDeserializer.getInt32();
            rDKTireInfo.rearPressure2 = n6 = iDeserializer.getInt32();
            rDKTireInfo.rearPressure3 = n5 = iDeserializer.getInt32();
            rDKTireInfo.spareWheelPressure = n4 = iDeserializer.getInt32();
            rDKTireInfo.pressureUnit = n3 = iDeserializer.getInt32();
            rDKTireInfo.speedLimit1 = rDKSpeedLimit3 = RDKSpeedLimitSerializer.getOptionalRDKSpeedLimit(iDeserializer);
            rDKTireInfo.speedLimit2 = rDKSpeedLimit2 = RDKSpeedLimitSerializer.getOptionalRDKSpeedLimit(iDeserializer);
            rDKTireInfo.speedLimit3 = rDKSpeedLimit = RDKSpeedLimitSerializer.getOptionalRDKSpeedLimit(iDeserializer);
            rDKTireInfo.frontPressure4 = n2 = iDeserializer.getInt32();
            rDKTireInfo.rearPressure4 = n = iDeserializer.getInt32();
        }
        return rDKTireInfo;
    }

    public static RDKTireInfo[] getOptionalRDKTireInfoVarArray(IDeserializer iDeserializer) {
        RDKTireInfo[] rDKTireInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            rDKTireInfoArray = new RDKTireInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                rDKTireInfoArray[i2] = RDKTireInfoSerializer.getOptionalRDKTireInfo(iDeserializer);
            }
        }
        return rDKTireInfoArray;
    }
}

