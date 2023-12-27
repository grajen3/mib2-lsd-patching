/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavLocationSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.NavLastDest;

public class NavLastDestSerializer {
    public static void putOptionalNavLastDest(ISerializer iSerializer, NavLastDest navLastDest) {
        boolean bl = navLastDest == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = navLastDest.getTitle();
            iSerializer.putOptionalString(string);
            NavLocation navLocation = navLastDest.getLocation();
            NavLocationSerializer.putOptionalNavLocation(iSerializer, navLocation);
            String string2 = navLastDest.getCodedTitle();
            iSerializer.putOptionalString(string2);
        }
    }

    public static void putOptionalNavLastDestVarArray(ISerializer iSerializer, NavLastDest[] navLastDestArray) {
        boolean bl = navLastDestArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(navLastDestArray.length);
            for (int i2 = 0; i2 < navLastDestArray.length; ++i2) {
                NavLastDestSerializer.putOptionalNavLastDest(iSerializer, navLastDestArray[i2]);
            }
        }
    }

    public static NavLastDest getOptionalNavLastDest(IDeserializer iDeserializer) {
        NavLastDest navLastDest = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            NavLocation navLocation;
            String string2;
            navLastDest = new NavLastDest();
            navLastDest.title = string2 = iDeserializer.getOptionalString();
            navLastDest.location = navLocation = NavLocationSerializer.getOptionalNavLocation(iDeserializer);
            navLastDest.codedTitle = string = iDeserializer.getOptionalString();
        }
        return navLastDest;
    }

    public static NavLastDest[] getOptionalNavLastDestVarArray(IDeserializer iDeserializer) {
        NavLastDest[] navLastDestArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            navLastDestArray = new NavLastDest[n];
            for (int i2 = 0; i2 < n; ++i2) {
                navLastDestArray[i2] = NavLastDestSerializer.getOptionalNavLastDest(iDeserializer);
            }
        }
        return navLastDestArray;
    }
}

