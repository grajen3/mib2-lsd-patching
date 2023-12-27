/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.caraircondition.AirconBlowerCompensation;

public class AirconBlowerCompensationSerializer {
    public static void putOptionalAirconBlowerCompensation(ISerializer iSerializer, AirconBlowerCompensation airconBlowerCompensation) {
        boolean bl = airconBlowerCompensation == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = airconBlowerCompensation.isSds();
            iSerializer.putBool(bl2);
            boolean bl3 = airconBlowerCompensation.isTel();
            iSerializer.putBool(bl3);
        }
    }

    public static void putOptionalAirconBlowerCompensationVarArray(ISerializer iSerializer, AirconBlowerCompensation[] airconBlowerCompensationArray) {
        boolean bl = airconBlowerCompensationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(airconBlowerCompensationArray.length);
            for (int i2 = 0; i2 < airconBlowerCompensationArray.length; ++i2) {
                AirconBlowerCompensationSerializer.putOptionalAirconBlowerCompensation(iSerializer, airconBlowerCompensationArray[i2]);
            }
        }
    }

    public static AirconBlowerCompensation getOptionalAirconBlowerCompensation(IDeserializer iDeserializer) {
        AirconBlowerCompensation airconBlowerCompensation = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            airconBlowerCompensation = new AirconBlowerCompensation();
            airconBlowerCompensation.sds = bl3 = iDeserializer.getBool();
            airconBlowerCompensation.tel = bl2 = iDeserializer.getBool();
        }
        return airconBlowerCompensation;
    }

    public static AirconBlowerCompensation[] getOptionalAirconBlowerCompensationVarArray(IDeserializer iDeserializer) {
        AirconBlowerCompensation[] airconBlowerCompensationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            airconBlowerCompensationArray = new AirconBlowerCompensation[n];
            for (int i2 = 0; i2 < n; ++i2) {
                airconBlowerCompensationArray[i2] = AirconBlowerCompensationSerializer.getOptionalAirconBlowerCompensation(iDeserializer);
            }
        }
        return airconBlowerCompensationArray;
    }
}

