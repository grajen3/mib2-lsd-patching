/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.bc.impl;

import de.esolutions.fw.comm.asi.hmisync.car.FloatBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.bc.BCTermGeneralData;
import de.esolutions.fw.comm.asi.hmisync.car.impl.FloatBaseTypeSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class BCTermGeneralDataSerializer {
    public static void putOptionalBCTermGeneralData(ISerializer iSerializer, BCTermGeneralData bCTermGeneralData) {
        boolean bl = bCTermGeneralData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            FloatBaseType floatBaseType = bCTermGeneralData.getDistance();
            FloatBaseTypeSerializer.putOptionalFloatBaseType(iSerializer, floatBaseType);
            FloatBaseType floatBaseType2 = bCTermGeneralData.getSpeed();
            FloatBaseTypeSerializer.putOptionalFloatBaseType(iSerializer, floatBaseType2);
            int n = bCTermGeneralData.getTimeValue();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalBCTermGeneralDataVarArray(ISerializer iSerializer, BCTermGeneralData[] bCTermGeneralDataArray) {
        boolean bl = bCTermGeneralDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCTermGeneralDataArray.length);
            for (int i2 = 0; i2 < bCTermGeneralDataArray.length; ++i2) {
                BCTermGeneralDataSerializer.putOptionalBCTermGeneralData(iSerializer, bCTermGeneralDataArray[i2]);
            }
        }
    }

    public static BCTermGeneralData getOptionalBCTermGeneralData(IDeserializer iDeserializer) {
        BCTermGeneralData bCTermGeneralData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            FloatBaseType floatBaseType;
            FloatBaseType floatBaseType2;
            bCTermGeneralData = new BCTermGeneralData();
            bCTermGeneralData.distance = floatBaseType2 = FloatBaseTypeSerializer.getOptionalFloatBaseType(iDeserializer);
            bCTermGeneralData.speed = floatBaseType = FloatBaseTypeSerializer.getOptionalFloatBaseType(iDeserializer);
            bCTermGeneralData.timeValue = n = iDeserializer.getInt32();
        }
        return bCTermGeneralData;
    }

    public static BCTermGeneralData[] getOptionalBCTermGeneralDataVarArray(IDeserializer iDeserializer) {
        BCTermGeneralData[] bCTermGeneralDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCTermGeneralDataArray = new BCTermGeneralData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCTermGeneralDataArray[i2] = BCTermGeneralDataSerializer.getOptionalBCTermGeneralData(iDeserializer);
            }
        }
        return bCTermGeneralDataArray;
    }
}

