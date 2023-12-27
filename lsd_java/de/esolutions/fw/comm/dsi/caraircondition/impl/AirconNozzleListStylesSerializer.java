/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.caraircondition.AirconNozzleListStyles;

public class AirconNozzleListStylesSerializer {
    public static void putOptionalAirconNozzleListStyles(ISerializer iSerializer, AirconNozzleListStyles airconNozzleListStyles) {
        boolean bl = airconNozzleListStyles == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = airconNozzleListStyles.isInterval();
            iSerializer.putBool(bl2);
            boolean bl3 = airconNozzleListStyles.isFocus();
            iSerializer.putBool(bl3);
            boolean bl4 = airconNozzleListStyles.isDiffuse();
            iSerializer.putBool(bl4);
            boolean bl5 = airconNozzleListStyles.isManual();
            iSerializer.putBool(bl5);
        }
    }

    public static void putOptionalAirconNozzleListStylesVarArray(ISerializer iSerializer, AirconNozzleListStyles[] airconNozzleListStylesArray) {
        boolean bl = airconNozzleListStylesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(airconNozzleListStylesArray.length);
            for (int i2 = 0; i2 < airconNozzleListStylesArray.length; ++i2) {
                AirconNozzleListStylesSerializer.putOptionalAirconNozzleListStyles(iSerializer, airconNozzleListStylesArray[i2]);
            }
        }
    }

    public static AirconNozzleListStyles getOptionalAirconNozzleListStyles(IDeserializer iDeserializer) {
        AirconNozzleListStyles airconNozzleListStyles = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            airconNozzleListStyles = new AirconNozzleListStyles();
            airconNozzleListStyles.interval = bl5 = iDeserializer.getBool();
            airconNozzleListStyles.focus = bl4 = iDeserializer.getBool();
            airconNozzleListStyles.diffuse = bl3 = iDeserializer.getBool();
            airconNozzleListStyles.manual = bl2 = iDeserializer.getBool();
        }
        return airconNozzleListStyles;
    }

    public static AirconNozzleListStyles[] getOptionalAirconNozzleListStylesVarArray(IDeserializer iDeserializer) {
        AirconNozzleListStyles[] airconNozzleListStylesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            airconNozzleListStylesArray = new AirconNozzleListStyles[n];
            for (int i2 = 0; i2 < n; ++i2) {
                airconNozzleListStylesArray[i2] = AirconNozzleListStylesSerializer.getOptionalAirconNozzleListStyles(iDeserializer);
            }
        }
        return airconNozzleListStylesArray;
    }
}

