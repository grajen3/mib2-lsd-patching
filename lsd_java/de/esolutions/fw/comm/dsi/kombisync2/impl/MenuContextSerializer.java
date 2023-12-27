/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync2.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombisync2.MenuContext;

public class MenuContextSerializer {
    public static void putOptionalMenuContext(ISerializer iSerializer, MenuContext menuContext) {
        boolean bl = menuContext == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = menuContext.getSdsTabState();
            iSerializer.putInt32(n);
            int n2 = menuContext.getLeftMenuState();
            iSerializer.putInt32(n2);
            int n3 = menuContext.getRightMenuState();
            iSerializer.putInt32(n3);
            int n4 = menuContext.getSecondStatusLineState();
            iSerializer.putInt32(n4);
        }
    }

    public static void putOptionalMenuContextVarArray(ISerializer iSerializer, MenuContext[] menuContextArray) {
        boolean bl = menuContextArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(menuContextArray.length);
            for (int i2 = 0; i2 < menuContextArray.length; ++i2) {
                MenuContextSerializer.putOptionalMenuContext(iSerializer, menuContextArray[i2]);
            }
        }
    }

    public static MenuContext getOptionalMenuContext(IDeserializer iDeserializer) {
        MenuContext menuContext = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            menuContext = new MenuContext();
            menuContext.sdsTabState = n4 = iDeserializer.getInt32();
            menuContext.leftMenuState = n3 = iDeserializer.getInt32();
            menuContext.rightMenuState = n2 = iDeserializer.getInt32();
            menuContext.secondStatusLineState = n = iDeserializer.getInt32();
        }
        return menuContext;
    }

    public static MenuContext[] getOptionalMenuContextVarArray(IDeserializer iDeserializer) {
        MenuContext[] menuContextArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            menuContextArray = new MenuContext[n];
            for (int i2 = 0; i2 < n; ++i2) {
                menuContextArray[i2] = MenuContextSerializer.getOptionalMenuContext(iDeserializer);
            }
        }
        return menuContextArray;
    }
}

