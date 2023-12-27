/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.caraircondition.AirconFreshAirCartridge;

public class AirconFreshAirCartridgeSerializer {
    public static void putOptionalAirconFreshAirCartridge(ISerializer iSerializer, AirconFreshAirCartridge airconFreshAirCartridge) {
        boolean bl = airconFreshAirCartridge == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = airconFreshAirCartridge.getLevel();
            iSerializer.putInt32(n);
            int n2 = airconFreshAirCartridge.getWarning();
            iSerializer.putInt32(n2);
            int n3 = airconFreshAirCartridge.getFlavourID();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalAirconFreshAirCartridgeVarArray(ISerializer iSerializer, AirconFreshAirCartridge[] airconFreshAirCartridgeArray) {
        boolean bl = airconFreshAirCartridgeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(airconFreshAirCartridgeArray.length);
            for (int i2 = 0; i2 < airconFreshAirCartridgeArray.length; ++i2) {
                AirconFreshAirCartridgeSerializer.putOptionalAirconFreshAirCartridge(iSerializer, airconFreshAirCartridgeArray[i2]);
            }
        }
    }

    public static AirconFreshAirCartridge getOptionalAirconFreshAirCartridge(IDeserializer iDeserializer) {
        AirconFreshAirCartridge airconFreshAirCartridge = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            airconFreshAirCartridge = new AirconFreshAirCartridge();
            airconFreshAirCartridge.level = n3 = iDeserializer.getInt32();
            airconFreshAirCartridge.warning = n2 = iDeserializer.getInt32();
            airconFreshAirCartridge.flavourID = n = iDeserializer.getInt32();
        }
        return airconFreshAirCartridge;
    }

    public static AirconFreshAirCartridge[] getOptionalAirconFreshAirCartridgeVarArray(IDeserializer iDeserializer) {
        AirconFreshAirCartridge[] airconFreshAirCartridgeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            airconFreshAirCartridgeArray = new AirconFreshAirCartridge[n];
            for (int i2 = 0; i2 < n; ++i2) {
                airconFreshAirCartridgeArray[i2] = AirconFreshAirCartridgeSerializer.getOptionalAirconFreshAirCartridge(iDeserializer);
            }
        }
        return airconFreshAirCartridgeArray;
    }
}

