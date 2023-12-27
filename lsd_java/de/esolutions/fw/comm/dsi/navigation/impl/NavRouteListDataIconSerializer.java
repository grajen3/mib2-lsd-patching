/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.NavRouteListDataIcon;

public class NavRouteListDataIconSerializer {
    public static void putOptionalNavRouteListDataIcon(ISerializer iSerializer, NavRouteListDataIcon navRouteListDataIcon) {
        boolean bl = navRouteListDataIcon == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = navRouteListDataIcon.getType();
            iSerializer.putInt32(n);
            int n2 = navRouteListDataIcon.getCriteria1();
            iSerializer.putInt32(n2);
            int n3 = navRouteListDataIcon.getCriteria2();
            iSerializer.putInt32(n3);
            int[] nArray = navRouteListDataIcon.getIconDecoratorInformation();
            iSerializer.putOptionalInt32VarArray(nArray);
        }
    }

    public static void putOptionalNavRouteListDataIconVarArray(ISerializer iSerializer, NavRouteListDataIcon[] navRouteListDataIconArray) {
        boolean bl = navRouteListDataIconArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(navRouteListDataIconArray.length);
            for (int i2 = 0; i2 < navRouteListDataIconArray.length; ++i2) {
                NavRouteListDataIconSerializer.putOptionalNavRouteListDataIcon(iSerializer, navRouteListDataIconArray[i2]);
            }
        }
    }

    public static NavRouteListDataIcon getOptionalNavRouteListDataIcon(IDeserializer iDeserializer) {
        NavRouteListDataIcon navRouteListDataIcon = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            navRouteListDataIcon = new NavRouteListDataIcon();
            navRouteListDataIcon.type = n3 = iDeserializer.getInt32();
            navRouteListDataIcon.criteria1 = n2 = iDeserializer.getInt32();
            navRouteListDataIcon.criteria2 = n = iDeserializer.getInt32();
            int[] nArray = iDeserializer.getOptionalInt32VarArray();
            navRouteListDataIcon.iconDecoratorInformation = nArray;
        }
        return navRouteListDataIcon;
    }

    public static NavRouteListDataIcon[] getOptionalNavRouteListDataIconVarArray(IDeserializer iDeserializer) {
        NavRouteListDataIcon[] navRouteListDataIconArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            navRouteListDataIconArray = new NavRouteListDataIcon[n];
            for (int i2 = 0; i2 < n; ++i2) {
                navRouteListDataIconArray[i2] = NavRouteListDataIconSerializer.getOptionalNavRouteListDataIcon(iDeserializer);
            }
        }
        return navRouteListDataIconArray;
    }
}

