/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio.impl;

import de.esolutions.fw.comm.dsi.radio.impl.IntellitextSubmenuSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.radio.IntellitextMenu;
import org.dsi.ifc.radio.IntellitextSubmenu;

public class IntellitextMenuSerializer {
    public static void putOptionalIntellitextMenu(ISerializer iSerializer, IntellitextMenu intellitextMenu) {
        boolean bl = intellitextMenu == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = intellitextMenu.getName();
            iSerializer.putOptionalString(string);
            IntellitextSubmenu[] intellitextSubmenuArray = intellitextMenu.getSubmenuList();
            IntellitextSubmenuSerializer.putOptionalIntellitextSubmenuVarArray(iSerializer, intellitextSubmenuArray);
        }
    }

    public static void putOptionalIntellitextMenuVarArray(ISerializer iSerializer, IntellitextMenu[] intellitextMenuArray) {
        boolean bl = intellitextMenuArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(intellitextMenuArray.length);
            for (int i2 = 0; i2 < intellitextMenuArray.length; ++i2) {
                IntellitextMenuSerializer.putOptionalIntellitextMenu(iSerializer, intellitextMenuArray[i2]);
            }
        }
    }

    public static IntellitextMenu getOptionalIntellitextMenu(IDeserializer iDeserializer) {
        IntellitextMenu intellitextMenu = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            intellitextMenu = new IntellitextMenu();
            intellitextMenu.name = string = iDeserializer.getOptionalString();
            IntellitextSubmenu[] intellitextSubmenuArray = IntellitextSubmenuSerializer.getOptionalIntellitextSubmenuVarArray(iDeserializer);
            intellitextMenu.submenuList = intellitextSubmenuArray;
        }
        return intellitextMenu;
    }

    public static IntellitextMenu[] getOptionalIntellitextMenuVarArray(IDeserializer iDeserializer) {
        IntellitextMenu[] intellitextMenuArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            intellitextMenuArray = new IntellitextMenu[n];
            for (int i2 = 0; i2 < n; ++i2) {
                intellitextMenuArray[i2] = IntellitextMenuSerializer.getOptionalIntellitextMenu(iDeserializer);
            }
        }
        return intellitextMenuArray;
    }
}

