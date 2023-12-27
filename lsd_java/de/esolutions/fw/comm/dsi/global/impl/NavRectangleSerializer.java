/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.global.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavRectangle;

public class NavRectangleSerializer {
    public static void putOptionalNavRectangle(ISerializer iSerializer, NavRectangle navRectangle) {
        boolean bl = navRectangle == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = navRectangle.getXLeft();
            iSerializer.putInt32(n);
            int n2 = navRectangle.getXRight();
            iSerializer.putInt32(n2);
            int n3 = navRectangle.getYBottom();
            iSerializer.putInt32(n3);
            int n4 = navRectangle.getYUp();
            iSerializer.putInt32(n4);
            boolean bl2 = navRectangle.isRectangleInvalid();
            iSerializer.putBool(bl2);
        }
    }

    public static void putOptionalNavRectangleVarArray(ISerializer iSerializer, NavRectangle[] navRectangleArray) {
        boolean bl = navRectangleArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(navRectangleArray.length);
            for (int i2 = 0; i2 < navRectangleArray.length; ++i2) {
                NavRectangleSerializer.putOptionalNavRectangle(iSerializer, navRectangleArray[i2]);
            }
        }
    }

    public static NavRectangle getOptionalNavRectangle(IDeserializer iDeserializer) {
        NavRectangle navRectangle = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            int n;
            int n2;
            int n3;
            int n4;
            navRectangle = new NavRectangle();
            navRectangle.xLeft = n4 = iDeserializer.getInt32();
            navRectangle.xRight = n3 = iDeserializer.getInt32();
            navRectangle.yBottom = n2 = iDeserializer.getInt32();
            navRectangle.yUp = n = iDeserializer.getInt32();
            navRectangle.rectangleInvalid = bl2 = iDeserializer.getBool();
        }
        return navRectangle;
    }

    public static NavRectangle[] getOptionalNavRectangleVarArray(IDeserializer iDeserializer) {
        NavRectangle[] navRectangleArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            navRectangleArray = new NavRectangle[n];
            for (int i2 = 0; i2 < n; ++i2) {
                navRectangleArray[i2] = NavRectangleSerializer.getOptionalNavRectangle(iDeserializer);
            }
        }
        return navRectangleArray;
    }
}

