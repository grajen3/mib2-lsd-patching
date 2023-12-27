/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.caraircondition.AirconTemp;

public class AirconTempSerializer {
    public static void putOptionalAirconTemp(ISerializer iSerializer, AirconTemp airconTemp) {
        boolean bl = airconTemp == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = airconTemp.getTempValue();
            iSerializer.putInt32(n);
            int n2 = airconTemp.getTempUnit();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalAirconTempVarArray(ISerializer iSerializer, AirconTemp[] airconTempArray) {
        boolean bl = airconTempArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(airconTempArray.length);
            for (int i2 = 0; i2 < airconTempArray.length; ++i2) {
                AirconTempSerializer.putOptionalAirconTemp(iSerializer, airconTempArray[i2]);
            }
        }
    }

    public static AirconTemp getOptionalAirconTemp(IDeserializer iDeserializer) {
        AirconTemp airconTemp = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            airconTemp = new AirconTemp();
            airconTemp.tempValue = n2 = iDeserializer.getInt32();
            airconTemp.tempUnit = n = iDeserializer.getInt32();
        }
        return airconTemp;
    }

    public static AirconTemp[] getOptionalAirconTempVarArray(IDeserializer iDeserializer) {
        AirconTemp[] airconTempArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            airconTempArray = new AirconTemp[n];
            for (int i2 = 0; i2 < n; ++i2) {
                airconTempArray[i2] = AirconTempSerializer.getOptionalAirconTemp(iDeserializer);
            }
        }
        return airconTempArray;
    }
}

