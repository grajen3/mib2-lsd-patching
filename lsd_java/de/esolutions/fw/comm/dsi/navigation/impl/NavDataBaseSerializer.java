/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.NavDataBase;

public class NavDataBaseSerializer {
    public static void putOptionalNavDataBase(ISerializer iSerializer, NavDataBase navDataBase) {
        boolean bl = navDataBase == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = navDataBase.getUid();
            iSerializer.putInt64(l);
            boolean bl2 = navDataBase.isCurrentlyInUse();
            iSerializer.putBool(bl2);
            String string = navDataBase.getName();
            iSerializer.putOptionalString(string);
            String string2 = navDataBase.getLanguage();
            iSerializer.putOptionalString(string2);
            String string3 = navDataBase.getPath();
            iSerializer.putOptionalString(string3);
        }
    }

    public static void putOptionalNavDataBaseVarArray(ISerializer iSerializer, NavDataBase[] navDataBaseArray) {
        boolean bl = navDataBaseArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(navDataBaseArray.length);
            for (int i2 = 0; i2 < navDataBaseArray.length; ++i2) {
                NavDataBaseSerializer.putOptionalNavDataBase(iSerializer, navDataBaseArray[i2]);
            }
        }
    }

    public static NavDataBase getOptionalNavDataBase(IDeserializer iDeserializer) {
        NavDataBase navDataBase = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            String string3;
            boolean bl2;
            long l;
            navDataBase = new NavDataBase();
            navDataBase.uid = l = iDeserializer.getInt64();
            navDataBase.currentlyInUse = bl2 = iDeserializer.getBool();
            navDataBase.name = string3 = iDeserializer.getOptionalString();
            navDataBase.language = string2 = iDeserializer.getOptionalString();
            navDataBase.path = string = iDeserializer.getOptionalString();
        }
        return navDataBase;
    }

    public static NavDataBase[] getOptionalNavDataBaseVarArray(IDeserializer iDeserializer) {
        NavDataBase[] navDataBaseArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            navDataBaseArray = new NavDataBase[n];
            for (int i2 = 0; i2 < n; ++i2) {
                navDataBaseArray[i2] = NavDataBaseSerializer.getOptionalNavDataBase(iDeserializer);
            }
        }
        return navDataBaseArray;
    }
}

