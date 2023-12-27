/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.HybridInhibitReason;

public class HybridInhibitReasonSerializer {
    public static void putOptionalHybridInhibitReason(ISerializer iSerializer, HybridInhibitReason hybridInhibitReason) {
        boolean bl = hybridInhibitReason == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = hybridInhibitReason.isBatteryCapacity();
            iSerializer.putBool(bl2);
            boolean bl3 = hybridInhibitReason.isBatteryTemperatureLow();
            iSerializer.putBool(bl3);
            boolean bl4 = hybridInhibitReason.isBatteryTemperatureHigh();
            iSerializer.putBool(bl4);
            boolean bl5 = hybridInhibitReason.isIceTemperatureLow();
            iSerializer.putBool(bl5);
            boolean bl6 = hybridInhibitReason.isPowerEE();
            iSerializer.putBool(bl6);
            boolean bl7 = hybridInhibitReason.isSpeed();
            iSerializer.putBool(bl7);
            boolean bl8 = hybridInhibitReason.isFuelQuality();
            iSerializer.putBool(bl8);
            boolean bl9 = hybridInhibitReason.isEngineProtection();
            iSerializer.putBool(bl9);
            boolean bl10 = hybridInhibitReason.isMalfunctionLow();
            iSerializer.putBool(bl10);
            boolean bl11 = hybridInhibitReason.isMalfunctionCritical();
            iSerializer.putBool(bl11);
            boolean bl12 = hybridInhibitReason.isLeavingConcept();
            iSerializer.putBool(bl12);
            boolean bl13 = hybridInhibitReason.isDiagnosis();
            iSerializer.putBool(bl13);
        }
    }

    public static void putOptionalHybridInhibitReasonVarArray(ISerializer iSerializer, HybridInhibitReason[] hybridInhibitReasonArray) {
        boolean bl = hybridInhibitReasonArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(hybridInhibitReasonArray.length);
            for (int i2 = 0; i2 < hybridInhibitReasonArray.length; ++i2) {
                HybridInhibitReasonSerializer.putOptionalHybridInhibitReason(iSerializer, hybridInhibitReasonArray[i2]);
            }
        }
    }

    public static HybridInhibitReason getOptionalHybridInhibitReason(IDeserializer iDeserializer) {
        HybridInhibitReason hybridInhibitReason = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            boolean bl8;
            boolean bl9;
            boolean bl10;
            boolean bl11;
            boolean bl12;
            boolean bl13;
            hybridInhibitReason = new HybridInhibitReason();
            hybridInhibitReason.batteryCapacity = bl13 = iDeserializer.getBool();
            hybridInhibitReason.batteryTemperatureLow = bl12 = iDeserializer.getBool();
            hybridInhibitReason.batteryTemperatureHigh = bl11 = iDeserializer.getBool();
            hybridInhibitReason.iceTemperatureLow = bl10 = iDeserializer.getBool();
            hybridInhibitReason.powerEE = bl9 = iDeserializer.getBool();
            hybridInhibitReason.speed = bl8 = iDeserializer.getBool();
            hybridInhibitReason.fuelQuality = bl7 = iDeserializer.getBool();
            hybridInhibitReason.engineProtection = bl6 = iDeserializer.getBool();
            hybridInhibitReason.malfunctionLow = bl5 = iDeserializer.getBool();
            hybridInhibitReason.malfunctionCritical = bl4 = iDeserializer.getBool();
            hybridInhibitReason.leavingConcept = bl3 = iDeserializer.getBool();
            hybridInhibitReason.diagnosis = bl2 = iDeserializer.getBool();
        }
        return hybridInhibitReason;
    }

    public static HybridInhibitReason[] getOptionalHybridInhibitReasonVarArray(IDeserializer iDeserializer) {
        HybridInhibitReason[] hybridInhibitReasonArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            hybridInhibitReasonArray = new HybridInhibitReason[n];
            for (int i2 = 0; i2 < n; ++i2) {
                hybridInhibitReasonArray[i2] = HybridInhibitReasonSerializer.getOptionalHybridInhibitReason(iDeserializer);
            }
        }
        return hybridInhibitReasonArray;
    }
}

