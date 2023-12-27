/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.caraircondition.AirconAirDistribution;

public class AirconAirDistributionSerializer {
    public static void putOptionalAirconAirDistribution(ISerializer iSerializer, AirconAirDistribution airconAirDistribution) {
        boolean bl = airconAirDistribution == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = airconAirDistribution.getUp();
            iSerializer.putInt32(n);
            int n2 = airconAirDistribution.getBody();
            iSerializer.putInt32(n2);
            int n3 = airconAirDistribution.getFootwell();
            iSerializer.putInt32(n3);
            int n4 = airconAirDistribution.getIndirect();
            iSerializer.putInt32(n4);
            boolean bl2 = airconAirDistribution.isAutomode();
            iSerializer.putBool(bl2);
            boolean bl3 = airconAirDistribution.isAutoDemandOriented();
            iSerializer.putBool(bl3);
            int n5 = airconAirDistribution.getSide();
            iSerializer.putInt32(n5);
        }
    }

    public static void putOptionalAirconAirDistributionVarArray(ISerializer iSerializer, AirconAirDistribution[] airconAirDistributionArray) {
        boolean bl = airconAirDistributionArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(airconAirDistributionArray.length);
            for (int i2 = 0; i2 < airconAirDistributionArray.length; ++i2) {
                AirconAirDistributionSerializer.putOptionalAirconAirDistribution(iSerializer, airconAirDistributionArray[i2]);
            }
        }
    }

    public static AirconAirDistribution getOptionalAirconAirDistribution(IDeserializer iDeserializer) {
        AirconAirDistribution airconAirDistribution = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            boolean bl2;
            boolean bl3;
            int n2;
            int n3;
            int n4;
            int n5;
            airconAirDistribution = new AirconAirDistribution();
            airconAirDistribution.up = n5 = iDeserializer.getInt32();
            airconAirDistribution.body = n4 = iDeserializer.getInt32();
            airconAirDistribution.footwell = n3 = iDeserializer.getInt32();
            airconAirDistribution.indirect = n2 = iDeserializer.getInt32();
            airconAirDistribution.automode = bl3 = iDeserializer.getBool();
            airconAirDistribution.autoDemandOriented = bl2 = iDeserializer.getBool();
            airconAirDistribution.side = n = iDeserializer.getInt32();
        }
        return airconAirDistribution;
    }

    public static AirconAirDistribution[] getOptionalAirconAirDistributionVarArray(IDeserializer iDeserializer) {
        AirconAirDistribution[] airconAirDistributionArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            airconAirDistributionArray = new AirconAirDistribution[n];
            for (int i2 = 0; i2 < n; ++i2) {
                airconAirDistributionArray[i2] = AirconAirDistributionSerializer.getOptionalAirconAirDistribution(iDeserializer);
            }
        }
        return airconAirDistributionArray;
    }
}

