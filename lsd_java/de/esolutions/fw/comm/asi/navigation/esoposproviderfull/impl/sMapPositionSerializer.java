/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.esoposproviderfull.impl;

import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.impl.sPositionSerializer;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.sMapPosition;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.sPosition;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sMapPositionSerializer {
    public static void putOptionalsMapPosition(ISerializer iSerializer, sMapPosition sMapPosition2) {
        boolean bl = sMapPosition2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            sPosition sPosition2 = sMapPosition2.getPosition();
            sPositionSerializer.putOptionalsPosition(iSerializer, sPosition2);
            float f2 = sMapPosition2.getHorzStdDev();
            iSerializer.putFloat(f2);
            float f3 = sMapPosition2.getHeadingStdDev();
            iSerializer.putFloat(f3);
            float f4 = sMapPosition2.getAltitude();
            iSerializer.putFloat(f4);
            float f5 = sMapPosition2.getVelocity();
            iSerializer.putFloat(f5);
            float f6 = sMapPosition2.getVelocityStdDev();
            iSerializer.putFloat(f6);
            long l = sMapPosition2.getOdometer();
            iSerializer.putUInt32(l);
            int n = sMapPosition2.getIsOnMap();
            iSerializer.putEnum(n);
            int n2 = sMapPosition2.getIsOnRoad();
            iSerializer.putEnum(n2);
            int n3 = sMapPosition2.getIsInTunnel();
            iSerializer.putEnum(n3);
            String string = sMapPosition2.getStreetName();
            iSerializer.putOptionalString(string);
            short s = sMapPosition2.getNumSatInView();
            iSerializer.putUInt8(s);
            short s2 = sMapPosition2.getNumSatInUse();
            iSerializer.putUInt8(s2);
        }
    }

    public static void putOptionalsMapPositionVarArray(ISerializer iSerializer, sMapPosition[] sMapPositionArray) {
        boolean bl = sMapPositionArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sMapPositionArray.length);
            for (int i2 = 0; i2 < sMapPositionArray.length; ++i2) {
                sMapPositionSerializer.putOptionalsMapPosition(iSerializer, sMapPositionArray[i2]);
            }
        }
    }

    public static sMapPosition getOptionalsMapPosition(IDeserializer iDeserializer) {
        sMapPosition sMapPosition2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            short s;
            short s2;
            String string;
            int n;
            int n2;
            int n3;
            long l;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            sPosition sPosition2;
            sMapPosition2 = new sMapPosition();
            sMapPosition2.position = sPosition2 = sPositionSerializer.getOptionalsPosition(iDeserializer);
            sMapPosition2.horzStdDev = f6 = iDeserializer.getFloat();
            sMapPosition2.headingStdDev = f5 = iDeserializer.getFloat();
            sMapPosition2.altitude = f4 = iDeserializer.getFloat();
            sMapPosition2.velocity = f3 = iDeserializer.getFloat();
            sMapPosition2.velocityStdDev = f2 = iDeserializer.getFloat();
            sMapPosition2.odometer = l = iDeserializer.getUInt32();
            sMapPosition2.isOnMap = n3 = iDeserializer.getEnum();
            sMapPosition2.isOnRoad = n2 = iDeserializer.getEnum();
            sMapPosition2.isInTunnel = n = iDeserializer.getEnum();
            sMapPosition2.streetName = string = iDeserializer.getOptionalString();
            sMapPosition2.numSatInView = s2 = iDeserializer.getUInt8();
            sMapPosition2.numSatInUse = s = iDeserializer.getUInt8();
        }
        return sMapPosition2;
    }

    public static sMapPosition[] getOptionalsMapPositionVarArray(IDeserializer iDeserializer) {
        sMapPosition[] sMapPositionArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sMapPositionArray = new sMapPosition[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sMapPositionArray[i2] = sMapPositionSerializer.getOptionalsMapPosition(iDeserializer);
            }
        }
        return sMapPositionArray;
    }
}

