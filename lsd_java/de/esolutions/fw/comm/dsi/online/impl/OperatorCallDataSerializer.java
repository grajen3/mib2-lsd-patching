/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavLocationWgs84Serializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.online.OperatorCallData;

public class OperatorCallDataSerializer {
    public static void putOptionalOperatorCallData(ISerializer iSerializer, OperatorCallData operatorCallData) {
        boolean bl = operatorCallData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = operatorCallData.getHeading();
            iSerializer.putInt32(n);
            int n2 = operatorCallData.getAltitude();
            iSerializer.putInt32(n2);
            NavLocationWgs84 navLocationWgs84 = operatorCallData.getPosition();
            NavLocationWgs84Serializer.putOptionalNavLocationWgs84(iSerializer, navLocationWgs84);
            NavLocationWgs84 navLocationWgs842 = operatorCallData.getDestination();
            NavLocationWgs84Serializer.putOptionalNavLocationWgs84(iSerializer, navLocationWgs842);
            int n3 = operatorCallData.getValidBitMask();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalOperatorCallDataVarArray(ISerializer iSerializer, OperatorCallData[] operatorCallDataArray) {
        boolean bl = operatorCallDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(operatorCallDataArray.length);
            for (int i2 = 0; i2 < operatorCallDataArray.length; ++i2) {
                OperatorCallDataSerializer.putOptionalOperatorCallData(iSerializer, operatorCallDataArray[i2]);
            }
        }
    }

    public static OperatorCallData getOptionalOperatorCallData(IDeserializer iDeserializer) {
        OperatorCallData operatorCallData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            NavLocationWgs84 navLocationWgs84;
            NavLocationWgs84 navLocationWgs842;
            int n2;
            int n3;
            operatorCallData = new OperatorCallData();
            operatorCallData.heading = n3 = iDeserializer.getInt32();
            operatorCallData.altitude = n2 = iDeserializer.getInt32();
            operatorCallData.position = navLocationWgs842 = NavLocationWgs84Serializer.getOptionalNavLocationWgs84(iDeserializer);
            operatorCallData.destination = navLocationWgs84 = NavLocationWgs84Serializer.getOptionalNavLocationWgs84(iDeserializer);
            operatorCallData.validBitMask = n = iDeserializer.getInt32();
        }
        return operatorCallData;
    }

    public static OperatorCallData[] getOptionalOperatorCallDataVarArray(IDeserializer iDeserializer) {
        OperatorCallData[] operatorCallDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            operatorCallDataArray = new OperatorCallData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                operatorCallDataArray[i2] = OperatorCallDataSerializer.getOptionalOperatorCallData(iDeserializer);
            }
        }
        return operatorCallDataArray;
    }
}

