/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.global.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocationWgs84;

public class NavLocationWgs84Serializer {
    public static void putOptionalNavLocationWgs84(ISerializer iSerializer, NavLocationWgs84 navLocationWgs84) {
        boolean bl = navLocationWgs84 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = navLocationWgs84.getLongitude();
            iSerializer.putInt32(n);
            int n2 = navLocationWgs84.getLatitude();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalNavLocationWgs84VarArray(ISerializer iSerializer, NavLocationWgs84[] navLocationWgs84Array) {
        boolean bl = navLocationWgs84Array == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(navLocationWgs84Array.length);
            for (int i2 = 0; i2 < navLocationWgs84Array.length; ++i2) {
                NavLocationWgs84Serializer.putOptionalNavLocationWgs84(iSerializer, navLocationWgs84Array[i2]);
            }
        }
    }

    public static NavLocationWgs84 getOptionalNavLocationWgs84(IDeserializer iDeserializer) {
        NavLocationWgs84 navLocationWgs84 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            navLocationWgs84 = new NavLocationWgs84();
            navLocationWgs84.longitude = n2 = iDeserializer.getInt32();
            navLocationWgs84.latitude = n = iDeserializer.getInt32();
        }
        return navLocationWgs84;
    }

    public static NavLocationWgs84[] getOptionalNavLocationWgs84VarArray(IDeserializer iDeserializer) {
        NavLocationWgs84[] navLocationWgs84Array = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            navLocationWgs84Array = new NavLocationWgs84[n];
            for (int i2 = 0; i2 < n; ++i2) {
                navLocationWgs84Array[i2] = NavLocationWgs84Serializer.getOptionalNavLocationWgs84(iDeserializer);
            }
        }
        return navLocationWgs84Array;
    }
}

