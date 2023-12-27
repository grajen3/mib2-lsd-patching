/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.caraircondition.AirconSynchronisation;

public class AirconSynchronisationSerializer {
    public static void putOptionalAirconSynchronisation(ISerializer iSerializer, AirconSynchronisation airconSynchronisation) {
        boolean bl = airconSynchronisation == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = airconSynchronisation.getMaster();
            iSerializer.putInt32(n);
            boolean bl2 = airconSynchronisation.isSlaveZL1R();
            iSerializer.putBool(bl2);
            boolean bl3 = airconSynchronisation.isSlaveZR1R();
            iSerializer.putBool(bl3);
            boolean bl4 = airconSynchronisation.isSlaveZL2R();
            iSerializer.putBool(bl4);
            boolean bl5 = airconSynchronisation.isSlaveZR2R();
            iSerializer.putBool(bl5);
            boolean bl6 = airconSynchronisation.isSlaveZL3R();
            iSerializer.putBool(bl6);
            boolean bl7 = airconSynchronisation.isSlaveZR3R();
            iSerializer.putBool(bl7);
        }
    }

    public static void putOptionalAirconSynchronisationVarArray(ISerializer iSerializer, AirconSynchronisation[] airconSynchronisationArray) {
        boolean bl = airconSynchronisationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(airconSynchronisationArray.length);
            for (int i2 = 0; i2 < airconSynchronisationArray.length; ++i2) {
                AirconSynchronisationSerializer.putOptionalAirconSynchronisation(iSerializer, airconSynchronisationArray[i2]);
            }
        }
    }

    public static AirconSynchronisation getOptionalAirconSynchronisation(IDeserializer iDeserializer) {
        AirconSynchronisation airconSynchronisation = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            int n;
            airconSynchronisation = new AirconSynchronisation();
            airconSynchronisation.master = n = iDeserializer.getInt32();
            airconSynchronisation.slaveZL1R = bl7 = iDeserializer.getBool();
            airconSynchronisation.slaveZR1R = bl6 = iDeserializer.getBool();
            airconSynchronisation.slaveZL2R = bl5 = iDeserializer.getBool();
            airconSynchronisation.slaveZR2R = bl4 = iDeserializer.getBool();
            airconSynchronisation.slaveZL3R = bl3 = iDeserializer.getBool();
            airconSynchronisation.slaveZR3R = bl2 = iDeserializer.getBool();
        }
        return airconSynchronisation;
    }

    public static AirconSynchronisation[] getOptionalAirconSynchronisationVarArray(IDeserializer iDeserializer) {
        AirconSynchronisation[] airconSynchronisationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            airconSynchronisationArray = new AirconSynchronisation[n];
            for (int i2 = 0; i2 < n; ++i2) {
                airconSynchronisationArray[i2] = AirconSynchronisationSerializer.getOptionalAirconSynchronisation(iDeserializer);
            }
        }
        return airconSynchronisationArray;
    }
}

