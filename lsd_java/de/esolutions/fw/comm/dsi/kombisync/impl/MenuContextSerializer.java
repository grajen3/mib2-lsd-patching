/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombisync.MenuContext;

public class MenuContextSerializer {
    public static void putOptionalMenuContext(ISerializer iSerializer, MenuContext menuContext) {
        boolean bl = menuContext == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = menuContext.isLeftSideMenuOpen();
            iSerializer.putBool(bl2);
            boolean bl3 = menuContext.isRightSideMenuOpen();
            iSerializer.putBool(bl3);
            boolean bl4 = menuContext.isPartialPopupOpen();
            iSerializer.putBool(bl4);
            boolean bl5 = menuContext.isSecondStatusLine();
            iSerializer.putBool(bl5);
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
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            menuContext = new MenuContext();
            menuContext.leftSideMenuOpen = bl5 = iDeserializer.getBool();
            menuContext.rightSideMenuOpen = bl4 = iDeserializer.getBool();
            menuContext.partialPopupOpen = bl3 = iDeserializer.getBool();
            menuContext.secondStatusLine = bl2 = iDeserializer.getBool();
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

