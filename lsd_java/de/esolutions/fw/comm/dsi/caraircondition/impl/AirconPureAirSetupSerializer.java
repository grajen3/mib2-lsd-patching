/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.caraircondition.AirconPureAirSetup;

public class AirconPureAirSetupSerializer {
    public static void putOptionalAirconPureAirSetup(ISerializer iSerializer, AirconPureAirSetup airconPureAirSetup) {
        boolean bl = airconPureAirSetup == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = airconPureAirSetup.isSystemOnOff();
            iSerializer.putBool(bl2);
            boolean bl3 = airconPureAirSetup.isIonisator();
            iSerializer.putBool(bl3);
            boolean bl4 = airconPureAirSetup.isFragrance();
            iSerializer.putBool(bl4);
        }
    }

    public static void putOptionalAirconPureAirSetupVarArray(ISerializer iSerializer, AirconPureAirSetup[] airconPureAirSetupArray) {
        boolean bl = airconPureAirSetupArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(airconPureAirSetupArray.length);
            for (int i2 = 0; i2 < airconPureAirSetupArray.length; ++i2) {
                AirconPureAirSetupSerializer.putOptionalAirconPureAirSetup(iSerializer, airconPureAirSetupArray[i2]);
            }
        }
    }

    public static AirconPureAirSetup getOptionalAirconPureAirSetup(IDeserializer iDeserializer) {
        AirconPureAirSetup airconPureAirSetup = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            airconPureAirSetup = new AirconPureAirSetup();
            airconPureAirSetup.systemOnOff = bl4 = iDeserializer.getBool();
            airconPureAirSetup.ionisator = bl3 = iDeserializer.getBool();
            airconPureAirSetup.fragrance = bl2 = iDeserializer.getBool();
        }
        return airconPureAirSetup;
    }

    public static AirconPureAirSetup[] getOptionalAirconPureAirSetupVarArray(IDeserializer iDeserializer) {
        AirconPureAirSetup[] airconPureAirSetupArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            airconPureAirSetupArray = new AirconPureAirSetup[n];
            for (int i2 = 0; i2 < n; ++i2) {
                airconPureAirSetupArray[i2] = AirconPureAirSetupSerializer.getOptionalAirconPureAirSetup(iDeserializer);
            }
        }
        return airconPureAirSetupArray;
    }
}

