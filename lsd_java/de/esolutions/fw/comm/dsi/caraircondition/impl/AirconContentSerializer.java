/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.caraircondition.AirconContent;

public class AirconContentSerializer {
    public static void putOptionalAirconContent(ISerializer iSerializer, AirconContent airconContent) {
        boolean bl = airconContent == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = airconContent.getZone1();
            iSerializer.putInt32(n);
            int n2 = airconContent.getZone2();
            iSerializer.putInt32(n2);
            int n3 = airconContent.getZone3();
            iSerializer.putInt32(n3);
            int n4 = airconContent.getZone4();
            iSerializer.putInt32(n4);
            int n5 = airconContent.getZone5();
            iSerializer.putInt32(n5);
            int n6 = airconContent.getZone6();
            iSerializer.putInt32(n6);
            int n7 = airconContent.getMaster();
            iSerializer.putInt32(n7);
        }
    }

    public static void putOptionalAirconContentVarArray(ISerializer iSerializer, AirconContent[] airconContentArray) {
        boolean bl = airconContentArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(airconContentArray.length);
            for (int i2 = 0; i2 < airconContentArray.length; ++i2) {
                AirconContentSerializer.putOptionalAirconContent(iSerializer, airconContentArray[i2]);
            }
        }
    }

    public static AirconContent getOptionalAirconContent(IDeserializer iDeserializer) {
        AirconContent airconContent = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            airconContent = new AirconContent();
            airconContent.zone1 = n7 = iDeserializer.getInt32();
            airconContent.zone2 = n6 = iDeserializer.getInt32();
            airconContent.zone3 = n5 = iDeserializer.getInt32();
            airconContent.zone4 = n4 = iDeserializer.getInt32();
            airconContent.zone5 = n3 = iDeserializer.getInt32();
            airconContent.zone6 = n2 = iDeserializer.getInt32();
            airconContent.master = n = iDeserializer.getInt32();
        }
        return airconContent;
    }

    public static AirconContent[] getOptionalAirconContentVarArray(IDeserializer iDeserializer) {
        AirconContent[] airconContentArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            airconContentArray = new AirconContent[n];
            for (int i2 = 0; i2 < n; ++i2) {
                airconContentArray[i2] = AirconContentSerializer.getOptionalAirconContent(iDeserializer);
            }
        }
        return airconContentArray;
    }
}

